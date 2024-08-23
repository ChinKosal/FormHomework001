package com.example.formhomework001

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

data class UserData(
    var name : String = "",
    var gender : String = "",
    var phone : String = "",
    var address : String = ""
)

class RegisterViewModel : ViewModel(){
    var userData = mutableStateOf(UserData())
    fun updateUserData(field: String, input: String) {
        userData.value = when (field) {
            "name" -> userData.value.copy(name = input)
            "gender" -> userData.value.copy(gender = input)
            "phone" -> userData.value.copy(phone = input)
            "address" -> userData.value.copy(address = input)
            else -> userData.value
        }
    }

//    fun updateUserName(input: String){
//        userData.value = userData.value.copy(
//            name = input
//        )
//    }
//
//    fun updateGender (input: String){
//        userData.value = userData.value.copy(
//            gender = input
//        )
//    }
//
//    fun updatePhone (input: String){
//        userData.value = userData.value.copy(
//            phone = input
//        )
//    }
//
//    fun updateAddress ( input: String){
//        userData.value = userData.value.copy(
//            address =  input
//        )
//    }
}