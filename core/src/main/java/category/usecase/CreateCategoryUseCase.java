package category.usecase;

import category.exceptions.ExistingCategoryException;
import category.input.CreateCategoryInput;
import category.model.Category;
import category.output.ICreateCategoryRepository;

public class CreateCategoryUseCase implements CreateCategoryInput {
    private ICreateCategoryRepository iCreateCategoryRepository;

    public CreateCategoryUseCase(ICreateCategoryRepository iCreateCategoryRepository) {

        this.iCreateCategoryRepository = iCreateCategoryRepository;
    }

    @Override
    public boolean createCategory(Category category) throws ExistingCategoryException {
        if(iCreateCategoryRepository.existByName(category.getName()))
            throw new ExistingCategoryException();
        return iCreateCategoryRepository.save(category);
    }
}
