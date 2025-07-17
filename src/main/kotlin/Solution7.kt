package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/12931
 *
 * 배운 것 :
 * - Kotlin에서 Char을 Int로 변환하기 위해서는 Char.toInt()가 아니라 (아스키코드를 반환한다)
 *   String으로 변환 후 toInt()를 호출해야 한다.
 *
 */
class Solution7 {
    fun solution(n: Int): Int {
        var answer = 0

        n.toString().forEach { num ->
            answer += num.toString().toInt()
        }

        return answer
    }
}

fun main() {
    val answer = Solution7().solution(123)
    print(answer)
}
