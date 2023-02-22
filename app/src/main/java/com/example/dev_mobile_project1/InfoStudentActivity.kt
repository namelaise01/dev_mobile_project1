package com.example.dev_mobile_project1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class InfoStudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_student)
        val etudiantInfoButton = findViewById<Button>(R.id.buttonInfo)

        setHeaderTxt("Infos")
        showBack()

        etudiantInfoButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(application, InfoStudentActivity::class.java)
            startActivity(intent)
        })

    }
}