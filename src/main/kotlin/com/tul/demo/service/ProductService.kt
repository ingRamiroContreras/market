package com.tul.demo.service

import com.tul.demo.model.Product
import com.tul.demo.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService {

    @Autowired
    lateinit var repository: ProductRepository

    fun findAllProducts() = repository.findAll()

    fun findById(id: Long): Optional<Product> {
        return repository.findById(id)
    }

}