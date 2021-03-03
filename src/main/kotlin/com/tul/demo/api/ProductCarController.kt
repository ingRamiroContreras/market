package com.tul.demo.api

import com.tul.demo.model.Cart
import com.tul.demo.model.EnumCartSate
import com.tul.demo.model.ProductWithQuantity
import com.tul.demo.model.ProductsCarts
import com.tul.demo.service.CartService
import com.tul.demo.service.ProductCartService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.stream.Collectors

@RestController
class ProductCarController(
    var cartService: CartService,
    var productCarsService: ProductCartService
) {


    @GetMapping("/products/carts")
    fun getAllProductsCars() = productCarsService.findAllProductsCars()


    @GetMapping("/products/carts/{id}")
    fun getCartById(@PathVariable id: Long): Map<Cart, List<ProductWithQuantity>> {

        try {
            var cart = cartService.findById(id)
            var productsCarsList = productCarsService.getByCart(cart)

            isValidProductsCarsList(productsCarsList)
            return productsCarsList.groupBy(
                keySelector = { e -> e.cartId },
                valueTransform = { e -> ProductWithQuantity(e.productId, e.quantity) })
        } catch (e: Exception) {
            return mapOf()
        }
    }

    private fun isValidProductsCarsList(productsCarsList: List<ProductsCarts>) {
        if (productsCarsList.isEmpty()) return throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            " NOT FOUND CART"
        )
    }

    @DeleteMapping("/products/carts/{id}")
    fun deleteCartById(@PathVariable id: Long) {
        var cart = cartService.findById(id)
        productCarsService.deleteByCart(cart)
    }

    @PostMapping("cart/{cartName}")
    fun createCart(@PathVariable cartName: String, @RequestBody products: List<ProductWithQuantity>): Cart {

        var cart = cartService.addCart(Cart(0, cartName, EnumCartSate.NEW))
        insertProductsCarts(products, cart)
        return cart

    }


    @PutMapping("products/carts/{cartId}")
    fun updateCart(@PathVariable cartId: Long, @RequestBody products: List<ProductWithQuantity>) {

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