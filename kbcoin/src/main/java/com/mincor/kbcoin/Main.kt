package com.mincor.kbcoin

import com.mincor.kbcoin.core.KBChain

object Main {

    @JvmStatic
    fun main(arg: Array<String>) {
        println("HELLO KBCOIN")

        for (i in 1..15) {
            KBChain.mineNewKBlock("Test KBlock $i")
        }

        KBChain.kbchain.forEach {
            println("------------ \n INDEX: ${it.index} \n" +
                    " Timestamp: ${it.timestamp} \n " +
                    "Data: ${it.data} \n " +
                    "Previous Hash: ${it.previousHash} \n " +
                    "Current Hash: ${it.hash} \n " +
                    "ProofOFWork: ${it.pow}")
        }

    }
}
