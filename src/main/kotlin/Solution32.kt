package org.example

/**
 * 문제 : https://www.acmicpc.net/problem/6603
 *
 * 배운 것 :
 */
class Solution32 {
    val check = Array(6) { false }
    val temp = Array(6) { 0 } // k개 중 6개를 뽑은 조합

    fun dfs(index: Int, nums: List<Int>, start: Int) {
        val sb = StringBuilder()
        if (index == 6) {
            for (i in (0..5)) {
                sb.append(temp[i])
                if (i != 5) {
                    sb.append(' ')
                }
            }
            sb.append('\n')

            val bw = System.out.bufferedWriter()
            bw.write(sb.toString())
            bw.flush()
            return
        }

        check[index] = true


        for (i in (start .. nums.size - 1)) {
            temp[index] = nums[i]
            dfs(index + 1, nums, i + 1)
        }
    }

    fun solution(nums: List<Int>) {
        dfs(index = 0, nums = nums, 0)
        println()
    }
}

fun main() {
    do {
        val input: List<Int> = readLine()!!.split(" ").map { it.toInt() }
        if (input.first() == 0) {
            return
        }
        Solution32().solution(input.subList(1, input.size))
    } while (true)
}
