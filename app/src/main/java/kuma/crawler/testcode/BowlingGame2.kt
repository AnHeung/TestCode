package kuma.crawler.testcode

const val MAX_PIN = 10

class BowlingGame2 {

    private val bowArr = IntArray(21) { 0 }
    var currentRound = 0

    val score: Int
        get() {

            var score = 0
            var round = 0

            for (frame in 0..9) {
                when {
                    isStrike(round) -> {
                        score += MAX_PIN + bowArr[round + 1] + bowArr[round + 2]
                        round++
                    }
                    isSpare(round) -> {
                        score += MAX_PIN + bowArr[round + 2]
                        round += 2
                    }
                    else -> {
                        score += bowArr[round] + bowArr[round + 1]
                        round += 2
                    }
                }
            }
            return score
        }

    fun addScore(score: Int) {
        bowArr[currentRound++] = score
    }

    private fun isStrike(round: Int) = bowArr[round] == MAX_PIN

    private fun isSpare(round: Int) = bowArr[round] + bowArr[round + 1] == MAX_PIN

}