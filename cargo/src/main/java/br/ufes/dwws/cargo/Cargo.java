package br.ufes.dwws.cargo;

import br.ufes.dwws.location.UnLocode;
import br.ufes.dwws.utils.ddd.Entity;
import java.sql.Timestamp;

public class Cargo implements Entity<Cargo, TrackingId> {

    private TrackingId trackingId;
    private UnLocode origin;
    private RouteSpecification routeSpecification;
    private Itinerary itinerary;
    private Timestamp version;

    protected Cargo() {
    }

    @Override
    public TrackingId getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sameIdentityAs(Cargo other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
