package com.tul.demo.model

import javax.persistence.*

@Entity(name = "products")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    var name: String = "",
    var sku: String = "",
    var description: String = "",

) {


    override fun toString(): String {
        return "Product(id=$id, name='$name', sku='$sku', description='$description')"
    }
}