package com.rich.taskintentbundleparce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_result.*

class IntentResultActivity : AppCompatActivity() {
    private lateinit var umur : String
    private lateinit var tinggi : String
    private lateinit var berat : String
    private lateinit var bmi : String
    private lateinit var kategoriBmi : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_result)
        getUsingIntent()
        setValue()
    }

    fun getUsingIntent(){
        umur = intent.getStringExtra("umur").toString()
        tinggi = intent.getStringExtra("tinggi").toString()
        berat = intent.getStringExtra("berat").toString()
        bmi = intent.getStringExtra("bmi").toString()
        kategoriBmi = intent.getStringExtra("kategoriBmi").toString()
        Log.w("VAL", "umur : $umur, berat : $berat, tinggi : $tinggi, bmi : $bmi, kategori : $kategoriBmi")
    }


    fun setValue(){
        etUmurRead.setText(umur.toString())
        etTinggiRead.setText(tinggi.toString())
        etBeratRead.setText(berat.toString())
        etBmiRead.setText(bmi.toString())
        etKategoriRead.setText(kategoriBmi)
    }
}