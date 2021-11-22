package br.ufes.dwws.cargo;

import br.ufes.dwws.utils.ddd.ValueObject;
import java.util.Objects;

public class TrackingId implements ValueObject<TrackingId> {

    private String id;

    protected TrackingId() {
    }

    public TrackingId(String id) {
        this();
        this.id = Objects.requireNonNull(id, "tracking id must not be null");
    }

    @Override
    public boolean sameValueAs(TrackingId other) {
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        return sameValueAs((TrackingId) obj);
    }
}
