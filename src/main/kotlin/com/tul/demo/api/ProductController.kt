package com.tul.demo.api

import com.tul.demo.service.ProductServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(var serviceImpl: ProductServiceImpl) {


    @GetMapping("/products")
    fun getAllProducts() = serviceImpl.findAllProducts()

}