package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/12949
 *
 * 배운것 :
 * - 1차원 배열 초기화 방법
 *   - Array(3) { it -> it * 2 } → 인덱스로 초기화, [0, 2, 4]
 *   - Array(5) { 3 } => [3, 3, 3] → 모든 행이 같은 row
 * - 2차원 배열 초기화 방법
 *   - Array(행의 크기, {IntArray(열의 크기, {초기화 값})}
 *   - Array(size = 3, { IntArray(2, { 0 }) })
 */
class Solution23 {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = Array(size = arr1.size, { IntArray(arr2[0].size, { 0 }) })

        for (i in (0..arr1.size - 1)) {
            for (j in (0..arr2[0].size - 1)) {
                for (k in (0..arr2.size - 1)) {
                    answer[i][j] += arr1[i][k] * arr2[k][j]
                }
            }
        }

        return answer
    }
}

fun main() {
    val arr1 = arrayOf(
        intArrayOf(1, 4),
        intArrayOf(3, 2),
        intArrayOf(4, 1),
    )
    val arr2 = arrayOf(
        intArrayOf(3, 3),
        intArrayOf(3, 3),
    )
    val answer = Solution23().solution(arr1, arr2)
    print(answer.joinToString(""))
}
