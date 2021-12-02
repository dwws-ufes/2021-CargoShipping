package br.ufes.dwws.cargo;

import br.ufes.dwws.location.UnLocode;
import br.ufes.dwws.utils.ddd.ValueObject;
import br.ufes.dwws.voyage.VoyageNumber;
import java.time.LocalDateTime;
import java.util.Objects;

public class Leg implements ValueObject<Leg> {

    private VoyageNumber voyageNumber;
    private UnLocode loadLocation;
    private LocalDateTime loadTime;
    private UnLocode unloadLocation;
    private LocalDateTime unloadTime;

    protected Leg() {
    }

    public Leg(VoyageNumber voyageNumber, UnLocode loadLocation, LocalDateTime loadTime, UnLocode unloadLocation, LocalDateTime unloadTime) {
        this();
        this.voyageNumber = Objects.requireNonNull(voyageNumber);
        this.loadLocation = Objects.requireNonNull(loadLocation);
        this.loadTime = Objects.requireNonNull(loadTime);
        this.unloadLocation = Objects.requireNonNull(unloadLocation);
        this.unloadTime = Objects.requireNonNull(unloadTime);
    }

    public VoyageNumber getVoyageNumber() {
        return voyageNumber;
    }

    public UnLocode getLoadLocation() {
        return loadLocation;
    }

    public LocalDateTime getLoadTime() {
        return loadTime;
    }

    public UnLocode getUnloadLocation() {
        return unloadLocation;
    }

    public LocalDateTime getUnloadTime() {
        return unloadTime;
    }

    @Override
    public boolean sameValueAs(Leg other) {
        if (!Objects.equals(this.voyageNumber, other.voyageNumber)) {
            return false;
        } else if (!Objects.equals(this.loadLocation, other.loadLocation)) {
            return false;
        } else if (!Objects.equals(this.loadTime, other.loadTime)) {
            return false;
        } else if (!Objects.equals(this.unloadLocation, other.unloadLocation)) {
            return false;
        } else if (!Objects.equals(this.unloadTime, other.unloadTime)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.voyageNumber);
        hash = 13 * hash + Objects.hashCode(this.loadLocation);
        hash = 13 * hash + Objects.hashCode(this.loadTime);
        hash = 13 * hash + Objects.hashCode(this.unloadLocation);
        hash = 13 * hash + Objects.hashCode(this.unloadTime);
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
        return sameValueAs((Leg) obj);
    }
}
