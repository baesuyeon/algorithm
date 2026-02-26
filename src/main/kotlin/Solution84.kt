package org.example

/**
 * 문제 : https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution84 {
    fun pivotIndex(nums: IntArray): Int {
        var rightSum = nums.sum()
        var leftSum = 0

        for((index, value) in nums.withIndex()) {
            rightSum = rightSum - value
            leftSum = leftSum + if(index >= 1) {
                nums[index - 1]
            } else {
                0
            }

            if(rightSum == leftSum) {
                return index
            }
        }

        return -1
    }
}

fun main() {
    val nums = intArrayOf(2,1,-1)

    println(Solution84().pivotIndex(nums))
}
