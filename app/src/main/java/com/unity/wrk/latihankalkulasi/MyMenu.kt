package com.unity.wrk.mymovie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.unity.wrk.latihankalkulasi.BMI
import com.unity.wrk.latihankalkulasi.HitunganDasar
import com.unity.wrk.latihankalkulasi.R
import kotlinx.android.synthetic.main.my_menu.*

class MyMenu : AppCompatActivity() {

    private lateinit var moveTo : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_menu)

        moveTo = latihan_1
        moveTo.setOnClickListener {
            val moveToActivity = Intent (this, HitunganDasar::class.java)
            startActivity(moveToActivity)
        }

        moveTo = latihan_2
        moveTo.setOnClickListener {
            val moveToActivity = Intent (this, BMI::class.java)
            startActivity(moveToActivity)
        }
    }
}