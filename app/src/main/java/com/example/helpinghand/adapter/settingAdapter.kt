package com.example.helpinghand.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.helpinghand.R
import com.example.helpinghand.model.SettingItem

class SettingAdapter(private val settingsList: List<SettingItem>) :
    RecyclerView.Adapter<SettingAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.setting_title)
        val description: TextView = itemView.findViewById(R.id.setting_description)
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        val switch: Switch = itemView.findViewById(R.id.setting_switch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_setting, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val setting = settingsList[position]
        holder.title.text = setting.title
        holder.description.text = setting.description
        holder.switch.isChecked = setting.isEnabled

        // Optionally handle switch changes
        holder.switch.setOnCheckedChangeListener { _, _ ->
            // Update your model or handle state change
        }
    }

    override fun getItemCount(): Int = settingsList.size
}
