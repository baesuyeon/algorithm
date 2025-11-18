package org.example

/**
 * 문제 : https://leetcode.com/problems/generate-parentheses/
 *
 * 배운 것:
 * - '('는 최대 n개까지만 나올 수 있다.
 * - ')'는 최대 '('가 나온 횟수까지만 나올 수 있다.
 */
class Solution63 {
    var length: Int = 0
    val temp = Array<Char>(size = 20) { ' ' }
    val resultArray: MutableList<String> = mutableListOf()

    fun dfs(x: Int, c: Char, openCount: Int, closeCount: Int) {
        temp[x] = c

        if (x == length - 1) {
            // println(temp.joinToString(""))
            resultArray.add(temp.copyOfRange(0, length).joinToString(""))
            return
        }

        temp[x] = c

        if (openCount < length/2) {
            dfs(x + 1, '(', openCount = openCount + 1, closeCount = closeCount)
        }

        if (closeCount < openCount) {
            dfs(x + 1, ')', openCount = openCount, closeCount = closeCount + 1)
        }
    }

    fun generateParenthesis(n: Int): List<String> {
        length = n * 2

        dfs(0, '(', openCount = 1, closeCount = 0)

        return resultArray
    }
}

fun main() {
    val n = 2

    println(Solution63().generateParenthesis(n).joinToString(","))
}
