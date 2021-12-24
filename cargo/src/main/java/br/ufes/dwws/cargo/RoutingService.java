package br.ufes.dwws.cargo;

import java.util.List;

/** Routing service. */
public interface RoutingService {

    /**
     * @param routeSpecification routeSpecification
     * @return A list of itineraries that satisfy the specification. May be an empty
     *         list if no route is found.
     */
    List<Itinerary> fetchRoutesForSpecification(RouteSpecification routeSpecification);
}
