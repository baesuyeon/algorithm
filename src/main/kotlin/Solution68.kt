package org.example

/**
 * 문제 : https://www.hackerrank.com/challenges/one-week-preparation-kit-plus-minus/problem
 *
 * 배운 것 :
 * - float 자료형
 *   - 숫자 1개당 32비트 (오차가 크다)
 *   - 약 7자리의 소수점 이하 정밀도를 가지며, 이는 약 6자리까지는 정확하지만 7자리부터는 부정확할 수 있다
 * - double 자료형
 *   - 숫자 1개당 64비트 (오차가 적다)
 *   - 단점 : 메모리 용량 2배
 *
 * - 소숫점 자릿수를 정하기
 *   - String.format("%.2f", num)
 *   - String.format("%.8f", num)
 *
 * - 소수점 반올림
 * - double number = 5.5;
 * - int result = Math.round(number);
 */
class Solution68 {
    fun plusMinus(arr: Array<Int>): Unit {
        val totalCount = arr.size.toLong()
        var positiveCount = 0f
        var negativeCount = 0f
        var zeroCount = 0f

        arr.forEach {
            when {
                it > 0 -> positiveCount++
                it < 0 -> negativeCount++
                else -> zeroCount++
            }
        }

        println(String.format("%.6f", positiveCount / totalCount))
        println(String.format("%.6f", negativeCount / totalCount))
        println(String.format("%.6f", zeroCount / totalCount))
    }
}


fun main() {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    Solution68().plusMinus(arr)
}
