package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/131704?language=kotlin
 */
class Solution24 {
    fun solution(order: IntArray): Int {
        var answer: Int = 0
        val stack = ArrayDeque<Int>()
        val packages = (1..order.size).toList().toIntArray()
        var packagePointer = 0

        for (target in (order)) {
            while(true) {
                if (packagePointer < order.size && target == packages[packagePointer]) {
                    packagePointer++
                    answer++
                    break
                } else if (target == stack.lastOrNull()) {
                    stack.removeLast()
                    answer++
                    break
                } else if (packagePointer < order.size) {
                    stack.addLast(packages[packagePointer])
                    packagePointer++
                } else {
                    return answer
                }
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
