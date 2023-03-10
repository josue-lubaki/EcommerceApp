package com.renarosantos.ecommerceapp.product_list.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.renarosantos.ecommerceapp.R
import com.renarosantos.ecommerceapp.databinding.ProductListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {
    private lateinit var binding: ProductListFragmentBinding
    private val viewModel: ProductListViewModel by viewModels()
    private val adapter = ProductCardListAdapter(::onItemClicked, ::onFavoriteIconClicked)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProductListFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewProductList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.viewProductList.adapter = adapter
        viewModel.viewState.observe(viewLifecycleOwner) { viewState ->
            updateUI(viewState)
        }
    }

    private fun updateUI(viewState: ProductListViewState) {
        when (viewState) {
            is ProductListViewState.Content -> {
                binding.viewProductList.isVisible = true
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
            is ProductListViewState.Loading -> {
                binding.viewProductList.isVisible = false
                binding.errorView.isVisible = false
                binding.errorText.isVisible = false
                binding.loadingView.isVisible = true
            }
        }
    }

    // parameter just to show how to retrieve data from Adapter to the fragment
    private fun onItemClicked(viewState: ProductCardViewState) {
        // pass the product to the details fragment
        val bundle = bundleOf("productId" to viewState.id)
        findNavController().navigate(R.id.action_productListFragment_to_productDetailsFragment, bundle)
    }

    private fun onFavoriteIconClicked(viewState: ProductCardViewState){
        viewModel.favoriteIconClicked(viewState.id)
    }
}
