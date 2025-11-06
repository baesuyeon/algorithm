package org.example

/**
 * 문제 : https://leetcode.com/problems/n-th-tribonacci-number/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution56 {
    fun tribonacci(n: Int): Int {
        var result = 0
        val arr = IntArray(size = n + 1) { 0 }
        arr[0] = 0
        arr[1] = 1
        arr[2] = 1

        if (n <= 2) {
            return arr[n]
        }

        for (i in (3..n)) {
            val previousIndex = i - 4

            if (previousIndex >= 0) {
                arr[i] = (arr[i - 1]) * 2 - arr[previousIndex]
            } else {
                arr[i] = (arr[i - 1]) * 2
            }

            if (i == n) {
                result = arr[i]
                break
            }
        }

        return result
    }
}


fun main() {
    val n = 25

    val answer = Solution56().tribonacci(n)
    print(answer)
}
