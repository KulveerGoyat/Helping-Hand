
package com.example.helpinghand.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helpinghand.ProfessionalDetails
import com.example.helpinghand.adapter.SliderAdapter
import com.example.helpinghand.adapter.CarditemAdapter
import com.example.helpinghand.model.CardSliderItem
import com.example.helpinghand.R
import com.example.helpinghand.model.SliderItem

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize first RecyclerView (existing one)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Create a list of SliderItem objects
        val sliderItems = listOf(
            SliderItem(R.drawable.slider_image1),
            SliderItem(R.drawable.slider_image2),
            SliderItem(R.drawable.slider_image3),
            SliderItem(R.drawable.slider_image4),
            SliderItem(R.drawable.slider_image5)
        )

        // Set up the Adapter for first RecyclerView
        recyclerView.adapter = SliderAdapter(sliderItems)

        // Initialize second RecyclerView for CardView items
        val recyclerView2: RecyclerView = view.findViewById(R.id.recyclerView1)
        recyclerView2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Create a list of CardItem objects
        val cardItems = listOf(
            CardSliderItem(R.drawable.doc, "Home Doctor"),
            CardSliderItem(R.drawable.clean,"House Cleaning"),
            CardSliderItem(R.drawable.services, "General Repairs"),
            CardSliderItem(R.drawable.electrician, "Electrical Services"),
            CardSliderItem(R.drawable.pest, "Pest Patrol"),
            )

        // Set up the Adapter for second RecyclerView
        recyclerView2.adapter = CarditemAdapter(cardItems){ item ->
            handleCardClick(item) // Handle click event
        }

        // Initialize third RecyclerView for CardView items
        val recyclerView3: RecyclerView = view.findViewById(R.id.recyclerView2)
        recyclerView3.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Create a list of CardItem objects
        val cardItems2 = listOf(
            CardSliderItem(R.drawable.plumber, "Plumbing Services"),
            CardSliderItem(R.drawable.garden, "Garden Gurus"),
            CardSliderItem(R.drawable.paint, "Painting Services"),
            CardSliderItem(R.drawable.ac, "AC Experts"),
            CardSliderItem(R.drawable.move, "Mover Mate"),
            )

        // Set up the Adapter for second RecyclerView
        recyclerView3.adapter = CarditemAdapter(cardItems2){ item ->
            handleCardClick(item) // Handle click event
        }

        return view


    }
  private fun handleCardClick(item: CardSliderItem) {
      val intent = Intent(requireContext(), ProfessionalDetails::class.java)
      intent.putExtra("imageResId", item.imageResId)
      intent. putExtra("title", item.title)
      startActivity(intent)
    }
}
