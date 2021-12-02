package br.ufes.dwws.voyage;

import br.ufes.dwws.utils.ddd.Entity;
import java.sql.Timestamp;
import java.util.Objects;

public class Voyage implements Entity<Voyage, VoyageNumber> {

    private VoyageNumber id;
    private Schedule schedule;
    private Timestamp version;

    protected Voyage() {
    }

    public Voyage(VoyageNumber voyageNumber, Schedule schedule) {
        this();
        this.id = Objects.requireNonNull(voyageNumber);
        this.schedule = Objects.requireNonNull(schedule);
    }

    @Override
    public VoyageNumber getId() {
        return id;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    @Override
    public boolean sameIdentityAs(Voyage other) {
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        return sameIdentityAs((Voyage) obj);
    }
}
