package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42583?language=kotlin
 *
 * 배운 것 : DeQueue를 사용한 구현 문제
 */
class Solution33 {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        val waitingTruckList = ArrayDeque<Int>(truck_weights.toList())
        val bridgeTruckList = ArrayDeque<Truck>()
        var weightSum = 0 // 다리를 지나고있는 모든 트럭의 무게 합

        while (true) {
            // 다리를 지나는 모든 트럭의 남은 시간이 1 지난다
            if (!bridgeTruckList.isEmpty()) {
                bridgeTruckList.forEach {
                    it.timeLeft -= 1
                }
            }

            // 다리를 모두 건넌 트럭은 제거한다
            if (!bridgeTruckList.isEmpty()) {
                if (bridgeTruckList.first().timeLeft == 0) {
                    weightSum -= bridgeTruckList.first().weight
                    bridgeTruckList.removeFirst()
                }
            }

            // 다리에 트럭이 올라갈 수 있다면 트럭을 올린다
            if (!waitingTruckList.isEmpty()) {
                if (weightSum + waitingTruckList.first() <= weight) {
                    val truck = waitingTruckList.first()
                    waitingTruckList.removeFirst()
                    bridgeTruckList.add(Truck(weight = truck, timeLeft = bridge_length))
                    weightSum += truck
                }
            }

            answer++

            // 대기중인 트럭도 없고 다리를 지나는 트럭이 없으면 (모든 트럭이 지나갔다면) 종료한다.
            if (waitingTruckList.isEmpty() && bridgeTruckList.isEmpty()) {
                break
            }
        }

        return answer
    }
}

data class Truck(
    val weight: Int,
    var timeLeft: Int,
)

fun main() {
    val bridge_length: Int = 2
    val weight = 10
    val truck_weights = intArrayOf(7, 4, 5, 6)

    println(Solution33().solution(bridge_length, weight, truck_weights))
}
