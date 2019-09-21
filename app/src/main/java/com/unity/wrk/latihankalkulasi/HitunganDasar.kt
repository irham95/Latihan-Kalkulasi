package com.unity.wrk.latihankalkulasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HitunganDasar : AppCompatActivity(), View.OnClickListener {

    lateinit var inputSatu : EditText // lateint untuk membuat notnull. inisialisasi dr parameter/pengenalanvariabel
    lateinit var inputDua : EditText
    lateinit var btnTambah : Button
    lateinit var btnKurang : Button
    lateinit var btnKali : Button
    lateinit var btnBagi : Button
    lateinit var hasil : TextView

    override fun onCreate(savedInstanceState: Bundle?) { //
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hitungan_dasar)

        inputSatu = findViewById(R.id.input_satu) //menemukan id yg ada di xml
        inputDua = findViewById(R.id.input_dua)
        btnTambah = findViewById(R.id.btn_tambah)
        btnKurang = findViewById(R.id.btn_kurang)
        btnKali = findViewById(R.id.btn_kali)
        btnBagi = findViewById(R.id.btn_bagi)
        hasil = findViewById(R.id.hasil)

        btnTambah.setOnClickListener(this) //aktipin tombol button
        btnKurang.setOnClickListener(this)
        btnKali.setOnClickListener(this)
        btnBagi.setOnClickListener(this)
    }

    override fun onClick(p0: View) { //untuk memfungsikan tombol
        val angkaSatu = inputSatu.text.toString().trim()
        val angkaDua = inputDua.text.toString().trim()
        var inputKosong = false

        when { //pengganti switch case
            angkaSatu.isEmpty() -> { //memunculkan allert error atau tidak ketika tombol di klik,jk data null
                inputKosong = true
                inputSatu.error = "Angka ke-1 kosong"
            }
            angkaDua.isEmpty() -> {
                inputKosong = true
                inputDua.error = "Angka ke-2 kosong"
            }
        }

        if (p0.id == R.id.btn_tambah) {
            if (!inputKosong) {
                val hasilHitung = angkaSatu.toDouble() + angkaDua.toDouble() //object Immutable isinya tdk dpt di ubah2
                hasil.text = hasilHitung.toString()
            }
        }

        if (p0.id == R.id.btn_kurang) {
            if (!inputKosong) {
                val hasilHitung = angkaSatu.toDouble() - angkaDua.toDouble()
                hasil.text = hasilHitung.toString()
            }
        }

        if (p0.id == R.id.btn_kali) {
            if (!inputKosong) {
                val hasilHitung = angkaSatu.toDouble() * angkaDua.toDouble()
                hasil.text = hasilHitung.toString()
            }
        }

        if (p0.id == R.id.btn_bagi) {
            if (!inputKosong) {
                val hasilHitung = angkaSatu.toDouble() / angkaDua.toDouble()
                hasil.text = hasilHitung.toString()
            }
        }

    }
}
