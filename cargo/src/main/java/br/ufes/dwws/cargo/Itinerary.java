package br.ufes.dwws.cargo;

import br.ufes.dwws.location.Location;
import br.ufes.dwws.utils.ddd.ValueObject;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Itinerary implements ValueObject<Itinerary> {

    private List<Leg> legs;

    protected Itinerary() {
    }

    public Itinerary(List<Leg> legs) {
        this();
        if ((this.legs = Collections.unmodifiableList(Objects.requireNonNull(legs))).isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public Location initialDepartureLocation() {
        return legs.get(0).getLoadLocation();
    }

    public Location finalArrivalLocation() {
        return legs.get(legs.size() - 1).getUnloadLocation();
    }

    public LocalDateTime finalArrivalTime() {
        return legs.get(legs.size() - 1).getUnloadTime();
    }

    public boolean isExpected(HandlingActivity event) {
        Objects.requireNonNull(event);

        switch (event.getType()) {
            case RECEIVE:
                return initialDepartureLocation().equals(event.getLocation());
            case LOAD:
                return legs.stream().anyMatch(leg -> leg.getLoadLocation().sameIdentityAs(event.getLocation()) && event.getVoyage().filter(x -> x.sameIdentityAs(leg.getVoyage())).isPresent());
            case UNLOAD:
                return legs.stream().anyMatch(leg -> leg.getUnloadLocation().sameIdentityAs(event.getLocation()) && event.getVoyage().filter(x -> x.sameIdentityAs(leg.getVoyage())).isPresent());
        }

        // TODO: continue from here...
        return false;
    }

    @Override
    public boolean sameValueAs(Itinerary other) {
        return Objects.equals(this.legs, other.legs);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.legs);
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
        return sameValueAs((Itinerary) obj);
    }
}
