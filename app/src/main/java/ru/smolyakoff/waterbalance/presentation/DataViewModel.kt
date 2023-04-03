package ru.smolyakoff.waterbalance.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.smolyakoff.waterbalance.data.RepositoryImpl
import ru.smolyakoff.waterbalance.domain.user.AddUserUserCase
import ru.smolyakoff.waterbalance.domain.user.GetUserListUseCase
import ru.smolyakoff.waterbalance.domain.user.GetUserUseCase
import ru.smolyakoff.waterbalance.domain.user.UserItem

class DataViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)


    private val getUserUseCase = GetUserUseCase(repository)
    private val addUserUseCase = AddUserUserCase(repository)
    private val getUserListUseCase = GetUserListUseCase(repository)

    private val _userItem = MutableLiveData<UserItem>()
    val userItem: LiveData<UserItem>
        get() = _userItem

    val userList = getUserListUseCase.getUserList()

    fun getUser(userItemId: Int) {
        viewModelScope.launch {
            val user = getUserUseCase.getUser(userItemId)
            _userItem.value = user
        }
    }

    fun addUser(insertName: String, insertHeight: Int, insertWeight: Int) {
        viewModelScope.launch {
            val userItem = UserItem(
                insertName,
                insertHeight,
                insertWeight
            )
            addUserUseCase.addUser(userItem)
        }
    }


}