package br.ufes.dwws.cargo;

import br.ufes.dwws.location.Location;
import br.ufes.dwws.utils.ddd.ValueObject;
import br.ufes.dwws.voyage.Voyage;
import java.time.LocalDateTime;

public class Delivery implements ValueObject<Delivery> {

    private TransportStatus transportStatus;
    private Location lastKnownLocation;
    private Voyage currentVoyage;
    private boolean misdirected;
    private LocalDateTime eta;
    // private HandlingEvent lastEvent;
    private HandlingActivity lastActivity;
    private HandlingActivity nextExpectedActivity;
    private boolean isUnloadedAtDestination;
    private RoutingStatus routingStatus;
    private LocalDateTime calculatedAt;

    protected Delivery() {
    }

    @Override
    public boolean sameValueAs(Delivery other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
