package kuma.crawler.testcode

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*


class CalViewModelTest {

    private lateinit var calViewModel : CalViewModel
    private lateinit var calculations: Calculations

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        calculations = mock(Calculations::class.java)
        `when`(calculations.calculateArea(2.1)).thenReturn(13.8474)
        `when`(calculations.calculateCircumference(1.0)).thenReturn(6.28)
        calViewModel = CalViewModel(calculations)
    }

    @Test
    fun calculateArea_radiusSent_updateLiveData(){
        calViewModel.calculateArea(2.1)
        val result = calViewModel.area.value
        Truth.assertThat(result).isEqualTo("13.8474")
    }

    @Test
    fun calculateCircumference_radiusSent_updateLiveData(){
        calViewModel.calculateCircumference(1.0)
        val result = calViewModel.circumference.value
        Truth.assertThat(result).isEqualTo("6.28")
    }
}