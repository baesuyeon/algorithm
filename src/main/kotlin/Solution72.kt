package org.example

/**
 * 문제 : https://leetcode.com/problems/climbing-stairs/description/
 *
 * 배운 것 : DP
 *
 * n = 2
 * (1, 1), (2)
 *
 * n = 3
 * (1, 1, 1), (2, 1), (1, 2)
 *
 * n = 4
 * n = 3에서 1칸을 올라간 케이스 / n=2에서 2칸을 올라간 케이스
 * (1, 1, 1, 1), (2, 1, 1), (1, 2, 1) / (1, 1, 2), (2, 2)
 */
class Solution72 {
    fun climbStairs(n: Int): Int {
        val array = IntArray(size = 46) { 0 }

        array[1] = 1
        array[2] = 2

        for (i in (3..n)) {
            array[i] = array[i - 1] + array[i - 2]
        }

        return array[n]
    }
}

fun main() {
    val n = 5

    println(Solution72().climbStairs(n))
}
