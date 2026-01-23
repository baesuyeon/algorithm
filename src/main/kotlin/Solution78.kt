package org.example

/**
 * 문제 : https://leetcode.com/problems/binary-search/description/
 */
class Solution78 {
    fun search(nums: IntArray, target: Int): Int {
        var s = 0
        var e = nums.size - 1

        while (s <= e) {
            val mid = s + (e - s) / 2

            val midValue = nums[mid]
            if (midValue == target) {
                return mid
            } else if (midValue < target) {
                s = mid + 1
            } else {
                e = mid - 1
            }
        }

        return -1
    }
}

fun main() {
    val nums = intArrayOf(1, 3, 5, 7, 9, 11)
    val target = 5

    println(Solution78().search(nums, target))
}
