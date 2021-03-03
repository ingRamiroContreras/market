package com.tul.demo.service

import com.tul.demo.model.Product
import java.util.*

interface ProducService {

    fun findAllProducts(): MutableIterable<Product>

    fun findById(id: Long): Optional<Product>

}