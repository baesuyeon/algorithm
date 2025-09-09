package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/87946
 *
 * 배운 것
 * - 순서에 따라 결과가 달라질 수 있다. -> 순열
 * - 중복을 허용하지 않는다 -> check 배열 필요
 */
class Solution35 {
    var answer: Int = 0
    val check = Array(10) { false }

    fun dfs(index: Int, k: Int, dungeons: Array<IntArray>, visitNum: Int) {
        if (visitNum > answer) {
            answer = visitNum
        }

        if (index >= dungeons.size) {
            return
        }

        for (i in (0..dungeons.size - 1)) {
            if (!check[i]) {
                val min = dungeons[i][0]
                if (k >= min) {
                    check[i] = true
                    dfs(index + 1, k - dungeons[i][1], dungeons, visitNum + 1)
                    check[i] = false
                }
            }
        }
    }

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        dfs(0, k, dungeons, 0)

        return answer
    }
}

fun main() {
    val k = 80
    val dungeons = arrayOf(
            intArrayOf(80, 20),
            intArrayOf(50, 40),
            intArrayOf(30, 10),
        )

    println(Solution35().solution(k, dungeons))
}
