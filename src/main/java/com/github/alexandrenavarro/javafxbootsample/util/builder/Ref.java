package com.github.alexandrenavarro.javafxbootsample.util.builder;

/**
 * Created by anavarro on 26/02/17.
 */
public final class Ref<T> {

    public static <T> Ref<T> create() {
        return new Ref<>();
    }

    public static <T> Ref<T> create(T t) {
        return new Ref<>(t);
    }

    private T ref;

    public Ref() {
    }

    public Ref(T ref) {
        this.ref = ref;
    }

    public T get() {
        return this.ref;
    }

    public void set(final T reference) {
        this.ref = reference;
    }

}
