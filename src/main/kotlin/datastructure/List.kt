package org.example.datastructure

fun main() {
    val people = listOf("Song", "Kim", "Lee") // 읽기 전용 리스트
    val peopleSize = people.size

    for (person in people) {
        println(person)
    }

    val numbers = mutableListOf(1, 2, 3)
    numbers.add(4) // 1, 2, 3, 4
    numbers[0] = 10 // 10, 2, 3, 4
    numbers.removeAt(1) // 10, 3, 4
}