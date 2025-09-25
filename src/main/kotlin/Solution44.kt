package org.example

/**
 * 문제 : https://leetcode.com/problems/number-of-recent-calls/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution44 {
    val queue = ArrayDeque<Int>()

    fun ping(t: Int): Int {
        queue.addLast(t)

        while(queue.isNotEmpty() && queue.first() < t- 3000) {
          queue.removeFirst()
        }

        return queue.size
    }
}

fun main() {
    val t = 3

    Solution44().ping(t)
}
