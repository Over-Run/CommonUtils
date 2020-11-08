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

package io.github.overrun.common.util.collection

import io.github.overrun.common.util.annotation.CuApi

/**
 * @author squid233
 * @since 2020/11/07
 */
@CuApi(status = [CuApi.Status.EXPERIMENTAL], since = "0.1.0")
interface CuList2D<T> : Iterable<T> {
    operator fun get(x: Int, y: Int): T?

    operator fun get(x: Int, y: Int, defaultValue: T): T

    operator fun set(x: Int, y: Int, t: T): CuList2D<T>

    fun clear(): CuList2D<T>

    fun remove(y: Int): CuList2D<T>

    fun remove(x: Int, y: Int): CuList2D<T>

    fun isEmpty(): Boolean

    operator fun contains(t: T): Boolean

    fun contains(y: Int, t: T): Boolean

    fun <T> of(): CuList2D<T> {
        return CuImmutableList2D()
    }
}