package com.tul.demo.service

import com.tul.demo.model.Cart
import com.tul.demo.repository.CartRepository
import com.tul.demo.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CartService {

    @Autowired
    lateinit var repository: CartRepository

    fun addCart(cart: Cart): Cart {
        return repository.save(cart)
    }
}