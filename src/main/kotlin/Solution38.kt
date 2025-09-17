package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */
class Solution38 {
    fun solution(elements: IntArray): Int {
        val set = mutableSetOf<Int>()

        for (i in (0..elements.size - 1)) {
            var sum = 0 // 누적 합

            for (j in (i..elements.size - 1)) {
                sum += elements[j]
                set.add(sum)
            }

            for (k in (0..i - 1)) {
                sum += elements[k]
                set.add(sum)
            }
        }

        return set.size
    }
}

fun main() {
    val elements = intArrayOf(7, 9, 1, 1, 4)

    println(Solution38().solution(elements))
}
