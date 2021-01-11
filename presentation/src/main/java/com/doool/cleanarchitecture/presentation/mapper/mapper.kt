package com.doool.cleanarchitecture.presentation.mapper

import com.doool.cleanarchitecture.domain.model.Model
import com.doool.cleanarchitecture.presentation.model.Item

interface ItemMapper<I : Item, M : Model> {
    abstract fun mapToModel(item: I): M
}

interface ModelMapper<M : Model, I : Item> {
    abstract fun mapToItem(model: M): I
}