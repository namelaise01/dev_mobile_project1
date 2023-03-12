package com.example.dev_mobile_project1

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProductsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        var productLink: String = ""
        var productName: String = ""

        if (intent.extras != null) {
            productLink = intent.extras!!.getString("productLink", "");
            productName = intent.extras!!.getString("title", "");
        }

        setHeaderTxt(productName)
        showBack()


        val products = arrayListOf<Product>()

        val recyclerviewProducts = findViewById<RecyclerView>(R.id.recyclerviewProduct)
        recyclerviewProducts.layoutManager = LinearLayoutManager(this)
        val productAdapter = ProductAdapter(products, this)
        recyclerviewProducts.adapter = productAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val request =
            Request.Builder().url(productLink).cacheControl(CacheControl.FORCE_NETWORK).build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                if (data != null) {
                    val jsProduct = JSONObject(data)
                    val jsArrayProducts = jsProduct.getJSONArray("items")

                    for (i in 0 until jsArrayProducts.length()) {
                        val jsProduct = jsArrayProducts.getJSONObject(i)
                        val product = Product(
                            jsProduct.optString("name", "Not found"),
                            jsProduct.optString("description", "Not found"),
                            jsProduct.optString("picture_url", "Not found"),
                        )
                        products.add(product)
                    }
                    runOnUiThread(Runnable {
                        productAdapter.notifyDataSetChanged()
                    })
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread(Runnable {
                    Toast.makeText(application, e.message, Toast.LENGTH_SHORT).show()
                })
            }
        })
    }
}