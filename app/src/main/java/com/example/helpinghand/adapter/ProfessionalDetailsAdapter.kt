package com.example.helpinghand.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.helpinghand.R
import com.example.helpinghand.model.ProfessionItem
import com.google.android.material.snackbar.Snackbar

class ProfessionalDetailsAdapter(
    private val professionals: List<ProfessionItem>,
    private val context: Context
) : RecyclerView.Adapter<ProfessionalDetailsAdapter.ProfessionalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessionalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_professional_detail, parent, false)
        return ProfessionalViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfessionalViewHolder, position: Int) {
        val professional = professionals[position]
        holder.bind(professional)
    }

    override fun getItemCount(): Int = professionals.size

    inner class ProfessionalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImage: ImageView = itemView.findViewById(R.id.professional_image)
        private val itemName: TextView = itemView.findViewById(R.id.professional_name)
        private val itemDescription: TextView = itemView.findViewById(R.id.professional_description)
        private val itemPhone: TextView = itemView.findViewById(R.id.professional_phone)
        private val itemEmail: TextView = itemView.findViewById(R.id.professional_email)
        private val buttonCall: Button = itemView.findViewById(R.id.button_call)
        private val buttonbook: Button = itemView.findViewById(R.id.button_schedule)

        fun bind(professional: ProfessionItem) {
            itemImage.setImageResource(professional.imageResId)
            itemName.text = professional.title
            itemDescription.text = professional.description
            itemPhone.text = professional.phone
            itemEmail.text = professional.email

            // Call button functionality
            buttonCall.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:${"1234567890"}")
                context.startActivity(intent)
            }
            buttonbook.setOnClickListener { view ->
                Snackbar.make(view, "Booking done! Thanks", Snackbar.LENGTH_SHORT).show()
            }

        }
    }
}
