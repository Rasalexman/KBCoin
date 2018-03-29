package com.mincor.kbcoin.core

import java.security.MessageDigest

fun Any.toSha256():String {
    val bytes = this.toString().toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(bytes)
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}

fun ByteArray.toSha256():String {
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(this)
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}
