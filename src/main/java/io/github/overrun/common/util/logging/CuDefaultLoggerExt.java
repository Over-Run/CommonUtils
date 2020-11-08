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

package io.github.overrun.common.util.logging;

import io.github.overrun.common.util.annotation.CuApi;
import org.jetbrains.annotations.Nullable;

/**
 * @author squid233
 * @since 2020/11/08
 */
@CuApi(since = "0.1.0")
public class CuDefaultLoggerExt extends CuDefaultLogger {
    CuDefaultLoggerExt(@Nullable final String name) {
        super(name);
    }

    public void msg(@Nullable String msg, final Level level, final Object... params) {
        if (msg != null && params != null) {
            for (Object o : params) {
                msg = msg.replace("{}", o.toString());
            }
        }
        msg(msg, level);
    }

    @Override
    public void info(@Nullable String msg, @Nullable Object... params) {
        msg(msg, Level.INFO, params);
    }

    @Override
    public void warn(@Nullable String msg, @Nullable Object... params) {
        msg(msg, Level.WARN, params);
    }

    @Override
    public void error(@Nullable String msg, @Nullable Object... params) {
        msg(msg, Level.ERROR, params);
    }

    @Override
    public void fatal(@Nullable String msg, @Nullable Object... params) {
        msg(msg, Level.FATAL, params);
    }

    @Override
    public void debug(@Nullable String msg, @Nullable Object... params) {
        msg(msg, Level.DEBUG, params);
    }
}
