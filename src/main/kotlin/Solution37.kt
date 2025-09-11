package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */
class Solution37 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0

        val clothArray = Array(n + 1) { 1 }

        lost.forEach {
            clothArray[it] -= 1
        }

        reserve.forEach {
            clothArray[it] += 1
        }

        for (i in (1..n)) {
            if (clothArray[i] == 0) {
                // 왼쪽 사람에게 먼저 빌린다
                if (i > 1) {
                    if (clothArray[i - 1] >= 2) {
                        clothArray[i - 1] -= 1
                        clothArray[i] += 1
                        continue // 왼쪽 사람에게 빌리기 성공시에는 오른쪽 사람에게 빌리지 않는다
                    }
                }

                if (i < n) {
                    if (clothArray[i + 1] >= 2) {
                        clothArray[i + 1] -= 1
                        clothArray[i] += 1
                    }
                }
            }
        }

        for (i in (1..n)) {
            if (clothArray[i] >= 1) {
                answer++
            }
        }

        return answer
    }
}

fun main() {
    val n = 5
    val lost = intArrayOf(2, 4)
    val reserve = intArrayOf(1, 3, 5)

    println(Solution37().solution(n, lost, reserve))
}
