package br.ufes.dwws.voyage;

import br.ufes.dwws.utils.ddd.Entity;
import java.util.Objects;

public class Voyage implements Entity<Voyage, VoyageNumber> {

    private VoyageNumber voyageNumber;
    private Schedule schedule;

    protected Voyage() {
    }

    public Voyage(VoyageNumber voyageNumber, Schedule schedule) {
        this();
        this.voyageNumber = Objects.requireNonNull(voyageNumber);
        this.schedule = Objects.requireNonNull(schedule);
    }

    @Override
    public VoyageNumber getId() {
        return voyageNumber;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    @Override
    public boolean sameIdentityAs(Voyage other) {
        return Objects.equals(this.voyageNumber, other.voyageNumber);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.voyageNumber);
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
