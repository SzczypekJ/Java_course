package com.solvd.lambdas;

@FunctionalInterface
public interface ISpeak<T> {
    T speak(T t);
}
