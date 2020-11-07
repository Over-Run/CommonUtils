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

/**
 * @author squid233
 * @since 2020/11/07
 */
@CuSince("0.1.0")
public interface List2D<T> extends Iterable<T> {
    T get(int x, int y);

    List2D<T> set(int x, int y, T t);

    List2D<T> add(int y, T t);

    List2D<T> add(int y, int x, T t);

    List2D<T> clear();

    List2D<T> remove(int y);

    List2D<T> remove(int y, int x);

    boolean isEmpty();

    boolean contains(T t);

    boolean contains(int y, T t);

    static <T> List2D<T> of() {
        return new ImmutableList2D<>();
    }
}
