package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/76502
 *
 * 배운것 :
 * - 이 문제의 핵심은 각 라운드마다 번호가 반으로 줄어들면서 새로 매겨진다는 점이다.
 * - 참가자 A와 B가 서로 만날 때까지 몇 라운드가 걸리는지는 새로 매겨진 위치가 동일해지는 시점과 같다.
 */
class Solution14 {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0

        var nextPos1 = a
        var nextPos2 = b

        while(nextPos1 != nextPos2) {
            nextPos1 = (nextPos1 + 1) / 2
            nextPos2 = (nextPos2 + 1) / 2
            answer++
        }

        return answer
    }
}

fun main() {
    val n = 8
    val a = 4
    val b = 7
    val answer = Solution14().solution(n, a, b)
    print(answer)
}
