package org.example

/**
 * 문제 : https://www.acmicpc.net/problem/6603
 * 오름차순으로 정렬된 K개의 숫자 중에서 6개를 뽑는 조합
 *
 * 배운 것 :
 * - { 1 2 3 4 5 6 7 }
 * - 1 부터 시작 → 뒤에서 5개 선택 가능 → OK
 * - 2 부터 시작 → 뒤에서 5개 선택 가능 → OK
 * - 3 부터 시작 → 뒤에서 5개 선택해야 하는데 뒤에는 [4,5,6,7] 4개뿐이라 6개를 다 채울 수가 없다
 *   → DFS는 끝까지 가지 못하고 출력도 생기지 않는다
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
