package com.example.dev_mobile_project1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailProductActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)
        val textViewProductDescription = findViewById<TextView>(R.id.textViewProductDescription)
        val imageProduct : ImageView = findViewById<ImageView>(R.id.imageViewProduct)


        var productdescription: String = ""
        var productName: String = ""
        var productLink: String = ""

        if (intent.extras != null) {
            val image = findViewById<ImageView>(R.id.imageViewProduct)
            productName = intent.extras!!.getString("name", "");
            productdescription = intent.extras!!.getString("description", "");
            productLink = intent.extras!!.getString("picture_url", "");

            Picasso.get().load(productLink).into(imageProduct)

            textViewProductDescription.text = "Description: \n\n" + productdescription
        }

        setHeaderTxt(productName)
        showBack()
    }
}