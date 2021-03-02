package com.tul.demo.api

import com.tul.demo.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController {

    @Autowired
    lateinit var service: ProductService

    @GetMapping("/products")
    fun getAllUsers() = service.findAllProducts()

}