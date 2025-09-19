package org.example

import kotlin.math.max
import kotlin.math.min

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=kotlin
 *
 * 배운 것 :
 * - maxOfOrNull
 *   - 컬렉션의 최댓값을 반환한다.
 *   - 컬렉션이 비어있으면 null을 반환한다
 * val people = listOf(
 *     Person("철수", 28),
 *     Person("영희", 35),
 *     Person("민수", 22)
 * )
 *
 * val oldestAge = people.maxOfOrNull { it.age }
 */
class Solution40 {
    fun solution(sizes: Array<IntArray>): Int {
        val maxWidth = sizes.maxOfOrNull { it[0] } ?: 0
        val maxHeight = sizes.maxOfOrNull { it[1] } ?: 0

        // 가장 긴 길이
        val first = max(maxWidth, maxHeight)

        // 짧은 길이 중 가장 긴 길이
        val second = sizes.maxOfOrNull {
            min(it[0], it[1])
        } ?: 0

        return first * second
    }
}

fun main() {
    val sizes = arrayOf(
        intArrayOf(80, 70),
        intArrayOf(70, 60),
        intArrayOf(50, 40),
        intArrayOf(30, 20),
    )

    println(Solution40().solution(sizes))
}
