package category.input;

import category.exceptions.ExistingCategoryException;
import category.model.Category;

public interface CreateCategoryInput {
    boolean createCategory(Category category) throws ExistingCategoryException;
}
