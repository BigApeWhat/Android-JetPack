package com.example.layered_jetpack_mvvm.common.helper

import java.util.Random

class RandomStringGenerator {
 companion object {
     fun randomString(): String {
         val generator = Random()
         val randomStringBuilder = StringBuilder()
         val randomLength: Int = generator.nextInt(12)
         var tempChar: Char
         for (i in 0 until randomLength) {
             tempChar = ((generator.nextInt(96) + 32).toChar())
             randomStringBuilder.append(tempChar)
         }
         return randomStringBuilder.toString()
     }
 }
}