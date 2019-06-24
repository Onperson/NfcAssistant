package com.power.nfc.assistant.activitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.power.nfc.assistant.R
import com.power.nfc.assistant.comm.HttpsComm
import com.power.nfc.assistant.model.LoginModel
import com.power.nfc.assistant.model.ResponseData
import com.power.nfc.assistant.utils.FormatUtils
import com.power.nfc.assistant.utils.JsonCallback
import me.goldze.mvvmhabit.utils.ToastUtils

class LoginActivity : AppCompatActivity() {

    private var mEmsNum = System.currentTimeMillis()

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        setContentView(R.layout.activity_login_in)

        val mBtnLoginIn = findViewById<AppCompatButton>(R.id.btn_login_nfc)
        val mEtNfcAccount = findViewById<EditText>(R.id.et_nfc_account)
        val mEtNfcPassword = findViewById<EditText>(R.id.et_nfc_password)
        val mEtNfcEms = findViewById<EditText>(R.id.et_picture_ems)

        val mIvEmsPicture = findViewById<AppCompatImageView>(R.id.iv_ems_picture)
        Glide.with(mIvEmsPicture).load("https://user.api.it120.cc/code?k=$mEmsNum").into(mIvEmsPicture)
        mIvEmsPicture.setOnClickListener {
            Glide.with(mIvEmsPicture).load("https://user.api.it120.cc/code?k=$mEmsNum").into(mIvEmsPicture)
        }
        mBtnLoginIn.setOnClickListener {
            Log.e(">>>>>>>>>>>>>", "接口请求:"+"https://user.api.it120.cc/code?k=$mEmsNum\"")
            val loginModel = LoginModel()
            if(mEtNfcAccount.text.toString().trim() != "") {
                loginModel.userName = mEtNfcAccount.text.toString().trim()
            }else{
            }
            if(mEtNfcPassword.text.toString().trim().trim() != "") {
                loginModel.pwd = mEtNfcPassword.text.toString().trim()
            }else{
            }
            if(mEtNfcEms.text.toString().trim().trim() != "") {
                loginModel.imgcode = mEtNfcEms.text.toString().trim()
            }else{
                Toast.makeText(baseContext,"请输入正确的验证码",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            loginModel.k = mEmsNum.toString()
            val API_BASE_DOMAIN = "https://user.api.it120.cc/login/userName"

            Log.e(">>>>>>>>>>>>>", "接口请求:$loginModel")
            OkGo.post<ResponseData<String>>(API_BASE_DOMAIN+loginModel.toString())
                    .execute(object : JsonCallback<ResponseData<String>>(){
                        override fun onSuccess(response: Response<ResponseData<String>>?) {
                            val e = Log.e(">>>>>>>>>>>>>", "接口请求成功:response:" + response?.body()?.data)
                            val mainIntent = Intent(baseContext,MainMenu::class.java)
                            startActivity(mainIntent)
                        }

                        override fun onError(response: Response<ResponseData<String>>?) {
                            super.onError(response)
                            Log.e(">>>>>>>>>>>>>", "接口请求失败:"+response.toString())
                        }
                    })
        }
    }
}
