package com.doool.cleanarchitecture.ui.mapper

import com.doool.cleanarchitecture.domain.model.Model
import com.doool.cleanarchitecture.ui.model.Item

abstract class ItemMapper<M : Model, I : Item> {
    abstract fun mapToModel(item: I): M
    abstract fun mapToItem(model: M): I
}