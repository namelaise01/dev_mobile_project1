package com.example.dev_mobile_project1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class DetailStudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_student)

        setHeaderTxt("Nom")
        showBack()

        val buttonLinkEpsi = findViewById<TextView>(R.id.linkEpsi)

        setHeaderTxt("Epsi")

        buttonLinkEpsi.setOnClickListener(View.OnClickListener {
            val browserIntent =  Intent(Intent.ACTION_VIEW, Uri.parse("http://www.epsi.fr"));
            startActivity(browserIntent);
        })

    }
}