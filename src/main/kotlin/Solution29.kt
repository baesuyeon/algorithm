package org.example

/**
 * 문제 : https://www.acmicpc.net/problem/15650
 * - 1~N 중 M개를 뽑는 Case
 * - ex) {1, 2, 3, 4, 5} 중 3개를 뽑는 Case
 * - 고른 수열은 오름차순이어야 한다.
 *
 * 배운 것 :
 * - 조합 문제 (from 설정)
 */
class Solution29 {
    val temp = Array(8) { 0 }
    val sb = StringBuilder()

    fun dfs(index: Int, n: Int, m: Int, from: Int) {
        if (index >= m) {
            for (i in (0..m - 1)) {
                sb.append(temp[i])
                if (i != m - 1) {
                    sb.append(" ")
                }
            }
            sb.append("\n")

            return
        }

        for (i in (from..n)) {
            temp[index] = i
            dfs(index + 1, n, m, i + 1)
        }
    }

    fun solution(n: Int, m: Int) {
        dfs(0, n, m, 1)

        val bw = System.out.bufferedWriter()
        bw.write(sb.toString())
        bw.flush()
    }
}

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    Solution29().solution(n, m)
}
