package org.example

/**
 * 문제 : https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운 것:
 * - dfs 종료 조건에서는 항상 return을 빼먹으면 안된다.
 * - CharArray to String
 *   - String(char 배열, 시작 인덱스, 변환할 길이)
 */
class Solution52 {
    var temp = CharArray(4) { ' ' }
    var answer = mutableListOf<String>()

    val map = mapOf(
        '2' to listOf('a', 'b', 'c'),
        '3' to listOf('d', 'e', 'f'),
        '4' to listOf('g', 'h', 'i'),
        '5' to listOf('j', 'k', 'l'),
        '6' to listOf('m', 'n', 'o'),
        '7' to listOf('p', 'q', 'r', 's'),
        '8' to listOf('t', 'u', 'v'),
        '9' to listOf('w', 'x', 'y', 'z'),
    )

    fun dfs(index: Int, digits: String) {
        if (index == digits.length) {
            answer.add(String(temp, 0, digits.length))
            return
        }

        val words: List<Char> = map[digits[index]] ?: throw IllegalArgumentException()

        for (word in words) {
            temp[index] = word
            dfs(index + 1, digits)
        }
    }

    fun letterCombinations(digits: String): List<String> {
        dfs(0, digits)
        return answer
    }
}

fun main() {
    val digits = "23"

    val answer = Solution52().letterCombinations(digits)
    print(answer.joinToString(", "))
}
