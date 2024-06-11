
package productModel;

import category.model.entityCategory;

public class product {
    int id;
    String nombre;
    double precio;
    private entityCategory category;

    public product(int id, String nombre, double precio, entityCategory category) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.category = category;
    }

    

    public product() {
    }
   
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public entityCategory getCategory() {
        return category;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(entityCategory category) {
        this.category = category;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

   

     @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", Price=" + precio +
                ", Name='" + nombre+ '\'' +
                ", category=" + category.getCategoriaName() +
                '}';
    }
   
    
}
