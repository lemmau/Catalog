package product.model;

import category.model.Category;
import product.exceptions.IncompleteProductException;

public class Product {
    private String sku;
    private String name;
    private Double price;
    private String imgURL;
    private Category category;


    private Product(String sku, String name, Double price, String imgURL, Category category) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.imgURL = imgURL;
        this.category = category;
    }

    public static Product makeProduct(String sku, String name, Double price, String imgURL, Category category) throws IncompleteProductException {
        if(sku == null || sku.isEmpty()) throw new IncompleteProductException();
        if(name == null || name.isEmpty()) throw new IncompleteProductException();
        if(price == null) throw new IncompleteProductException();
        if(imgURL == null || imgURL.isEmpty()) throw new IncompleteProductException();
        if(category == null) throw new IncompleteProductException();

        return new Product(sku, name, price, imgURL, category);


    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public Category getCategory() {
        return category;
    }
}
