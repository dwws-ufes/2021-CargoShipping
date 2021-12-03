package br.ufes.dwws.handling;

import br.ufes.dwws.cargo.Cargo;
import br.ufes.dwws.cargo.HandlingEventType;
import br.ufes.dwws.location.UnLocode;
import br.ufes.dwws.utils.ddd.DomainEvent;
import br.ufes.dwws.utils.ddd.Entity;
import br.ufes.dwws.voyage.VoyageNumber;
import java.time.LocalDateTime;
import java.util.Objects;

public class HandlingEvent implements DomainEvent<HandlingEvent>, Entity<HandlingEvent, Long> {

    private Long id;
    private HandlingEventType type;
    private Cargo cargo;
    private UnLocode location;
    private LocalDateTime completionTime;
    private LocalDateTime registrationTime;
    private VoyageNumber voyage;
    private LocalDateTime version;

    protected HandlingEvent() {
    }

    public HandlingEvent(HandlingEventType type, Cargo cargo, VoyageNumber voyage, UnLocode location, LocalDateTime completionTime) {
        this();
        this.type = Objects.requireNonNull(type);
        this.cargo = Objects.requireNonNull(cargo);
        this.voyage = Objects.requireNonNull(voyage);
        this.location = Objects.requireNonNull(location);
        this.completionTime = Objects.requireNonNull(completionTime);
        this.registrationTime = LocalDateTime.now();
    }

    @Override
    public Long getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sameEventAs(HandlingEvent other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sameIdentityAs(HandlingEvent other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
