package com.power.nfc.assistant.utils;

import java.lang.System;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：16/9/11
 * 描    述：
 * 修订历史：
 * ================================================
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a2\u0006\u0002\u0010\rJ%\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0002\u00a2\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0012H\u0002\u00a2\u0006\u0002\u0010\u0013J!\u0010\u0014\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0002\u0010\u0015R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/power/nfc/assistant/utils/JsonConvert;", "T", "Lcom/lzy/okgo/convert/Converter;", "()V", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "convertResponse", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)Ljava/lang/Object;", "parseClass", "rawType", "(Lokhttp3/Response;Ljava/lang/Class;)Ljava/lang/Object;", "parseParameterizedType", "Ljava/lang/reflect/ParameterizedType;", "(Lokhttp3/Response;Ljava/lang/reflect/ParameterizedType;)Ljava/lang/Object;", "parseType", "(Lokhttp3/Response;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "app_release"})
public final class JsonConvert<T extends java.lang.Object> implements com.lzy.okgo.convert.Converter<T> {
    private java.lang.reflect.Type type;
    private java.lang.Class<T> clazz;
    
    /**
     * 该方法是子线程处理，不能做ui相关的工作
     * 主要作用是解析网络返回的 response 对象，生成onSuccess回调中需要的数据对象
     * 这里的解析工作不同的业务逻辑基本都不一样,所以需要自己实现,以下给出的时模板代码,实际使用根据需要修改
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public T convertResponse(@org.jetbrains.annotations.NotNull()
    okhttp3.Response response) {
        return null;
    }
    
    private final T parseClass(okhttp3.Response response, java.lang.Class<?> rawType) {
        return null;
    }
    
    private final T parseType(okhttp3.Response response, java.lang.reflect.Type type) {
        return null;
    }
    
    private final T parseParameterizedType(okhttp3.Response response, java.lang.reflect.ParameterizedType type) {
        return null;
    }
    
    public JsonConvert() {
        super();
    }
    
    public JsonConvert(@org.jetbrains.annotations.NotNull()
    java.lang.reflect.Type type) {
        super();
    }
    
    public JsonConvert(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> clazz) {
        super();
    }
}