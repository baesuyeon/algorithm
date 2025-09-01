package org.example.datastructure.implements

// 연결 리스트는 데이터를 담고 있는 노드들의 연결로 이루어진다.
// 각 노드는 value와 다음 노드를 가리키는 next 참조를 가지고 있다.
class Node<T> (
    val value: T,
    var next: Node<T>? = null,
)

// 연결 리스트 클래스는 노드들을 관리하며 리스트의 동작을 구현한다.
class MyLinkedList<T> {
    private var head: Node<T>? = null // 리스트의 첫 번째 노드
    private var size: Int = 0 // 리스트의 크기

    // 리스트가 비어있는지 확인하는 메서드
    fun isEmpty(): Boolean {
        return (size == 0)
    }

    // 첫 번째 원소를 제거하지 않고 반환
    fun peekFirst(): T? {
        return head?.value
    }

    // 마지막 원소를 제거하지 않고 반환
    fun peekLast(): T? {
        var current = head
        while(current?.next != null) {
            current = current.next
        }
        return current?.value
    }

    // 리스트의 크기 반환
    fun getSize(): Int {
        return size
    }

    // 리스트의 맨 앞에 요소 추가
    fun addFirst(value: T) {
        head = Node<T>(value, head)
        size++
    }

    // 맨 마지막에 요소를 추가
    fun addLast(value: T) {
        size++

        if (head == null) {
            head = Node(value, null)
            return
        }

        var current = head
        while(current?.next != null) {
            current = current.next
        }

        current?.next = Node(value, null)
    }

    // 리스트의 맨 앞 노드 제거
    fun removeFirst() {
        if (size == 0) {
            return
        }

        head = head?.next
        size--
    }

    // 요소를 순회하며 문자열로 표현
    fun printList() {
        var current = head

        if (current == null) {
            println("리스트가 비어있습니다.")
            return
        }

        print("리스트 출력: ")
        while(current?.next != null) {
            print("${current.value} => ")
            current = current.next
        }
        println(current?.value)
        return
    }
}