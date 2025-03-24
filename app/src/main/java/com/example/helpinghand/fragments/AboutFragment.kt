package com.example.helpinghand.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helpinghand.R
import com.example.helpinghand.adapter.RecyclerAdapter
import com.example.helpinghand.model.AboutItem

class AboutFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerAdapter
    private lateinit var aboutItems: List<AboutItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Create sample data
        aboutItems = listOf(
            AboutItem("App Name", "Helping Hand"),
            AboutItem("Version", "1.0.0"),
            AboutItem("Developer", getString(R.string.dev_name)),
            AboutItem("Features", "Profile Creation\n" +
                    "Service Categories\n" +
                    "Booking System\n" +
                    "Rating and Reviews\n" +
                    "Availability Calendar\n" +
                    "Reminders and Notifications\n" +
                    "Referral Program"),
            AboutItem("Website", "www.Helpinghand.com"),
            AboutItem("Contact", "kulveergoyat1@gmail.com")
        )

        // Set up the adapter
        adapter = RecyclerAdapter(aboutItems)
        recyclerView.adapter = adapter

        return view
    }
}
