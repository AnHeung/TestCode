package kuma.crawler.testcode

import com.google.common.truth.Truth
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Test

class CalTest {

    private lateinit var cal : Cal

    @Before
    fun setUp(){
        cal = Cal()
    }

    @Test
    fun calculateCircumference_radius_returnsCorrectResult(){
        val result = cal.calculateCircumference(2.1)
        assertThat(result , `is`(13.188))
    }

    @Test
    fun calculateCircumference_zeroRadius_returnsCorrectResult(){
        val result = cal.calculateCircumference(0.0)
        assertThat(result,  `is`(0.0))
    }

    @Test
    fun calculateArea_radius_returnsCorrectResult(){
        val result = cal.calculateArea(2.0)
        assertThat(result , `is`(12.56))
    }

    @Test
    fun calculateArea_zeroRadius_returnsCorrectResult(){
        val result = cal.calculateArea(0.0)
        assertThat(result , `is`(0.0))
    }

    @Test
    fun calculateArea_null_returnsZero(){
        val result = cal.calculateArea(null)
//        assertThat(result,  `is`(0.0))
        Truth.assertThat(result).isEqualTo(0.0)
    }
}