package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/132265
 *
 * 배운 것 :
 * - map.remove(key) : mutable map에서 키/값 쌍을 삭제하기 위해 사용한다
 */
class Solution9 {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0

        val map1 = mutableMapOf<Int, Int>()
        val map2 = mutableMapOf<Int, Int>()

        for (t in topping) {
            map2[t] = map2.getOrDefault(t, 0) + 1
        }

        topping.forEach { t  ->
            map1[t] = map1.getOrDefault(t, 0) + 1
            map2[t] = map2.getOrDefault(t, 0) - 1
            if(map2[t] == 0) {
                map2.remove(t)
            }

            if (map1.size == map2.size) {
                answer++
            }
        }

        return answer
    }
}

fun main() {
    val topping: IntArray = intArrayOf(1, 2, 1, 3, 1, 4, 1, 2)
    val answer = Solution9().solution(topping)
    print(answer)
}
