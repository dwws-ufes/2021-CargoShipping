package br.ufes.dwws.cargo;

import br.ufes.dwws.location.UnLocode;
import br.ufes.dwws.utils.ddd.ValueObject;
import br.ufes.dwws.voyage.Voyage;
import java.time.LocalDateTime;
import java.util.Objects;

public class Leg implements ValueObject<Leg> {

    private Voyage voyage;
    private UnLocode loadLocation;
    private LocalDateTime loadTime;
    private UnLocode unloadLocation;
    private LocalDateTime unloadTime;

    protected Leg() {
    }

    public Leg(Voyage voyage, UnLocode loadLocation, LocalDateTime loadTime, UnLocode unloadLocation, LocalDateTime unloadTime) {
        this();
        this.voyage = Objects.requireNonNull(voyage);
        this.loadLocation = Objects.requireNonNull(loadLocation);
        this.loadTime = Objects.requireNonNull(loadTime);
        this.unloadLocation = Objects.requireNonNull(unloadLocation);
        this.unloadTime = Objects.requireNonNull(unloadTime);
    }

    public Voyage getVoyage() {
        return voyage;
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
        if (!Objects.equals(this.voyage, other.voyage)) {
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
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.voyage);
        hash = 53 * hash + Objects.hashCode(this.loadLocation);
        hash = 53 * hash + Objects.hashCode(this.loadTime);
        hash = 53 * hash + Objects.hashCode(this.unloadLocation);
        hash = 53 * hash + Objects.hashCode(this.unloadTime);
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
