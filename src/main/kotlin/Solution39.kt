package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/152996
 *
 * 배운 것 :
 * - weights의 길이가 100,000이기 때문에 이중 for문으로는 풀 수 없다. (for문 한번으로 풀어야한다)
 * - 1:1, 2:3, 1:2, 2:1, 3:2, 3:4, 4:3 비율인 경우만 시소쌍이 될 수 있다.
 * - (a, b), (b, a)는 시소쌍 1개로 보기 때문에, 1:1, 2:3, 1:2, 3:4 케이스만 고려하기로 한다.
 * - 오름차순으로 정렬한 뒤, 각 weight가 큰 수일 케이스로 고려하여 계산하였다.
 * - 짝꿍 관계가 (작은 값, 큰 값) 이라고 가정했고, weights를 순회하면서 두번째 사람을 고르고, 그 사람과 짝꿍이 될 수 있는 사람을 고른다.
 * - 작은값 => 큰값 순서로 등장해야 map에 작은 값이 먼저 들어가고 큰 값이 그걸 참조할 수 있기 때문에 오름차순으로 정렬하였다.
 *   - 1:1 => 1, 2:3 => 2/3, 1:2 => 1/2, 3:4 => 3/4
 *   - 시소 짝꿍이 map에 존재하면 answer에 시소 짝꿍 수를 더한다.
 */
class Solution39 {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0

        val map = mutableMapOf<Double, Int>()

        weights.sorted().forEach { weight ->
            val a = weight * 1.0
            val b = weight / 2.0
            val c = (weight / 3.0) * 2.0
            val d = (weight / 4.0) * 3.0

            if (map.containsKey(a)) {
                answer += map[a] ?: 0
            }
            if (map.containsKey(b)) {
                answer += map[b] ?: 0
            }
            if (map.containsKey(c)) {
                answer += map[c] ?: 0
            }
            if (map.containsKey(d)) {
                answer += map[d] ?: 0
            }

            map.put(
                key = weight.toDouble(),
                value = (map[weight.toDouble()] ?: 0) + 1
            )
        }

        return answer
    }
}

fun main() {
    val weights = intArrayOf(100,180,360,100,270)

    println(Solution39().solution(weights))
}
