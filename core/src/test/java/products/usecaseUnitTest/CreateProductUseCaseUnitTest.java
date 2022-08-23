package products.usecaseUnitTest;

import category.exceptions.IncompleteCategoryException;
import category.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import product.exceptions.IncompleteProductException;
import product.exceptions.ExistingProductException;
import product.model.Product;
import product.output.ICreateProductRepository;
import product.usecase.CreateProductUseCase;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateProductUseCaseUnitTest {

    @Mock
    ICreateProductRepository iCreateProductRepository;

    @Test
    void createProduct_ProductNotExists_ReturnTrue() throws ExistingProductException, IncompleteCategoryException, IncompleteProductException {
        Product aProduct = getFakeProduct();
        when(iCreateProductRepository.existBySKU("1")).thenReturn(false);
        when(iCreateProductRepository.save(aProduct)).thenReturn(true);
        CreateProductUseCase createProductUseCase = new CreateProductUseCase(iCreateProductRepository);
        Assertions.assertTrue(createProductUseCase.createProduct(aProduct));
    }

    @Test
    void createProduct_CannotSave_ReturnFalse() throws ExistingProductException, IncompleteCategoryException, IncompleteProductException {
        Product aProduct = getFakeProduct();
        when(iCreateProductRepository.existBySKU("1")).thenReturn(false);
        when(iCreateProductRepository.save(aProduct)).thenReturn(false);
        CreateProductUseCase createProductUseCase = new CreateProductUseCase(iCreateProductRepository);
        Assertions.assertFalse(createProductUseCase.createProduct(aProduct));
    }

    @Test
    void createProduct_ProductExists_ExistingProductException() throws IncompleteCategoryException, IncompleteProductException {
        Product aProduct = getFakeProduct();
        when(iCreateProductRepository.existBySKU("1")).thenReturn(true);
        CreateProductUseCase createProductUseCase = new CreateProductUseCase(iCreateProductRepository);
        Assertions.assertThrows(ExistingProductException.class, () -> createProductUseCase.createProduct(aProduct));
    }

    private Product getFakeProduct() throws IncompleteProductException, IncompleteCategoryException {
        return Product.makeProduct("1", "fakeName", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory"));
    }
}
