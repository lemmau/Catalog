package product.output;

import product.model.Product;

import java.util.List;

public interface IRetrieveProductsRepository {
    List<Product> findAll(Integer pageSize, Integer offset, String sku);
}
