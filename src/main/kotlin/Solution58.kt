package org.example

import kotlin.text.forEach

/**
 * 문제 : https://leetcode.com/problems/implement-trie-prefix-tree/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운 것 :
 * - 트라이 자료구조 구현 (map 사용)
 * - find: O(m) m: 찾으려는 문자열의 길이
 * - add: O(m) m: 찾으려는 문자열의 길이
 */
class Trie2() {
    val rootNode = Node(linkMap = mutableMapOf(), isEnd = false)

    fun insert(word: String) {
        var node: Node = rootNode

        word.forEach { char -> // 'a', 'p', 'p', 'l', 'e'
            if(node.linkMap[char] == null) {
                node.linkMap[char] = Node(linkMap = mutableMapOf(), isEnd = false)
            }
            node = node.linkMap[char]!!
        }

        node.isEnd = true
    }

    fun search(word: String): Boolean {
        var node: Node = rootNode

        word.forEach { char ->
            if(node.linkMap[char] == null) {
                return false
            }

            node = node.linkMap[char]!!
        }

        return node.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var node: Node = rootNode

        prefix.forEach { char ->
            if(node.linkMap[char] == null) {
                return false
            }

            node = node.linkMap[char]!!
        }

        return true
    }

    class Node(
        val linkMap: MutableMap<Char, Node>,
        var isEnd: Boolean,
    )
}

fun main() {
    val trie = Trie2()
    trie.insert("apple")
    println(trie.search("apple")) // true
    println(trie.search("app")) // false
    println(trie.startsWith("app")) // true
    trie.insert("app")
    println(trie.search("app")) // true
}
