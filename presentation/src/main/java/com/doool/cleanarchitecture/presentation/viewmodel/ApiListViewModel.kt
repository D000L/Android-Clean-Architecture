package com.doool.cleanarchitecture.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.doool.cleanarchitecture.domain.ResultModel
import com.doool.cleanarchitecture.domain.usecase.GetAllCategory
import com.doool.cleanarchitecture.domain.usecase.GetAllPublicApi
import com.doool.cleanarchitecture.presentation.base.BaseViewModel
import com.doool.cleanarchitecture.presentation.mapper.EntryMapper
import com.doool.cleanarchitecture.presentation.model.EntryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApiListViewModel @Inject constructor(
    private val getAllCategory: GetAllCategory,
    private val getAllPublicApi: GetAllPublicApi,
    private val entriesMapper: EntryMapper
) : BaseViewModel() {

    private val _categoryList: MutableLiveData<List<String>> = MutableLiveData()
    val categoryList: MutableLiveData<List<String>> get() = _categoryList

    private val _apiList: MutableLiveData<List<EntryItem>> = MutableLiveData()
    val apiList: MutableLiveData<List<EntryItem>> get() = _apiList

    private var category: String? = null

    fun setCategory(category: String?) {
        this.category = category
        loadAllApi()
    }

    fun loadCategory() {
        viewModelScope.launch {
            getAllCategory(GetAllCategory.Params(GetAllCategory.Sort.ASC)).collect {
                when (it) {
                    is ResultModel.Success -> {
                        _categoryList.postValue(listOf("All") + it.data)
                    }
                    is ResultModel.Fail -> {

                    }
                }
            }
        }
    }

    fun loadAllApi() {
        viewModelScope.launch {
            getAllPublicApi(GetAllPublicApi.Params(category = category)).collectResult(
                onSuccess = {
                    _apiList.postValue(it.entries.map { entriesMapper.mapToItem(it) })
                },
                onFail = {
                    return@collectResult true
                })
        }
    }
}