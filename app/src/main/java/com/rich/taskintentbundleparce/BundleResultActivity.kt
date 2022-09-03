package com.rich.taskintentbundleparce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_bundle_result.*

class BundleResultActivity : AppCompatActivity() {
    private lateinit var umur : String
    private lateinit var tinggi : String
    private lateinit var berat : String
    private lateinit var bmi : String
    private lateinit var kategoriBmi : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bundle_result)
        getUsingBundle()
        setValue()
    }

    private fun setValue() {
        etUmurRead.setText(umur.toString())
        etTinggiRead.setText(tinggi.toString())
        etBeratRead.setText(berat.toString())
        etBmiRead.setText(bmi.toString())
        etKategoriRead.setText(kategoriBmi)
    }

    private fun getUsingBundle() {
        val dataBundle = intent.extras
        if (dataBundle != null) {
            umur = dataBundle.getString("umur").toString()
            tinggi = dataBundle.getString("tinggi").toString()
            berat = dataBundle.getString("berat").toString()
            bmi = dataBundle.getString("bmi").toString()
            kategoriBmi = dataBundle.getString("kategoriBmi").toString()
        }
    }
}