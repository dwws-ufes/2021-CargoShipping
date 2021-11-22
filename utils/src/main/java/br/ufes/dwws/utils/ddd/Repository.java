package br.ufes.dwws.utils.ddd;

import java.util.Collection;
import java.util.Optional;

public interface Repository<T extends Entity<T, U>, U> {

    Optional<T> find(U id);

    Collection<T> findAll(int offset, int limit);
}
