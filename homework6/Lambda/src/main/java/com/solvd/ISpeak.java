package com.solvd;

@FunctionalInterface
public interface ISpeak<T> {
    T speak(T t);
}
