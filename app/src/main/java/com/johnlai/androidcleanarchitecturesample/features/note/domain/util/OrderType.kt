package com.johnlai.androidcleanarchitecturesample.features.note.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
