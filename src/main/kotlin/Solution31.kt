package org.example

/**
 * 문제 : https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운 것 :
 * - 소수 출력 방식
 *   - String.format("%.2f", floatNumber) // 소수점 2자리까지 출력 지정
 *   - String.format("%.5f", floatNumber) // 소수점 5자리까지 출력 지정
 * - edge case 체크까지 체크할 것
 */
class Solution31 {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var start = 0
        var end = k - 1
        var sum = 0
        var max = 0

        for (i in (start..end)) {
            sum += nums[i]
        }
        max = sum

        while (end < nums.size - 1) {
            sum -= nums[start]
            start++
            end++
            sum += nums[end]

            if (sum > max) {
                max = sum
            }
        }

        return max.toDouble() / k
    }
}

fun main() {
    // val nums = intArrayOf(1, 12, -5, -6, 50, 3)
    val nums = intArrayOf(5)
    val k = 1
    val result = Solution31().findMaxAverage(nums, k)

    val formattedString = String.format("%.5f", result)
    println(formattedString)
}
