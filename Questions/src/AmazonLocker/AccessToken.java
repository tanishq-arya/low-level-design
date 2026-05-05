package AmazonLocker;

import java.util.UUID;

public class AccessToken {
    String code;
    long expiration;

    Compartment compartment; // linked to this compartment

    public AccessToken(Compartment compartment) {
        this.code = UUID.randomUUID().toString();
        this.expiration = System.currentTimeMillis() + 7L * 24 * 60 * 60 * 100;
        this.compartment = compartment;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiration; // expiration timestamp is in past
    }

    public Compartment getCompartment() {
        return compartment;
    }

    public String getCode() {
        return code;
    }
}
