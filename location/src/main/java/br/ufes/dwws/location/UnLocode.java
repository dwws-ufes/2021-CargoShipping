package br.ufes.dwws.location;

import br.ufes.dwws.utils.ddd.ValueObject;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * United Nations location code.
 * <p/>
 * http://www.unece.org/cefact/locode/
 * http://www.unece.org/cefact/locode/DocColumnDescription.htm#LOCODE
 */
public class UnLocode implements ValueObject<UnLocode> {

    // Country code is exactly two letters.
    // Location code is usually three letters, but may contain the numbers 2-9 as well
    private static final Pattern VALID_PATTERN = Pattern.compile("[a-zA-Z]{2}[a-zA-Z2-9]{3}");

    private String unlocode;

    protected UnLocode() {
    }

    public UnLocode(String unlocode) {
        this();
        if (!VALID_PATTERN.matcher(this.unlocode = Objects.requireNonNull(unlocode, "UN/LOCODE must not be null").toUpperCase()).matches()) {
            throw new IllegalArgumentException(unlocode + " is not a valid UN/LOCODE");
        }
    }

    @Override
    public boolean sameValueAs(UnLocode other) {
        return Objects.equals(this.unlocode, other.unlocode);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.unlocode);
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
        return sameValueAs((UnLocode) obj);
    }
}
