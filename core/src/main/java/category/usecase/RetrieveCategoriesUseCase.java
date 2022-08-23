package category.usecase;

import category.input.RetrieveCategoriesInput;
import category.model.Category;
import category.output.IRetrieveCategoriesRepository;

import java.util.List;

public class RetrieveCategoriesUseCase implements RetrieveCategoriesInput {
    private IRetrieveCategoriesRepository iRetrieveCategoriesRepository;

    public RetrieveCategoriesUseCase(IRetrieveCategoriesRepository iRetrieveCategoriesRepository) {

        this.iRetrieveCategoriesRepository = iRetrieveCategoriesRepository;
    }

    @Override
    public List<Category> retrieveAll() {
        return iRetrieveCategoriesRepository.findAll();
    }
}
