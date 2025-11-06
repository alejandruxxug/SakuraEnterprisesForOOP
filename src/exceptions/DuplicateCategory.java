package exceptions;

public class DuplicateCategory extends RuntimeException {
    public DuplicateCategory(String message) {
        super(message);
    }
}
