package org.example

import java.util.*

/**
 * 문제 : https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운 것:
 * - for문 안에서 인덱스가 필요한 경우 indices를 사용할 수 있다.
 *   - for (변수명 in 객체명.indices) { }
 */
class Solution65 {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var count = 0

        for (index in flowerbed.indices) {
            if (flowerbed[index] == 1) continue

            val isLeftEmpty = (index == 0 || flowerbed[index - 1] == 0)
            val isRightEmpty = (index == flowerbed.size - 1 || flowerbed[index + 1] == 0)

            if (isLeftEmpty && isRightEmpty) {
                flowerbed[index] = 1
                count++
            }
        }

        return (count >= n)
    }
}


fun main() {
    val flowerbed = intArrayOf(1,0,0,0,1)
    val n = 2

    println(Solution65().canPlaceFlowers(flowerbed, n))
}
