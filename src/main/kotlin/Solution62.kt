package org.example

/**
 * 문제 : https://leetcode.com/problems/generate-parentheses/
 *
 * 배운 것:
 * - Array.copyOfRange(start, end): [start, end)
 * - 현재 방식은 모든 조합을 만들고 마지막에 isValid를 검사하는 비효율적인 방식
 */
class Solution62 {
    var length: Int = 0
    val temp = Array<Char>(size = 20) { ' ' }
    val resultArray: MutableList<String> = mutableListOf()

    fun dfs(x: Int, c: Char) {
        temp[x] = c

        if (x == length - 1) {
            // println(temp.joinToString("") + " " + isValid())

            if (isValid()) {
                resultArray.add(temp.copyOfRange(0, length).joinToString(""))
            }
            return
        }

        dfs(x + 1, '(')
        dfs(x + 1, ')')
    }

    fun isValid(): Boolean {
        val stack = ArrayDeque<Char>()

        for(i in (0 until length)) {
            if (temp[i] == '(') {
                stack.addLast('(')
            } else { // ')'
                if (stack.lastOrNull() == '(') {
                   stack.removeLast()
                } else {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }

    fun generateParenthesis(n: Int): List<String> {
        length = n * 2

        dfs(0, '(')

        return resultArray
    }
}

fun main() {
    val n = 2

    println(Solution62().generateParenthesis(n).joinToString(","))
}
