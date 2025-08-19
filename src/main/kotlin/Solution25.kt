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
        dfs(total = 0, numbers = numbers, index = 0, target = target)

        return answer
    }

    fun dfs(total: Int, numbers: IntArray, index: Int, target: Int) { // total = 누적 합계값
        // dfs 종료 조건 (가장 마지막 인덱스까지 연산이 완료되었을 때)
        if (index == numbers.size) {
            if (total == target) {
                answer++
            }
            return
        }

        dfs(total + numbers[index], numbers, index + 1, target = target)
        dfs(total - numbers[index], numbers, index + 1, target = target)
    }
}

fun main() {
    val numbers = intArrayOf(1, 1, 1, 1, 1)
    val target = 3
    val answer = Solution25().solution(numbers, target)
    print(answer)
}
