package org.example

/**
 * 문제 : https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운 것
 * - 현재 풀이는 모든 후보를 확인하는 비효율적인 방식
 * - 공통 패턴이 있다면 str1 + str2 == str2 + str1 이다.
 *   - ex) "ABAB" + "AB" = "ABABAB"
 *         "AB" + "ABAB" = "ABABAB"
 * - 문자열 길이의 최대공약수(gcd)를 구하면 공통 문자열의 후보 길이는 무조건 그 값이다.
 * private fun gcd(a: Int, b: Int): Int {
 *     return if (b == 0) a else gcd(b, a % b)
 * }
 */
class Solution46 {
    fun gcdOfStrings(str1: String, str2: String): String {
        var answer = ""

        var temp = str2
        while (temp.isNotEmpty()) {
            var flag1 = true
            var flag2 = true

            // 만약 str1을 나누고
            if (str1.length % temp.length == 0) {
                for((index, char) in str1.withIndex()) {
                    if (char != temp[index % temp.length]) {
                        flag1 = false
                    }
                }
            } else {
                flag1 = false
            }

            // str2도 나눈다면
            if (str2.length % temp.length == 0) {
                for((index, char) in str2.withIndex()) {
                    if (char != temp[index % temp.length]) {
                        flag2 = false
                    }
                }
            } else {
                flag2 = false
            }

            if (flag1 && flag2) {
                answer = temp
                break
            }

            temp = temp.substring(0, temp.length - 1)
        }

        return answer
    }
}

fun main() {
    val str1 = "ABABABAB"
    val str2 = "ABAB"

    println(Solution46().gcdOfStrings(str1, str2))
}
