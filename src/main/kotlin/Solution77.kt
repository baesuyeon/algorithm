package org.example

/**
 * 문제 : https://leetcode.com/problems/search-in-a-binary-search-tree/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution77 {
    var answer: TreeNode? = null

    fun searchBST(root: TreeNode?, value: Int): TreeNode? {
        if (root == null) return null

        if (answer != null) return answer

        if (root.value == value) {
            answer = root
            return answer
        }

        val left = root.left
        val right = root.right

        searchBST(root = left, value = value)
        searchBST(root = right, value = value)

        return answer
    }

    data class TreeNode(
        var value: Int
    ) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun buildTree(treeArr: Array<Int>): TreeNode {
        var nodes: List<Solution77.TreeNode> = emptyList()
        nodes = treeArr.map {
            val treeNode = TreeNode(it)
            treeNode
        }

        for(index in nodes.indices) {
            val leftIndex = index * 2 + 1
            val rightIndex = index * 2 + 2

            if (leftIndex < treeArr.size) {
                nodes[index].left = nodes[leftIndex]
            }

            if (rightIndex < treeArr.size) {
                nodes[index].right = nodes[rightIndex]
            }
        }

        return nodes[0]
    }
}

fun main() {
    val treeArr = Array<Int>(5001) { 0 }
    treeArr[0] = 4
    treeArr[1] = 2
    treeArr[2] = 7
    treeArr[3] = 1
    treeArr[4] = 3

    val instance = Solution77()
    val root = instance.buildTree(treeArr)

    println(instance.searchBST(root, 2)?.value)
}
