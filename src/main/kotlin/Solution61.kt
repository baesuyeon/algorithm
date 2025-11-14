package org.example

/**
 * 문제 : https://leetcode.com/problems/course-schedule-ii/description/
 *
 * 배운 것 :
 * - Map.getOrPut(key) { defaultValue }
 *   - key가 존재하면 해당 값을 반환하고
 *   - 없으면 { } 블록의 값을 넣고 그 값을 반환
 */
class Solution61 {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        val degree: MutableMap<Int, Int> = mutableMapOf()

        prerequisites.forEach {
            val from = it[1]
            val to = it[0]

            degree[to] = degree.getOrDefault(to, 0) + 1
//            if (graph[from] == null) {
//                graph[from] = mutableListOf(to)
//            } else {
//                graph[from]!!.addLast(to)
//            }
            graph.getOrPut(from) { mutableListOf() }.add(to)
        }

        val queue = ArrayDeque<Int>()
        val result = mutableListOf<Int>()

        for (i in (0 until numCourses)) {
            if (degree.getOrDefault(i, 0) == 0) {
                queue.addLast(i)
            }
        }

        for (i in (0 until numCourses)) {
            if (queue.isEmpty()) {
                return intArrayOf()
            }

            val node = queue.first()
            queue.removeFirst()
            result.add(node)

            graph[node]?.forEach { to ->
                degree[to] = degree[to]!! - 1

                if (degree[to] == 0) {
                    queue.addLast(to)
                }
            }
        }

        return result.toIntArray()
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

    println(Solution61().findOrder(numCourses, prerequisites).joinToString(""))
}
