package exceptions;

public class MatchingCategoryNotFound extends RuntimeException {
    public MatchingCategoryNotFound(String message) {
        super(message);
    }
}
