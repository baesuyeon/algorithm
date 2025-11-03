package org.example

import kotlin.math.max

/**
 * 문제 : https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운 것:
 * - 이진 트리 만들기
 * - 이진 트리를 dfs로 순회하기
 */
class Solution55 {
    var maxValue = 0

    fun dfs(node: TreeNode?, length: Int, isLeft: Boolean) {
        if (node == null) return

        maxValue = max(length, maxValue)

        if (isLeft) {
            dfs(node.right, length + 1, false)
            dfs(node.left, 1, true)
        } else {
            dfs(node.left, length + 1, true)
            dfs(node.right, 1, false)
        }
    }

    fun longestZigZag(root: TreeNode?): Int {
        dfs(root, 0, isLeft = false)
        dfs(root, 0, isLeft = true)

        return maxValue
    }
}

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun buildTree(treeArr: Array<Int?>): TreeNode? {
    if (treeArr.isEmpty()) return null

    val nodes: List<TreeNode?> = treeArr.map { element ->
        if (element != null) {
            TreeNode(element)
        } else {
            null
        }
    }

    for (index in treeArr.indices) {
        val node = nodes[index] ?: continue

        val leftIndex = index * 2 + 1
        val rightIndex = index * 2 + 2

        if (leftIndex < treeArr.size) {
            node.left = nodes[leftIndex]
        }
        if (rightIndex < treeArr.size) {
            node.right = nodes[rightIndex]
        }
    }

    return nodes[0]
}

fun main() {
    val treeArr: Array<Int?> = Array(size = 1000) { null }
    treeArr[0] = 1
    treeArr[2] = 1
    treeArr[5] = 1
    treeArr[6] = 1
    treeArr[13] = 1
    treeArr[14] = 1
    treeArr[28] = 1
    treeArr[58] = 1

    val root = buildTree(treeArr)

    val answer = Solution55().longestZigZag(root)
    print(answer)
}
