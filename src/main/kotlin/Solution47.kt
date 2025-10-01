package org.example

import java.util.PriorityQueue

/**
 * 문제 : https://leetcode.com/problems/smallest-number-in-infinite-set/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 배운 것 :
 * - 1~1000까지 있다고 가정한다. (굳이 priorityQueue에 모두 넣을 필요가 없다)
 * - smallestNumber를 1부터 순차적으로 증가시킨다
 * - pop 후 add 된 항목들은 별도 priorityQueue에 저장한다 (중복 체크를 위해 set을 함께 사용한다)
 */
class Solution47 {
    var smallestNumber = 1
    val pq = PriorityQueue<Int>()
    val set = mutableSetOf<Int>() // pq에 넣을 value 중복 체크

    fun popSmallest(): Int {
        if (pq.isNotEmpty()) {
            val num = pq.remove()
            set.remove(num)
            return num
        }

        return smallestNumber++
    }

    fun addBack(num: Int) {
        if (num < smallestNumber) {
            if (!set.contains(num)) {
                set.add(num)
                pq.add(num)
            }
        }
    }

// Solution 1 (비효율적)
//    val priorityQueue = PriorityQueue<Int>()
//    val set = mutableSetOf<Int>()
//
//    init {
//        for (i in (1..1000)) {
//            priorityQueue.add(i)
//            set.add(i)
//        }
//    }
//
//    fun popSmallest(): Int {
//        val value: Int = priorityQueue.remove()
//        set.remove(value)
//        return value
//    }
//
//    fun addBack(num: Int) {
//        if (set.contains(num)) {
//            return
//        }
//
//        set.add(num)
//        priorityQueue.add(num)
//    }
}

fun main() {

}
