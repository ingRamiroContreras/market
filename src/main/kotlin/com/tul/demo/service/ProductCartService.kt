package com.tul.demo.service

import com.tul.demo.model.Cart
import com.tul.demo.model.ProductsCarts

interface ProductCartService {

    fun findAllProductsCars(): MutableIterable<ProductsCarts>

    fun addProductCar(cart: ProductsCarts)

    fun addMultipleProductsCars(carts: List<ProductsCarts>)

    fun deleteByCart(cart: Cart)
}