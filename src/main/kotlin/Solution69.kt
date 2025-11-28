package org.example

/**
 * 문제 : https://www.hackerrank.com/challenges/one-week-preparation-kit-mini-max-sum/problem
 *
 * 배운 것 :
 * - Array<Int>.sumOf(selector: (T) -> Long): Long
 */
class Solution69 {
    fun miniMaxSum(arr: Array<Int>): Unit {
        val min = arr.minOrNull()!!
        val max = arr.maxOrNull()!!

        val sum = arr.sumOf { it.toLong() }
        print("${sum - max} ${sum - min}")
    }
}


fun main() {
    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    Solution69().miniMaxSum(arr)
}
