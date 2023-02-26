package com.voitov.jetpackcomposefixedinstagramcard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _isFollowed = MutableLiveData<Boolean>()
    val isFollowed: LiveData<Boolean>
        get() = _isFollowed

    fun changeFollowingStatus() {
        val wasFollower = _isFollowed.value ?: false
        _isFollowed.value = !wasFollower
    }
}