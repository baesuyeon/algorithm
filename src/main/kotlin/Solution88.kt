package org.example

import kotlin.math.max

/**
 * 문제 : https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 불필요하게 복잡하게 품, 추후 다시 풀어볼 것
 */
class Solution88 {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var answer = 0
        var chance = k
        var left = 0
        var right = 0

        while(right < nums.size) {
            if(nums[right] == 1) {
                answer = max(answer, right - left + 1)
                right++
            } else { // 0
                if (chance > 0) {
                    nums[right] = 2
                    chance--
                    answer = max(answer, right - left + 1)
                    right++
                } else {
                    while(chance <= 0 && nums[right] == 0) {
                        if (left == right) {
                            left++
                            right++
                        } else {
                            if (nums[left] == 2) {
                                chance++
                            }
                            left++
                        }

                        if (right == nums.size || left == nums.size) {
                            break
                        }
                    }
                }
            }
        }

        return answer
    }
}

fun main() {
    val nums = intArrayOf(0,0,1,1,1,0,0)
    val k = 0

    println(Solution88().longestOnes(nums = nums, k = k))
}
