package ru.smolyakoff.waterbalance.domain.user

import ru.smolyakoff.waterbalance.domain.other.WaterBalanceRepository

class AddUserUserCase(private val waterBalanceRepository: WaterBalanceRepository) {


    suspend fun addUser(userItem: UserItem) {
        waterBalanceRepository.addUser(userItem)
    }

}