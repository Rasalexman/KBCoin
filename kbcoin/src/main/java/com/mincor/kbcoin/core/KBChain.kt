package com.mincor.kbcoin.core

import com.mincor.kbcoin.core.block.KBlock
import java.util.*

object KBChain {
    val kbchain = mutableListOf(createGeneratesKBlock())

    /**
     * Во-первых, цепочка генерирует pow (proofOfWork) для нового блока,
     * затем создает новый объект KBlock и, наконец, добавляет его в цепочку.
     * Новый блок не будет добавлен, если проверка не удалась.
     * После этого метод возвращает последний элемент в цепочке.
     */
    fun mineNewKBlock(data: Any): KBlock {
        val pow = generatePOW(getLatestBlock().pow)
        val block = KBlock(kbchain.size, getLatestBlock().hash, data, Date().time, pow)
        addNewKBlock(block)
        return getLatestBlock()
    }

    private fun getLatestBlock(): KBlock {
        return kbchain.last()
    }

    private fun addNewKBlock(block: KBlock) {
        if (isNewKBlockValid(block)) kbchain.add(block)
    }

    /**
     * В основе "proofOfWork", далее POW - сгенерированная часть данных, использующая сложные, трудоемкие операции, которые легко проверить.
     * Получение POW должно быть сложным и довольно случайным процессом, поэтому для завершения требуется довольно много времени.
     * Результатом этой операции является создание нового блока. Пользователь, который выполняет эту операцию, называется "MINER" (добытчик/майнер)
     * и в ответ на завершение акта добычи приходит новая блочная цепь, вознаграждает майнера блоком.
     */
    private fun generatePOW(previousPow: Int, difficulty: Int = 1): Int {
        var proof = previousPow + 1
        val nonce = 5 * difficulty
        while ((proof + previousPow) % nonce != 0) {
            proof += 1
        }
        return proof
    }

    /**
     * Проверка правильности нового блока
     */
    private fun isNewKBlockValid(newBlock: KBlock): Boolean =
            ((newBlock.index == getLatestBlock().index + 1) || (newBlock.previousHash == getLatestBlock().hash))

    private fun createGeneratesKBlock(): KBlock {
        return KBlock(0, "0", "Genesis kblock", 0, 0)
    }
}