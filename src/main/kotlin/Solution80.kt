package org.example

/**
 * 문제 : https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution80 {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val map1 = mutableMapOf<Int, Boolean>()
        val map2 = mutableMapOf<Int, Boolean>()

        nums1.forEach {
            map1[it] = true
        }

        nums2.forEach {
            map2[it] = true
        }

        val answer = mutableListOf<List<Int>>()

        answer.add(nums1.filter { map2[it] == null }.distinct())
        answer.add(nums2.filter { map1[it] == null }.distinct())

        return answer
    }
}

fun main() {
    val nums1 = intArrayOf(1,2,3)
    val nums2 = intArrayOf(2,4,6)

    println(Solution80().findDifference(nums1, nums2))
}
