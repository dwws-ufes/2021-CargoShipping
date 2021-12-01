package br.ufes.dwws.cargo;

import br.ufes.dwws.location.UnLocode;
import br.ufes.dwws.utils.ddd.ValueObject;
import br.ufes.dwws.voyage.Voyage;
import java.util.Objects;
import java.util.Optional;

public class HandlingActivity implements ValueObject<HandlingActivity> {

    private HandlingEventType type;
    private UnLocode location;
    private Voyage voyage;

    protected HandlingActivity() {
    }

    public HandlingActivity(HandlingEventType type, UnLocode location, Optional<Voyage> voyage) {
        this();
        this.type = Objects.requireNonNull(type);
        this.location = Objects.requireNonNull(location);

        if (type.isVoyageRequired() && voyage.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.voyage = voyage.orElse(null);
    }

    public HandlingEventType getType() {
        return type;
    }

    public UnLocode getLocation() {
        return location;
    }

    public Optional<Voyage> getVoyage() {
        return Optional.ofNullable(voyage);
    }

    @Override
    public boolean sameValueAs(HandlingActivity other) {
        if (this.type != other.type) {
            return false;
        } else if (!Objects.equals(this.location, other.location)) {
            return false;
        } else if (!Objects.equals(this.voyage, other.voyage)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.type);
        hash = 89 * hash + Objects.hashCode(this.location);
        hash = 89 * hash + Objects.hashCode(this.voyage);
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
        return sameValueAs((HandlingActivity) obj);
    }
}
