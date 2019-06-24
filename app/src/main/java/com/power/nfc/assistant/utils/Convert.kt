/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.power.nfc.assistant.utils

import com.google.gson.Gson
import com.google.gson.JsonIOException
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import com.google.gson.stream.JsonReader
import java.io.Reader
import java.lang.reflect.Type

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：16/9/28
 * 描    述：
 * 修订历史：
 * ================================================
 */
object Convert {

    private fun create(): Gson {
        return Convert.GsonHolder.gson
    }

    private object GsonHolder {
        val gson = Gson()
    }

    @Throws(JsonIOException::class, JsonSyntaxException::class)
    fun <T> fromJson(json: String, type: Class<T>): T {
        return create().fromJson(json, type)
    }

    fun <T> fromJson(json: String, type: Type): T {
        return create().fromJson(json, type)
    }

    @Throws(JsonIOException::class, JsonSyntaxException::class)
    fun <T> fromJson(reader: JsonReader, typeOfT: Type): T {
        return create().fromJson(reader, typeOfT)
    }

    @Throws(JsonSyntaxException::class, JsonIOException::class)
    fun <T> fromJson(json: Reader, classOfT: Class<T>): T {
        return create().fromJson(json, classOfT)
    }

    @Throws(JsonIOException::class, JsonSyntaxException::class)
    fun <T> fromJson(json: Reader, typeOfT: Type): T {
        return create().fromJson(json, typeOfT)
    }

    fun toJson(src: Any): String {
        return create().toJson(src)
    }

    fun toJson(src: Any, typeOfSrc: Type): String {
        return create().toJson(src, typeOfSrc)
    }

}
