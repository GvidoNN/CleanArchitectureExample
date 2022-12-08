package my.lovely.mvvmexample.domain.usecase

import my.lovely.mvvmexample.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam) : Boolean {
        if(param.name.isEmpty()){
            return false
        } else return true
    }
}