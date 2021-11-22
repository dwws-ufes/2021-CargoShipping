package br.ufes.dwws.cargo;

import br.ufes.dwws.location.Location;
import br.ufes.dwws.utils.ddd.Entity;

public class Cargo implements Entity<Cargo, TrackingId> {

    private TrackingId trackingId;
    private Location origin;
    private RouteSpecification routeSpecification;
    private Itinerary itinerary;

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
