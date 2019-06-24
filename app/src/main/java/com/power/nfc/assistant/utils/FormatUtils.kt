package com.power.nfc.assistant.utils

import com.google.gson.Gson

/**
 * 格式化输入工具类
 *
 */
object FormatUtils {

    /**
     * 打印输入到控制台
     *
     * @param jsonStr
     * @author lizhgb
     * @Date 2015-10-14 下午1:17:22
     */
    fun printJson(jsonStr: String) {
        println(formatJson(jsonStr))
    }

    /**
     * 格式化
     *
     * @param jsonStr
     * @return
     * @author lizhgb
     * @Date 2015-10-14 下午1:17:35
     * @Modified 2017-04-28 下午8:55:35
     */
    fun formatJson(jsonStr: String?): String {
        if (null == jsonStr || "" == jsonStr)
            return ""
        val sb = StringBuilder()
        var last = '\u0000'
        var current = '\u0000'
        var indent = 0
        var isInQuotationMarks = false
        for (i in 0 until jsonStr.length) {
            last = current
            current = jsonStr[i]
            when (current) {
                '"' -> {
                    if (last != '\\') {
                        isInQuotationMarks = !isInQuotationMarks
                    }
                    sb.append(current)
                }
                '{', '[' -> {
                    sb.append(current)
                    if (!isInQuotationMarks) {
                        sb.append('\n')
                        indent++
                        addIndentBlank(sb, indent)
                    }
                }
                '}', ']' -> {
                    if (!isInQuotationMarks) {
                        sb.append('\n')
                        indent--
                        addIndentBlank(sb, indent)
                    }
                    sb.append(current)
                }
                ',' -> {
                    sb.append(current)
                    if (last != '\\' && !isInQuotationMarks) {
                        sb.append('\n')
                        addIndentBlank(sb, indent)
                    }
                }
                else -> sb.append(current)
            }
        }

        return sb.toString()
    }

    /**
     * 添加space
     *
     * @param sb
     * @param indent
     * @author lizhgb
     * @Date 2015-10-14 上午10:38:04
     */
    private fun addIndentBlank(sb: StringBuilder, indent: Int) {
        for (i in 0 until indent) {
            sb.append('\t')
        }
    }

}
