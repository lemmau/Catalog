package category.output;

import category.model.Category;

public interface ICreateCategoryRepository {
    boolean existByName(String name);

    boolean save(Category category);
}
