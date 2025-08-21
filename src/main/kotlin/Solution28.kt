package org.example

/**
 * 문제 : https://www.acmicpc.net/problem/15649
 * - N개 중 M개를 뽑는 Case
 * - ex) {1, 2, 3, 4, 5} 중 3개를 뽑는 Case
 * - 순서에 상관이 있고 중복을 허용하지 않고 나올 수 있는 모든 수열
 * 배운 것 :
 */
class Solution28 {
    val check = Array(9) { false } // 중복된 값을 선택하지 않기 위한 배열
    val temp = Array(8) { 0 } // N개 중 M개를 뽑은 순열
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
            if (check[i]) {
                continue
            }
            check[i] = true
            temp[index] = i
            dfs(index + 1, n, m)
            check[i] = false
        }
    }

    fun run(n: Int, m: Int) {
        dfs(index = 0, n = n, m = m)

        val bw = System.out.bufferedWriter()
        bw.write(sb.toString())
        bw.flush()
    }
}

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    Solution28().run(n = N, m = M)
}
