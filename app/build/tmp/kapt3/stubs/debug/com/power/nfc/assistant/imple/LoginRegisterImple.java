package com.power.nfc.assistant.imple;

import java.lang.System;

/**
 * 登录、注册的功能接口
 * @author guotianhui
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lcom/power/nfc/assistant/imple/LoginRegisterImple;", "", "userEmsCodeLogin", "", "userEmsCodeRegister", "userPasswordLogin", "app_debug"})
public abstract interface LoginRegisterImple {
    
    public abstract void userPasswordLogin();
    
    public abstract void userEmsCodeLogin();
    
    public abstract void userEmsCodeRegister();
}