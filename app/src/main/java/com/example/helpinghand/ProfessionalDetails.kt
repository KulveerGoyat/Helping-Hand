package com.example.helpinghand

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helpinghand.adapter.ProfessionalDetailsAdapter
import com.example.helpinghand.model.ProfessionItem

class ProfessionalDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_professional_details)

        // Retrieve the imageResId from the intent
        val imageResId = intent.getIntExtra("imageResId", 0)

        // Create a list of professionals. You can expand this list based on imageResId if needed.
        val doctor = listOf(
            ProfessionItem(R.drawable.doc, "Home Doctor", "Home doctor services offer convenient and personalized healthcare right at your doorstep. These services are ideal for patients who prefer receiving medical attention in the comfort of their homes. Our qualified doctors provide a range of services, including routine check-ups, chronic disease management, vaccinations, and minor treatments. They come equipped with essential medical tools to perform examinations and provide immediate care. This service is especially beneficial for the elderly, disabled, or those recovering from surgery, ensuring they receive timely medical attention without the hassle of traveling. Trust our home doctor services for compassionate and professional healthcare tailored to your needs.", "Phone: 1234567890", "Email: doctor@helpinghand.com")
        )
        val clean = listOf(
            ProfessionItem(R.drawable.clean, "House Cleaning", "House Cleaning services are dedicated to creating a clean and healthy living environment for you and your family. Our professional cleaning team is trained to tackle every corner of your home, using eco-friendly products that are safe for children and pets. We offer customizable cleaning packages, from routine maintenance to deep cleaning, ensuring your space is spotless and inviting. Whether you need a one-time service or regular cleaning, we work around your schedule to deliver exceptional results. Experience the joy of a clean home without the hassle—let our House Cleaning experts handle it for you.", "Phone: 1234567890", "Email: housecleaning@helpinghand.com")
        )
        val repair = listOf(
            ProfessionItem(R.drawable.services, "General Repairs", "General Repairs provide essential services to maintain and enhance the functionality of your home or business. Our skilled technicians are experienced in a variety of repair tasks, from fixing drywall and plumbing issues to electrical work and appliance repair. We understand that small problems can quickly escalate, which is why we offer prompt and reliable service to address your needs. With a focus on quality craftsmanship and customer satisfaction, we ensure every job is completed to the highest standards. Trust General Repairs to keep your property in excellent condition and prolong its lifespan.", "Phone: 1234567890", "Email: geberalrepairs@helpinghand.com")
        )
        val electrician = listOf(
            ProfessionItem(R.drawable.electrician, "Electrical Services", "Electrical Services are crucial for ensuring the safety and efficiency of your home’s electrical systems. Our licensed electricians provide a range of services, including installation, repair, and maintenance of wiring, lighting, and electrical panels. Whether you need new outlets, ceiling fans, or troubleshooting for electrical issues, our team is equipped to handle it all. We prioritize safety and adhere to all regulations, providing peace of mind with every job. With a commitment to quality and customer satisfaction, our Electrical Services ensure your home remains well-lit and safe for you and your family.", "Phone: 1234567890", "Email: electricalservices@helpinghand.com")
        )
        val pest = listOf(
            ProfessionItem(R.drawable.pest, "Pest Patrol", "Pest Patrol offers effective pest control solutions to protect your home and business from unwanted invaders. Our experienced technicians use safe and environmentally friendly methods to eliminate pests, including rodents, insects, and other nuisances. We conduct thorough inspections to identify infestations and develop tailored treatment plans to address your specific needs. Our proactive approach includes preventive measures to ensure pests don’t return. With Pest Patrol, you can rest easy knowing your property is safeguarded against pests. Trust us for quick, reliable service that prioritizes your health and comfort.", "Phone: 1234567890", "Email: pestpatrol@helpinghand.com")
        )
        val gardener = listOf(
            ProfessionItem(R.drawable.garden, "Garden Gurus", "Garden Gurus specialize in transforming outdoor spaces into beautiful, thriving gardens. Our team of horticulturists and landscape designers is dedicated to creating personalized garden designs that suit your style and needs. We offer a range of services, including planting, landscaping, and garden maintenance, ensuring your garden flourishes throughout the seasons. With expert knowledge of local flora and sustainable practices, we can enhance the beauty and health of your outdoor spaces. Whether you’re looking for a cozy vegetable garden or an elaborate flower bed, trust our Garden Gurus to bring your vision to life.", "Phone: 1234567890", "Email: gardengurus@helpinghand.com")
        )
        val paint = listOf(
            ProfessionItem(R.drawable.paint, "Painting Services", "Painting Services provide high-quality interior and exterior painting solutions to enhance the beauty and value of your property. Our skilled painters use premium materials and techniques to ensure a flawless finish and long-lasting durability. We offer a wide range of colors and styles, allowing you to customize your space to reflect your personal taste. Whether it’s a single room or an entire home, we handle every project with meticulous attention to detail. Our team is committed to cleanliness and professionalism, ensuring minimal disruption to your daily life while delivering stunning results you’ll love.", "Phone: 1234567890", "Email: paintingservices@helpinghand.com")
        )
        val plumber = listOf(
            ProfessionItem(R.drawable.plumber, "Plumbing Services", "Plumbing Services provide essential support for all your water system needs. Whether it’s fixing a leaky faucet, unclogging drains, or installing new fixtures, our skilled plumbers ensure efficient and reliable service. We specialize in both residential and commercial plumbing, using the latest techniques and tools to resolve issues promptly. Our commitment to quality means you’ll receive thorough inspections and maintenance recommendations to prevent future problems. From routine repairs to emergency services, our experienced plumbers are just a call away, ready to restore functionality and peace of mind to your home or business.", "Phone: 1234567890", "Email: plumbingservices@helpinghand.com")
        )
        val ac = listOf(
            ProfessionItem(R.drawable.ac, "AC Experts", "AC Experts are your go-to professionals for all air conditioning needs. From installation to repair and maintenance, we ensure your home remains comfortable year-round. Our certified technicians are experienced in various AC systems, offering tailored solutions to fit your specific requirements. We prioritize energy efficiency, helping you save on utility bills while keeping your space cool. Our maintenance services extend the lifespan of your unit, preventing breakdowns during peak seasons. Whether you need a quick fix or a complete system overhaul, trust our AC Experts for reliable service and unparalleled customer satisfaction.\n" +
                    "\n", "Phone: 1234567890", "Email: acexperts@helpinghand.com")
        )
        val move = listOf(
            ProfessionItem(R.drawable.move, "Mover Mate", "Mover Mate offers comprehensive moving services designed to make your relocation as smooth and stress-free as possible. Our experienced team handles every aspect of your move, from packing and loading to transportation and unpacking. We understand that moving can be overwhelming, which is why we provide customized solutions to fit your specific needs, whether it’s a local move or a long-distance journey. Our professional movers are trained to handle your belongings with care, ensuring everything arrives safely at your new home. With Mover Mate, you can focus on settling in while we take care of the logistics.", "Phone: 1234567890", "Email: movermate@helpinghand.com")
        )

        // Initialize the RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_professional_details)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Use when to handle different cases based on imageResId
        when (imageResId) {
            R.drawable.doc -> {
                // Set the adapter for Home Doctor
                recyclerView.adapter = ProfessionalDetailsAdapter(doctor, this)
            }
            R.drawable.clean-> {
                // Set the adapter for Home Doctor
                recyclerView.adapter = ProfessionalDetailsAdapter(clean, this)
            }
            R.drawable.services -> {
                // Set the adapter for Home Doctor
                recyclerView.adapter = ProfessionalDetailsAdapter(repair, this)
            }
            R.drawable.pest -> {
                // Set the adapter for Home Doctor
                recyclerView.adapter = ProfessionalDetailsAdapter(pest, this)
            }
            R.drawable.electrician-> {
                // Set the adapter for Home Doctor
                recyclerView.adapter = ProfessionalDetailsAdapter(electrician, this)
            }
            R.drawable.garden -> {
                // Set the adapter for Home Doctor
                recyclerView.adapter = ProfessionalDetailsAdapter(gardener, this)
            }
            R.drawable.plumber -> {
                // Set the adapter for Home Doctor
                recyclerView.adapter = ProfessionalDetailsAdapter(plumber, this)
            }
            R.drawable.paint -> {
                // Set the adapter for Home Doctor
                recyclerView.adapter = ProfessionalDetailsAdapter(paint, this)
            }
            R.drawable.move-> {
                // Set the adapter for Home Doctor
                recyclerView.adapter = ProfessionalDetailsAdapter(move, this)
            }
            R.drawable.ac-> {
                // Set the adapter for Home Doctor
                recyclerView.adapter = ProfessionalDetailsAdapter(ac, this)
            }
            R.drawable.pest -> {
                // Set the adapter for Home Doctor
                recyclerView.adapter = ProfessionalDetailsAdapter(pest, this)
            }

            else -> {
                // Handle the default case if needed
                println("No matching professional found.")
            }
        }
    }
}
