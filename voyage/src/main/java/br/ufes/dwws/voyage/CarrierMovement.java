package br.ufes.dwws.voyage;

import br.ufes.dwws.location.Location;
import br.ufes.dwws.location.UnLocode;
import br.ufes.dwws.utils.ddd.ValueObject;
import java.time.LocalDateTime;
import java.util.Objects;

/** A carrier movement is a vessel voyage from one location to another. */
public class CarrierMovement implements ValueObject<CarrierMovement> {

    private UnLocode departureLocation;
    private LocalDateTime departureTime;
    private UnLocode arrivalLocation;
    private LocalDateTime arrivalTime;

    protected CarrierMovement() {
    }

    public CarrierMovement(Location departureLocation, Location arrivalLocation, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this();
        this.departureLocation = Objects.requireNonNull(departureLocation).getId();
        this.departureTime = Objects.requireNonNull(departureTime);
        this.arrivalLocation = Objects.requireNonNull(arrivalLocation).getId();
        this.arrivalTime = Objects.requireNonNull(arrivalTime);
    }

    public UnLocode getDepartureLocation() {
        return departureLocation;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public UnLocode getArrivalLocation() {
        return arrivalLocation;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public boolean sameValueAs(CarrierMovement other) {
        if (!Objects.equals(this.departureLocation, other.departureLocation)) {
            return false;
        } else if (!Objects.equals(this.departureTime, other.departureTime)) {
            return false;
        } else if (!Objects.equals(this.arrivalLocation, other.arrivalLocation)) {
            return false;
        }
        return Objects.equals(this.arrivalTime, other.arrivalTime);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.departureLocation);
        hash = 97 * hash + Objects.hashCode(this.departureTime);
        hash = 97 * hash + Objects.hashCode(this.arrivalLocation);
        hash = 97 * hash + Objects.hashCode(this.arrivalTime);
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
        return sameValueAs((CarrierMovement) obj);
    }
}
