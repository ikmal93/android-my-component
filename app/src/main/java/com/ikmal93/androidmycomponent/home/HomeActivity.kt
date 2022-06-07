package com.ikmal93.androidmycomponent.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ikmal93.androidmycomponent.component.banner.BannerComponentActivity
import com.ikmal93.androidmycomponent.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: HomeActivityBinding
    private lateinit var homeAdapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        homeAdapter = HomeAdapter(setComponentListData()) {
            startActivity(Intent(this, BannerComponentActivity::class.java))
        }
        binding.rvComponentList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = homeAdapter
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
    }

    private fun setComponentListData(): List<String> {
        return listOf("Banner", "List")
    }
}