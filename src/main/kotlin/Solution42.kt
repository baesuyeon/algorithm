package org.example

/**
 * 문제 : https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution42 {
    fun moveZeroes(nums: IntArray): Unit {
        var pos = 0
        val size = nums.size

        for (num in nums) {
            if (num != 0) {
                nums[pos] = num
                pos++
            }
        }

        while (pos < size) {
            nums[pos] = 0
            pos++
        }
    }
}

fun main() {
    val nums = intArrayOf(0, 1, 0, 3, 12)

    Solution42().moveZeroes(nums)
}
