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

package io.github.overrun.common.util.map

import io.github.overrun.common.util.annotation.CuApi

/**
 * @author squid233
 * @since 2020/11/07
 */
@CuApi(since = "0.1.0")
open class CuPos2ObjectMap<V> : HashMap<CuPos2ObjectMap.Entry, V>() {
    fun put(x: Int, y: Int, v: V): CuPos2ObjectMap<V> {
        put(CachePool[x, y], v)
        return this
    }

    fun containsKey(x: Int, y: Int): Boolean {
        return containsKey(CachePool[x, y])
    }

    fun replace(x: Int, y: Int, oldValue: V, newValue: V): CuPos2ObjectMap<V> {
        replace(CachePool[x, y], oldValue, newValue)
        return this
    }

    fun replace(x: Int, y: Int, value: V): CuPos2ObjectMap<V> {
        replace(CachePool[x, y], value)
        return this
    }

    fun remove(x: Int, y: Int): CuPos2ObjectMap<V> {
        remove(CachePool[x, y])
        return this
    }

    operator fun get(x: Int, y: Int): V? {
        return get(CachePool[x, y])
    }

    operator fun get(x: Int, y: Int, defaultValue: V): V {
        return getOrDefault(CachePool[x, y], defaultValue)
    }

    fun retainAll(y: Int): CuPos2ObjectMap<V> {
        val map = CuPos2ObjectMap<V>()
        map.putAll(this)
        for (entry in map.keys) {
            if (entry.y != y) remove(entry)
        }
        return map
    }

    fun removeAll(y: Int): CuPos2ObjectMap<V> {
        val map = CuPos2ObjectMap<V>()
        map.putAll(this)
        for (k in map.keys) {
            if (k.y == y) remove(k)
        }
        return this
    }

    data class Entry(val x: Int, val y: Int)

    private object CachePool {
        private val caches: MutableMap<String, Entry> = HashMap(16)
        operator fun get(x: Int, y: Int): Entry {
            val s = "$x,$y"
            if (!caches.containsKey(s)) {
                caches[s] = Entry(x, y)
            }
            return caches[s] ?: Entry(0, 0)
        }
    }
}