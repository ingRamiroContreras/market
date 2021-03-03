package com.tul.demo.repository

import com.tul.demo.model.Cart
import com.tul.demo.model.ProductsCarts
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductsCarsRepository : CrudRepository<ProductsCarts, Long> {

    fun deleteByCartId(cart: Cart)

}