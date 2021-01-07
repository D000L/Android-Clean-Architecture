package com.doool.cleanarchitecture.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.doool.cleanarchitecture.domain.Result
import com.doool.cleanarchitecture.domain.usecase.CheckServerStatus
import com.doool.cleanarchitecture.domain.usecase.GetAllCategory
import com.doool.cleanarchitecture.domain.usecase.GetAllPublicApi
import com.doool.cleanarchitecture.ui.base.BaseViewModel
import com.doool.cleanarchitecture.ui.mapper.EntryMapper
import com.doool.cleanarchitecture.ui.model.EntryItem
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val getAllCategory: GetAllCategory,
    private val getAllPublicApi: GetAllPublicApi,
    private val entriesMapper: EntryMapper
) : BaseViewModel() {

    private val _categoryList: MutableLiveData<List<String>> = MutableLiveData()
    val categoryList: MutableLiveData<List<String>> get() = _categoryList

    private val _apiList: MutableLiveData<List<EntryItem>> = MutableLiveData()
    val apiList: MutableLiveData<List<EntryItem>> get() = _apiList

    fun loadCategory(){
        viewModelScope.launch {
            getAllCategory(GetAllCategory.Params(GetAllCategory.Sort.ASC)).collect {
                when(it){
                    is Result.Success -> {
                        _categoryList.postValue(it.data)
                    }
                    is Result.Fail -> {

                    }
                }
            }
        }
    }

    fun loadAllApi() {
        viewModelScope.launch {
            getAllPublicApi(GetAllPublicApi.Params()).collectResult(
                onSuccess = {
                    _apiList.postValue(it.entries.map { entriesMapper.mapToItem(it) })
                },
                onFail = {
                    return@collectResult true
                })
        }
    }
}