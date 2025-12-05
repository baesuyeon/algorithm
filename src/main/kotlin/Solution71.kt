package org.example

/**
 * 문제 : https://leetcode.com/problems/minimum-window-substring/description/
 *
 * 배운 것 :
 */
class Solution71 {
    fun minWindow(s: String, t: String): String {
        val targetMap = mutableMapOf<Char, Int>()
        t.forEach { char ->
            targetMap[char] = targetMap.getOrDefault(char, 0) + 1
        }

        val tempMap = mutableMapOf<Char, Int>()

        var left = 0
        var right = -1
        var usedCount = 0

        var minLeft = -1
        var minLength = 1000000

        while (right < s.length - 1) {
            // 조건을 만족하지 않으면
            if (usedCount < t.length) {
                val current = s[++right]
                if (current !in t) {
                    continue
                }
                val tempValue = tempMap.getOrDefault(current, 0)
                val targetValue = targetMap.getOrDefault(current, 0)
                if (tempValue < targetValue) {
                    usedCount++
                }
                tempMap[current] = tempMap.getOrDefault(current, 0) + 1
            }

            // 조건을 만족하면
            while (usedCount == t.length) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1
                    minLeft = left
                }

                val current = s[left++]
                if (current !in t) {
                    continue
                }
                val tempValue = tempMap.getOrDefault(current, 0)
                val targetValue = targetMap.getOrDefault(current, 0)
                if (tempValue <= targetValue) {
                    usedCount--
                }
                tempMap[current] = tempValue - 1
            }
        }

        return if (minLeft == -1) {
            ""
        } else {
            s.substring(minLeft, minLeft + minLength)
        }
    }
}

fun main() {
    val s = "ADOBECODEBANC"
    val t = "ABC"
    // val s = "aa"
    // val t = "aa"

    println(Solution71().minWindow(s, t))
}
