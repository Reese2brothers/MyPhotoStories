package com.merfilom.myphotostories.data.mappers

interface PhotoMapperInterface<E, D> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E
}