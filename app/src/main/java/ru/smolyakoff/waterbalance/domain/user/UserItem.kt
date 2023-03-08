package ru.smolyakoff.waterbalance.domain.user

data class UserItem(

    val id: Int = USER_ID,
    val name: String,
    val height: Int,
    val weight: Int

) {
    companion object {
        const val USER_ID = 0
    }
}