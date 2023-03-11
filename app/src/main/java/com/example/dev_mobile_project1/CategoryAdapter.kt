package com.example.dev_mobile_project1

import android.app.Application
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(val categories: ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_category, viewGroup, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories.get(position)
        holder.textViewName.text = category.title
        //  holder.textViewEmail.text = category.title
        //  holder.textViewCity.text = category.products_url


        holder.contentLayout.setOnClickListener(View.OnClickListener {

            Toast.makeText(holder.contentLayout.context, category.category_id, Toast.LENGTH_SHORT)
                .show()
        })
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById<TextView>(R.id.textViewCategory)

        //   val textViewEmail = view.findViewById<TextView>(R.id.textViewEmail)
        //   val textViewCity = view.findViewById<TextView>(R.id.textViewCity)
        ///  val textViewZipcode = view.findViewById<TextView>(R.id.textViewZipcode)
        //  val textViewPhone = view.findViewById<TextView>(R.id.textViewPhone)
        //  val imageViewStudent = view.findViewById<ImageView>(R.id.imageViewStudent)
        val contentLayout: LinearLayout = view.findViewById<LinearLayout>(R.id.contentLayout)
    }
}
