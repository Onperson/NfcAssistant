package com.power.nfc.assistant.comm

/**
 * 全局网络请求接口配置
 * @author flair
 */
object HttpsComm {
    const val  API_PRIVATE_DOMAIN = "nfc" //这个配置更改为你在api工厂申请的后台地址后缀

    const val  API_BASE_URL = "https://user.api.it120.cc"+ API_PRIVATE_DOMAIN


    const val  LOGIN_IN = "/login/userName"


}