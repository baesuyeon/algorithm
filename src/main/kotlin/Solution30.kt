package org.example

/**
 * 문제 : https://leetcode.com/problems/subsets/description/
 * - {1, 2, 3} 의 부분집합을 만드는 문제
 *
 * 배운 것 :
 * - 원소가 N개 있는 집합의 부분집합 개수는 2^N이다.
 *   - 예: {A, B, C} → 부분집합 개수는 2^3 = 8개
 *
 * - 집합 {A, B, C}의 부분집합은 0과 1을 사용한 비트마스크로 표현할 수 있다.
 * - 1은 그 원소를 포함한다는 의미이다.
 *
 * | i (10진수 ) | i (2진수)  |   부분집합     |
 * |------------|-----------|--------------|
 * | 0          | 000       | {}           |
 * | 1          | 001       | {C}          |
 * | 2          | 010       | {B}          |
 * | 3          | 011       | {B, C}       |
 * | 4          | 100       | {A}          |
 * | 5          | 101       | {A, C}       |
 * | 6          | 110       | {A, B}       |
 * | 7          | 111       | {A, B, C}    |
 *
 * - 1 << 3 = 8, 1.shl(3)
 * - shl(bits) → 왼쪽 시프트 (<<)
 * - shr(bits) → 부호 유지 오른쪽 시프트 (>>)
 */
class Solution30 {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val max = 1.shl(nums.size) // 부분집합의 개수

        for (i in (0..max-1)) {
            val list = mutableListOf<Int>()
            for (j in (0..nums.size - 1)) {
                if ((i and (1.shl(j))) != 0) { // 각 자리에 스위치가 켜져있는지 확인
                    list.add(nums[j])
                }
            }
            result.add(list)
        }

        return result
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3)
    Solution30().subsets(nums)
}
