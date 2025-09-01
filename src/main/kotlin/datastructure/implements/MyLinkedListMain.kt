package org.example.datastructure.implements

fun main() {
    val myLinkedList = MyLinkedList<Int>()

    println(myLinkedList.isEmpty()) // true

    myLinkedList.addLast(3)
    myLinkedList.addLast(4)
    myLinkedList.addLast(5)

    println(myLinkedList.isEmpty()) // false

    // 3, 4, 5
    myLinkedList.printList()

    // 2, 1, 3, 4, 5
    myLinkedList.addFirst(1)
    myLinkedList.addFirst(2)

    println(myLinkedList.getSize()) // 5

    println(myLinkedList.peekFirst()) // 2
    println(myLinkedList.peekLast()) // 5

    myLinkedList.removeFirst()

    // 1, 3, 4, 5
    myLinkedList.printList()
}