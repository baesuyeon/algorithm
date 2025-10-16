package org.example

/**
 * 문제 : https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution51 {

    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = ArrayDeque<Int>()

        for (asteroid in asteroids) {
            if (stack.isEmpty()) {
                stack.addLast(asteroid)
            } else {
                val lastElement = stack.last()

                if (asteroid < 0 && lastElement > 0) { // 만나는 경우
                    while(true) {
                        if (stack.isEmpty() || stack.last() < 0) {
                            stack.addLast(asteroid)
                            break
                        }

                        if (stack.last() + asteroid > 0) { // -> 방향의 행성이 더 큰 경우
                            break
                        } else if (stack.last() + asteroid < 0) { // <- 방향의 행성이 더 큰 경우
                            stack.removeLast()
                        } else { // -> 방향, <- 방향의 크기가 동일한 경우
                            stack.removeLast()
                            break
                        }
                    }
                } else { // 만나지 않는 경우
                    stack.addLast(asteroid)
                }
            }
        }

        return stack.toIntArray()
    }
}

fun main() {
    val asteroids = intArrayOf(1,-2,-2,-2)

    val answer = Solution51().asteroidCollision(asteroids)
    print(answer.joinToString(", "))
}
