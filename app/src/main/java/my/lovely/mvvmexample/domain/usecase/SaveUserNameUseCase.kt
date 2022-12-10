package my.lovely.mvvmexample.domain.usecase

import my.lovely.mvvmexample.domain.models.SaveUserNameParam
import my.lovely.mvvmexample.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam) : Boolean {
        val oldUserName = userRepository.getName()

        if(oldUserName.firstName == param.name){
            return true
        }

        val result = userRepository.saveName(saveParam = param)
        return result
    }
}