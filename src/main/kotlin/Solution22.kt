package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/154539
 *
 * 배운것 :
 * - 크기가 고정된 MutableList 생성
 * - val answer: MutableList<Int> = MutableList(size = numbers.size) { 0 }
 *
 * - MutableList -> IntArray
 * - answer.toIntArray()
 *
 * - MutableList -> ArrayList
 * - ArrayList(answer)
 */
class Solution22 {
    fun solution(numbers: IntArray): IntArray {
        val answer: MutableList<Int> = MutableList(size = numbers.size) { 0 }
        val stack = ArrayDeque<Int>() // index가 저장된다

        stack.addLast(0)

        for (index in (1..(numbers.size - 1))) {
            while(!stack.isEmpty() && numbers[stack.last()] < numbers[index]) {
                answer[stack.last()] = numbers[index]
                stack.removeLast()
            }
            stack.addLast(index)
        }

        while (!stack.isEmpty()) {
            answer[stack.last()] = -1
            stack.removeLast()
        }

        return answer.toIntArray()
    }
}

fun main() {
    val numbers = intArrayOf(9, 1, 5, 3, 6, 2)
    val answer = Solution22().solution(numbers)
    print(answer.joinToString(""))
}
