package my.lovely.mvvmexample.domain.repository

import my.lovely.mvvmexample.domain.models.SaveUserNameParam
import my.lovely.mvvmexample.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName


}