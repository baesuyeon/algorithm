package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42578
 *
 * 배운것 :
 * - 각 종류별로 n가지 선택 + 아무것도 선택하지 않는 경우(1) -> (n + 1)가지 선택지가 있다.
 */
class Solution16 {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer: Int = 1 // 곱셈 기반이라 초기값은 1
        val map = mutableMapOf<String, Int>()

        clothes.forEach { row ->
            val clothKind = row[1]

            map[clothKind] = map.getOrDefault(clothKind, 0) + 1
        }

        map.entries.forEach { (key, value) ->
            answer *= (value + 1)
        }

        return answer - 1 // 아무 의상도 입지 않은 케이스를 제외한다
    }
}

fun main() {
    val clothes: Array<Array<String>> = arrayOf(
        arrayOf("crow_mask", "face"),
        arrayOf("blue_sunglasses", "face"),
        arrayOf("smoky_makeup", "face")
    )
    val answer = Solution16().solution(clothes)
    print(answer)
}
