package com.tul.demo.model

import javax.persistence.*

@Entity(name = "products_carts")
class ProductsCarts(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    @ManyToOne var productId: Product,
    @ManyToOne var cartId: Cart,
    var quantity: Long = 0,
)