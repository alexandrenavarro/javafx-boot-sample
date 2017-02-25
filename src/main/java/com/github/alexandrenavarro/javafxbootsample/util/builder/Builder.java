package com.github.alexandrenavarro.javafxbootsample.util.builder;

/**
 * Created by anavarro on 25/02/17.
 */
public interface Builder<T> {

    T build();

    default T buildTo(T arg) {
        arg = build();
        return arg;
    }
}
