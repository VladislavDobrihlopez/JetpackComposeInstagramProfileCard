package com.voitov.jetpackcomposefixedinstagramcard

data class InstaProfile(
    val id: Int,
    val firstName: String?,
    val lastName: String?,
    val description: String?,
    val posts: Int,
    val followers: Int,
    val following: Int,
    val avatarResId: Int,
    val isFollower: Boolean = false,
)