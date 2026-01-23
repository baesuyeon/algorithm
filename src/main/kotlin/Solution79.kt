package org.example

import kotlin.math.min

/**
 * 문제 : https://leetcode.com/problems/heaters/description/
 * 배운것 :
 * binarySearch(target)의 반환값이
 * 0보다 크면: 정확히 일치하는 인덱스를 반환
 * 0보다 작으면: -(원래 위치) -1 값을 반환 (target보다 큰 값이 처음 나오는 인덱스)
 *
 * arr = [1, 4, 8, 10]
 * target = 6
 * binarySearch(6) = -3
 *
 * arr = [2, 3, 4]
 * target = 5
 * binarySearch(5) = -4
 *
 * (1) 각 집마다 히터와의 최단 거리를 구한다.
 * (2) (1) 목록 중 가장 큰 값을 반환한다.
 */
class Solution79 {
    fun findRadius(houses: IntArray, heaters: IntArray): Int {
        val minRadiusList = mutableListOf<Int>()
        heaters.sort()

        // 각 집마다 히터와의 최단 거리를 구한다.
        houses.forEach { house ->
            val result = heaters.binarySearch(house)

            if (result >= 0) {
                minRadiusList.add(0)
            } else {
                val index = -1 * result - 1

                val left = if (index - 1 >= 0) {
                    kotlin.math.abs(heaters[index - 1] - house)
                } else {
                    Int.MAX_VALUE
                }
                val right = if (index >= heaters.size) {
                    Int.MAX_VALUE
                } else {
                    kotlin.math.abs(heaters[index] - house)
                }

                minRadiusList.add(min(left, right))
            }
        }

        return minRadiusList.max()
    }
}

fun main() {
    val houses = intArrayOf(1,5)
    val heaters = intArrayOf(2)

    println(Solution79().findRadius(houses, heaters))
}
