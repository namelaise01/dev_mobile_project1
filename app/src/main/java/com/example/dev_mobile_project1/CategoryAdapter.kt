package com.example.dev_mobile_project1

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(val categories: ArrayList<Category>, val mcontext: Context) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_category, viewGroup, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories.get(position)
        holder.textViewName.text = category.title

        holder.contentLayout.setOnClickListener(View.OnClickListener {
            val intent =Intent(mcontext,  ProductsActivity::class.java)
            intent.putExtra("title", category.title)
            intent.putExtra("productLink", category.products_url)
            mcontext.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById<TextView>(R.id.textViewCategory)
        val contentLayout: LinearLayout = view.findViewById<LinearLayout>(R.id.contentLayout)

    }
}
