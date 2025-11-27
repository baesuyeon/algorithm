package org.example

/**
 * 문제 : https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution66 {
    fun reverseVowels(s: String): String {
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val positionList = mutableListOf<Int>()
        val vowelList = mutableListOf<Char>()

        for (index in s.indices) {
            if (s[index] in vowels) {
                positionList.add(index)
                vowelList.add(s[index])
            }
        }

        val array = s.toCharArray()
        val size = positionList.size
        positionList.forEachIndexed { index, position ->
            array[position] = vowelList[size - 1 - index]
        }

        return array.joinToString("")
    }
}


fun main() {
    val s = "IceCreAm"

    println(Solution66().reverseVowels(s))
}
