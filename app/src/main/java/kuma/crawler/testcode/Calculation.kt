package kuma.crawler.testcode

class Cal : Calculations {

    private val pi = 3.14

    override fun calculateCircumference(radius: Double?): Double = radius?.let { 2 * pi * it} ?: 0.0

    override fun calculateArea(radius: Double?): Double = radius?.let { pi * it * it }?:0.0
}

interface Calculations {

    fun calculateCircumference(radius : Double?) : Double

    fun calculateArea(radius : Double?) : Double
}