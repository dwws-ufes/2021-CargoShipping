package br.ufes.dwws.cargo;

import br.ufes.dwws.location.UnLocode;
import br.ufes.dwws.utils.ddd.Entity;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;

/**
 * A Cargo. This is the central class in the domain model, and it is the root of
 * the Cargo-Itinerary-Leg-Delivery-RouteSpecification aggregate.
 * <p>
 * A cargo is identified by a unique tracking id, and it always has an origin
 * and a route specification. The life cycle of a cargo begins with the booking
 * procedure, when the tracking id is assigned. During a (short) period of time,
 * between booking and initial routing, the cargo has no itinerary.
 * <p>
 * The booking clerk requests a list of possible routes, matching the route
 * specification, and assigns the cargo to one route. The route to which a cargo
 * is assigned is described by an itinerary.
 * <p>
 * A cargo can be re-routed during transport, on demand of the customer, in
 * which case a new route is specified for the cargo and a new route is
 * requested. The old itinerary, being a value object, is discarded and a new
 * one is attached.
 * <p>
 * It may also happen that a cargo is accidentally misrouted, which should
 * notify the proper personnel and also trigger a re-routing procedure.
 * <p>
 * When a cargo is handled, the status of the delivery changes. Everything about
 * the delivery of the cargo is contained in the Delivery value object, which is
 * replaced whenever a cargo is handled by an asynchronous event triggered by
 * the registration of the handling event.
 * <p>
 * The delivery can also be affected by routing changes, i.e. when the route
 * specification changes, or the cargo is assigned to a new route. In that case,
 * the delivery update is performed synchronously within the cargo aggregate.
 * <p>
 * The life cycle of a cargo ends when the cargo is claimed by the customer.
 * <p>
 * The cargo aggregate, and the entire domain model, is built to solve the
 * problem of booking and tracking cargo. All important business rules for
 * determining whether or not a cargo is misdirected, what the current status of
 * the cargo is (on board carrier, in port etc), are captured in this aggregate.
 */
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
