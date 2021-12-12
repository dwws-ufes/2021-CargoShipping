package br.ufes.dwws.infrastructure.jpa;

import br.ufes.dwws.cargo.Cargo;
import br.ufes.dwws.cargo.CargoRepository;
import br.ufes.dwws.cargo.TrackingId;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
class CargoJPARepository extends JPAPersistence implements CargoRepository {

    private static final String FIND_ALL = "Cargo.findAll";

    @Override
    public TrackingId nextId() {
        return new TrackingId(UUID.randomUUID().toString());
    }

    @Override
    public void save(Cargo cargo) {
        getEntityManager().persist(cargo);
    }

    @Override
    public Optional<Cargo> find(TrackingId id) {
        return Optional.ofNullable(getEntityManager().find(Cargo.class, id));
    }

    @Override
    public Collection<Cargo> findAll(int offset, int limit) {
        return getEntityManager().createNamedQuery(FIND_ALL, Cargo.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
