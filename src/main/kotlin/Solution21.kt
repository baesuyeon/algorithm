package org.example

/**
 * 문제 : https://leetcode.com/problems/valid-palindrome/description/
 *
 * 배운것 :
 * - String.reversed(): 역순으로 정렬된 새 문자열을 반환한다
 *
 * - In-place: 원본 데이터 자체를 변경한다. (원본 데이터가 손상될 수 있다)
 * ex) list.sort() → 원본 리스트가 정렬된 상태로 변형된다
 *
 * - Out-of-place: 원본은 그대로 두고 새로운 결과를 반환한다 (새 객체를 생성하므로 메모리가 낭비된다)
 * ex) list.sorted() → 정렬된 새로운 리스트 반환한다.
 */
class Solution21 {
    fun isPalindrome(s: String): Boolean {
        val originalString = s.lowercase().filter { c -> (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') }
        val reversedString = originalString.reversed()

        return originalString == reversedString
    }
}

fun main() {
    val s = "A man, a plan, a canal: Panama"
    val answer = Solution21().isPalindrome(s)
    print(answer)
}
