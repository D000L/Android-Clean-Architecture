package com.doool.cleanarchitecture.presentation.ui.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.doool.cleanarchitecture.domain.ResultModel
import com.doool.cleanarchitecture.domain.usecase.GetAllCategory
import com.doool.cleanarchitecture.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getAllCategory: GetAllCategory
) : BaseViewModel() {

    private val _categoryList: MutableLiveData<List<String>> = MutableLiveData()
    val categoryList: MutableLiveData<List<String>> get() = _categoryList


    init {
        loadCategory()
    }

    private fun loadCategory() {
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
}