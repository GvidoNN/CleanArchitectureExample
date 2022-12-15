package my.lovely.mvvmexample.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import my.lovely.mvvmexample.data.respository.UserRepositoryImpl
import my.lovely.mvvmexample.domain.usecase.GetUserNameUseCase
import my.lovely.mvvmexample.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy { UserRepositoryImpl(context = context) }

    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = userRepository) }

    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository = userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}