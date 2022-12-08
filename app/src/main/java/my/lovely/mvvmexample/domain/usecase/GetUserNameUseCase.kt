package my.lovely.mvvmexample.domain.usecase

import my.lovely.mvvmexample.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Kiparo", lastName = "Hello")

    }
}