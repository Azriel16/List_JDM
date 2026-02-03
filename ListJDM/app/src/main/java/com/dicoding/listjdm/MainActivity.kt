package com.dicoding.listjdm

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvJdm: RecyclerView
    private val list = ArrayList<Jdm>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvJdm = findViewById(R.id.rv_jdm)
        rvJdm.setHasFixedSize(true)

        list.addAll(getListJdm())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_profile -> {
                val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.action_list -> {
                rvJdm.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvJdm.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListJdm(): ArrayList<Jdm> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listJdm = ArrayList<Jdm>()
        for (i in dataName.indices) {
            val jdm = Jdm(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listJdm.add(jdm)
        }
        return listJdm
    }

    private fun showRecyclerList() {
        rvJdm.layoutManager = LinearLayoutManager(this)
        val listJdmAdapter = ListJdmAdapter(list)
        rvJdm.adapter = listJdmAdapter

        listJdmAdapter.setOnItemClickCallback(object : ListJdmAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Jdm) {
                showSelectedJdm(data)
            }
        })
    }

    private fun showSelectedJdm(jdm: Jdm) {
        val intent = Intent(this, ItemDetailJdm::class.java)
        intent.putExtra("selected_jdm", jdm)
        startActivity(intent)
    }
}
