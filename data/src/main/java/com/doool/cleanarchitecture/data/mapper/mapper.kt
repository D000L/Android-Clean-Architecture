package com.doool.cleanarchitecture.data.mapper

import com.doool.cleanarchitecture.data.model.Entity
import com.doool.cleanarchitecture.domain.model.Model

internal interface EntityMapper<EM : Entity, M : Model> {
    fun mapToModel(entity: EM): M
}

internal interface ModelMapper<M : Model, EM : Entity> {
    fun mapToEntity(model: M): EM
}
