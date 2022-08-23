package category.exceptions;

public class ExistingCategoryException extends Exception{

    @Override
    public String getMessage() {
        return "There's another category with the same Name";
    }
}
