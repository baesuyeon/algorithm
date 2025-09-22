package org.example

import kotlin.math.min

/**
 * 문제 : https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운 것 :
 * - 수조의 높이가 모두 동일했다면 0 ~ 마지막 인덱스 길이가 가장 넓이가 컸을것이다.
 * - 최대 넓이에서 시작해서 포인터를 이동시킨다.
 * - 각 단계별 넓이는 1씩 줄어들지만 줄인 쪽이 더 낮은 높이를 같이 때문에 넓이가 커질 여지가 있다.
 * - 양쪽 길이가 같다면 어느쪽을 먼저 옮기든 더 큰 높이를 만날 가능성은 양쪽에 똑같이 존재한다. -> 최대 면적을 얻는 조합은 결국 만나게 된다
 */
class Solution41 {
    fun maxArea(height: IntArray): Int {
        var answer = 0

        var start = 0
        var end = height.size - 1

        while(start < end) {
            val w = end - start
            val h = min(height[start], height[end])

            if (w * h > answer) {
                answer = w * h
            }

            if (height[start] < height[end]) {
                start++
            } else {
                end--
            }
        }

        return answer
    }
}

fun main() {
    val height = intArrayOf(1,8,6,2,5,4,8,3,7)

    println(Solution41().maxArea(height))
}
