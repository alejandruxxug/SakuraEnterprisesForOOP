package exceptions;

public class MatchingProductNotFound extends RuntimeException {
    public MatchingProductNotFound(String message) {
        super(message);
    }
}
