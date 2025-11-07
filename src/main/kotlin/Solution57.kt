package org.example

import kotlin.math.min

/**
 * 문제 : https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution57 {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val size = cost.size
        val dp = IntArray(size = size) { 0 }

        dp[size - 1] = cost[size -1]
        dp[size - 2] = cost[size - 2]

        for(i in (cost.size - 3 downTo 0)) {
            dp[i] = cost[i] + min(dp[i + 1], dp[i + 2])
        }

        return min(dp[0], dp[1])
    }
}


fun main() {
    val cost = intArrayOf(10, 15, 20)

    val answer = Solution57().minCostClimbingStairs(cost)
    print(answer)
}
