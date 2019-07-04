package com.power.nfc.assistant.comm

/**
 * 全局网络请求接口配置
 * @author flair
 */
object HttpsComm {


    const val  API_BASE_URL = "https://user.api.it120.cc/" //


    const val  LOGIN_IN = "$API_BASE_URL/login/userName"


    const val  EMS_PICTURE_URL = "$API_BASE_URL/code?k="

    const val  QUERY_USER_INFO = "$API_BASE_URL/user/apiExtUser/info/nfc"
    const val  REGISTER_USER_ACCOUNT = "$API_BASE_URL/user/apiExtUser/addNewUser"

}