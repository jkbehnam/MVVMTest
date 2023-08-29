package com.rasis.myloginmvvm2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val btnstate = MutableLiveData<Boolean>()

    public fun checkUserPass(username: String, password: String) {
        btnstate.value = username.length > 5 && password.length > 5

    }
}