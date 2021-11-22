package br.ufes.dwws.cargo;

import java.util.List;

public interface RoutingService {

    List<Itinerary> fetchRoutesForSpecification(RouteSpecification routeSpecification);
}
