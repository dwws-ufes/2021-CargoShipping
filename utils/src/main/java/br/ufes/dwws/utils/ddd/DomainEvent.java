package br.ufes.dwws.utils.ddd;

public interface DomainEvent<T> {

    boolean sameEventAs(T other);
}
