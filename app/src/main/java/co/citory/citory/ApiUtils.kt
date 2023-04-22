package co.citory.citory

import co.citory.citory.Client.CitoryClient
import co.citory.citory.Dao.UsersRegister

class ApiUtils {

    companion object{
        val BASE_URL="https://api.citory.co/"
        fun getUsersInterface():UsersRegister{
            return CitoryClient.getClient(BASE_URL).create(UsersRegister::class.java)
        }
    }

}