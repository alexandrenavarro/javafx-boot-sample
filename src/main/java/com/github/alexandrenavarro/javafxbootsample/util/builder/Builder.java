package com.github.alexandrenavarro.javafxbootsample.util.builder;

/**
 * Created by anavarro on 25/02/17.
 */
public interface Builder<T> {

    T build();

    //TODO add checker framework, must not be null
    default T buildToRef(Ref<T> ref) {
        final T t = build();
        ref.set(t);
        return t;
    }
}
