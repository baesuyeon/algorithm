package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/84512
 *
 * 배운 것
 * - CharArray를 String으로 바꾸는 방법
 *   - val charArray = charArrayOf('h', 'e', 'l', 'l', 'o', 'w')
 *     val str = String(charArray)
 *   - val charArray = charArrayOf('w', 'o', 'r', 'l', 'd')
 *     val str = charArray.concatToString()
 */
class Solution34 {
    val dictionary = listOf('A', 'E', 'I', 'O', 'U')
    var temp = CharArray(5) { ' ' }
    var answer = 0
    var isFound = false

    fun dfs(index: Int, word: String) {
        if (index >= 5) {
            return
        }

        for (i in (0..4)) {
            if (isFound) {
                return
            }
            temp[index] = dictionary[i]

            answer++
            if (temp.concatToString().trim() == word) {
                isFound = true
                return
            }

            dfs(index + 1, word)
            temp[index] = ' '
        }
    }

    fun solution(word: String): Int {
        dfs(index = 0, word = word)

        return answer
    }
}

fun main() {
    val word = "EIO"

    println(Solution34().solution(word))
}
