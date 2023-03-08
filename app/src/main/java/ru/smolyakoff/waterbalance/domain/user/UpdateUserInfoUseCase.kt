package ru.smolyakoff.waterbalance.domain.user

import ru.smolyakoff.waterbalance.domain.other.WaterBalanceRepository

class UpdateUserInfoUseCase(private val waterBalanceRepository: WaterBalanceRepository) {

    suspend fun updateUserInfo(userItem: UserItem){
        waterBalanceRepository.updateUserInfo(userItem)
    }
}