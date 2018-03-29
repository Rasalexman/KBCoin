package com.mincor.kbcoin.core.block

import com.mincor.kbcoin.core.toSha256


data class KBlock(val index:Int, val previousHash:String, val data:Any, val timestamp:Long, val pow: Int) {

    /**
     * Наш основной хэш для каждой отдельной коины
     */
    val hash:String = calculateHash()

    /**
     * Здесь мы вычисляем хеш с использованием SHA-256.
     * Криптографическая функция SHA-256 используется в реализации биткойнов.
     * В этом примере я использовал java.security.MessageDigest с преобразованием SHA-256 ByteArray в hex.
     */
    private fun calculateHash():String {
        val cryptoHashBlock = (index.toString() + previousHash + timestamp + data).toByteArray()
        return cryptoHashBlock.toSha256()
    }
}

