package kuma.crawler.testcode

import com.google.common.truth.Truth
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Before
import org.junit.Test

class BowlingGame2Test {

    private lateinit var bowlingGame: BowlingGame2

    @Before
    fun setUp() {
        bowlingGame = BowlingGame2()
    }

    @Test
    fun bowlingGame_create() {
        assertThat(bowlingGame, `is`(notNullValue()))
    }

    @Test
    fun allGutter_returnZero() {
        repeatAddScore(20,0)
        assertThat(bowlingGame.score, `is`(0))
    }

    @Test
    fun oneStrike_allGutter_returnTen() {
        bowlingGame.addScore(10)
        bowlingGame.addScore(0)
        repeatAddScore(18, 0)
        assertThat(bowlingGame.score, `is`(10))
    }

    @Test
    fun allGutter_oneStrike_oneStrike_nineScore() {
        repeatAddScore(18, 0)
        bowlingGame.addScore(10)
        bowlingGame.addScore(10)
        bowlingGame.addScore(9)
        assertThat(bowlingGame.score, `is`(29))
    }

    @Test
    fun realGame(){
        bowlingGame.addScore(8)
        bowlingGame.addScore(1)
        bowlingGame.addScore(10)
        bowlingGame.addScore(10)
        bowlingGame.addScore(9)
        bowlingGame.addScore(1)
        bowlingGame.addScore(0)
        bowlingGame.addScore(4)
        bowlingGame.addScore(6)
        bowlingGame.addScore(4)
        bowlingGame.addScore(10)
        bowlingGame.addScore(10)
        bowlingGame.addScore(4)
        bowlingGame.addScore(3)
        bowlingGame.addScore(10)
        bowlingGame.addScore(5)
        bowlingGame.addScore(5)

        Truth.assertThat(bowlingGame.score).isEqualTo(160)
    }

    private fun repeatAddScore(repeatSize: Int , score:Int) {
        repeat(repeatSize) {
            bowlingGame.addScore(score)
        }
    }
}