package br.ufes.dwws.cargo;

import br.ufes.dwws.location.UnLocode;
import br.ufes.dwws.utils.ddd.Entity;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;

public class Cargo implements Entity<Cargo, TrackingId> {

    private TrackingId trackingId;
    private UnLocode origin;
    private RouteSpecification routeSpecification;
    private Itinerary itinerary;
    // private Delivery delivery;
    private Timestamp version;

    protected Cargo() {
    }

    public Cargo(TrackingId trackingId, UnLocode origin, RouteSpecification routeSpecification) {
        this();
        this.trackingId = Objects.requireNonNull(trackingId);
        this.origin = Objects.requireNonNull(origin);
        this.routeSpecification = Objects.requireNonNull(routeSpecification);
    }

    @Override
    public TrackingId getId() {
        return trackingId;
    }

    public UnLocode getOrigin() {
        return origin;
    }

    public RouteSpecification getRouteSpecification() {
        return routeSpecification;
    }

    public Optional<Itinerary> getItinerary() {
        return Optional.ofNullable(itinerary);
    }

    public void assignToRoute(Itinerary itinerary) throws InvalidRouteException {
        if (!this.routeSpecification.isSatisfiedBy(itinerary)) {
            throw new InvalidRouteException();
        }

        this.itinerary = itinerary;
        // TODO: this.delivery = delivery.updateOnRouting(this.routeSpecification, this.itinerary);
    }

    @Override
    public boolean sameIdentityAs(Cargo other) {
        return Objects.equals(this.trackingId, other.trackingId);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.trackingId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return sameIdentityAs((Cargo) obj);
    }
}
