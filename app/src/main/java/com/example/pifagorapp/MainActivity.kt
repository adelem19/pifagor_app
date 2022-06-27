 package com.example.pifagorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pifagorapp.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

 class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
     fun onClickResult(view : View){
         if(!isFieldEmpty()){
             val result = getString(R.string.result_info) + getResult()
             binding.tvRes.text = result

         }
     }

     private fun isFieldEmpty() : Boolean{
         binding.apply {
             if(inputA.text.isNullOrEmpty()) inputA.error = "Значение не введено"
             if(inputB.text.isNullOrEmpty()) inputB.error = "Значение не введено"
             return inputA.text.isNullOrEmpty() || inputB.text.isNullOrEmpty()
         }

     }
     private fun getResult() : String {
         val a : Double
         val b : Double
         binding.apply {
             a = inputA.text.toString().toDouble()
             b = inputB.text.toString().toDouble()
         }
         return sqrt((a.pow(2) + b.pow(2))).toString()
     }

 }