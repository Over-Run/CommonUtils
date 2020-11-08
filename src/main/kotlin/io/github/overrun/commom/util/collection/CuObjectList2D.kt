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
import io.github.overrun.commom.util.map.CuPos2ObjectMap

/**
 * @author squid233
 * @since 2020/11/08
 */
@CuApi(status = [CuApi.Status.EXPERIMENTAL], since = "0.1.0")
open class CuObjectList2D<T> : CuAbstractList2D<T>() {
    private val entries = CuPos2ObjectMap<T>()

    override fun isEmpty(): Boolean = entries.isEmpty()

    override fun contains(t: T): Boolean = entries.containsValue(t)

    override fun contains(y: Int, t: T): Boolean {
        val map = entries.retainAll(y)
        return map.containsValue(t)
    }

    override fun remove(x: Int, y: Int): CuList2D<T> {
        entries.remove(x, y)
        return this
    }

    override fun clear(): CuList2D<T> {
        entries.clear()
        return this
    }

    override fun remove(y: Int): CuList2D<T> {
        entries.removeAll(y)
        return this
    }

    override fun iterator(): Iterator<T> =
            object : Iterator<T> {
                private var nextId = 0

                override fun hasNext(): Boolean = entries.size > nextId

                override fun next(): T {
                    TODO("Not implemented yet")
                }
            }

    override fun get(x: Int, y: Int): T? = entries[x, y]

    override fun set(x: Int, y: Int, t: T): CuList2D<T> {
        entries.put(x, y, t)
        return this
    }

    class SimpleEntry<T>(override val x: Int,
                         override val y: Int,
                         override val entry: T) : CuAbstractList2D.Entry<T>()
}