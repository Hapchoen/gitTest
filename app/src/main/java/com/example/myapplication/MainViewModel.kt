package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // 수정사항 이거 수정사항
    // this is TempBranch11
    private val _userData : MutableStateFlow<List<User>> = MutableStateFlow(emptyList())
    val userData = _userData

    init {
        getUsers()
    }

    fun getUsers()  {
        viewModelScope.launch {
         _userData.value = RetrofitInstance.getUsersData()
        }

    }

}