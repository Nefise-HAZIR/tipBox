package com.develop.dsc_android_lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.develop.dsc_android_lesson2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHesapla.setOnClickListener{
            bahsisHesapla()
        }


    }

    fun bahsisHesapla(){
        val hizmetBedeliTutar=binding.editTextTextHizmetBedeli.toString()
        val tutar=hizmetBedeliTutar.toDouble()

        val secilenRadioButton=binding.radioGroup.checkedRadioButtonId // 3 seçeneği de tarayıp true olanı atıyor

        val bahsisYüzdesi=when(secilenRadioButton){
            R.id.radioButtonYüzde20->0.20
            R.id.radioButtonYüzde18->0.18
            else->0.15
        }

        var bahsis=tutar*bahsisYüzdesi

        val yukarıYuvarla=binding.switchBahsisYuvarla.isChecked
        if(yukarıYuvarla){
            bahsis=kotlin.math.ceil(bahsis)
        }
        binding.TextViewBahsisTutar.text="$bahsis ₺"



    }
}