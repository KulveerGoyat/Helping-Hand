package com.example.helpinghand.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helpinghand.R
import com.example.helpinghand.adapter.SettingAdapter
import com.example.helpinghand.model.SettingItem

class SettingsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var settingsAdapter: SettingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        recyclerView = view.findViewById(R.id.recycler_view2)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Populate settings list
        val settingsList = listOf(
            SettingItem("Notifications", "Enable push notifications", true),
            SettingItem("Location", "Use location services", false),
            SettingItem("Data ", "Control your data ON/OFF", true),
            SettingItem("Dark Mode", "Switch to dark theme", false),
            SettingItem("Account Privacy", "Manage your account privacy settings", false),
            SettingItem("Language", "Select your preferred language", false),
            SettingItem("Feedback", "Send your feedback to us", false),
            SettingItem("About App", "Learn more about this app", false),
            SettingItem("App Updates", "Check for app updates", true)
        )

        // Set up the adapter
        settingsAdapter = SettingAdapter(settingsList)
        recyclerView.adapter = settingsAdapter

        return view
    }
}
