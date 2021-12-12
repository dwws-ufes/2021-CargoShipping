package br.ufes.dwws.cargo;

import br.ufes.dwws.utils.ddd.Repository;

public interface CargoRepository extends Repository<Cargo, TrackingId> {

    TrackingId nextId();

    void save(Cargo cargo);
}
