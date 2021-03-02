package com.tul.demo.model

import javax.persistence.*

@Entity(name = "carts")
class Cart(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    var status: String = "",
){

    override fun toString(): String {
        return "Cart(id=$id, status='$status')"
    }
}