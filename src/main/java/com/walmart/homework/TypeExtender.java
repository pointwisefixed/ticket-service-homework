// author: Mark W. Naylor
// file:   TypeExtender.java
// date:   2016-Aug-27

package com.walmart.homework;

/**
 * Basic types (ex. Integer) don't provide enough type safety.  Type
 * extension allows the compiler to performe semantic checks upon
 * code.
 *
 */
abstract public class TypeExtender<T> implements Value<T> {
    private T _value;

    public TypeExtender(T t) {
        _value = t;
    }

    public T value() {
        return _value;
    }
}
