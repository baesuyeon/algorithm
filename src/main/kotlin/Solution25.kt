package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/43165
 *
 * 배운것 : DFS는 스택 또는 재귀함수로 구현할 수 있다.
 * - 일반적으로는 별도의 스택을 직접 사용하지 않고 재귀 호출을 활용한 방식으로 많이 구현한다.
 */
class Solution25 {
    var answer = 0

    fun solution(numbers: IntArray, target: Int): Int {
        dfs(n = 0, numbers = numbers, depth = 0, target = target)

        return answer
    }

    fun dfs(n: Int, numbers: IntArray, depth: Int, target: Int) { // n = 노드
        // dfs 종료 조건 (가장 마지막 노드까지 연산이 완료되었을 때)
        if (depth == numbers.size) {
            if (n == target) {
                answer++
            }
            return
        }

        dfs(n + numbers[depth], numbers, depth + 1, target = target)
        dfs(n - numbers[depth], numbers, depth + 1, target = target)
    }
}

fun main() {
    val numbers = intArrayOf(1, 1, 1, 1, 1)
    val target = 3
    val answer = Solution25().solution(numbers, target)
    print(answer)
}
