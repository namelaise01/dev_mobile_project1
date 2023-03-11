package com.example.dev_mobile_project1

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    var productLink: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Log.i("Epsi","################## onCreate :"+javaClass.simpleName)
    }

    override fun onStart() {
        super.onStart()
        // Log.i("Epsi","################## onStart :"+javaClass.simpleName)
    }

    override fun onResume() {
        super.onResume()
        // Log.i("Epsi","################## onResume :"+javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()
        //Log.i("Epsi","################## onPause :"+javaClass.simpleName)
    }

    override fun onStop() {
        super.onStop()
        // Log.i("Epsi","################## onStop :"+javaClass.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()
        //Log.i("Epsi","################## onDestroy :"+javaClass.simpleName)
    }

    fun setHeaderTxt(txt:String) {
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.setText(txt)
    }

    fun showBack(){
        val imageViewBack=findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility=View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }


}