package com.doool.cleanarchitecture.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.doool.cleanarchitecture.domain.usecase.CheckServerStatus
import com.doool.cleanarchitecture.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
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