
package productController;

import category.controller.controllerCategory;
import category.model.entityCategory;
import category.model.repositoryCategory;
import category.view.viewCate;
import java.util.List;
import productModel.product;
import productModel.repositoryProduct;
import productView.viewProduct;

public class controllerProduct {
  
    private repositoryProduct repoProd;
    private viewProduct vistaProduct;
    
     private repositoryCategory repoCate;

    public controllerProduct(repositoryProduct repoProd, viewProduct vistaProduct, repositoryCategory repoCate) {
       
        this.repoProd = repoProd;
        this.vistaProduct = vistaProduct;
        
        this.repoCate = repoCate;
    }

    

    
    public void mostrarProducts(){
         List<product>  lista= repoProd.getListaProductos();
         vistaProduct.mostrarLista(lista);

      }

   public void cargarLista() {
       List<entityCategory>  listaCate = repoCate.getCategorias();
       List<product>  listaProd= repoProd.getListaProductos();
       product produ = vistaProduct.valoresACargar(listaCate, listaProd);
       
       if(produ!=null){
          repoProd.agregar(produ);
           System.out.println("Cargado correctamente");
       }
    }

      public boolean buscarProducto(int id) {
          boolean encontrado= repoProd.buscarProdList(id);
          return encontrado;
        }
       
    public void ActualizarProd() {
    int id = vistaProduct.pedirID();
    boolean encontrado = buscarProducto(id);
    
    if (encontrado) {
        Object[] valorActualizado = vistaProduct.actualizarLista(id);
        if (valorActualizado != null) {
            String aModificar = (String) valorActualizado[1];
            int idProducto = (int) valorActualizado[0];
            repoProd.actualizar(idProducto, aModificar, valorActualizado);
            System.out.println("Producto actualizado correctamente.");
        } else {
            System.out.println("No se ha podido actualizar el producto.");
        }
    } else {
        System.out.println("El producto no se encuentra.");
    }
}

    public void eliminar(){
        int id=vistaProduct.pedirID();
       boolean encontrado=buscarProducto(id);
       
        int idEliminar = (int) vistaProduct.productoAEliminar(encontrado, id);

        if(idEliminar!=-1){
         repoProd.eliminar(idEliminar);
            System.out.println("eliminado correctamente");
        }
       
    }
    
    
}



