package org.example

import kotlin.math.max

/**
 * 문제 : https://leetcode.com/problems/merge-intervals/description/
 *
 * 구간들을 시작 지점 기준으로 오름차순 한다.
 *
 * case1)
 * -----
 * ---
 * -------
 *
 * case2)
 * -----
 *  --
 *  -------
 */
class Solution73 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()

        val sortedIntervals = intervals.sortedBy { it.first() }

        result.add(sortedIntervals.first())

        for (interval in sortedIntervals.subList(1, sortedIntervals.size)) {
            val prevInterval = result.last()
            val start1 = prevInterval[0]
            val end1 = prevInterval[1]

            val start2 = interval[0]
            val end2 = interval[1]

            // 겹치지 않음
            if (end1 < start2) {
                result.add(intArrayOf(start2, end2))
            } else { // 겹침
                result.removeLast()

                val end = max(end1, end2)
                result.add(intArrayOf(start1, end))
            }
        }

        return result.toTypedArray()
    }
}

fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 6),
        intArrayOf(8, 10),
        intArrayOf(15, 18),
    )

    println(Solution73().merge(intervals).contentDeepToString())
}
