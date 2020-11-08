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
package io.github.overrun.commom.util.collection

import io.github.overrun.commom.util.annotation.CuApi

/**
 * @author squid233
 * @since 2020/11/07
 */
@CuApi(since = "0.1.0")
object CuCollections {
    /**
     * Create an array by concise method.<br/>
     * When a method need a param of array, you may be input this:
     * `new Object[]{this, this}`,
     * but if you use this method, you can call it like this example:
     * `arrayOf(this, this)`.<br/>
     * <b>For Kotlin developers: </b>Use {@link Library#arrayOf} instead.
     *
     * @param t   Objects for array.
     * @param <T> Objects type.
     * @return An array.
    </T> */
    @SafeVarargs
    fun <T> arrayOf(vararg t: T): Array<out T> {
        return t
    }

    /**
     * @param i Numbers.
     * @return Int array.
     * @see CuCollections.arrayOf
     */
    fun intArrayOf(vararg i: Int): IntArray {
        return i
    }
}