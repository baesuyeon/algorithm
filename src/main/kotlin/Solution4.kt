package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/138476
 *
 * 배운 것 :
 * - groupingBy().eachCount()를 사용하면, 해당 리스트 내 각 요소가 몇 번 등장했는지를 Map<요소, 개수> 형태로 반환한다.
 */
class Solution4 {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var totalSize = k

        val map = tangerine.toList().groupingBy { it }.eachCount() // <Size, Count>

        map.values.sortedByDescending { it }

        for(count in map.values.sortedByDescending { it }) {
            answer++
            totalSize -= count
            if (totalSize <= 0) {
                break
            }
        }

        return answer
    }
}

fun main() {
    val k = 2
    val tangerine = intArrayOf(1, 1, 1, 1, 2, 2, 2, 3)
    val answer = Solution4().solution(k, tangerine)
    print(answer)
}
