package br.ufes.dwws.voyage;

import br.ufes.dwws.utils.ddd.ValueObject;
import java.util.Objects;

/** Identifies a voyage. */
public class VoyageNumber implements ValueObject<VoyageNumber> {

    private String number;

    protected VoyageNumber() {
    }

    public VoyageNumber(String number) {
        this();
        this.number = Objects.requireNonNull(number);
    }

    @Override
    public boolean sameValueAs(VoyageNumber other) {
        return Objects.equals(this.number, other.number);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.number);
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
        return sameValueAs((VoyageNumber) obj);
    }
}
