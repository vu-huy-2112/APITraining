package com.example.apitraining.view.user

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apitraining.view.data.user.UserModel
import com.example.apitraining.view.data.user.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    val userLiveData: MutableLiveData<List<UserModel>> = MutableLiveData()


    fun getUser() {
        viewModelScope.launch {

            kotlin.runCatching {
                var users = UserRepository.instance.getUser()
//            withContext(Dispatchers.Main){
//                userLiveData.value = users
//            }
                users
            }.onSuccess {
                userLiveData.postValue(it)
            }.onFailure {
                Log.d("TAG", "getUser: ")
            }


        }

    }
}