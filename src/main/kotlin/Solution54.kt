package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/258712?language=kotlin
 *
 * 배운 것:
 * - 2차원 배열, 1차원 배열을 다루는 방법
 *  - 2차원 배열 : Array(size = friends.size, { Array(friends.size, { 0 }) })
 *  - 1차원 배열 : IntArray(friends.size) // 0으로 초기화
 */
class Solution54 {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        // Map<name, index>
        val nameIndexMap = mutableMapOf<String, Int>()
        friends.forEachIndexed { index, friend ->
            nameIndexMap[friend] = index
        }

        val twoMap: Array<Array<Int>> = Array(size = friends.size, { Array(friends.size, { 0 }) })
        val giftIndex = IntArray(friends.size)

        gifts.forEach { giftString ->
            val arr = giftString.split(" ")
            val person1 = arr[0]
            val person2 = arr[1]

            twoMap[nameIndexMap[person1]!!][nameIndexMap[person2]!!] += 1
            giftIndex[nameIndexMap[person1]!!] += 1
            giftIndex[nameIndexMap[person2]!!] -= 1
        }

        val nextGift = IntArray(friends.size)
        for (i in 0..friends.size - 1) {
            for (j in i + 1..friends.size - 1) {
                // 주고 받은 선물 수가 같다면
                if (twoMap[i][j] == twoMap[j][i]) {
                    if (giftIndex[i] > giftIndex[j]) {
                        nextGift[i] += 1
                    } else if (giftIndex[j] > giftIndex[i]) {
                        nextGift[j] += 1
                    }
                }
                else if (twoMap[i][j] > twoMap[j][i]) {
                    nextGift[i] += 1
                } else {
                    nextGift[j] += 1
                }
            }
        }

        return nextGift.maxOrNull() ?: 0
    }
}

fun main() {
    val friends = arrayOf("muzi", "ryan", "frodo", "neo")
    val gifts = arrayOf(
        "muzi frodo",
        "muzi frodo",
        "ryan muzi",
        "ryan muzi",
        "ryan muzi",
        "frodo muzi",
        "frodo ryan",
        "neo muzi"
    )

    val answer = Solution54().solution(friends, gifts)
    print(answer)
}
