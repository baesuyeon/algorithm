package org.example

/**
 * 문제 : https://leetcode.com/problems/course-schedule/
 *
 * 배운 것 :
 * 위상정렬: 순서가 정해져있는 작업을 차례로 수행해야 할 때 사용하는 알고리즘
 *
 * 위상정렬은 여러개의 답이 존재할 수 있다.
 * 사이클이 발생하지 않는 방향 그래프에만 적용이 가능하다.
 *
 * - 중간에 큐가 비어버리는 경우 사이클이 존재한다고 판단하는 이유:
 * - 큐에는 항상 현재 방문할 수 있는 노드(진입차수가 0인 노드)만 들어있다.
 * - 사이클이 있는 그래프는 진입 차수가 0이 되는 노드가 중간에 없어진다.
 * - 사이클 안의 노드들은 서로 의존하고 있어서 어느 노드도 진입 차수가 0이 되지 않기 때문이다.
 * - 그래서 모든 노드를 방문하기 전에 큐가 비게된다.
 *
 * (1) 진입차수가 0인 정점을 큐에 삽입한다.
 * (2) 큐에서 원소를 꺼내 연결된 모든 간선을 제거한다.
 * (3) 간선 제거 이후 진입차수가 0이된 정점을 큐에 삽입한다.
 * (4) 큐에 빌 때까지 (2)~(3)을 반복한다. 모든 원소를 방문하기 전에 큐가 빈다면 사이클이 존재하는 것이고
 *     모든 원소를 방문했다면 큐에서 꺼낸 순서가 위상정렬의 결과이다.
 */
class Solution60 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = mutableMapOf<Int, List<Int>>()
        val degreeMap = mutableMapOf<Int, Int>()

        prerequisites.forEach { prerequisites ->
            val to = prerequisites[0]
            val from = prerequisites[1]

            degreeMap[to] = degreeMap.getOrDefault(to, 0) + 1
            graph[from] = graph.getOrDefault(from, mutableListOf()) + listOf(to)
        }

        val queue = ArrayDeque<Int>()

        for (i in (0 until numCourses)) {
            // 진입 차수가 0인 노드는 queue에 넣는다.
            if (degreeMap.getOrDefault(i, 0) == 0) {
                queue.addLast(i)
            }
        }

        for (i in (0 until numCourses)) {
            // 사이클 존재
            if (queue.isEmpty()) {
                return false
            }

            val node = queue.first()
            queue.removeFirst()

            graph[node]?.forEach { to ->
                val degree = degreeMap[to] ?: throw IllegalArgumentException()
                degreeMap[to] = degree - 1

                if (degreeMap[to] == 0) {
                    queue.addLast(to)
                }
            }
        }

        return true
    }
}

fun main() {
    val numCourses = 7
    val prerequisites = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(2, 1),
        intArrayOf(3, 2),
        intArrayOf(4, 0),
        intArrayOf(5, 4),
        intArrayOf(6, 5),
        intArrayOf(5, 3),
    )
//    val prerequisites = arrayOf(
//        intArrayOf(1, 0),
//        intArrayOf(0, 1),
//    )

    println(Solution60().canFinish(numCourses, prerequisites))
}
