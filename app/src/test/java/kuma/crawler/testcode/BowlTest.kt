package kuma.crawler.testcode

import com.google.common.truth.Truth.*
import org.junit.Before
import org.junit.Test

class BowlTest {

    private lateinit var bowlingGame : BowlingGame

    @Before
    fun setUp(){
        bowlingGame = BowlingGame()
    }

    @Test
    fun bowlingGame_create(){
        assertThat(bowlingGame).isNotNull()
    }

    @Test
    fun allGutter_returnZero(){
        bowlRepeat(20, 0)
        assertThat(bowlingGame.score).isEqualTo(0)
    }

    @Test
    fun allStrike_return300(){
        bowlRepeat(12, 10)
        assertThat(bowlingGame.score).isEqualTo(300)
    }

    @Test
    fun oneStrike_oneGutter(){
        bowlingGame.bowl(10)
        bowlRepeat(18, 0)
        assertThat(bowlingGame.score).isEqualTo(10)
    }

    @Test
    fun oneStrike_oneSevenScore_allGutter(){
        bowlingGame.bowl(10)
        bowlingGame.bowl(7)
        bowlRepeat(17, 0)
        assertThat(bowlingGame.score).isEqualTo(24)
    }

    @Test
    fun allGutter_oneStrike_oneStrike_nineScore(){
        bowlRepeat(18,0)
        bowlingGame.bowl(10)
        bowlingGame.bowl(10)
        bowlingGame.bowl(9)

        assertThat(bowlingGame.score).isEqualTo(29)
    }

    @Test
    fun oneSpare_sixScore_threeScore_allGutter(){
        bowlingGame.bowl(9)
        bowlingGame.bowl(1)
        bowlingGame.bowl(6)
        bowlingGame.bowl(3)
        bowlRepeat(16,0)

        assertThat(bowlingGame.score).isEqualTo(25)
    }

    @Test
    fun realGame(){
        bowlingGame.bowl(8)
        bowlingGame.bowl(1)
        bowlingGame.bowl(10)
        bowlingGame.bowl(10)
        bowlingGame.bowl(9)
        bowlingGame.bowl(1)
        bowlingGame.bowl(0)
        bowlingGame.bowl(4)
        bowlingGame.bowl(6)
        bowlingGame.bowl(4)
        bowlingGame.bowl(10)
        bowlingGame.bowl(10)
        bowlingGame.bowl(4)
        bowlingGame.bowl(3)
        bowlingGame.bowl(10)
        bowlingGame.bowl(5)
        bowlingGame.bowl(5)

        assertThat(bowlingGame.score).isEqualTo(160)
    }

    private fun bowlRepeat(size: Int, pin : Int){
        for(i in 0 until size){
            bowlingGame.bowl(pin)
        }
    }
}