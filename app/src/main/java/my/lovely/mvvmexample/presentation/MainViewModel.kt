package my.lovely.mvvmexample.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import my.lovely.mvvmexample.data.respository.UserRepositoryImpl
import my.lovely.mvvmexample.domain.models.SaveUserNameParam
import my.lovely.mvvmexample.domain.models.UserName
import my.lovely.mvvmexample.domain.usecase.GetUserNameUseCase
import my.lovely.mvvmexample.domain.usecase.SaveUserNameUseCase

class MainViewModel(private val getUserNameUseCase: GetUserNameUseCase, private val saveUserNameUseCase: SaveUserNameUseCase) : ViewModel() {
//    private val userRepository by lazy { UserRepositoryImpl(context = applicationContext) }
//    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = userRepository) }
//    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository = userRepository) }


    fun save(text: String): String {
        val params = SaveUserNameParam(name = text)
        val result: Boolean = saveUserNameUseCase.execute(param = params)
        return "Save result = $result"

    }

    fun load(): String{
        val userName: UserName = getUserNameUseCase.execute()
        val result: String = "${userName.firstName} ${userName.lastName}"
        return result

    }
}