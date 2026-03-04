package org.example

/**
 * 문제 : https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution87 {
    fun maxVowels(s: String, k: Int): Int {
        var left = 0
        var right = 0
        var answer = 0
        var count = 0

        // left~right까지
        for (i in (0 until k)) {
            if (isVowel(s[i])) {
                count++
            }
        }

        if (answer < count) {
            answer = count
        }

        right = k - 1
        while (right + 1 < s.length) {
            right++

            if (isVowel(s[right])) {
                count++
            }
            if (isVowel(s[left])) {
                count--
            }

            left++

            if (answer < count) {
                answer = count
            }
        }

        return answer
    }

    private fun isVowel(c: Char): Boolean {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
    }
}

fun main() {
    val s = "leetcode"
    val k = 3

    println(Solution87().maxVowels(s = s, k = k))
}
