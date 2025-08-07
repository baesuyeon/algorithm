package org.example.datastructure

/**
 * 코틀린의 mapOf, setOf, mutableMapOf, mutableSetOf 등은 내부적으로 HashMap 기반으로 구현되어있다.
 * HashMap은 어떻게 작동할까?
 *
 * HashMap은 <key,value> 형태로 데이터를 저장한다.
 * key 값을 기준으로 해시함수(hashCode())를 사용해서 고유 식별값인 해시값을 만든다.
 * 하지만 HashMap의 크기는 한정적이기 때문에 같은 서로 다른 객체라 하더라도 같은 해시값을 갖게 될 수도 있다.(해시 충돌)
 * 이런 경우 해당 버킷에 LinkedList 형태로 객체를 추가한다.
 * 이처럼 같은 해시값의 버킷 안에 다른 객체가 있는 경우 equals() 메서드가 사용된다. (실제로 key가 동일한지 확인)
 *
 * equals()를 재정의한 클래스에는 hashCode()도 반드시 재정의해야 한다.
 * (equals()의 값이 true이면, hashCode()도 동일한 값을 가져야 함, 반대로 equals()의 값이 false이면, hashCode()도 다른 값을 가져야 함
 * hashCode()를 함께 재정의하지 않으면 해시기반 컬렉션 코드가 예상과 다르게 동작할 수 있다.
 *
 * - HashSet에 논리적으로 같은 데이터가 계속 추가될 수 있다.(hashCode()가 다르기 때문)
 * - hashCode가 다르다면 HashMap에서 get 할 수가 없다.
 *
 * 참고)
 * - hashCode() 메서드는 실행 중(Runtime) heap에 저장된 객체의 메모리 주소와 연관된 객체의 유일한 int 값을 반환한다.
 * - 코틀린 data class는 컴파일러가 equals(), hashCode(), toString(), copy() 와 같은 유용한 메소드들을 자동으로 생성해준다.
 * - equals()의 경우 주 생성자에 선언된 모든 프로퍼티의 값이 같으면 두 data class 인스턴스는 동등하다고 판단한다.
 */
fun main() {
    // 1. 불변 Map (읽기 전용)
    val readOnlyMap = mapOf(
        "apple" to 3,
        "banana" to 5,
        "orange" to 2
    )
    println("mapOf: $readOnlyMap")
    println("readOnlyMap[banana]: ${readOnlyMap["banana"]}")

    // 2. 가변 Map (수정 가능)
    val mutableMap = mutableMapOf(
        "dog" to 1,
        "cat" to 2
    )
    mutableMap["dog"] = 5 // 값 수정
    mutableMap["bird"] = 3 // 새로운 키 추가
    println("mutableMap: $mutableMap")

    // 3. 불변 Set
    val readOnlySet = setOf("a", "b", "c", "a", "b")
    println("setOf: $readOnlySet")

    // 4. 가변 Set
    val mutableSet = mutableSetOf("x", "y")
    mutableSet.add("z")
    mutableSet.add("x")
    mutableSet.remove("y")
    println("mutableSet: $mutableSet")

    // 5. HashMap의 hashCode / equals 개념
    val person1 = Person("Bae", 31)
    val person2 = Person("Bae", 31) // 논리적으로 동일한 객체

    val peopleMap = mutableMapOf<Person, String>()
    peopleMap[person1] = "개발자"
    println("동일 key(person2)로 조회: ${peopleMap[person2]}") // 조회 가능
}

data class Person(
    val name: String,
    val age: Int
)
