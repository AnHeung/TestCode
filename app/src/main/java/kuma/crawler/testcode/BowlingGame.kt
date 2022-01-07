package kuma.crawler.testcode

const val MAX_ROLL_PIN = 10

class BowlingGame {

    private var currentBowl = 0
    private val bowls = IntArray(21) { 0 }

    val score: Int
        get() {
            var score = 0
            var round = 0

            for (frame in 0..9) {
                when {
                    isStrike(round) -> {
                        score += strikeNextFrameScore(round)
                        round++
                    }
                    isSpare(round) -> {
                        score += spareNextFrameFirstScore(round)
                        round += 2
                    }
                    else -> {
                        score += currentFrameScore(round)
                        round += 2
                    }
                }
            }
            return score
        }

    private fun currentFrameScore(round : Int)= bowls[round] + bowls[round+1]

    private fun strikeNextFrameScore(round : Int)= MAX_ROLL_PIN + bowls[round+1] + bowls[round+2]

    private fun spareNextFrameFirstScore(round : Int)= MAX_ROLL_PIN + bowls[round+2]

    private fun isSpare (round : Int) = currentFrameScore(round) == MAX_ROLL_PIN

    private fun isStrike(round : Int) = bowls[round] == MAX_ROLL_PIN

    fun bowl(pin: Int) {
        bowls[currentBowl++] = pin
    }
}