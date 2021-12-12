package br.ufes.dwws.infrastructure.routing;

import br.ufes.dwws.cargo.Itinerary;
import br.ufes.dwws.cargo.RouteSpecification;
import br.ufes.dwws.cargo.RoutingService;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
class MockRoutingService implements RoutingService {

    @Override
    public List<Itinerary> fetchRoutesForSpecification(RouteSpecification routeSpecification) {
        // TODO: implement mock service
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
