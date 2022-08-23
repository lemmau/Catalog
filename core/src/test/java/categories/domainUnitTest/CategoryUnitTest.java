package categories.domainUnitTest;

import category.exceptions.IncompleteCategoryException;
import category.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CategoryUnitTest {

    @Test
    void makeCategory_allValues_createCategory() throws IncompleteCategoryException {
        Category category = Category.makeCategory(1, "fakeCategory");
        Assertions.assertNotNull(category);
    }

    @Test
    void makeCategory_nameMissing_IncompleteCategoryException() {
        Assertions.assertThrows(IncompleteCategoryException.class, () -> Category.makeCategory(1, null));
        Assertions.assertThrows(IncompleteCategoryException.class, () -> Category.makeCategory(1, ""));
    }

}
