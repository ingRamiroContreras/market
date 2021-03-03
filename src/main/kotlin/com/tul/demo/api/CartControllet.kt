package com.tul.demo.api

import com.tul.demo.model.Cart
import com.tul.demo.model.EnumCartSate
import com.tul.demo.service.CartService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CartControllet(var cartService: CartService) {

    @GetMapping("/carts/{id}")
    fun getAllProducts(@PathVariable id: Long) = cartService.findById(id)


    @PostMapping("carts/change/{id}")
    fun createCart(@PathVariable id: Long): Cart {
        try {
            var cart = cartService.findById(id)
            cart.status = EnumCartSate.COMPLETE
            cartService.addCart(cart)
            return cart
        } catch (e: Exception) {
            return Cart()
        }
    }

}