package org.example

/**
 * 문제 : https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운 것:
 * - bfs 완전탐색 기법으로 최단 경로 찾기
 * - 방문 처리 시점이 중요하다.
 *   - 큐에서 꺼낸 시점에 방문 체크를 하면 같은 좌표가 여러번 큐에 들어갈 수 있어 큐가 커지고 시간초과가 발생할 수 있다.
 *   - 큐에 넣기 전에 방문 체크를 하면된다.
 */
class Solution53 {
    val moveX = intArrayOf(-1, 0, 1, 0)

    val moveY = intArrayOf(0, 1, 0, -1)

    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val width = maze[0].size
        val height = maze.size

        val initialData = Data(
            positionX = entrance[0],
            positionY = entrance[1],
            stepCount = 0,
        )

        val queue = ArrayDeque<Data>()
        maze[initialData.positionX][initialData.positionY] = 'v' // 방문 체크

        queue.addLast(initialData)
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()

            for (i in 0..3) {
                val nextX = current.positionX + moveX[i]
                val nextY = current.positionY + moveY[i]

                if (nextX < 0 || nextX >= height || nextY < 0 || nextY >= width) {
                    if (current.positionX == entrance[0] && current.positionY == entrance[1]) {
                        // 입구는 출구로 간주하지 않음
                        continue
                    } else {
                        // 입구가 아니라면 출구로 간주
                        return current.stepCount
                    }
                }

                if (maze[nextX][nextY] == '.') {
                    maze[nextX][nextY] = 'v' // 방문 체크
                    queue.addLast(
                        Data(
                            positionX = nextX,
                            positionY = nextY,
                            stepCount = current.stepCount + 1
                        )
                    )
                }
            }
        }

        return -1
    }

    data class Data(
        val positionX: Int,
        val positionY: Int,
        val stepCount: Int,
    )
}

fun main() {
    val maze = arrayOf(
        charArrayOf('+', '+', '+'),
        charArrayOf('.', '.', '.'),
        charArrayOf('+', '+', '+'),
    )

    val entrance = intArrayOf(1, 0)

    val answer = Solution53().nearestExit(maze, entrance)
    print(answer)
}
