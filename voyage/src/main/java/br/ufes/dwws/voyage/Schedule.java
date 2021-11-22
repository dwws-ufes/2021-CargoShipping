package br.ufes.dwws.voyage;

import br.ufes.dwws.utils.ddd.ValueObject;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Schedule implements ValueObject<Schedule> {

    private List<CarrierMovement> carrierMovements;

    protected Schedule() {
    }

    public Schedule(List<CarrierMovement> carrierMovements) {
        this();
        if ((this.carrierMovements = Collections.unmodifiableList(Objects.requireNonNull(carrierMovements))).isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public List<CarrierMovement> getCarrierMovements() {
        return carrierMovements;
    }

    @Override
    public boolean sameValueAs(Schedule other) {
        return Objects.equals(this.carrierMovements, other.carrierMovements);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.carrierMovements);
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
        return sameValueAs((Schedule) obj);
    }
}
