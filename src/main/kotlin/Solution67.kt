package org.example

/**
 * 문제 : https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution67 {
    fun reverseWords(s: String): String {
        val trimmedString = s.trim()

        val splitString = trimmedString.split(" ").filter { it.isNotBlank() }

        val stringBuilder = StringBuilder()
        splitString.reversed().forEach {
            stringBuilder.append(it)
            stringBuilder.append(" ")
        }

        return stringBuilder.toString().trimEnd()
    }
}


fun main() {
    val s = "  hello   world  "

    println(Solution67().reverseWords(s))
}
