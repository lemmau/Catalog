package product.input;

import product.exceptions.ExistingProductException;
import product.model.Product;

public interface CreateProductInput {
    boolean createProduct(Product aProduct) throws ExistingProductException;
}
