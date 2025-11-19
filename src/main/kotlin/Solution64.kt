package org.example

import java.util.*

/**
 * 문제 : https://leetcode.com/problems/lru-cache/description/
 *
 * 배운 것:
 * - LinkedList를 사용해야하는 케이스 학습 (Map을 함꼐 사용해서 value가 node를 가리키도록)
 */
class LRUCache(capacity: Int) {
    val capacity = capacity
    val map = mutableMapOf<Int, Node>()
    val linkedList = LinkedList<Node>() // value를 가지고 있다

    fun get(key: Int): Int {
        val node = map[key] ?: return -1

        // 해당 노드를 제거 후 맨 뒤로 이동
        linkedList.remove(node)
        linkedList.addLast(node)

        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = map[key]

        if (node != null) {
            // 이미 key 값이 존재하는 경우
            node.value = value
            linkedList.remove(node)
            linkedList.addLast(node)
        } else {  // key 값이 없는 경우
            // evict
            if (map.size >= capacity) {
                val node = linkedList.first()
                map.remove(node.key)
                linkedList.removeFirst()
            }

            val newNode = Node(key, value)
            map[key] = newNode
            linkedList.addLast(newNode)
        }
    }

    data class Node(
        val key: Int,
        var value: Int,
    )
}


fun main() {
    val cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    println(cache.get(1))
    cache.put(3, 3)
    println(cache.get(2))
    cache.put(4, 4)
    println(cache.get(1))
    println(cache.get(3))
    println(cache.get(4))
}
