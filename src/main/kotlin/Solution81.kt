package org.example

/**
 * 문제 : https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution81 {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val occurrenceMap = mutableMapOf<Int, Int>()

        arr.forEach {
            occurrenceMap[it] = occurrenceMap.getOrDefault(it, 0) + 1
        }

        val res1 = occurrenceMap.entries.map { it.value }.distinct().size
        val res2 = occurrenceMap.entries.map { it.key }.distinct().size

        return res1 == res2
    }
}

fun main() {
    val arr = intArrayOf(-3,0,1,-3,1,1,1,-3,10,0)

    println(Solution81().uniqueOccurrences(arr))
}
