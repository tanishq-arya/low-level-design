package LinkedIn.Services;

public class PasswordHasherImpl implements PasswordHasher {
    public String hash(String plain) {
        // Simplified for example
        return "HASHED(" + plain + ")";
    }
    public boolean matches(String plain, String hash) {
        return hash.equals(hash(plain));
    }
}