package com.doool.cleanarchitecture.data.mapper

import com.doool.cleanarchitecture.data.model.Entity
import com.doool.cleanarchitecture.domain.model.Model

abstract class EntityMapper<M : Model, EM : Entity> {
    abstract fun mapToModel(entity: EM): M
    abstract fun mapToEntity(model: M): EM
}