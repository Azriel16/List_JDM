package com.dicoding.listjdm

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ItemDetailJdm : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail_jdm)

        val jdm = intent.getParcelableExtra<Jdm>("selected_jdm")

        findViewById<TextView>(R.id.item_detail_title).text = jdm?.name
        findViewById<TextView>(R.id.item_detail_description).text = jdm?.description

        jdm?.photo?.let {
            findViewById<ImageView>(R.id.item_detail_image).setImageResource(it)
        }

        val btnShare: Button = findViewById(R.id.btnShare)

        btnShare.setOnClickListener {
            shareJdmContent(jdm)
        }
    }

    private fun shareJdmContent(jdm: Jdm?) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        val shareMessage = "Check out this JDM car: ${jdm?.name}\nDescription: ${jdm?.description}"
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
        startActivity(Intent.createChooser(shareIntent, "Share JDM Car"))
    }
}
