package com.tul.demo.api

import com.tul.demo.model.Cart
import com.tul.demo.model.EnumCartSate
import com.tul.demo.model.ProductWithQuantity
import com.tul.demo.model.ProductsCarts
import com.tul.demo.service.CartService
import com.tul.demo.service.ProductCartService
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
class ProductCarController(
    var cartService: CartService,
    var productCarsService: ProductCartService
) {


    @GetMapping("/products/carts")
    fun getAllUsers() = productCarsService.findAllProductsCars()


    @PostMapping("cart/{cartName}")
    fun createCart(@PathVariable cartName: String, @RequestBody products: List<ProductWithQuantity>) {

        var cart = cartService.addCart(Cart(0, cartName, EnumCartSate.NEW))
        insertProductsCarts(products, cart)

    }



    @PutMapping("products/carts/{cartId}")
    fun updateCart(@PathVariable cartId: Long, @RequestBody products: List<ProductWithQuantity>){

        var cart = cartService.findById(cartId)
        productCarsService.deleteByCart(cart)
        insertProductsCarts(products, cart)

    }

    private fun insertProductsCarts(
        products: List<ProductWithQuantity>,
        cart: Cart
    ) {
        var productsCartsToSave = products.stream()
            .map { p -> ProductsCarts(0, p.product, cart, p.quantity) }
            .collect(Collectors.toList())

        productCarsService.addMultipleProductsCars(productsCartsToSave)
    }




}