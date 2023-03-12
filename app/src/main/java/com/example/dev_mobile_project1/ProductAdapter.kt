package com.example.dev_mobile_project1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter(val products: ArrayList<Product>, val mcontext: Context) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_products, viewGroup, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)
        var productLink: String = product.picture_url
        holder.textViewProductName.text = product.name
        holder.textViewProductDescription.text = product.description
        Picasso.get().load(productLink).into(holder.imageProduct)

        holder.contentLayout.setOnClickListener(View.OnClickListener {
            //val intent =Intent(mcontext,  ProductsActivity::class.java)
            ///intent.putExtra("title", category.title)
           //intent.putExtra("productLink", category.products_url)
           // mcontext.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageProduct : ImageView = view.findViewById<ImageView>(R.id.imageViewProduct)
        val textViewProductName: TextView = view.findViewById<TextView>(R.id.textViewProductName)
        val textViewProductDescription: TextView = view.findViewById<TextView>(R.id.textViewProductDescription)
        val contentLayout: LinearLayout = view.findViewById<LinearLayout>(R.id.contentLayout)

    }
}
