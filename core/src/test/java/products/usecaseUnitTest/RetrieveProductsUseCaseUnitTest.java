package products.usecaseUnitTest;

import category.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import product.model.Product;
import product.output.IRetrieveProductsRepository;
import product.usecase.RetrieveProductsUseCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RetrieveProductsUseCaseUnitTest {

    @Mock
    IRetrieveProductsRepository iRetrieveProductsRepository;

    @Spy
    List<Product> productList = productsFactory();

    @Test
    void retrieveProducts_ThereAreProducts_ReturnList() {
        when(iRetrieveProductsRepository.findAll(3,0,"")).thenReturn(productList);
        RetrieveProductsUseCase retrieveProductsUseCase = new RetrieveProductsUseCase(iRetrieveProductsRepository);
        List<Product> products = retrieveProductsUseCase.retrieveAll(3,0,"");
        Assertions.assertEquals(3, products.size());
    }
    @Test
    void retrieveProducts_ThereAreNotProducts_ReturnEmptyList() {
        when(iRetrieveProductsRepository.findAll(3,0,"")).thenReturn(Collections.emptyList());
        RetrieveProductsUseCase retrieveProductsUseCase = new RetrieveProductsUseCase(iRetrieveProductsRepository);
        List<Product> products = retrieveProductsUseCase.retrieveAll(3,0,"");
        Assertions.assertEquals(0, products.size());
    }


    private List<Product> productsFactory() {
        try {
            List<Product> categoryList = new ArrayList<>();
            categoryList.add(Product.makeProduct("1", "fakeName", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory")));
            categoryList.add(Product.makeProduct("2", "fakeName", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory")));
            categoryList.add(Product.makeProduct("3", "fakeName", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory")));
            return categoryList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
