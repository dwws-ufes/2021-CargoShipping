package br.ufes.dwws.utils.ddd;

import java.util.function.Predicate;

public interface Specification<T> extends Predicate<T> {

    @Override
    default boolean test(T t) {
        return isSatisfiedBy(t);
    }

    boolean isSatisfiedBy(T t);
}
