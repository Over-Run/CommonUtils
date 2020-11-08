/*
 * MIT License
 *
 * Copyright (c) 2020 Over-Run
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.overrun.common.util.logging

import io.github.overrun.common.util.CuSpecialChars
import io.github.overrun.common.util.annotation.CuApi
import java.time.LocalTime

/**
 * @author squid233
 * @since 2020/11/08
 */
@CuApi(since = "0.1.0")
open class CuDefaultLogger internal constructor(override val name: String?) : CuLogger {
    /**
     * Log format: `[20:09:12] [main/INFO] (squid233) New game has released`
     */
    fun msg(msg: String?, level: Level) =
        println("${Style.C_LIGHT_BLUE}[${LocalTime.now().toString().split('.')[0]}]" +
                " ${level.color}[${Thread.currentThread().name}/$level]${Style.CLEAR}" +
                " (${name ?: "Unknown"})" +
                " ${level.msgColor}${msg ?: ""}${Style.CLEAR}")

    override fun info(msg: String?) = msg(msg, Level.INFO)
    override fun info(msg: String?, vararg params: Any?) = info(msg)

    override fun warn(msg: String?) = msg(msg, Level.WARN)
    override fun warn(msg: String?, vararg params: Any?) = warn(msg)

    override fun error(msg: String?) = msg(msg, Level.ERROR)
    override fun error(msg: String?, vararg params: Any?)  = error(msg)

    override fun fatal(msg: String?) = msg(msg, Level.FATAL)
    override fun fatal(msg: String?, vararg params: Any?)  = fatal(msg)

    override fun debug(msg: String?) {
        if (CuLogManager.debugging) msg(msg, Level.DEBUG)
    }

    override fun debug(msg: String?, vararg params: Any?)  = debug(msg)

    object Style {
        const val NONE = ""
        const val CLEAR = "${CuSpecialChars.ESCAPE}[0m"
        const val BOLD = "${CuSpecialChars.ESCAPE}[1m"
        const val UNDERLINE = "${CuSpecialChars.ESCAPE}[4m"
        const val INVERSE_COLOR = "${CuSpecialChars.ESCAPE}[7m"
        const val C_WHITE = "${CuSpecialChars.ESCAPE}[30m"
        const val C_RED = "${CuSpecialChars.ESCAPE}[31m"
        const val C_GREEN = "${CuSpecialChars.ESCAPE}[32m"
        const val C_YELLOW = "${CuSpecialChars.ESCAPE}[33m"
        const val C_BLUE = "${CuSpecialChars.ESCAPE}[34m"
        const val C_PURPLE = "${CuSpecialChars.ESCAPE}[35m"
        const val C_LIGHT_BLUE = "${CuSpecialChars.ESCAPE}[36m"
        const val C_GRAY = "${CuSpecialChars.ESCAPE}[37m"
        const val CF_RED = "${CuSpecialChars.ESCAPE}[91m"
        const val CF_GREEN = "${CuSpecialChars.ESCAPE}[92m"
    }

    enum class Level(val color: String, val msgColor: String = color) {
        INFO(Style.C_GREEN, Style.NONE),
        WARN(Style.C_YELLOW),
        ERROR(Style.CF_RED),
        FATAL(Style.C_RED),
        DEBUG(Style.CF_GREEN, Style.CF_GREEN)
    }
}