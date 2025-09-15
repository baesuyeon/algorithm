package org.example

import kotlin.math.min

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42860?language=kotlin
 */
class Solution38 {
    fun solution(name: String): Int {
        val size = 'Z' - 'A' + 1

        // 각 문자 별 상하 방향 최소 이동 횟수
        val minCount = Array(size = name.length) { 0 }

        name.forEachIndexed { index, word ->
            val a = word - 'A'
            val b = size - (word - 'A')
            minCount[index] = min(a, b)
        }

        // 오른쪽으로 돌았을 때 조이스틱을 움직인 최소 횟수
        var right = 0
        // 왼쪽 돌았을 때 조이스틱을 움직인 최소 횟수
        var left = 0

        // 오른쪽으로 돌면서 알파벳을 교체해가는 배열
        var rightArray = Array(size = name.length) { 'A' }
        // 왼쪽으로 돌면서 알파벳을 교체해가는 배열
        var leftArray = Array(size = name.length) { 'A' }

        // 오른쪽 회전
        for(i in (0..name.length - 1)) {
            right += minCount[i]
            rightArray[i] = name[i]
            if (rightArray.joinToString("") == name) {
                break
            }
            right += 1
        }

        // 왼쪽 회전
        left += minCount[0]
        leftArray[0] = name[0]
        if(leftArray.joinToString("") != name) {
            left += 1
            for(i in (name.length - 1 downTo 1)) {
                left += minCount[i]
                leftArray[i] = name[i]
                if (leftArray.joinToString("") == name) {
                    break
                }
                left += 1
            }
        }

        return min(left, right)
    }
}

fun main() {
    val name = "BBBAAAAAB" // 기댓값 8

    println(Solution38().solution(name))
}
