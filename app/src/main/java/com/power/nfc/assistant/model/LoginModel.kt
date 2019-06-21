package com.power.nfc.assistant.model

import me.goldze.mvvmhabit.base.BaseModel

data class LoginModel(
        var userName : String,
        var password : String
) : BaseModel()