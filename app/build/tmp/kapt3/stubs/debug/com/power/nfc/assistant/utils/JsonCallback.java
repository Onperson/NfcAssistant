package com.power.nfc.assistant.utils;

import java.lang.System;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：2016/1/14
 * 描    述：默认将返回的数据解析成需要的Bean,可以是 BaseBean，String，List，Map
 * 修订历史：
 * ================================================
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a2\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\u00020\u000f2\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0011\u0018\u00010\u0011H\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/power/nfc/assistant/utils/JsonCallback;", "T", "Lcom/lzy/okgo/callback/AbsCallback;", "()V", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "convertResponse", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)Ljava/lang/Object;", "onStart", "", "request", "Lcom/lzy/okgo/request/base/Request;", "app_debug"})
public abstract class JsonCallback<T extends java.lang.Object> extends com.lzy.okgo.callback.AbsCallback<T> {
    private java.lang.reflect.Type type;
    private java.lang.Class<T> clazz;
    
    @java.lang.Override()
    public void onStart(@org.jetbrains.annotations.Nullable()
    com.lzy.okgo.request.base.Request<T, ? extends com.lzy.okgo.request.base.Request<?, ?>> request) {
    }
    
    /**
     * 该方法是子线程处理，不能做ui相关的工作
     * 主要作用是解析网络返回的 response 对象,生产onSuccess回调中需要的数据对象
     * 这里的解析工作不同的业务逻辑基本都不一样,所以需要自己实现,以下给出的时模板代码,实际使用根据需要修改
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public T convertResponse(@org.jetbrains.annotations.NotNull()
    okhttp3.Response response) {
        return null;
    }
    
    public JsonCallback() {
        super();
    }
    
    public JsonCallback(@org.jetbrains.annotations.NotNull()
    java.lang.reflect.Type type) {
        super();
    }
    
    public JsonCallback(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> clazz) {
        super();
    }
}