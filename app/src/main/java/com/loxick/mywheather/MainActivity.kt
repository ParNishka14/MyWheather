package com.loxick.mywheather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tempreatureText: TextView
    private lateinit var preasureText: TextView
    private lateinit var windText: TextView
    private lateinit var feelsLikeText: TextView
    private lateinit var humidityText: TextView
    private lateinit var generateWheater:Button
    private lateinit var wetherIco: ImageView
    private lateinit var dateText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dateText = findViewById(R.id.dateText)
        tempreatureText = findViewById(R.id.tempreatureText)
        preasureText = findViewById(R.id.preasureText)
        windText = findViewById(R.id.windText)
        feelsLikeText = findViewById(R.id.feelsLikeText)
        humidityText = findViewById(R.id.HumidityText)
        generateWheater = findViewById(R.id.showWheatherButton)
        wetherIco = findViewById(R.id.WheatherIco)

        generateWhether()
        generateWheater.setOnClickListener{
            view: View -> generateWhether()
        }
    }




 private fun generateWhether(){
     var month:Int = (1..12).random()
     println(month)
     when(month){
         12 -> {
             wetherIco.setImageResource(R.drawable.winter)
             //setParameters(-10,-3)
         }
         1 -> {
             wetherIco.setImageResource(R.drawable.winter)
             setParameters(-30,-16)
         }
         2 -> {
             wetherIco.setImageResource(R.drawable.winter)
             setParameters(-10,0)
         }
         3 -> {
             wetherIco.setImageResource(R.drawable.vesna)
             setParameters(0,2)
         }
         4 -> {
             wetherIco.setImageResource(R.drawable.vesna)
             setParameters(3,10)
         }
         5 -> {
             wetherIco.setImageResource(R.drawable.vesna)

             setParameters(10, 18)
         }
         6 -> {
             wetherIco.setImageResource(R.drawable.summer)
             setParameters(15,20)
         }
         7 -> {
             wetherIco.setImageResource(R.drawable.summer)
             setParameters(20,35)
         }
         8 -> {
             wetherIco.setImageResource(R.drawable.summer)
             setParameters(20,35)
         }
         9 -> {
             wetherIco.setImageResource(R.drawable.osen)
             setParameters(10,20)
         }
         10 -> {
             wetherIco.setImageResource(R.drawable.osen)
             setParameters(8,13)
         }
         11 -> {
             wetherIco.setImageResource(R.drawable.osen)
             setParameters(0,10)
         }
     }
     dateText.setText("${(1..30).random()}/$month")

 }
    fun setTempreature (min:Int, max:Int){
        var tm:Int = (min..max).random()
        tempreatureText.setText("$tm°/$max°")
    }
    fun setRandomPreasure(){
        var preasure:Int = (700..1400).random()
        preasureText.setText("Preasure: $preasure")
    }
    fun setRandomWind(){
        var wind:Int = (1..20).random()
        windText.setText("Wind: $wind m/s")
    }
    fun setFeelsLike(min: Int, max: Int){
        feelsLikeText.setText("Feels like ${min + (1..5).random()}")
    }
    fun setHumidity(){
        var hudl:Int = (20..100).random()
        humidityText.setText("Humidity: $hudl %")
    }
    fun setParameters(min:Int, max:Int){
        setTempreature(min,max)
        setRandomPreasure()
        setFeelsLike(min,max)
        setRandomWind()
        setHumidity()
    }
}