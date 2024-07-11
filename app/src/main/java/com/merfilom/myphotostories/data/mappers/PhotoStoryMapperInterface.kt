package com.merfilom.myphotostories.data.mappers

interface PhotoStoryMapperInterface<T, A> {
    fun mapFromEntity(type: T): A

    fun mapToEntity(type: A): T
}