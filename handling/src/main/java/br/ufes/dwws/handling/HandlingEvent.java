package br.ufes.dwws.handling;

import br.ufes.dwws.cargo.Cargo;
import br.ufes.dwws.cargo.HandlingEventType;
import br.ufes.dwws.location.Location;
import br.ufes.dwws.voyage.Voyage;
import java.time.LocalDateTime;

public class HandlingEvent {

    private HandlingEventType type;
    private Voyage voyage;
    private Location location;
    private LocalDateTime completionTime;
    private LocalDateTime registrationTime;
    private Cargo cargo;

}
