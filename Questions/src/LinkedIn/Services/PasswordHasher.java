package LinkedIn.Services;

public interface PasswordHasher {
    String hash(String plain);
    boolean matches(String plain, String hash);
}