package com.power.nfc.assistant.model

data class RegisterUserInfo(

        var mobile: String? = null,
        var nfcCardId: String? = null,
        var pwd: String? = null
){
    override fun toString(): String {
        return "?mobile=$mobile&nfcCardId=$nfcCardId&pwd=$pwd"
    }
}
