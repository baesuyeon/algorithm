package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/131704?language=kotlin
 *
 * 배운것 :
 * - 메인 벨트는 1..n 순서대로 온다
 * - 오는 족족 스택에 넣고 pop이 가능한 동안 pop 하면 된다.
 * - 타겟을 맞추려 가는 방향이 아니라 들어오는 흐름을 스택에 흘리면서 맞출 수 있을 때만 꺼낸다.
 */
class Solution24 {
    fun solution(order: IntArray): Int {
        var answer: Int = 0
        val stack = ArrayDeque<Int>()

        for (box in (1..order.size)) {
            stack.addLast(box)

            while(!stack.isEmpty() && stack.last() == order[answer]) {
                stack.removeLast()
                answer++
            }
        }

        return answer
    }
}

fun main() {
    val order = intArrayOf(4, 3, 1, 2, 5)
    val answer = Solution24().solution(order)
    print(answer)
}
