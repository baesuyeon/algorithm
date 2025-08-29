package org.example

/**
 * 문제 : https://www.acmicpc.net/problem/15651
 * - 1~N 중 M개를 뽑는 Case
 * - ex) {1, 2, 3, 4, 5} 중 3개를 뽑는 Case
 * - 순서에 상관이 있고 중복을 허용하면서 나올 수 있는 모든 수열
 * 배운 것 :
 * - 입력을 받아야할 때 readLine()을 사용할 수 있다.
 * - List도 구조 분해 할당이 가능하다
 * - 출력시 StringBuilder, System.out.bufferedWriter()를 사용해야 한다. (버퍼(메모리)에 모았다가 크게 모이면 한번에 출력)
 */
class Solution27 {
    val temp = Array(7) { 0 } // N개 중 M개를 뽑은 순열
    val sb = StringBuilder()

    fun dfs(index: Int, n: Int, m: Int) {
        if (index >= m) {
            for (i in (0..m - 1)) {
                sb.append(temp[i])
                if (i != m - 1) {
                    sb.append(' ')
                }
            }
            sb.append('\n')

            return
        }

        for (i in (1..n)) {
            temp[index] = i
            dfs(index + 1, n, m)
        }
    }

    fun solution(n: Int, m: Int) {
        dfs(index = 0, n = n, m = m)

        val bw = System.out.bufferedWriter()
        bw.write(sb.toString())
        bw.flush()
    }
}

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    Solution27().solution(n = N, m = M)
}
