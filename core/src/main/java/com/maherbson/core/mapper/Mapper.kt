package com.maherbson.core.mapper

interface Mapper<S, T> {
    fun map(source: S): T
}
