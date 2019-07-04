package com.power.nfc.assistant.activitys

import android.content.Intent
import android.os.AsyncTask.execute
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.power.nfc.assistant.R
import com.power.nfc.assistant.comm.CommConstant
import com.power.nfc.assistant.comm.HttpsComm
import com.power.nfc.assistant.model.LoginModel
import com.power.nfc.assistant.model.RegisterUserInfo
import com.power.nfc.assistant.model.ResponseData
import com.power.nfc.assistant.utils.JsonCallback
import com.power.nfc.assistant.utils.SharePreferfenceUtils


class RegisterActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        val mEtNfcAccount = findViewById<EditText>(R.id.et_nfc_account)
        val mEtNfcPassword = findViewById<EditText>(R.id.et_nfc_password)
        val mEtNfcUid = findViewById<EditText>(R.id.et_nfc_uid)
        val mBtnRegister = findViewById<AppCompatButton>(R.id.btn_register_nfc)

        mBtnRegister.setOnClickListener {
            val registerModel = RegisterUserInfo()
            if (mEtNfcAccount.text.toString().trim() != "") {
                registerModel.mobile = mEtNfcAccount.text.toString().trim()
            } else {
                Toast.makeText(baseContext, "请输入正确的账户", Toast.LENGTH_LONG).show()
                //return@setOnClickListener
            }
            if (mEtNfcPassword.text.toString().trim().trim() != "") {
                registerModel.pwd = mEtNfcPassword.text.toString().trim()
            } else {
                Toast.makeText(baseContext, "请输入正确的密码", Toast.LENGTH_LONG).show()
                // return@setOnClickListener
            }
            if (mEtNfcUid.text.toString().trim().trim() != "") {
                registerModel.nfcCardId = mEtNfcUid.text.toString().trim()
            } else {
                Toast.makeText(baseContext, "请输入正确的验证码", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            // val API_BASE_DOMAIN = "https://user.api.it120.cc/login/userName"

            val spUtilsInstance = SharePreferfenceUtils.getSpUtilsInstance(baseContext)
            val userToken = spUtilsInstance?.getStringValue(CommConstant.USER_TOKEN, "")
            Log.e(">>>>>>>>>>>>>>", "用户的Token:" + userToken!!)
            Log.e(">>>>>>>>>>>>>", "接口请求:$registerModel")
            OkGo.post<ResponseData<String>>(HttpsComm.REGISTER_USER_ACCOUNT + registerModel.toString())
                    .headers("X-Token", userToken)
                    .execute(object : JsonCallback<ResponseData<String>>() {
                        override fun onSuccess(response: Response<ResponseData<String>>?) {
                            val e = Log.e(">>>>>>>>>>>>>", "注册成功:response:" + response?.body()?.data)
                            if(response?.body()?.code == 0){
                                Toast.makeText(baseContext, "恭喜您注册成功!", Toast.LENGTH_LONG).show()
                                finish()
                            }else if(response?.body()?.code == 10001){
                                Toast.makeText(baseContext,  response?.message(), Toast.LENGTH_LONG).show()
                                finish()
                            }
                        }

                        override fun onError(response: Response<ResponseData<String>>?) {
                            super.onError(response)
                            if ("" != response?.message()) {
                                Toast.makeText(baseContext, response?.message(), Toast.LENGTH_LONG).show()
                            }

                            Log.e(">>>>>>>>>>>>>", "注册接口请求失败:" + response.toString())
                        }
                    })
        }
    }
}