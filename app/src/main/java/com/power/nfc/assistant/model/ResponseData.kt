package com.power.nfc.assistant.model

import java.io.Serializable

/**
 * 请求响应公共参数封住
 * @author guotianhui
 */
class ResponseData<T> : Serializable {

    var code: Int = 0
    var message: String? = null
    var data: T? = null
}
