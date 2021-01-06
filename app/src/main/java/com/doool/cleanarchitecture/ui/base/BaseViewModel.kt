package com.doool.cleanarchitecture.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.doool.cleanarchitecture.domain.ErrorModel
import com.doool.cleanarchitecture.domain.Result
import com.doool.cleanarchitecture.domain.model.Model
import com.doool.cleanarchitecture.ui.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

abstract class BaseViewModel : ViewModel() {

    private val _error: MutableLiveData<Event<ErrorModel>> = MutableLiveData()
    val error: LiveData<Event<ErrorModel>> get() = _error

    protected suspend fun <M : Model> Flow<Result<M>>.collectResult(
        onSuccess: (M) -> Unit = { },
        onFail: (ErrorModel) -> Boolean = { false }
    ) {
        collect {
            when (it) {
                is Result.Success -> {
                    onSuccess(it.data)
                }
                is Result.Fail -> {
                    val consumed = onFail(it.error)
                    if (!consumed) _error.postValue(Event(it.error))
                }
            }
        }
    }
}
