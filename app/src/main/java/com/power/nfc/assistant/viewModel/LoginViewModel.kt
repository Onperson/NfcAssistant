package com.power.nfc.assistant.viewModel

import android.app.Application
import com.power.nfc.assistant.model.LoginModel
import me.goldze.mvvmhabit.base.BaseViewModel


class LoginViewModel: BaseViewModel<LoginModel?> {


    constructor(application: Application) : super(application) {

    }

    constructor(application: Application, model: LoginModel) : super(application, model) {
        // mHomePresenter = LoginRegisterPresenter(this)
    }
}