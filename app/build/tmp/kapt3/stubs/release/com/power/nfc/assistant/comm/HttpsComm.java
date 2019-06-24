package com.power.nfc.assistant.comm;

import java.lang.System;

/**
 * 全局网络请求接口配置
 * @author flair
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/power/nfc/assistant/comm/HttpsComm;", "", "()V", "API_BASE_URL", "", "EMS_PICTURE_URL", "LOGIN_IN", "app_release"})
public final class HttpsComm {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String API_BASE_URL = "https://user.api.it120.cc/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LOGIN_IN = "https://user.api.it120.cc//login/userName";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EMS_PICTURE_URL = "https://user.api.it120.cc/code?k=";
    public static final com.power.nfc.assistant.comm.HttpsComm INSTANCE = null;
    
    private HttpsComm() {
        super();
    }
}