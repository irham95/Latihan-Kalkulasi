package com.unity.wrk.latihankalkulasi

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

/**
 * written by Naya Nurwiyoga
 */

class BMI : AppCompatActivity() {

    private var height: EditText? = null
    private var weight: EditText? = null
    private var result: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi_berat_badan)
        height = findViewById<View>(R.id.input_tinggibadan) as EditText
        weight = findViewById<View>(R.id.input_beratbadan) as EditText
        result = findViewById<View>(R.id.hasil) as TextView
    }

    fun calculateBMI(v: View) {
        val heightStr = height!!.text.toString()
        val weightStr = weight!!.text.toString()

        if (heightStr != null && "" != heightStr
            && weightStr != null && "" != weightStr
        ) {
            val heightValue = java.lang.Float.parseFloat(heightStr) / 100
            val weightValue = java.lang.Float.parseFloat(weightStr)

            val bmi = weightValue / (heightValue * heightValue)

            displayBMI(bmi)
        }
    }

    private fun displayBMI(bmi: Float) {
        var bmiLabel = ""

        if (java.lang.Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight)
        } else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(
                bmi,
                16f
            ) <= 0
        ) {
            bmiLabel = getString(R.string.severely_underweight)
        } else if (java.lang.Float.compare(bmi, 16f) > 0 && java.lang.Float.compare(
                bmi,
                18.5f
            ) <= 0
        ) {
            bmiLabel = getString(R.string.underweight)
        } else if (java.lang.Float.compare(bmi, 18.5f) > 0 && java.lang.Float.compare(
                bmi,
                25f
            ) <= 0
        ) {
            bmiLabel = getString(R.string.normal)
        } else if (java.lang.Float.compare(bmi, 25f) > 0 && java.lang.Float.compare(
                bmi,
                30f
            ) <= 0
        ) {
            bmiLabel = getString(R.string.overweight)
        } else if (java.lang.Float.compare(bmi, 30f) > 0 && java.lang.Float.compare(
                bmi,
                35f
            ) <= 0
        ) {
            bmiLabel = getString(R.string.obese_class_i)
        } else if (java.lang.Float.compare(bmi, 35f) > 0 && java.lang.Float.compare(
                bmi,
                40f
            ) <= 0
        ) {
            bmiLabel = getString(R.string.obese_class_ii)
        } else {
            bmiLabel = getString(R.string.obese_class_iii)
        }
        bmiLabel = bmi.toString() + "\n\n" + bmiLabel
        result!!.text = bmiLabel
    }
}