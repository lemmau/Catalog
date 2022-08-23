package product.exceptions;

public class IncompleteProductException extends Exception{

    @Override
    public String getMessage() {
        return "Missing values on Product creation";
    }
}
