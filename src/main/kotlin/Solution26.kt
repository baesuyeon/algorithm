package org.example

/**
 * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42579
 * 배운 것 :
 * - map.toList()의 결과는 List<Pair<Int, Int>>가 된다.
 * - map value 기준 내림차순 정렬 : val sortedByValueDesc = map.toList().sortedByDescending { it.second }
 * - map key 기준 내림차순 정렬 : val sortedByKeyDesc = map.toList().sortedByDescending { it.first }
 */
class Solution26 {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        // Map<장르, 속한 노래 재생 수 합>
        val genresMap = mutableMapOf<String, Int>()

        // Map<장르, (노래 ID, 재생 수) 배열>
        val songMap = mutableMapOf<String, List<Song>>()

        genres.forEachIndexed { index, genre ->
            genresMap[genre] = (genresMap[genre] ?: 0) + plays[index]

            val bestSongs: List<Song> = (songMap[genre] ?: listOf())
            songMap[genre] = findPopularSongs(songs = bestSongs + Song(id = index, playCount = plays[index]))
        }

        val sortedGenres = genresMap.toList().sortedByDescending { it.second }.map { it.first }

        val sortedSongs = sortedGenres.mapNotNull { genres ->
            songMap[genres]
        }.flatMap { it }

        return sortedSongs.map { it.id }.toIntArray()
    }

    data class Song(
        val id: Int,
        val playCount: Int,
    )

    fun findPopularSongs(songs: List<Song>): List<Song> {
        return songs.sortedByDescending { it.playCount }.take(2)
    }
}

fun main() {
    val genres = arrayOf("classic", "pop", "classic", "classic", "pop")
    val plays = intArrayOf(500, 600, 150, 800, 2500)
    val answer = Solution26().solution(genres, plays)
    print(answer.contentToString())
}
