package com.rich.taskintentbundleparce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_serializable_result.*

class SerializableResultActivity : AppCompatActivity() {
    private lateinit var umur : String
    private lateinit var tinggi : String
    private lateinit var berat : String
    private lateinit var bmi : String
    private lateinit var kategoriBmi : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serializable_result)
        getUsingSerializable()
        setValue()
    }

    private fun getUsingSerializable() {
        val dataResult = intent.getSerializableExtra("dataSer") as DataSerializable
        umur = dataResult.umur
        tinggi = dataResult.tinggi
        berat = dataResult.berat
        bmi = dataResult.bmi
        kategoriBmi = dataResult.kategoriBmi
    }

    private fun setValue() {
        etUmurRead.setText(umur.toString())
        etTinggiRead.setText(tinggi.toString())
        etBeratRead.setText(berat.toString())
        etBmiRead.setText(bmi.toString())
        etKategoriRead.setText(kategoriBmi)
    }
}