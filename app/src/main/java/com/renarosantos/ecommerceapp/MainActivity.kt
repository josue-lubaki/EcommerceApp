package com.renarosantos.ecommerceapp

import android.os.Bundle
import android.view.View
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.renarosantos.ecommerceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter = ProductCardListAdapter()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.viewProductList
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        updateUI(ProductListViewState.Content((1..5).map {
            ProductCardViewState("Playstation $it", "This is a nice console! Check it out", "${200 * it} US$")
        }))
//        updateUI(ProductListViewState.Loading)
//        updateUI(ProductListViewState.Error("Something went wrong"))
    }

    private fun updateUI(viewState : ProductListViewState) {
        when(viewState){
            is ProductListViewState.Content -> {
                binding.errorView.isVisible = false
                binding.errorText.isVisible = false
                binding.loadingView.isVisible = false
                adapter.setData(viewState.productList)
            }
            is ProductListViewState.Error -> {
                binding.viewProductList.isVisible = false
                binding.errorView.isVisible = true
                binding.loadingView.isVisible = false
                binding.errorText.isVisible = true
                binding.errorText.text = viewState.message
            }
            ProductListViewState.Loading -> {
                binding.viewProductList.isVisible = false
                binding.errorView.isVisible = false
                binding.errorText.isVisible = false
                binding.loadingView.isVisible = true
            }
        }
    }
}