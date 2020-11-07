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

package io.github.overrun.commom.util.map;

import io.github.overrun.commom.util.annotation.CuSince;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author squid233
 * @since 2020/11/07
 */
@CuSince("0.1.0")
public class Pos2ObjectMap<V> extends HashMap<Pos2ObjectMap.Entry, V> {
    public static <V> Pos2ObjectMap<V> of() {
        return new Pos2ObjectMap<>();
    }

    public Pos2ObjectMap<V> put(int x, int y, V v) {
        put(Entry.of(x, y), v);
        return this;
    }

    public boolean containsKey(int x, int y) { return containsKey(Entry.of(x, y)); }

    public Pos2ObjectMap<V> replace(int x, int y, V oldValue, V newValue) {
        replace(Entry.of(x, y), oldValue, newValue);
        return this;
    }

    public Pos2ObjectMap<V> replace(int x, int y, V value) {
        replace(Entry.of(x, y), value);
        return this;
    }

    public V get(int x, int y) { return get(Entry.of(x, y)); }

    public V get(int x, int y, V defaultValue) { return getOrDefault(Entry.of(x, y), defaultValue); }

    public static final class Entry {
        private final int x;
        private final int y;

        private Entry(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Entry of(int x, int y) { return CachePool.get(x, y); }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return x == entry.x && y == entry.y;
        }

        @Override
        public int hashCode() { return Objects.hash(x, y); }

        @Override
        public String toString() {
            return new StringJoiner(", ", Entry.class.getSimpleName() + "[", "]")
                    .add("x=" + x)
                    .add("y=" + y)
                    .toString();
        }

    }

    private static final class CachePool {
        private static final Map<String, Entry> caches = new HashMap<>(16);

        public static Entry get(int x, int y) {
            String s = x + "," + y;
            if (!caches.containsKey(s)) {
                caches.put(s, new Entry(x, y));
            }
            return caches.get(s);
        }
    }

    public Pos2ObjectMap<V> retainAll(int y) {
        Pos2ObjectMap<V> map = this;
        for (Entry entry : map.keySet()) {
            if (entry.y != y) remove(entry);
        }
        return map;
    }
}
