package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/12951
 *
 * 배운 것 :
 * - 대문자 변환: Char.uppercase(), String.uppercase()
 * - 소문자 변환: Char.lowercase(), String.lowercase()
 * - 대소문자 여부 확인 : Char.isUpperCase(), Char.isLowerCase()
 */
class Solution8 {
    fun solution(s: String): String {
        val words: List<String> = s.split(" ")

        val list = words.map { word ->
            if (word.isEmpty()) {
                ""
            } else if (word[0] >= '0' && word[0] <= '9') {
                word[0] + word.substring(1, word.length).lowercase()
            } else {
                word[0].uppercase() + word.substring(1, word.length).lowercase()
            }
        }

        return list.joinToString(" ")
    }
}

fun main() {
    val answer = Solution8().solution("AAAA")
    print(answer)
}
