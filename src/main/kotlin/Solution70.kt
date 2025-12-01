package org.example

/**
 * 문제 : https://leetcode.com/problems/combination-sum-iii/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운 것 :
 * - 조합, 백트래킹
 */
class Solution70 {
    val check = Array<Int>(size = 10) { 0 }
    val answer = mutableListOf<List<Int>>()
    val temp = Array<Int>(size = 10) { 0 }

    fun dfs(index: Int, k: Int, n: Int, cumulative: Int, from: Int) {
        if (cumulative > n) {
            return
        }

        if (index >= k) {
            // edge
            val result = temp.copyOfRange(0, k)
            if (result.sum() == n) {
                answer.add(result.toList())
            }
            return
        }

        for (i in (from..9)) {
            if (check[i] == 0) {
                check[i] = 1
                temp[index] = i
                dfs(index + 1, k, n, cumulative + i, i + 1)
                check[i] = 0
            }
        }
    }

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        dfs(0, k, n, 0, 1)
        return answer
    }
}


fun main() {
    val k = 3
    val n = 9

    println(Solution70().combinationSum3(k, n))
}
