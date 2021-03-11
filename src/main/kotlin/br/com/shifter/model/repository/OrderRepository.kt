package br.com.shifter.model.repository

import javax.inject.Singleton

@Singleton
class OrderRepository {

    fun findOrders(table: String): List<String> {
        return listOf("a", "b")
    }
}