package org.example

/**
 * 문제 : https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운 것:
 * - stack.joinToString("") : 스택 안의 문자들을 합쳐서 문자열로 반환
 */
class Solution50 {

    fun removeStars(s: String): String {
        val stack = ArrayDeque<Char>()

        s.forEach {
            if (it == '*') {
                stack.removeLast()
            } else {
                stack.addLast(it)
            }
        }

       return stack.joinToString("")
    }
}

fun main() {
    val s = "leet**cod*e"

    val answer = Solution50().removeStars(s)
    print(answer)
}
