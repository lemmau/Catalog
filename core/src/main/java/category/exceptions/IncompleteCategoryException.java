package category.exceptions;

public class IncompleteCategoryException extends Exception{

    @Override
    public String getMessage() {
        return "Missing values on Category creation";
    }
}
