package product.input;

import product.model.Product;

import java.util.List;

public interface RetrieveProductsInput {
    List<Product> retrieveAll(Integer pageSize, Integer offset, String sku);

}
