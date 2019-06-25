package com.power.nfc.assistant.activitys

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import androidx.appcompat.widget.AppCompatButton
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.power.nfc.assistant.R
import com.power.nfc.assistant.comm.CommConstant
import com.power.nfc.assistant.comm.HttpsComm
import com.power.nfc.assistant.model.ResponseData
import com.power.nfc.assistant.utils.JsonCallback
import com.power.nfc.assistant.utils.SharePreferfenceUtils

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
/*
        val appCompatDialog = AppCompatDialog(baseContext)
        val dialogView = View.inflate(baseContext, R.layout.dialog_swap_card, null)
        appCompatDialog.setContentView(dialogView)
        dialogView.findViewById<AppCompatButton>(R.id.btn_cancel).setOnClickListener {
            appCompatDialog.dismiss()
        }
        dialogView.findViewById<AppCompatButton>(R.id.btn_register).setOnClickListener {
            val registerIntent = Intent(MainActivity@this,RegisterActivity::class.java)
        }
        appCompatDialog.create()
        appCompatDialog.show()*/
        // Log.e(">>>>>>>>>>>>>", "接口请求:$loginModel")
       /* OkGo.post<ResponseData<String>>(HttpsComm.LOGIN_IN+loginModel.toString())
                .execute(object : JsonCallback<ResponseData<String>>(){
                    override fun onSuccess(response: Response<ResponseData<String>>?) {
                        val e = Log.e(">>>>>>>>>>>>>", "接口请求成功:response:" + response?.body()?.data)
                        val mainIntent = Intent(baseContext,MainActivity::class.java)
                        startActivity(mainIntent)
                        val spUtilsInstance = SharePreferfenceUtils.getSpUtilsInstance(baseContext)
                        spUtilsInstance?.saveStringValue(CommConstant.USER_TOKEN, response?.body()?.data)
                    }

                    override fun onError(response: Response<ResponseData<String>>?) {
                        super.onError(response)
                        if("" != response?.message()){
                            Toast.makeText(baseContext,response?.message(), Toast.LENGTH_LONG).show()
                        }

                        Log.e(">>>>>>>>>>>>>", "接口请求失败:"+response.toString())
                    }
                })*/
    }
}
