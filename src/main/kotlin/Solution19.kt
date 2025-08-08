package org.example

/**
 * 문제 : https://leetcode.com/problems/valid-anagram/submissions/1727969124/
 *
 * 배운것 :
 * - 애너그램이란? 서로 다른 단어이지만 같은 알파벳으로 구성되어 있는 경우
 * - map 순회 방법: map.entries.forEach { (key, value) -> }
 *
 * - String.toCharArray(): 문자열을 문자 배열로 변환한다.
 * - Array.sorted(): 문자 배열을 사전 순으로 정렬한다. // sortedDescending() 역순 정렬
 */
class Solution19 {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val map1 = s.groupingBy { it }.eachCount()
        val map2 = t.groupingBy { it }.eachCount()

        map1.entries.forEach { (key, value) ->
            if (map2[key] != value) {
                return false
            }
        }

        return true
    }

    fun isAnagram2(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val result1 = s.toCharArray().sorted().joinToString("")
        val result2 = t.toCharArray().sorted().joinToString("")

        return result1 == result2
    }
}

fun main() {
    val s = "anagram"
    val t = "nagaram"
    val answer = Solution19().isAnagram2(s, t)
    print(answer)
}
