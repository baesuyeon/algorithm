package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/12939
 *
 * 배운 것 :
 * - split(vararg delimiters: String, ignoreCase: Boolean = false)
 * - : 여러 문자열을 구분자로 사용할 수 있고 대소문자를 무시할지 선택할 수 있다.
 */
class Solution10 {
    fun solution(s: String): String {
        val numberList: List<Int> = s.split(" ").map { it.toInt() }

        val min = numberList.minOrNull()
        val max = numberList.maxOrNull()

        return "$min $max"
    }
}

fun main() {
    val s: String = "-1 -1"
    val answer = Solution10().solution(s)
    print(answer)
}
