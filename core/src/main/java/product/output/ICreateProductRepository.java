package product.output;

import product.model.Product;

public interface ICreateProductRepository {
    boolean existBySKU(String sku);

    boolean save(Product product);
}
