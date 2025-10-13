package org.example

/**
 * 문제 : https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution48 {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val max = candies.maxOrNull()!!

        return candies.map {
            it + extraCandies >= max
        }
    }
}

fun main() {
    val candies = intArrayOf(4, 2, 1, 1, 2)
    val extraCandies = 1

    val answer = Solution48().kidsWithCandies(candies, extraCandies)
    print(answer)
}
