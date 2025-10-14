package org.example

/**
 * 문제 : https://leetcode.com/problems/guess-number-higher-or-lower/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운 것:
 * - s + e 값이 int 자료형 범위를 넘어가면 오버플로우가 발생하여 올바른 값이 mid에 할당되지 않고 무한 루프에 빠진다.
 * - (s + e) / 2  대신 (s + (e - s) / 2) 를 사용하는 것은 이진 탐색에서 가장 흔한 오버플로우 방지 방법이다
 *   - 두 번호가 너무 크면 합쳐질 때 숫자가 터질 수 있다.
 *   - 두 번호의 거리 차를 구해서 절반만큼 s에서 이동하자
 */
class Solution49 {
    /**
     * The API guess is defined in the parent class.
     * @param  num   your guess
     * @return       -1 if num is higher than the picked number
     *			     1 if num is lower than the picked number
     *               otherwise return 0
     */
    fun guess(num: Int): Int {
        val pick = 6

        return if (num > pick) {
            -1
        } else if (num < pick) {
            1
        } else {
            0
        }
    }

    // 1~n 중 pick을 return 해야 한다.
    fun guessNumber(n: Int): Int {
        var s = 1
        var e = n

        while (true) {
            val mid = s + (e - s) / 2

            val result = guess(mid)
            if (result == -1) {
                e = mid - 1
            } else if (result == 1) {
                s = mid + 1
            } else {
                return mid
            }
        }
    }
}

fun main() {
    val answer = Solution49().guessNumber(10)
    print(answer)
}
