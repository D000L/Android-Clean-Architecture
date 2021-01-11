package com.doool.cleanarchitecture.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.doool.cleanarchitecture.domain.model.Model
import com.doool.cleanarchitecture.presentation.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

abstract class BaseViewModel : ViewModel() {

    private val _error: MutableLiveData<Event<com.doool.cleanarchitecture.domain.ErrorModel>> = MutableLiveData()
    val error: LiveData<Event<com.doool.cleanarchitecture.domain.ErrorModel>> get() = _error

    protected suspend fun <M : Model> Flow<com.doool.cleanarchitecture.domain.ResultModel<M>>.collectResult(
        onSuccess: (M) -> Unit = { },
        onFail: (com.doool.cleanarchitecture.domain.ErrorModel) -> Boolean = { false }
    ) {
        collect {
            when (it) {
                is com.doool.cleanarchitecture.domain.ResultModel.Success -> {
                    onSuccess(it.data)
                }
                is com.doool.cleanarchitecture.domain.ResultModel.Fail -> {
                    val consumed = onFail(it.error)
                    if (!consumed) _error.postValue(Event(it.error))
                }
            }
        }
    }
}
