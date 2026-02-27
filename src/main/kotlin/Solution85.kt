package org.example

/**
 * 문제 : https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운것: num > medium이 되는순간
 * small < medium을 만족하는 값이 있었기 때문에 유효한 쌍이 존재하는 것이다.
 * [10, 20, 5, 6, 7]
 *          ㄴ 5->small, 20->medium
 *          medium 값을 10으로 변경하지 않아도 된다.
 *          20이 medium이라는 것은 20보다 작은 값이 있었다는 것을 보증하며
 *          새로운 num이 medium보다 크면 유효한 쌍을 찾은것이 된다.
 */
class Solution85 {
    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3) return false

        var small = Int.MAX_VALUE
        var medium = Int.MAX_VALUE

        for (num in nums) {
            if (num < small) {
                small = num
            } else if (num < medium) {
                medium = num
            } else {
                return true
            }
        }

        return false
    }
}

fun main() {
    val nums = intArrayOf(2, 1, -1)

    println(Solution85().increasingTriplet(nums))
}
