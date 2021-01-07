package com.doool.cleanarchitecture.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.doool.cleanarchitecture.domain.usecase.CheckServerStatus
import com.doool.cleanarchitecture.domain.usecase.GetAllPublicApi
import com.doool.cleanarchitecture.ui.base.BaseViewModel
import com.doool.cleanarchitecture.ui.mapper.EntriesMapper
import com.doool.cleanarchitecture.ui.mapper.EntryMapper
import com.doool.cleanarchitecture.ui.mapper.ServerStatusMapper
import com.doool.cleanarchitecture.ui.model.EntryItem
import com.doool.cleanarchitecture.ui.model.ServerStatusItem
import kotlinx.coroutines.launch

class StartViewModel @ViewModelInject constructor(
    private val checkServerStatus: CheckServerStatus
) : BaseViewModel() {

    private val _serverOn: MutableLiveData<Boolean> = MutableLiveData()
    val serverOn: LiveData<Boolean> get() = _serverOn

    fun checkServerOn() {
        viewModelScope.launch {
            checkServerStatus().collectResult(onSuccess = {
                _serverOn.postValue(it.alive)
            }, onFail = {
                _serverOn.postValue(false)
                return@collectResult true
            })
        }
    }
}