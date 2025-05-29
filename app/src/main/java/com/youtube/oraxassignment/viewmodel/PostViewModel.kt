package com.youtube.oraxtechassignment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youtube.oraxtechassignment.model.PostModel
import com.youtube.oraxtechassignment.retrofit.RetrofitHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PostViewModel:ViewModel() {
    private val _post= MutableLiveData<List<PostModel>>()
    val post:LiveData<List<PostModel>> get() = _post
    private val _error=MutableLiveData<String>()
    val error:LiveData<String> get() = _error
    private val _loading=MutableLiveData<Boolean>()
    val loading:LiveData<Boolean> get() = _loading
    fun getPost(){
        _loading.value=true
        viewModelScope.launch {
           try {
               val response=RetrofitHelper.apiService.getPost()
               _post.value=response
           }catch (e:Exception){
               _error.value=e.message.toString()
           }

        }
    }

}