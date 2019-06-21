package com.power.nfc.assistant.viewModel

import android.app.Application
import com.power.nfc.assistant.model.LoginModel
import me.goldze.mvvmhabit.base.BaseViewModel


class LoginViewModel(application: Application, model: LoginModel?) : BaseViewModel<LoginModel>(application, model) {


    override fun onCreate() {
        super.onCreate()
    }
}