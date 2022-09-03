package com.rich.taskintentbundleparce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_serializable_result.*

class ParcelableResultActivity : AppCompatActivity() {
    private lateinit var umur : String
    private lateinit var tinggi : String
    private lateinit var berat : String
    private lateinit var bmi : String
    private lateinit var kategoriBmi : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable_result)
        getUsingParcelable()
        setValue()
    }

    private fun getUsingParcelable() {
        val dataResult = intent.getParcelableExtra<DataParcelable>("dataParcel") as DataParcelable
        umur = dataResult.umur.toString()
        tinggi = dataResult.tinggi.toString()
        berat = dataResult.berat.toString()
        bmi = dataResult.bmi.toString()
        kategoriBmi = dataResult.kategoriBmi.toString()
    }

    private fun setValue() {
        etUmurRead.setText(umur.toString())
        etTinggiRead.setText(tinggi.toString())
        etBeratRead.setText(berat.toString())
        etBmiRead.setText(bmi.toString())
        etKategoriRead.setText(kategoriBmi)
    }
}