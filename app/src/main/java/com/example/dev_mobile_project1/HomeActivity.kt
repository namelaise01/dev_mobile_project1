package com.example.dev_mobile_project1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val buttonInfo = findViewById<Button>(R.id.buttonInfo)
        val buttonProduits = findViewById<Button>(R.id.buttonProduits)

        setHeaderTxt("Epsi")

        buttonInfo.setOnClickListener(View.OnClickListener {
            val intent = Intent(application, InfoStudentActivity::class.java)
            startActivity(intent)
        })

        buttonProduits.setOnClickListener(View.OnClickListener {
            val intent = Intent(application, CategoryActivity::class.java)
            startActivity(intent)
        })

    }
}