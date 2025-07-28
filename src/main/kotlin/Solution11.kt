package org.example

import java.util.Stack

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
class Solution11 {
    fun solution(s: String): IntArray {
        var currentString: String = s
        var zeroCount = 0
        var calculateCount = 0

        while (currentString != "1") {
            val onesString = currentString.filter { it == '1' }

            zeroCount += currentString.length - onesString.length
            currentString = onesString.length.toString()

            currentString = calculate(currentString.toInt())
            calculateCount++
        }

        var answer: IntArray = intArrayOf(calculateCount, zeroCount)
        return answer
    }

    private fun calculate(num: Int): String {
        var num = num
        var stack = Stack<Int>()
        var result: String = ""

        while(num != 0) {
            stack.push(num % 2)
            num = num / 2
        }

        while(!stack.empty()) {
            result += stack.pop().toString()
        }

        return result
    }
}

fun main() {
    val s: String = "110010101001"
    val answer = Solution11().solution(s)
    print(answer)
}
