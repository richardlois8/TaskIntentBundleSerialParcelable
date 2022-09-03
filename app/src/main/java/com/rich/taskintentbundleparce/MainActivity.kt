package com.rich.taskintentbundleparce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private lateinit var umur : String
    private lateinit var tinggi : String
    private lateinit var berat : String
    private lateinit var bmi : String
    private lateinit var kategoriBmi : String
    lateinit var intentMove : Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListenerHitung()
        setListenerReset()
    }

    fun setListenerHitung() {
        btnHitung.setOnClickListener() {
            Toast.makeText(this, "Use Another Button", Toast.LENGTH_SHORT).show()
        }
        btnIntent.setOnClickListener {
            intentMove = Intent(this, IntentResultActivity::class.java)
            setValue()
            sendUsingIntent()
        }
        btnBundle.setOnClickListener {
            intentMove = Intent(this, BundleResultActivity::class.java)
            setValue()
            sendUsingBundle()
        }
        btnSerializable.setOnClickListener {
            intentMove = Intent(this, SerializableResultActivity::class.java)
            setValue()
            sendUsingSerializable()
        }
        btnParcelable.setOnClickListener {
            intentMove = Intent(this, ParcelableResultActivity::class.java)
            setValue()
            sendUsingParcelable()
        }
    }

    fun setListenerReset() {
        btnReset.setOnClickListener{
            reset()
        }
    }

    fun setValue(){
        umur = etUmur.text.toString()
        berat = etBerat.text.toString()
        tinggi = etTinggi.text.toString()
        bmi = round(hitungBmi(berat.toDouble(), tinggi.toDouble())).toString()
        kategoriBmi = kategoriBmi(bmi.toDouble())
    }

    fun hitungBmi(berat: Double, tinggi: Double): Double {
        val bmi = berat / ((tinggi * tinggi) / 10000)
        return bmi
    }

    fun kategoriBmi(bmi: Double): String {
        var hasilBmi = ""
        if (bmi < 16.0) {
            hasilBmi = "Terlalu kurus"
        } else if (bmi >= 16.0 && bmi < 17.0) {
            hasilBmi = "Cukup Kurus"
        } else if (bmi >= 17.0 && bmi < 18.5) {
            hasilBmi = "Sedikit Kurus"
        } else if (bmi >= 18.5 && bmi < 25.0) {
            hasilBmi = "Normal"
        } else if (bmi >= 25.0 && bmi < 30.0) {
            hasilBmi = "Gemuk"
        } else if (bmi >= 30.0 && bmi < 35.0) {
            hasilBmi = "Obesitas Kelas I"
        } else if (bmi >= 35.0 && bmi < 40.0) {
            hasilBmi = "Obesitas Kelas II"
        } else if (bmi >= 40.0) {
            hasilBmi = "Obesitas Kelas III"
        }
        return hasilBmi
    }

    fun reset() {
        etBerat.setText("")
        etTinggi.setText("")
        etUmur.setText("")
    }

    fun sendUsingIntent(){
        intentMove.putExtra("umur", umur)
        intentMove.putExtra("tinggi", tinggi)
        intentMove.putExtra("berat", berat)
        intentMove.putExtra("bmi", bmi)
        intentMove.putExtra("kategoriBmi", kategoriBmi)
        Log.w("VAL", "umur : ${intentMove.getStringExtra("umur")}, berat : $berat, tinggi : $tinggi, bmi : $bmi, kategori : $kategoriBmi")
        startActivity(intentMove)
    }

    fun sendUsingBundle(){
        val bundle = Bundle()
        bundle.putString("umur", umur)
        bundle.putString("tinggi", tinggi)
        bundle.putString("berat", berat)
        bundle.putString("bmi", bmi)
        bundle.putString("kategoriBmi", kategoriBmi)
        intentMove.putExtras(bundle)
        startActivity(intentMove)
    }

    fun sendUsingSerializable(){
        val dataSer = DataSerializable(umur, tinggi, berat, bmi, kategoriBmi)
        intentMove.putExtra("dataSer", dataSer)
        startActivity(intentMove)
    }

    fun sendUsingParcelable(){
        val dataParcel = DataParcelable(umur, tinggi, berat, bmi, kategoriBmi)
        intentMove.putExtra("dataParcel", dataParcel)
        startActivity(intentMove)
    }
}