package category.model;

import category.exceptions.IncompleteCategoryException;

public class Category {
    private Integer id;
    private String name;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Category makeCategory(Integer id, String name) throws IncompleteCategoryException {
        if (name == null || name.isEmpty()) throw new IncompleteCategoryException();
        return new Category(id, name);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
