package category.output;

import category.model.Category;

import java.util.List;

public interface IRetrieveCategoriesRepository {
    List<Category> findAll();
}
