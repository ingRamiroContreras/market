package com.tul.demo.api

import com.tul.demo.service.ProductServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController {

    @Autowired
    lateinit var serviceImpl: ProductServiceImpl

    @GetMapping("/products")
    fun getAllUsers() = serviceImpl.findAllProducts()

}