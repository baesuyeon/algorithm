package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/12935
 *
 * 배운 것 :
 * - kotlin 1.4.0 버전 부터는 min() 대신 minOrNull()을 사용한다.
 * - min()은 최소값이 존재하지 않을 경우 NoSuchElementException을 발생시킨다.
 */
class Solution5 {
    fun solution(arr: IntArray): IntArray {
        val intList = arr.toList()
        val minValue = intList.minOrNull() ?: -1

        val result: List<Int> = intList.mapNotNull {
            if (it == minValue) {
                null
            } else {
                it
            }
        }

        return if (result == emptyList<Int>()) {
            intArrayOf(-1)
        } else {
            result.toIntArray()
        }
    }
}

fun main() {
    val arr = intArrayOf(4,3,2,1)
    val answer = Solution5().solution(arr)
    print(answer.toList())
}
