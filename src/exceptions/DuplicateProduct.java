package exceptions;

public class DuplicateProduct extends RuntimeException {
    public DuplicateProduct(String message) {
        super(message);
    }
}
