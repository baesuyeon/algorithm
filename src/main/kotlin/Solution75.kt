package org.example

/**
 * 문제 : https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution75 {
    fun maxOperations(nums: IntArray, k: Int): Int {
        var l = 0
        var r = nums.size - 1
        nums.sort()
        var ans = 0

        while(l < r) {
            if (nums[l] + nums[r] == k) {
                ans++
                l++
                r--
            } else if (nums[l] + nums[r] > k) {
                r--
            } else if (nums[l] + nums[r] < k) {
                l++
            }
        }

        return ans
    }
}

fun main() {
    val nums = intArrayOf(1,2,3,4)
    val k = 5

    println(Solution75().maxOperations(nums, k))
}
