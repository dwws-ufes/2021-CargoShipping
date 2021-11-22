package br.ufes.dwws.handling;

import br.ufes.dwws.utils.ddd.ValueObject;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HandlingHistory implements ValueObject<HandlingHistory> {

    private List<HandlingEvent> events;

    protected HandlingHistory() {
    }

    public HandlingHistory(List<HandlingEvent> events) {
        this();
        if ((this.events = Collections.unmodifiableList(Objects.requireNonNull(events))).isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean sameValueAs(HandlingHistory other) {
        return Objects.equals(this.events, other.events);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.events);
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
        return sameValueAs((HandlingHistory) obj);
    }
}
