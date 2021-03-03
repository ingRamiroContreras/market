package com.tul.demo.service

import com.tul.demo.model.Product
import com.tul.demo.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl : ProducService {

    @Autowired
    lateinit var repository: ProductRepository

    override fun findAllProducts() = repository.findAll()

    override fun findById(id: Long): Optional<Product> {
        return repository.findById(id)
    }

}