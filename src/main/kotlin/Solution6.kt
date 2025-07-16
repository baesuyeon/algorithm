package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/131127
 *
 * 배운 것 :
 * - Map의 키가 존재하지 않을 때 기본값을 주는 방식으로 (windowMap[key] ?: 0) 또는 windowMap.getOrDefault(key, 0)를 사용할 수 있다.
 * - Kotlin의 zip() 함수는 두 배열을 쌍으로 묶어서 List<Pair<A, B>> 형태로 만들어준다
 *   - ["banana", "apple", "rice"], [3, 2, 1] => [("banana", 3), ("apple", 2), ("rice", 1)]
 *   - 이렇게 만들어진 Pair 리스트를 .toMap()을 이용해 Map<String, Int>로 변환할 수 있다.
 */
class Solution6 {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0

        val targetMap: Map<String, Int> = want.zip(number.toList()).toMap()
        val windowMap: MutableMap<String, Int> = mutableMapOf()

        for (i in 0..9) {
            windowMap[discount[i]] = windowMap.getOrDefault(discount[i], 0) + 1
        }

        for (i in 0 .. (discount.size - 10)) {
            if (matches(targetMap, windowMap)) {
                answer++
            }

            if (i == (discount.size - 10)) {
                break
            }

            // 윈도우 이동
            windowMap[discount[i]] = windowMap.getOrDefault(discount[i], 0) - 1
            windowMap[discount[i + 10]] = windowMap.getOrDefault(discount[i + 10], 0) + 1
        }


        return answer
    }

    private fun matches(targetMap: Map<String, Int>, windowMap: Map<String, Int>): Boolean {
        return targetMap.all { (item, count) ->
            windowMap.getOrDefault(item, 0) >= count
        }
    }
}

fun main() {
    val want = arrayOf("banana", "apple", "rice", "pork", "pot")
    val number = intArrayOf(3, 2, 2, 2, 1)
    val discount = arrayOf("chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana")
    val answer = Solution6().solution(want, number, discount)
    print(answer)
}
