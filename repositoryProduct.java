
package productModel;

import category.model.entityCategory;
import java.util.ArrayList;
import java.util.List;
import productView.viewProduct;

public class repositoryProduct {
    List<product> listaProductos= new ArrayList<>();
    viewProduct viewProduct = new viewProduct();
 
    public repositoryProduct( List<product> listaProductos) {
        this.listaProductos = listaProductos;
    }


    public repositoryProduct() {
    }

    
    public void setListaProductos(List<product> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<product> getListaProductos() {
        return listaProductos;
    }

    public void agregar(product p){
        listaProductos.add(p);
    
    }
    public void mostrarProducts(){
     viewProduct.mostrarLista(listaProductos);
    }
    public boolean buscarProdList(int id) {
    boolean encontrado = false;
    for (int i = 0; i < listaProductos.size(); i++) {
        product producto = listaProductos.get(i);
        if (id == producto.getId()) {
            encontrado = true;
            break;
        }
    } 
    return encontrado;
}

    
   public void actualizar(int idProdu, String aModificar, Object[] valorActualizado){
   
   for (int i = 0; i < listaProductos.size(); i++) {
            product producto = listaProductos.get(i);
            if (producto.getId() == idProdu) {
                if(aModificar=="nombre"){
                    producto.setNombre((String)valorActualizado[2]);
                    System.out.println("Actualizada correctamente");
                }
                else if(aModificar=="precio"){
                    producto.setPrecio((double)valorActualizado[2]);
                    System.out.println("Actualizada correctamente");
                }
                else if(aModificar=="categoria"){
                    producto.setCategory((entityCategory) valorActualizado[2]);
                    System.out.println("Actualizada correctamente");
                }
                else if(aModificar=="todo"){
                    producto.setNombre((String)valorActualizado[2]);
                    producto.setPrecio((double)valorActualizado[3]);
                    producto.setCategory((entityCategory)valorActualizado[4]);
                    System.out.println("Actualizada correctamente");
                }     
            }
        }      
   
   }
   
   public void eliminar( int idEliminar) {
    for (int i = 0; i < listaProductos.size(); i++) {
        product productoActual = listaProductos.get(i);
        if (productoActual.getId() == idEliminar) {
            listaProductos.remove(i);
            
            break; 
        }
    }
}

}
