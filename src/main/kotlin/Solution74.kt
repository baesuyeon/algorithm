package org.example

/**
 * 문제 : https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * 이분탐색 심화
 * - mid를 기준으로 오른쪽 또는 왼쪽은 무조건 오름차순 정렬되어있다.
 */
class Solution74 {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return mid
            }

            // 왼쪽 정렬
            if (nums[left] < nums[mid]) {
                // 왼쪽 정렬된 구간에 target이 있다면
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            // 오른쪽 정렬
            else {
                // 오른쪽 정렬된 구간에 target이 있다면
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }
        return -1
    }
}

fun main() {
    val nums = intArrayOf(4,5,6,7,0,1,2)
    val target = 3

    println(Solution74().search(nums, target))
}
