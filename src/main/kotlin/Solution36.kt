package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=kotlin
 *
 * 배운 것
 * - 각 숫자를 문자열로 바꾼다.
 * - 정렬 조건 : 문자열 a, b를 각각 이어붙인 후 어느 순서가 더 큰 숫자를 만드는지 비교한다 (ab vs ba)
 */
class Solution36 {

    fun solution(numbers: IntArray): String {
        val stringNumbers = numbers.toList().map { it.toString() }

        val sortedNumbers = stringNumbers.sortedWith { a, b ->
            (b + a).compareTo(a + b)
        }

        return if (sortedNumbers[0] == "0") {
            "0"
        } else {
            sortedNumbers.joinToString("")
        }
    }
}

fun main() {
    val numbers = intArrayOf(6, 10, 2)

    println(Solution36().solution(numbers))
}
