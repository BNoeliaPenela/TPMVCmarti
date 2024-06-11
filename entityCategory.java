
package category.model;

import productModel.product;

public class entityCategory {
    private int id;
    private String categoriaName;

    public entityCategory(String categoriaName, int id) {
        this.id = id;
        this.categoriaName = categoriaName;
    }

    public entityCategory() {
    }

    public int getId() {
        return id;
    }

    public String getCategoriaName() {
        return categoriaName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoriaName(String categoriaName) {
        this.categoriaName = categoriaName;
    }
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ",Name='" + categoriaName + '\'' +
                '}';
    }

   
}
