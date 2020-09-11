package com.dev_candra.age_calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Aksi()
    }

    private fun Aksi(){
        button_hitung.setOnClickListener {
            calculate()
        }
        initToolbar()
    }

    private fun calculate(){
        val year = Calendar.getInstance().get(Calendar.YEAR)
        val userUmur = edit_umur.text.toString()
        if (userUmur.isEmpty()){
            makeToast("kolom umur harus diisi") // jika umur tidak diisi
        }else if (userUmur.length > 5){
            makeToast("Angka umur berlebihan") // jika inputan diisi lebih dari 5 karakter
        }else if (userUmur > year.toString()){
            makeToast("Inputan Anda Lebih dari panjang tahun")
        }else{
            val value = year - userUmur.toInt() // tahun dikurang dari umur anda
            textHasil.setText("Umur anda adalah: $value")
        }
    }

    private fun makeToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    private fun initToolbar(){
        val actionBar = supportActionBar
        actionBar?.title = "Candra Julius Sinaga"
        actionBar?.subtitle = "Kalkulator Umur"
    }
}
