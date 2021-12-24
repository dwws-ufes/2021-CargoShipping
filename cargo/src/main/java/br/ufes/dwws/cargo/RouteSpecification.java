package br.ufes.dwws.cargo;

import br.ufes.dwws.location.UnLocode;
import br.ufes.dwws.utils.ddd.Specification;
import br.ufes.dwws.utils.ddd.ValueObject;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Route specification. Describes where a cargo origin and destination is, and
 * the arrival deadline.
 */
public class RouteSpecification implements ValueObject<RouteSpecification>, Specification<Itinerary> {

    private UnLocode origin;
    private UnLocode destination;
    private LocalDateTime arrivalDeadline;

    protected RouteSpecification() {
    }

    public RouteSpecification(UnLocode origin, UnLocode destination, LocalDateTime arrivalDeadline) {
        this();
        this.origin = Objects.requireNonNull(origin);
        this.destination = Objects.requireNonNull(destination);
        this.arrivalDeadline = Objects.requireNonNull(arrivalDeadline);
    }

    public UnLocode getOrigin() {
        return origin;
    }

    public UnLocode getDestination() {
        return destination;
    }

    public LocalDateTime getArrivalDeadline() {
        return arrivalDeadline;
    }

    @Override
    public boolean isSatisfiedBy(Itinerary itinerary) {
        return null != itinerary
                && origin.sameValueAs(itinerary.initialDepartureLocation())
                && destination.sameValueAs(itinerary.finalArrivalLocation())
                && arrivalDeadline.isAfter(itinerary.finalArrivalTime());
    }

    @Override
    public boolean sameValueAs(RouteSpecification other) {
        if (!Objects.equals(this.origin, other.origin)) {
            return false;
        } else if (!Objects.equals(this.destination, other.destination)) {
            return false;
        } else if (!Objects.equals(this.arrivalDeadline, other.arrivalDeadline)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.origin);
        hash = 73 * hash + Objects.hashCode(this.destination);
        hash = 73 * hash + Objects.hashCode(this.arrivalDeadline);
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
        return sameValueAs((RouteSpecification) obj);
    }
}
