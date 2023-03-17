package ru.smolyakoff.waterbalance.data

import ru.smolyakoff.waterbalance.domain.user.UserItem
import ru.smolyakoff.waterbalance.domain.water.WaterItem

class WBMapper {

    // mapper for water

    fun mapWaterToDbModel(waterItem: WaterItem) = WaterItemDbModel(
        id = waterItem.id,
        count = waterItem.count,
        name = waterItem.name
    )

    fun mapDbModelToWater(waterItemDbModel: WaterItemDbModel) = WaterItem(
        id = waterItemDbModel.id,
        count = waterItemDbModel.count,
        name = waterItemDbModel.name
    )

    fun mapListDbModelToListWater(list: List<WaterItemDbModel>) = list.map {
        mapDbModelToWater(it)
    }

    //mapper for user

    fun mapUserToDbModel(userItem: UserItem) = UserItemDbModel(
        id = userItem.id,
        name = userItem.name,
        height = userItem.height,
        weight = userItem.weight
    )

    fun mapDbModelToUser(userItemDbModel: UserItemDbModel) = UserItem(
        id = userItemDbModel.id,
        name = userItemDbModel.name,
        height = userItemDbModel.height,
        weight = userItemDbModel.weight
    )

    fun mapListDbModelToUserList(list: List<UserItemDbModel>) = list.map {
        mapDbModelToUser(it)
    }
}