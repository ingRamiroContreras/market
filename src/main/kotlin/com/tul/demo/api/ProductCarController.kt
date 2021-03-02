package com.tul.demo.api

import com.tul.demo.model.Cart
import com.tul.demo.model.ProductWithQuantity
import com.tul.demo.model.ProductsCarts
import com.tul.demo.service.CartService
import com.tul.demo.service.ProductCarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ProductCarController {


    @Autowired
    lateinit var cartService: CartService

    @Autowired
    lateinit var productCarsService: ProductCarService

    @GetMapping("/products/carts")
    fun getAllUsers() = productCarsService.findAllProductsCars()


    @PostMapping("cart/{cartName}")
    fun createCart(@PathVariable cartName: String, @RequestBody products: List<ProductWithQuantity>) {

        var cart = cartService.addCart(Cart(0, cartName))

        for (product in products) {
            var productCart =
                productCarsService.addProductCar(ProductsCarts(0, product.product, cart, product.quantity))
        }


    }


}