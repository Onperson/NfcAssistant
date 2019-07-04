package com.power.nfc.assistant.model

import me.goldze.mvvmhabit.base.BaseModel



data class UserInfoModel(
        var cardId: String = "",
        var token: String = ""

) : BaseModel(){
    override fun toString(): String {
        return "?cardId=$cardId&X-Token=$token"
    }
}