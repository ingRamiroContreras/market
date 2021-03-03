package com.tul.demo.service

import com.tul.demo.model.Cart
import com.tul.demo.model.ProductsCarts
import com.tul.demo.repository.ProductsCarsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class ProductCartServiceImpl : ProductCartService {

    @Autowired
    lateinit var repository: ProductsCarsRepository

    override fun findAllProductsCars() = repository.findAll()

    override fun addProductCar(cart: ProductsCarts) {
        repository.save(cart)
    }

    override fun addMultipleProductsCars(carts: List<ProductsCarts>) {
        repository.saveAll(carts)
    }

    override fun getByCart(cart: Cart): List<ProductsCarts>{
       return repository.getByCartId(cart)
    }
    @Transactional
    override fun deleteByCart(cart: Cart) {
        repository.deleteByCartId(cart)
    }
}