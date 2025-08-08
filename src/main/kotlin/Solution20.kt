package org.example

/**
 * 문제 : https://leetcode.com/problems/valid-palindrome/description/
 *
 * 배운것 :
 * - String.reversed(): 역순으로 정렬된 새 문자열을 반환한다.
 */
class Solution20 {
    fun isPalindrome(s: String): Boolean {
        val originalString = s.lowercase().filter { c -> (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') }
        val reversedString = originalString.reversed()

        return originalString == reversedString
    }
}

fun main() {
    val s = "A man, a plan, a canal: Panama"
    val answer = Solution20().isPalindrome(s)
    print(answer)
}
