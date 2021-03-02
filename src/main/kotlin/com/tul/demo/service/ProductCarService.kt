package com.tul.demo.service

import com.tul.demo.model.Cart
import com.tul.demo.model.ProductsCarts
import com.tul.demo.repository.CartRepository
import com.tul.demo.repository.ProductsCarsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductCarService {

    @Autowired
    lateinit var repository: ProductsCarsRepository

    fun findAllProductsCars() = repository.findAll()

    fun addProductCar(cart: ProductsCarts) {
        repository.save(cart)
    }
}