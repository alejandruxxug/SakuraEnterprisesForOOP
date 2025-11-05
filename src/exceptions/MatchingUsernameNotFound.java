package exceptions;

public class MatchingUsernameNotFound extends RuntimeException {
    public MatchingUsernameNotFound(String message) {
        super(message);
    }
}
