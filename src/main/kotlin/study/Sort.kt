package org.example.study

/**
 * | 상황                | 추천 함수                                    |
 * | ----------------- | ---------------------------------------- |
 * | 단일 기준 + 오름차순      | `sortedBy`                               |
 * | 단일 기준 + 내림차순      | `sortedByDescending`                     |
 * | 다중 기준 정렬 필요       | **`sortedWith(compareBy(...))`**         |
 * | 복잡한 비교 로직 필요      | `sortedWith(Comparator { a, b -> ... })` |
 * | mutableList 정렬 필요 | `sortBy`, `sortWith`                     |
 */
fun main() {
    val arr = listOf(
        listOf(5, 2),
        listOf(2, 3),
        listOf(4, 7),
        listOf(4, 5)
    )

    // 1. sortedBy
    // - 하나의 기준만으로 정렬할 때 사용한다.
    val sortedArr1 = arr.sortedBy { it.first() }
    println("sortedArr1: $sortedArr1")

    val sortedArr2 = arr.sortedByDescending { it.first() }
    println("sortedArr2: $sortedArr2")

    // 2. sortedWith
    // - 정렬 기준을 여러개, 원하는 방식으로 세밀하게 작성할 수 있다.
    // - Comparator를 파라미터로 받는데, Comparator를 쉽게 만들어주는 compareBy 도우미 함수를 사용할 수 있다.
    val sortedArr3 = arr.sortedWith(compareBy({ it[0]}, {it[1]}))
    println("sortedArr3: $sortedArr3")

    val sortedArr4 = arr.sortedWith(compareByDescending { it[0] })
    println("sortedArr4: $sortedArr4")

    // 첫번째는 오름차순, 두번째만 내림차순 상황
    // 체이닝도 가능하다, compareBy(a).thenBy(b).thenByDescending(c)
    val sortedArr5 = arr.sortedWith(
        compareBy<List<Int>> { it[0] }
            .thenByDescending { it[1] }
    )
    println("sortedArr5: $sortedArr5")
}
