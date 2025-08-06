package org.example

import java.util.PriorityQueue

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42587?language=kotlin
 *
 * 배운것 :
 * - Kotlin에서 PriorityQueue<Int>()는 기본적으로 오름차순 정렬을 사용하기 때문에 peek() 하면 가장 작은 값이 나온다.
 * - 값이 클수록 우선순위 높게 하고 싶다면 PriorityQueue 생성 시 Comparator를 지정해주면 된다.
 * - ex) PriorityQueue<Int>(compareByDescending { it })
 * - PQ에 추가: add(element)
 * - PQ head 확인: peek()
 * - PQ head 제거: poll() // remove() 도 가능하나, poll()은 null-safe (큐가 비어있으면 NoSuchElementException가 아닌 null 반환)
 */
class Solution18 {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0

        val queue = ArrayDeque<Element>()
        val priorityQueue = PriorityQueue<Int>(compareByDescending { it })

        priorities.forEachIndexed { index, value ->
            queue.add(
                Element(
                    index = index,
                    value = value
                )
            )

            priorityQueue.add(value)
        }

        while(!queue.isEmpty()) {
            // 프로세스 실행 조건 만족
            if (queue.first().value == priorityQueue.peek()) {
                val e = queue.removeFirst()
                priorityQueue.remove()
                answer++

                if (e.index == location) {
                    break
                }
            } else {
                val e = queue.removeFirst()
                queue.addLast(e)
            }
        }

        return answer
    }
}

data class Element(
    val index: Int,
    val value: Int,
)

fun main() {
    val priorities = intArrayOf(1, 1, 9, 1, 1, 1)
    val location = 0
    val answer = Solution18().solution(priorities, location)
    print(answer)
}
