package org.example

/**
 * 문제 : https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution43 {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) {
            return true
        }

        var pos = 0

        for (word in t) {
            if (word == s[pos]) {
                pos++
            }

            if (pos == s.length) {
                break
            }
        }

        return pos == s.length
    }
}

fun main() {
    val s = "abc"
    val t = "ahbgdc"

    Solution43().isSubsequence(s, t)
}
