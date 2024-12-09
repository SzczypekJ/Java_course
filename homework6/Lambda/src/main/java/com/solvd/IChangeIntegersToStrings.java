package com.solvd;

@FunctionalInterface
public interface IChangeIntegersToStrings<T, K> {

    T changeIntToString(K input);
}
