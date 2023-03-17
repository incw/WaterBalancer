package ru.smolyakoff.waterbalance.domain.user

data class UserItem(
    var name: String,
    var height: Int,
    var weight: Int,
    var id: Int = USER_ID

) {
    companion object {
        const val USER_ID = 1
    }
}