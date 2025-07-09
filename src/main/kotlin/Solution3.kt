package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/12903
 *
 * 배운 것 :
 * - str.substring(startIndex: Int, endIndex: Int): String
 *   - startIndex: 포함됨
 *   - endIndex: 포함되지 않음 (exclusive)
 *   - 즉, [startIndex, endIndex) 구간의 문자열을 반환한다.
 */
class Solution3 {
    fun solution(s: String): String {
        var answer: String = ""

        if (s.length % 2 == 0) {
            answer = s.substring(s.length / 2 - 1, s.length / 2 + 1)
        } else {
            answer = s.substring(s.length / 2, s.length / 2 + 1)
        }

        return answer
    }
}

fun main() {
    val answer = Solution3().solution("qwer")
    print(answer)
}
