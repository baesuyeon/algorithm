package org.example.md

/**
 * 배열 vs 링크드 리스트
 * 배열은 연속된 공간에 데이터를 저장하기 때문에 인덱스를 통해 빠르게 데이터에 접근할 수 있다.
 * 크기가 고정되어있어서 크기 조정이 어렵다.
 *
 * 링크드 리스트는 메모리에 데이터가 흩어져 저장되어 있기 때문에 특정 노드에 접근하기 위해서는 시작부터 끝까지 탐색해야 한다.
 * 각 노드는 다음 노드를 가리키는 포인터를 포함하기 때문에 노드를 추가하거나 제거하는것이 쉽다.
 *
 * 코틀린 배열의 종류
 * - arrayOf
 * - intArrayOf
 * - arrayOfNulls
 * - IntArray
 * - Array
 */
fun main() {
    // arrayOf
    // 초기값을 알고 있을 때
    val intArray = arrayOf(1, 2, 3)
    val strArray = arrayOf("Kim", "Lee", "Bae")
    println(intArray.contentToString())
    println(strArray.contentToString())

    // intArrayOf
    // 성능이 중요한 코드나 대량의 데이터를 처리해야 할 때
    val numbers = intArrayOf(1, 2, 3)
    println(numbers.contentToString())

    // arrayOfNulls
    // 크기만 알고 기본값(null)으로 초기화할 때
    val names = arrayOfNulls<String?>(3)
    println(names.contentToString())

    // IntArray
    // 크기만 알고 기본값(0)으로 초기화할 때
    val intArray1 = IntArray(5)
    println(intArray1.contentToString())

    // Array
    // 규칙으로 초기화할 때
    val names1 = Array(3) { "User$it" }
    println(names1.contentToString())

    // 배열의 반복
    // (1) for (변수명 in 객체명) { }
    println("간단한 반복")
    for (name in names1) {
        println(name)
    }

    // (2) for (변수명 in 객체명.indices) { }
    println("for문 안에서 인덱스가 필요한 경우")
    for (index in names1.indices) {
        println("$index, ${names1[index]}")
    }

    // (3) 객체명.forEach { it }
    println("forEach")
    names1.forEach {
        println(it)
    }

    // (4) 객체명.forEachIndexed { 인덱스, 값 -> }
    println("forEach 안에서 인덱스가 필요한 경우")
    names1.forEachIndexed { index, name ->
        println("$index, $name")
    }
}