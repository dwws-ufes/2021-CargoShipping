package br.ufes.dwws.cargotracker.infrastructure.jpa;

import br.ufes.dwws.cargo.Cargo;
import br.ufes.dwws.handling.HandlingEvent;
import br.ufes.dwws.handling.HandlingEventRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
class HandlingEventJPARepository extends JPAPersistence implements HandlingEventRepository {

    // private static final String FIND_ALL = "HandlingEvent.findAll";
    private static final String FIND_BY_CARGO = "HandlingEvent.findByCargo";

    @Override
    public void register(HandlingEvent event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<HandlingEvent> findByCargo(Cargo cargo) {
        return getEntityManager().createNamedQuery(FIND_BY_CARGO, HandlingEvent.class)
                .setParameter("cargo", cargo)
                .getResultList();
    }

    @Override
    public Optional<HandlingEvent> find(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<HandlingEvent> findAll(int offset, int limit) {
        throw new UnsupportedOperationException();
    }
}
