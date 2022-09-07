package com.gustavofleck.data.mappers

interface Mapper<T, out K> {

    fun map(source: T): K
}