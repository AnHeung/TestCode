package kuma.crawler.testcode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Exception

class CalViewModel(private val calculation : Calculations) : ViewModel(){

    private val _radius = MutableLiveData<String>()
    val radius: LiveData<String> = _radius
    private val _area = MutableLiveData<String>()
    val area: LiveData<String> = _area
    private val _circumference = MutableLiveData<String> ()
    val circumference: LiveData<String> = _circumference

    fun calculate(){
        try{
            val radiusDouble = radius.value?.toDouble()
            if(radiusDouble != null){
                calculateArea(radiusDouble)
                calculateCircumference(radiusDouble)
            }else{
                _area.value = null
                _circumference.value = null
            }

        }catch (e : Exception){
            println(e.message.toString())
            _area.value  = null
            _circumference.value  = null
        }
    }

    fun calculateArea(radius : Double){
        val calculateArea = calculation.calculateArea(radius)
        _area.value = calculateArea.toString()
    }

    fun calculateCircumference(radius: Double) {
        val calculatedCircumference = calculation.calculateCircumference(radius)
        _circumference.value = calculatedCircumference.toString()
    }
}