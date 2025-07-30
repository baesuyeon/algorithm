package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42842?language=kotlin
 *
 * 배운것 :
 * - intArrayOf(vararg elements: Int) : 특정 값을 직접 넣어 초기화할 때 사용 ex) intArrayOf(1, 2, 3)
 * - IntArray(size: Int) : 지정한 크기의 배열을 생성하고 모든 값을 기본값 0으로 초기화 (값은 나중에 할당 가능)
 * - arr[index] = value : 배열 요소에 값 할당
 */
class Solution13 {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = IntArray(2)

        for (width in (brown / 2 - 1) downTo 3) {
            val yellowHeight = (brown - (width * 2)) / 2
            if ((width - 2) * (yellowHeight) == yellow) {
                answer[0] = width
                answer[1] = yellowHeight + 2
                break
            }
        }

        return answer
    }
}

fun main() {
    val brown = 24
    val yellow = 24
    val answer = Solution13().solution(brown, yellow)
    print(answer[0])
    print(answer[1])
}
