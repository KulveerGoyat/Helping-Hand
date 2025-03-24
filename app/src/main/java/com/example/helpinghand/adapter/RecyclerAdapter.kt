package com.example.helpinghand.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.helpinghand.R
import com.example.helpinghand.model.AboutItem

class RecyclerAdapter(private val aboutItems: List<AboutItem>) : RecyclerView.Adapter<RecyclerAdapter.AboutViewHolder>() {

    class AboutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.item_title)
        val description: TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_about, parent, false)
        return AboutViewHolder(view)
    }

    override fun onBindViewHolder(holder: AboutViewHolder, position: Int) {
        val item = aboutItems[position]
        holder.title.text = item.title
        holder.description.text = item.description

    }

    override fun getItemCount(): Int = aboutItems.size
}
