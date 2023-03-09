package ru.smolyakoff.waterbalance.domain.user

data class UserItem(
    val name: String,
    val height: Int,
    val weight: Int,
    val id: Int = USER_ID

) {
    companion object {
        const val USER_ID = 0
    }
}