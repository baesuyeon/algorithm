package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/64065?language=kotlin
 *
 * 배운것 :
 * - map.toList()의 결과는 List<Pair<Int, Int>>가 된다.
 * - map value 기준 내림차순 정렬 : val sortedByValueDesc = map.toList().sortedByDescending { it.second }
 * - map key 기준 내림차순 정렬 : val sortedByKeyDesc = map.toList().sortedByDescending { it.first }
 */
class Solution17 {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()

        val countMap = mutableMapOf<Int, Int>()

        var temp = 0
        s.forEachIndexed { index, char ->
            if (isNumber(char)) {
                temp += char.toString().toInt()
                if (isNumber(s[index + 1])) {
                    temp *= 10
                }
            } else {
                countMap[temp] = countMap.getOrDefault(temp, 0) + 1
                temp = 0
            }
        }

        val sortedList = countMap.toList().sortedByDescending { it.second }

        answer = sortedList.mapNotNull { (key, value) ->
            if (key == 0) {
                null
            } else {
                key
            }
        }.toIntArray()

        return answer
    }

    private fun isNumber(char: Char): Boolean {
        return char != '{' && char != '}' && char != ','
    }
}

fun main() {
    val s = "{{20,111},{111}}"
    val answer = Solution17().solution(s)
    print(answer)
}
