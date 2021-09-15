package com.doool.cleanarchitecture.presentation.ui.api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.doool.cleanarchitecture.domain.usecase.GetAllPublicApi
import com.doool.cleanarchitecture.presentation.base.BaseViewModel
import com.doool.cleanarchitecture.presentation.mapper.EntryMapper
import com.doool.cleanarchitecture.presentation.model.EntryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApiViewModel @Inject constructor(
    private val getAllPublicApi: GetAllPublicApi,
    private val entriesMapper: EntryMapper,
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    companion object {
        const val CATEGORY_KEY = "CATEGORY_KEY"
    }

    val category: String? = savedStateHandle.get<String>(CATEGORY_KEY)

    private val _apiList: MutableLiveData<List<EntryItem>> = MutableLiveData()
    val apiList: MutableLiveData<List<EntryItem>> get() = _apiList

    init {
        loadAllApi()
    }

    private fun loadAllApi() {
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