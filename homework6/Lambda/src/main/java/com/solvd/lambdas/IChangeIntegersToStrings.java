package com.solvd.lambdas;

@FunctionalInterface
public interface IChangeIntegersToStrings<T, K> {

    T changeIntToString(K input);
}
