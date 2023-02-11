package com.renarosantos.ecommerceapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.renarosantos.ecommerceapp.databinding.FragmentProductDetailsBinding
import com.renarosantos.ecommerceapp.ui.ProductCardViewState


class ProductDetailsFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailsBinding

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

        // get the product from the arguments via Serializable
        val product = arguments?.getSerializable("product") as ProductCardViewState

        with(binding){
            viewProductTitle.text = product.title
            Glide.with(requireContext()).load(product.imageUrl).into(viewProductImage)
            binding.viewPrice.text = product.price
            binding.viewFullDescription.text = product.description
        }
    }
}