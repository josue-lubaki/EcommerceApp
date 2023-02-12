package com.renarosantos.ecommerceapp.product_list.presentation

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ProductListViewStateTest {

    private lateinit var content: ProductListViewState.Content

    @Before
    fun setUp() {
        content = ProductListViewState.Content(
            productList = (1..9).map {
                ProductCardViewState(
                    id = "id$it",
                    title = "Title $it",
                    description = "Description $it",
                    price = it.toString(),
                    imageUrl = "http://image.com/$it",
                    isFavorite = false
                )
            }
        )
    }

    @After
    fun tearDown() {
        content = ProductListViewState.Content(productList = emptyList())
    }

    @Test
    fun `when updateFavoriteProduct is called with a product id that exists in the list, then the product is updated`() {
        val updatedProductListViewState = content.updateFavoriteProduct("id1", true)
        assertTrue(updatedProductListViewState.productList.first().isFavorite)
    }

    @Test
    fun `when updateFavoriteProduct is called with a product id that does not exist in the list, then the product is not updated`() {
        val updatedProductListViewState = content.updateFavoriteProduct("id10", true)
        assertFalse(updatedProductListViewState.productList.first().isFavorite)
    }
}