package br.ufes.dwws.location;

import br.ufes.dwws.utils.ddd.Entity;
import java.util.Objects;

public class Location implements Entity<Location, UnLocode> {

    // public static final Location UNKNOWN = new Location(new UnLocode("XXXXX"), "Unknown location");
    private UnLocode id;
    private String name;

    protected Location() {
    }

    public Location(UnLocode unLocode, String name) {
        this();
        this.id = Objects.requireNonNull(unLocode, "location UN/LOCODE must not be null");
        this.name = Objects.requireNonNull(name, "location name must not be null");
    }

    @Override
    public UnLocode getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean sameIdentityAs(Location other) {
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        return sameIdentityAs((Location) obj);
    }
}
