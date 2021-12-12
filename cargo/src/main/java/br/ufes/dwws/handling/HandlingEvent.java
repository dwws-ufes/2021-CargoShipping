package br.ufes.dwws.handling;

import br.ufes.dwws.cargo.Cargo;
import br.ufes.dwws.location.UnLocode;
import br.ufes.dwws.utils.ddd.DomainEvent;
import br.ufes.dwws.utils.ddd.Entity;
import br.ufes.dwws.voyage.VoyageNumber;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public class HandlingEvent implements DomainEvent<HandlingEvent>, Entity<HandlingEvent, Long> {

    private Long id;
    private HandlingEventType type;
    private Cargo cargo;
    private UnLocode location;
    private LocalDateTime completionTime;
    private VoyageNumber voyage;
    private LocalDateTime version;

    protected HandlingEvent() {
    }

    public HandlingEvent(HandlingEventType type, Cargo cargo, UnLocode location, LocalDateTime completionTime, Optional<VoyageNumber> voyage) {
        this();
        this.type = Objects.requireNonNull(type);
        this.cargo = Objects.requireNonNull(cargo);
        this.location = Objects.requireNonNull(location);
        this.completionTime = Objects.requireNonNull(completionTime);
        this.voyage = voyage.orElse(null);
    }

    @Override
    public Long getId() {
        return id;
    }

    public HandlingEventType getType() {
        return type;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public UnLocode getLocation() {
        return location;
    }

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }

    public Optional<VoyageNumber> getVoyage() {
        return Optional.ofNullable(voyage);
    }

    @Override
    public boolean sameEventAs(HandlingEvent other) {
        if (this.type != other.type) {
            return false;
        } else if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        } else if (!Objects.equals(this.location, other.location)) {
            return false;
        } else if (!Objects.equals(this.completionTime, other.completionTime)) {
            return false;
        } else if (!Objects.equals(this.voyage, other.voyage)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameIdentityAs(HandlingEvent other) {
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        return sameIdentityAs((HandlingEvent) obj);
    }
}
