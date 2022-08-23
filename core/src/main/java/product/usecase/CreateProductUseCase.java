package product.usecase;

import product.exceptions.ExistingProductException;
import product.input.CreateProductInput;
import product.model.Product;
import product.output.ICreateProductRepository;

public class CreateProductUseCase implements CreateProductInput {
    private ICreateProductRepository iCreateProductRepository;

    public CreateProductUseCase(ICreateProductRepository iCreateProductRepository) {

        this.iCreateProductRepository = iCreateProductRepository;
    }

    @Override
    public boolean createProduct(Product aProduct) throws ExistingProductException {

        if(iCreateProductRepository.existBySKU(aProduct.getSku()))
            throw new ExistingProductException();
        return iCreateProductRepository.save(aProduct);
    }
}
