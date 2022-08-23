package product.usecase;

import product.input.RetrieveProductsInput;
import product.model.Product;
import product.output.IRetrieveProductsRepository;

import java.util.List;

public class RetrieveProductsUseCase implements RetrieveProductsInput {
    private IRetrieveProductsRepository iRetrieveProductsRepository;

    public RetrieveProductsUseCase(IRetrieveProductsRepository iRetrieveProductsRepository) {

        this.iRetrieveProductsRepository = iRetrieveProductsRepository;
    }

    @Override
    public List<Product> retrieveAll(Integer pageSize, Integer offset, String sku) {
        return iRetrieveProductsRepository.findAll(pageSize,offset,sku);
    }
}
