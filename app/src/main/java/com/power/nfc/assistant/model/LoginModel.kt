package com.power.nfc.assistant.model

import me.goldze.mvvmhabit.base.BaseModel



data class LoginModel(
        var imgcode: String = "9758",
        var k: String = "1",
        var pdomain: String = "nfc",
        var pwd: String = "123456",
        var userName: String = "admin",
        var rememberMe: String = "true"

) : BaseModel(){
    //https://user.api.it120.cc/login/userName?imgcode=0737&k=6&pdomain=nfc&pwd=123456&userName=admin&rememberMe=true
    override fun toString(): String {
        return "?imgcode=$imgcode&k=$k&pdomain=$pdomain&pwd=$pwd&userName=$userName&rememberMe=$rememberMe"
    }
}