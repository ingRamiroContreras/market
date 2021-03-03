package com.tul.demo.service

import com.tul.demo.model.Cart

interface CartService {

    fun addCart(cart: Cart): Cart

    fun findById(id: Long): Cart

}