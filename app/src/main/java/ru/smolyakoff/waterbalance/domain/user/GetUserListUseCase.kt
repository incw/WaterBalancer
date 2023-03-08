package ru.smolyakoff.waterbalance.domain.user

import androidx.lifecycle.LiveData
import ru.smolyakoff.waterbalance.domain.other.WaterBalanceRepository

class GetUserListUseCase(private val waterBalanceRepository: WaterBalanceRepository) {

    fun getUserList():LiveData<List<UserItem>>{
        return waterBalanceRepository.getUserList()
    }

}