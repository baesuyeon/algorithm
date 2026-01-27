package org.example

/**
 * 문제 : https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운 것:
 * Kotlin에서 List, Set, Map 같은 컬렉션은 == 연산자를 사용하면 내부적으로 equals()가 호출되고
 * 컬렉션의 논리적 내용을 기준으로 비교된다.
 *
 * 코틀린에서 리스트 비교
 * ==: 값 비교(`equals()` 호출)
 * ===: 주소 비교 (reference equality)
 *
 * val a = listOf(1, 2, 3)
 * val b = listOf(1, 2, 3)
 *
 * println(a == b)   // true
 * println(a === b)  // false
 *
 * 주의)
 * * 배열(Array, IntArray)은 예외라는 점 참고 (==가 주소 비교)
 * * 리스트에서 순서는 비교한다.
 */
class Solution82 {
    fun closeStrings(word1: String, word2: String): Boolean {
        val map1 = mutableMapOf<Char, Int>()
        val map2 = mutableMapOf<Char, Int>()

        word1.forEach {
            map1[it] = map1.getOrDefault(it, 0) + 1
        }

        word2.forEach {
            map2[it] = map2.getOrDefault(it, 0) + 1
        }

        val values1 = map1.entries.map { it.value }.sorted()
        val values2 = map2.entries.map { it.value }.sorted()

        return values1.size == values2.size && (values1 == values2) && (map1.keys == map2.keys)
    }
}

fun main() {
    val word1 = "abbzccca"
    val word2 = "babzzczc"

    println(Solution82().closeStrings(word1, word2))
}
