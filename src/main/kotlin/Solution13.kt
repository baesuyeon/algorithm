package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/12945
 *
 * 배운것 :
 * - (a + b) % c == ((a % c) + (b % c)) % c
 * - 모듈러 연산을 중간마다 해줘도 최종 결과에 영향이 없다.
 * - 오히려 정수 오버플로우 방지 때문에 반드시 해줘야 한다.
 */
class Solution12 {
    fun solution(n: Int): Int {
       var tmp1: Int = 0
       var tmp2: Int = 1

        repeat(n - 1) {
            val tmp3 = (tmp1 + tmp2) % 1234567
            tmp1 = tmp2
            tmp2 = tmp3
        }

        return tmp2 % 1234567
    }
}

fun main() {
    val n = 5
    val answer = Solution12().solution(n)
    print(answer)
}
