package com.example.dev_mobile_project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailStudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_student)

        setHeaderTxt("Nom")
        showBack()
    }
}