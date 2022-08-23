package product.exceptions;

public class ExistingProductException extends Exception{


    @Override
    public String getMessage() {
        return "There's another product with the same SKU";
    }
}
