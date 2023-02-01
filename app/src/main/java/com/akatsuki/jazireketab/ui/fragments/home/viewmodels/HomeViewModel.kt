package com.akatsuki.jazireketab.ui.fragments.home.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akatsuki.jazireketab.data.remote.Resource
import com.akatsuki.jazireketab.data.remote.repository.repository
import com.akatsuki.jazireketab.models.TopCatModel
import com.akatsuki.jazireketab.models.test.TestModel
import com.akatsuki.jazireketab.models.toplistsone.TopListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: repository): ViewModel(){

    val response = MutableLiveData<TestModel>()
    val isLoading = MutableLiveData<Boolean>()


    init {
        requests()
    }
    fun requests() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = repo.test()

            if (result is Resource.Success) {
                response.postValue(result.data!!)
                isLoading.postValue(false)
            }
        }
    }









}