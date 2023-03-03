package com.voitov.jetpackcomposefixedinstagramcard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {
    private val initialList = mutableListOf<InstaProfile>().apply {
        repeat(100) {
            val profile = InstaProfile(
                id = it,
                firstName = "Name $it",
                lastName = "Last name $it",
                description = "Some piece of description",
                posts = Random.nextInt(0, 10000),
                followers = Random.nextInt(10, 150),
                following = Random.nextInt(10, 150),
                avatarResId = R.drawable.ic_instagram_logo,
            )
            add(profile)
        }
    }
    private val _userProfile = MutableLiveData<List<InstaProfile>>(initialList)
    val userProfile: LiveData<List<InstaProfile>>
        get() = _userProfile

    fun changeFollowingStatus(userProfileId: Int) {
        val modifiedList = _userProfile.value?.toMutableList() ?: mutableListOf()
            modifiedList.replaceAll {
                if (it.id == userProfileId) {
                    it.copy(isFollower = !it.isFollower)
                } else {
                    it
                }
            }
        _userProfile.value = modifiedList
    }
}