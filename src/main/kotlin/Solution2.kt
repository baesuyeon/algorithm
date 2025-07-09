package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/12919
 *
 * 배운 것 :
 * - forEachIndexed는 컬렉션을 순회하면서 인덱스와 값을 동시에 사용할 수 있도록 해주는 확장 함수이다.
 *   forEach의 확장 버전이라고 생각할 수 있다.
 */
class Solution2 {
    fun solution(seoul: Array<String>): String {
        var position: Int = 0

        seoul.forEachIndexed { index, value ->
            if (value == "Kim") {
                position = index
            }
        }

        return "김서방은 ${position}에 있다"
    }
}

fun main() {
    val input: Array<String> = arrayOf("Jane", "Kim")
    val answer = Solution2().solution(input)
    print(answer)
}
