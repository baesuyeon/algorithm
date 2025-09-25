package org.example

/**
 * 문제 : https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution45 {
    fun mergeAlternately(word1: String, word2: String): String {
        var pos1 = 0
        var pos2 = 0

        val sb = StringBuilder()

        while (pos1 < word1.length || pos2 < word2.length) {
            if (pos1 < word1.length) {
                sb.append(word1[pos1++])
            }
            if (pos2 < word2.length) {
                sb.append(word2[pos2++])
            }
        }

        return sb.toString()
    }
}

fun main() {
    val word1 = "abc"
    val word2 = "pqr"

    println(Solution45().mergeAlternately(word1, word2))
}
