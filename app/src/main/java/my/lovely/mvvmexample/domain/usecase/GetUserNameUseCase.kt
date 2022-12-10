package my.lovely.mvvmexample.domain.usecase

import my.lovely.mvvmexample.domain.models.UserName
import my.lovely.mvvmexample.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()

    }
}