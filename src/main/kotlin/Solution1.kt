package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/12948
 *
 * 배운 것 :
 * - Iterable<T>나 Array<T> 타입에서 사용 가능한 확장 함수 withIndex()는
 *   컬렉션의 각 요소에 대해 **인덱스(index)**와 **값(value)**을 제공한다.
 *   단순한 for 루프에서 index가 필요한 경우 사용할 수 있다.
 */
class Solution1 {
    fun solution(phone_number: String): String {
        var answer = ""

        for ((index, value) in phone_number.withIndex()) {
            answer += if (index < phone_number.length - 4) {
                "*"
            } else {
                value
            }
        }

        return answer
    }
}

fun main() {
    val answer = Solution1().solution("027778888")
    print(answer)
}
