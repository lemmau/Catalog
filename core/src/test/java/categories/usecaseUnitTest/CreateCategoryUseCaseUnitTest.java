package categories.usecaseUnitTest;

import category.exceptions.ExistingCategoryException;
import category.exceptions.IncompleteCategoryException;
import category.model.Category;
import category.output.ICreateCategoryRepository;
import category.usecase.CreateCategoryUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCategoryUseCaseUnitTest {

    @Mock
    ICreateCategoryRepository iCreateCategoryRepository;

    @Test
    void createCategory_CategoryNotExists_ReturnTrue() throws ExistingCategoryException, IncompleteCategoryException {
        Category aCategory = getFakeCategory();
        when(iCreateCategoryRepository.existByName("fakeName")).thenReturn(false);
        when(iCreateCategoryRepository.save(aCategory)).thenReturn(true);
        CreateCategoryUseCase createCategoryUseCase = new CreateCategoryUseCase(iCreateCategoryRepository);
        Assertions.assertTrue(createCategoryUseCase.createCategory(aCategory));
    }

    @Test
    void createCategory_CannotSave_ReturnFalse() throws ExistingCategoryException, IncompleteCategoryException {
        Category aCategory = getFakeCategory();
        when(iCreateCategoryRepository.existByName("fakeName")).thenReturn(false);
        when(iCreateCategoryRepository.save(aCategory)).thenReturn(false);
        CreateCategoryUseCase createCategoryUseCase = new CreateCategoryUseCase(iCreateCategoryRepository);
        Assertions.assertFalse(createCategoryUseCase.createCategory(aCategory));
    }

    @Test
    void createCategory_CategoryExists_ExistingCategoryException() throws IncompleteCategoryException {
        Category aCategory = getFakeCategory();
        when(iCreateCategoryRepository.existByName("fakeName")).thenReturn(true);
        CreateCategoryUseCase createCategoryUseCase = new CreateCategoryUseCase(iCreateCategoryRepository);
        Assertions.assertThrows(ExistingCategoryException.class, () -> createCategoryUseCase.createCategory(aCategory));
    }

    private Category getFakeCategory() throws IncompleteCategoryException {
        return Category.makeCategory(1, "fakeName");
    }
}
