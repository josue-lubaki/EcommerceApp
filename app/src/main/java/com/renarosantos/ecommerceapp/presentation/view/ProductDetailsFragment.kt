package com.renarosantos.ecommerceapp.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.renarosantos.ecommerceapp.databinding.FragmentProductDetailsBinding
import com.renarosantos.ecommerceapp.presentation.ProductDetailsViewModel
import com.renarosantos.ecommerceapp.presentation.viewstate.ProductDetailsViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailsBinding
    private val viewModel: ProductDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // get String from bundle
        val productId = arguments?.getString("productId")

        // load product by id
        viewModel.loadProductDetailsById(productId!!)
        viewModel.viewState.observe(viewLifecycleOwner) { viewState ->
            updateUI(viewState)
        }
    }

    private fun updateUI(viewState: ProductDetailsViewState?) {
        when (viewState) {
            is ProductDetailsViewState.Content -> {
                with(binding){
                    binding.loadingView.isVisible = false
                    val product = viewState.product
                    viewProductTitle.text = product.title
                    Glide.with(requireContext()).load(product.imageUrl).into(viewProductImage)
                    "${product.price.toInt()} CAD".also { binding.viewPrice.text = it }
                    binding.viewShortDescription.text = product.description
                    binding.viewFullDescription.text = product.fullDescription
                }
            }
            ProductDetailsViewState.Loading -> {
                binding.loadingView.isVisible = true
            }
            else -> {
                binding.loadingView.isVisible = false
            }
        }
    }
}