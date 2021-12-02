package br.ufes.dwws.cargo;

import br.ufes.dwws.location.UnLocode;
import br.ufes.dwws.utils.ddd.ValueObject;
import br.ufes.dwws.voyage.VoyageNumber;
import java.util.Objects;
import java.util.Optional;

public class HandlingActivity implements ValueObject<HandlingActivity> {

    private HandlingEventType type;
    private UnLocode location;
    private VoyageNumber voyageNumber;

    protected HandlingActivity() {
    }

    public HandlingActivity(HandlingEventType type, UnLocode location, Optional<VoyageNumber> voyageNumber) {
        this();
        this.type = Objects.requireNonNull(type);
        this.location = Objects.requireNonNull(location);

        if (type.isVoyageRequired() && voyageNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.voyageNumber = voyageNumber.orElse(null);
    }

    public HandlingEventType getType() {
        return type;
    }

    public UnLocode getLocation() {
        return location;
    }

    public Optional<VoyageNumber> getVoyageNumber() {
        return Optional.ofNullable(voyageNumber);
    }

    @Override
    public boolean sameValueAs(HandlingActivity other) {
        if (this.type != other.type) {
            return false;
        } else if (!Objects.equals(this.location, other.location)) {
            return false;
        } else if (!Objects.equals(this.voyageNumber, other.voyageNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.type);
        hash = 89 * hash + Objects.hashCode(this.location);
        hash = 89 * hash + Objects.hashCode(this.voyageNumber);
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
