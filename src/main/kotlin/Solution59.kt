package org.example

import kotlin.text.forEach

/**
 * 문제 : https://leetcode.com/problems/implement-trie-prefix-tree/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운 것 :
 * - 트라이 자료구조 구현 (배열 사용)
 * - Array() 생성자는 두개의 인자를 받아야한다.
 *   - Array(size: Int, init: (Int) -> T)
 *   - 크기와 각 인덱스의 초기값을 생성하는 람다가 필요하다.
 */
class Trie() {
    val rootNode = Node()

    fun insert(word: String) {
        var node: Node = rootNode

        word.forEach { char -> // 'a', 'p', 'p', 'l', 'e'
            if(node.linkArray[char - 'a'] == null) {
                node.linkArray[char - 'a'] = Node()
            }
            node = node.linkArray[char - 'a']!!
        }

        node.isEnd = true
    }

    fun search(word: String): Boolean {
        var node: Node = rootNode

        word.forEach { char ->
            if(node.linkArray[char - 'a'] == null) {
                return false
            }

            node = node.linkArray[char - 'a']!!
        }

        return node.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var node: Node = rootNode

        prefix.forEach { char ->
            if(node.linkArray[char - 'a'] == null) {
                return false
            }

            node = node.linkArray[char - 'a']!!
        }

        return true
    }

    class Node(
        val linkArray: Array<Node?> = Array(30) { null },
        var isEnd: Boolean = false
    )
}

fun main() {
    val trie = Trie()
    trie.insert("apple")
    println(trie.search("apple")) // true
    println(trie.search("app")) // false
    println(trie.startsWith("app")) // true
    trie.insert("app")
    println(trie.search("app")) // true
}
