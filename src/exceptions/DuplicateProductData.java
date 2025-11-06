package exceptions;

public class DuplicateProductData extends RuntimeException {
    public DuplicateProductData(String message) {
        super(message);
    }
}
