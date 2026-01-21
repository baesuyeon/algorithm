package org.example

/**
 * 문제 : https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution76 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val arr1 = IntArray(nums.size)
        val arr2 = IntArray(nums.size)

        arr1[0] = nums[0]
        arr2[0] = nums[nums.size - 1]

        for(i in 1 until nums.size) {
            // 왼쪽 누적곱
            arr1[i] = arr1[i - 1] * nums[i]
            // 오른쪽 누적 곱
            arr2[i] = arr2[i - 1] * nums[nums.size - i - 1]
        }

        val answer = IntArray(nums.size)
        for(i in 0 .. nums.size - 1) {
            val num1 = if (i - 1 >= 0) {
                arr1[i - 1]
            } else {
                1
            }
            val num2 = if (nums.size - i - 2 >= 0) {
                arr2[nums.size - i - 2]
            } else {
                1
            }

            answer[i] = num1 * num2
        }

        return answer
    }
}

fun main() {
    val nums = intArrayOf(-1,1,0,-3,3)

    println(Solution76().productExceptSelf(nums).contentToString())
}
