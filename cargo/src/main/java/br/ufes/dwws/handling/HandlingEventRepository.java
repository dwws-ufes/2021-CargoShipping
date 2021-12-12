package br.ufes.dwws.handling;

import br.ufes.dwws.cargo.Cargo;
import br.ufes.dwws.utils.ddd.Repository;
import java.util.List;

public interface HandlingEventRepository extends Repository<HandlingEvent, Long> {

    void register(HandlingEvent event);

    List<HandlingEvent> findByCargo(Cargo cargo);
}
