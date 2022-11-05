package com.example.yakthesaplama

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")

    var dizel1=0f
    var benzin1=0f
    var lpg1=0f

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        saveData()
        getData()

        var x = 0.0f
        var mod = 1 //mod 1 hesapla mod 2 güncelle

       val rb1: RadioButton =findViewById(R.id.radioButton)
        val rb2: RadioButton =findViewById(R.id.radioButton2)
        val rb3 : RadioButton =findViewById(R.id.radioButton3)
        val btn1: Button= findViewById(R.id.button)
        val btn2: Button= findViewById(R.id.button2)
        val txt0: TextView=findViewById(R.id.textView78)
        val  txt1: EditText =findViewById(R.id.editTextTextPersonName4)
        val  txt2: EditText =findViewById(R.id.editTextTextPersonName2)
        val  txt3: EditText =findViewById(R.id.editTextTextPersonName)
        val  txt8: TextView =findViewById(R.id.textView8)
        val  txt9: TextView =findViewById(R.id.textView9)
        val  txt5: TextView =findViewById(R.id.textView4)
        val  txt6: TextView =findViewById(R.id.textView5)
        val  txt7: TextView =findViewById(R.id.textView6)
        rb1.setOnCheckedChangeListener{ buttonView, isChecked ->

         x=dizel1
         rb2.setChecked(false)
         rb3.setChecked(false)

        }

        rb2.setOnCheckedChangeListener{ buttonView, isChecked ->

            x=benzin1
            rb1.setChecked(false)
            rb3.setChecked(false)
        }

        rb3.setOnCheckedChangeListener{ buttonView, isChecked ->

            x=lpg1
            rb1.setChecked(false)
            rb2.setChecked(false)
        }
        btn1.setOnClickListener{

        if(mod==1){
          if(txt1.text.isEmpty()||txt2.text.isEmpty()||txt3.text.isEmpty()){
                txt1.setText("0")
                txt2.setText("0")
                txt3.setText("0")
            }
            val toFloat = txt1.text.toString().toFloat()
            val sim =toFloat * x
            val sonuc1 = ((txt3.text.toString().toFloat())*sim)/100.0f
            val sam =((txt2.text.toString().toFloat())*x)
            val sonuc2 =((txt3.text.toString().toFloat())*sam)/100.0f
            txt8.setText("Şehiriçi maliyet : ${sonuc1} tl")
            txt9.setText("Şehirlerarası maliyet : ${sonuc2} tl")}
            else if(mod==2){
            if(txt1.text.isEmpty()&&txt2.text.isEmpty()&&txt3.text.isEmpty()){
                txt1.setText("0")
                txt2.setText("0")
                txt3.setText("0")
            }
            rb1.visibility=View.VISIBLE
            rb2.visibility=View.VISIBLE
            rb3.visibility=View.VISIBLE
            txt0.visibility=View.VISIBLE
            btn1.setText("Hesapla")

            txt5.setText("Şehiriçi Yakıt Tüketimi")
            txt6.setText("Şehirlerarası Yakıt Tüketimi")
            txt7.setText("Gidilecek Km")
            dizel1=txt1.text.toString().toFloat()
            benzin1=txt2.text.toString().toFloat()
            lpg1=txt3.text.toString().toFloat()
            txt1.setText("0")
            txt2.setText("0")
            txt3.setText("0")
            btn2.visibility=View.VISIBLE
            mod=1
            saveData()





            }


        }
        btn2.setOnClickListener{
            rb1.visibility=View.INVISIBLE
            rb2.visibility=View.INVISIBLE
            rb3.visibility=View.INVISIBLE
            btn2.visibility=View.INVISIBLE
            txt0.visibility=View.INVISIBLE
            btn1.setText("Güncelle")

            txt5.setText("\nDizel Fiyat")
            txt6.setText("\nBenzin Fiyat")
            txt7.setText("Lpg fiyat")
            getData()
            txt1.setText(dizel1.toString())
            txt2.setText(benzin1.toString())
            txt3.setText(lpg1.toString())
            mod=2
        }





        }
  fun saveData(){
      val sharedPref = getSharedPreferences("saveData", Context.MODE_PRIVATE)
      val editor:SharedPreferences.Editor = sharedPref.edit()
        editor.putFloat("key_dizel", dizel1!!)
        editor.putFloat("key_benzin",benzin1!!)
        editor.putFloat("key_lpg",lpg1!!)

        editor.apply()
        Toast.makeText(applicationContext,"saved",Toast.LENGTH_LONG).show()
    }
    fun getData(){
        val sharedPref1 = getSharedPreferences("saveData", Context.MODE_PRIVATE)
        val editor1:SharedPreferences.Editor = sharedPref1.edit()
        val dizel2=sharedPref1.getFloat("key_dizel",0f)
        val benzin2=sharedPref1.getFloat("key_benzin",0f)
        val lpg2=sharedPref1.getFloat("key_lpg",0f)


        dizel1=dizel2.toString().toFloat()
        benzin1=benzin2.toString().toFloat()
        lpg1=lpg2.toString().toFloat()
        editor1.apply()


    }



}


