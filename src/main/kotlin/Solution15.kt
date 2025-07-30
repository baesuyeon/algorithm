package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/76502
 *
 * 배운것 :
 * - Deque (ArrayDeque) 사용법 (ArrayDeque를 Stack 대신 사용하는것이 권장된다)
 * - val deque = ArrayDeque<Char>()  // 또는 ArrayDeque<Int>(), ArrayDeque<String>() 등
 * - 앞에 추가: addFirst(element), 뒤에 추가: addLast(element)
 * - 앞에 제거: removeFirst(), 뒤에 제거 removeLast()
 * - 앞에 확인: first() 또는 peekFirst(), 뒤에 확인: last() 또는 peekLast()
 */
class Solution15 {
    fun solution(s: String): Int {
        var answer: Int = 0
        var stringDeque = ArrayDeque(s.toList())

        repeat(s.length) {
            val string = stringDeque.joinToString("")

            if(isValidString(string)) {
                answer++
            }

            stringDeque.addLast(stringDeque.removeFirst())
        }

        return answer
    }

    private fun isValidString(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val map = mapOf(']' to '[', ')' to '(', '}' to '{')

        for (c in s) {
            when (c) {
                '[', '(', '{' -> stack.addLast(c)
                ']', ')', '}' -> {
                    if (stack.isEmpty() || (stack.removeLast() != map[c])) {
                        return false
                    }
                }
            }
        }

        return stack.isEmpty()
    }
}

fun main() {
    val s = "[](){}"
    val answer = Solution15().solution(s)
    print(answer)
}
