package br.ufes.dwws.utils.ddd;

import java.io.Serializable;

public interface ValueObject<T> extends Serializable {

    boolean sameValueAs(T other);
}
