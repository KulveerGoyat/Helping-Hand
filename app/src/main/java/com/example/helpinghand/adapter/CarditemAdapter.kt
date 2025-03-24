package com.example.helpinghand.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.helpinghand.model.CardSliderItem
import com.example.helpinghand.R

// Adapter class for recyclerView2
class CarditemAdapter(private val cardItems: List<CardSliderItem>, private val itemClickListener: (CardSliderItem) -> Unit) : RecyclerView.Adapter<CarditemAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currentItem = cardItems[position]
        holder.itemImage.setImageResource(currentItem.imageResId)
        holder.itemTitle.text = currentItem.title
        holder.itemView.setOnClickListener {
            itemClickListener(currentItem) // Trigger the click listener
        }
    }

    override fun getItemCount(): Int = cardItems.size

    // ViewHolder class to bind the views
    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.item_image)
        val itemTitle: TextView = itemView.findViewById(R.id.item_title)
    }
}