package categories.usecaseUnitTest;

import category.model.Category;
import category.output.IRetrieveCategoriesRepository;
import category.usecase.RetrieveCategoriesUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RetrieveCategoriesUseCaseUnitTest {

    @Mock
    IRetrieveCategoriesRepository iRetrieveCategoriesRepository;

    @Spy
    List<Category> categoryList = categoriesFactory();

    @Test
    void retrieveCategories_ThereAreCategories_ReturnList() {
        when(iRetrieveCategoriesRepository.findAll()).thenReturn(categoryList);
        RetrieveCategoriesUseCase retrieveCategoriesUseCase = new RetrieveCategoriesUseCase(iRetrieveCategoriesRepository);
        List<Category> categories = retrieveCategoriesUseCase.retrieveAll();
        Assertions.assertEquals(3, categories.size());
    }
    @Test
    void retrieveCategories_ThereAreNotCategories_ReturnEmptyList() {
        when(iRetrieveCategoriesRepository.findAll()).thenReturn(Collections.emptyList());
        RetrieveCategoriesUseCase retrieveCategoriesUseCase = new RetrieveCategoriesUseCase(iRetrieveCategoriesRepository);
        List<Category> categories = retrieveCategoriesUseCase.retrieveAll();
        Assertions.assertEquals(0, categories.size());
    }


    private List<Category> categoriesFactory() {
        try {
            List<Category> categoryList = new ArrayList<>();
            categoryList.add(Category.makeCategory(1, "fakeCategory1"));
            categoryList.add(Category.makeCategory(2, "fakeCategory2"));
            categoryList.add(Category.makeCategory(3, "fakeCategory3"));
            return categoryList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
