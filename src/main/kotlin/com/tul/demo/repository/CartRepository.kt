package com.tul.demo.repository

import com.tul.demo.model.Cart
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CartRepository : CrudRepository<Cart, Long> {


}