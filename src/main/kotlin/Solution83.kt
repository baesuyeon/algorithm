package org.example

import kotlin.math.max

/**
 * 문제 : https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution83 {
    fun largestAltitude(gain: IntArray): Int {
        var answer = 0
        var currentAltitude = 0

        for(diff in gain) {
            currentAltitude += diff
            answer = max(answer, currentAltitude)
        }

        return answer
    }
}

fun main() {
    val gain = intArrayOf(-4,-3,-2,-1,4,3,2)

    println(Solution83().largestAltitude(gain))
}
