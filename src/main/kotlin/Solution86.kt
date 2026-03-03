package org.example

/**
 * 문제 : https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution86 {
    fun compress(chars: CharArray): Int {
        var position = 0
        var prev: Char = chars[0]
        var count = 1

        var target = chars.copyOfRange(1, chars.size)

        for(char in target) {
            if (char != prev) {
                chars[position] = prev

                position++
                if (count > 1) {
                    for(numChar in count.toString().toCharArray()) {
                        chars[position++] = numChar
                    }
                }

                prev = char
                count = 1
            } else {
                count++
            }
        }

        chars[position] = prev
        position++

        if (count > 1) {
            for(numChar in count.toString().toCharArray()) {
                chars[position++] = numChar
            }
        }

        return position
    }
}

fun main() {
    val nums = charArrayOf('a')

    println(Solution86().compress(nums))
}
