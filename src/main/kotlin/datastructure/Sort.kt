package org.example.datastructure

/**
 * sortWith vs sortedWith
 *
 * sortWith
 * - 원본 리스트 자체를 정렬(in-place)한다.
 * - 반환값이 없다
 *
 * sortedWith
 * - 원본 리스트는 변경하지 않고 정렬된 새로운 리스트를 반환한다.
 */
fun main() {
    val users = listOf(
        User("Bae", 31),
        User("Kim", 25),
        User("Lee", 29)
    )

    // sortedWith에 Comparator 인터페이스 구현체를 직접 주입해서 정렬 전략을 바꾸는 방법
    val sorted1 = users.sortedWith(AgeDescendingComparator())
    println(sorted1)

    // 람다로 Comparator를 만드는 방식 (Comparator { a, b -> ... })
    val sorted2 = users.sortedWith(Comparator { a, b ->
        b.age.compareTo(a.age)
    })
    println(sorted2)

    // 헬퍼 함수 사용
    val sorted3 = users.sortedWith(compareByDescending<User> { it.age })
    println(sorted3)

    // 헬퍼 함수 사용 확장 (정렬 조건이 여러개인 경우)
    val sorted4 = users.sortedWith(
        compareByDescending<User> { it.age }
            .thenBy { it.name }
    )
    println(sorted4)
}

data class User(val name: String, val age: Int)

class AgeDescendingComparator : Comparator<User> {
    override fun compare(a: User, b: User): Int {
        /**
         * compareTo는 비교 결과를 숫자로 반환하는 함수이다.
         * 음수 : 현재 객체가 비교 객체보다 작다
         * 0 : 같다
         * 양수 : 현재 객체가 비교 객체보다 크다
         * 결과가 음수면 a가 먼저, 양수면 b가 먼저, 0이면 순서 유지
         * 내림차순으로 정렬하고 싶으면 비교 인자의 순서를 바꾸면 된다.
         */
        return b.age.compareTo(a.age) // 나이 내림차순
    }
}