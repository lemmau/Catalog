package products.domainUnitTest;

import category.exceptions.IncompleteCategoryException;
import category.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import product.exceptions.IncompleteProductException;
import product.model.Product;

public class ProductUnitTest {

    @Test
    void productCreation_allValues_createProduct() throws IncompleteProductException, IncompleteCategoryException {
        Product product = Product.makeProduct("1", "fakeName", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory"));
        Assertions.assertNotNull(product);
    }

    @Test
    void productCreation_missingSKU_IncompleteProductException() {
        Assertions.assertThrows(IncompleteProductException.class, () -> Product.makeProduct("", "fakeName", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory")));
        Assertions.assertThrows(IncompleteProductException.class, () -> Product.makeProduct(null, "fakeName", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory")));
        
    }

    @Test
    void productCreation_missingName_IncompleteProductException() {
        Assertions.assertThrows(IncompleteProductException.class, () -> Product.makeProduct("1", "", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory")));
        Assertions.assertThrows(IncompleteProductException.class, () -> Product.makeProduct("1", null, 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory")));
    }

    @Test
    void productCreation_missingURL_IncompleteProductException() {
        Assertions.assertThrows(IncompleteProductException.class, () -> Product.makeProduct("1", "fakeName", 100.0, "", Category.makeCategory(1, "fakeCategory")));
        Assertions.assertThrows(IncompleteProductException.class, () -> Product.makeProduct("1", "fakeName", 100.0, null, Category.makeCategory(1, "fakeCategory")));
    }

    @Test
    void productCreation_missingPrice_IncompleteProductException() {
        Assertions.assertThrows(IncompleteProductException.class, () -> Product.makeProduct("1", "fakeName", null, "http://fake.url", Category.makeCategory(1, "fakeCategory")));
    }

    @Test
    void productCreation_missingCategory_IncompleteProductException() {
        Assertions.assertThrows(IncompleteProductException.class, () -> Product.makeProduct("1", "fakeName", 100.0, "http://fake.url", null));
    }
    
    

}
