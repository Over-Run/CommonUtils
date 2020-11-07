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

package io.github.overrun.commom.util.collection;

import io.github.overrun.commom.util.annotation.CuSince;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * @author squid233
 * @since 2020/11/07
 */
@CuSince("0.1.0")
public abstract class AbstractList2D<T> implements List2D<T> {
    @Override
    public T get(int x, int y) { throw new UnsupportedOperationException(); }

    @Override
    public List2D<T> set(int x, int y, T t) { throw new UnsupportedOperationException(); }

    @Override
    public List2D<T> add(int y, T t) { throw new UnsupportedOperationException(); }

    @Override
    public List2D<T> add(int y, int x, T t) { throw new UnsupportedOperationException(); }

    @Override
    public List2D<T> clear() { throw new UnsupportedOperationException(); }

    @Override
    public List2D<T> remove(int y) { throw new UnsupportedOperationException(); }

    @Override
    public List2D<T> remove(int y, int x) { throw new UnsupportedOperationException(); }

    @NotNull
    @Override
    public Iterator<T> iterator() { throw new UnsupportedOperationException(); }

    @CuSince("0.1.0")
    public static abstract class Entry<T> {
        public abstract int getX();

        public abstract int getY();

        public abstract T getEntry();
    }
}
