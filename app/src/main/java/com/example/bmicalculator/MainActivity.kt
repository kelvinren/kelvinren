package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener{
            calculateBMI()
        }
        buttonReset.setOnClickListener{
            buttonReset()
        }
    }
    private fun calculateBMI(){
        if(editTextWeight .text.isEmpty()){
            editTextWeight.setError(getString(R.string.input_error))
            return
        }
        if(editTextHeight .text.isEmpty()){
            editTextHeight.setError(getString(R.string.input_error))
            return
        }
        val weight = editTextWeight.text.toString().toFloat()
        val height = editTextHeight.text.toString().toFloat()

        val bmi = weight / height.pow(2)
        textViewBMI.text = String.format("%s %.2f",getString(R.string.bmi), bmi)

        if(bmi < 18.5) {
            textViewStatus.text =
                String.format("%s %s", getString(R.string.status), getString(R.string.underweight))
            imageViewProfile.setImageResource(R.drawable.under)
        }
        if(bmi >= 18.5 && bmi <= 24.9) {
            textViewStatus.text =
                String.format("%s %s", getString(R.string.status), getString(R.string.normal))
            imageViewProfile.setImageResource(R.drawable.normal)
        }
        if(bmi >= 25) {
            textViewStatus.text =
                String.format("%s %s", getString(R.string.status), getString(R.string.overweight))
            imageViewProfile.setImageResource(R.drawable.over)
        }
    }
    private fun buttonReset(){
        editTextWeight.setText("")
        editTextHeight.setText("")
        textViewStatus.text = getString(R.string.status)
        textViewBMI.text = getString(R.string.bmi)
        imageViewProfile.setImageResource((R.drawable.empty))
    }
}
