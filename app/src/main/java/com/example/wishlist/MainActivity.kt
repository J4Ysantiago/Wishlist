package com.example.wishlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: com.example.wishlist.WishlistAdapter
    private val items = mutableListOf<WishlistItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etUrl = findViewById<EditText>(R.id.etUrl)
        val etPrice = findViewById<EditText>(R.id.etPrice)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val rvItems = findViewById<RecyclerView>(R.id.rvItems)

        adapter = WishlistAdapter(items)
        rvItems.layoutManager = LinearLayoutManager(this)
        rvItems.adapter = adapter

        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val url = etUrl.text.toString()
            val price = etPrice.text.toString()

            if (name.isNotBlank() && url.isNotBlank() && price.isNotBlank()) {
                val newItem = WishlistItem(name, price, url)
                adapter.addItem(newItem)

                etName.text?.clear()
                etUrl.text?.clear()
                etPrice.text?.clear()
            }
        }
    }
}
