
package category.controller;

import category.model.entityCategory;
import category.model.repositoryCategory;
import category.view.viewCate;
import java.util.List;
import productModel.product;
import productModel.repositoryProduct;
import productView.viewProduct;



public class controllerCategory {
    private entityCategory cate;
    private repositoryCategory repoCate;
    private viewCate vistaCategory;
    private repositoryProduct repoProduct;

    public controllerCategory(entityCategory cate, repositoryCategory repoCate, viewCate vistaCategory, repositoryProduct repoProduct) {
        this.cate = cate;
        this.repoCate = repoCate;
        this.vistaCategory = vistaCategory;
        this.repoProduct = repoProduct;
    }

    
    
      public void cargarLista(){
        List<entityCategory>  listaCate = repoCate.getCategorias();
        entityCategory cate =vistaCategory.cateACargar(listaCate);
        if(cate!=null){
            repoCate.agregar(cate);
            System.out.println("Cargado correctamente");      
        }
       }
        public void mostrarCate(){
         List<entityCategory>  lista= repoCate.getCategorias();
         vistaCategory.mostrarCategorias(lista);
        }
    
      public boolean buscarCategoria(int id) {
          boolean encontrado= repoCate.buscarCateList(id, cate);
          return encontrado;
        }
      
      
       public void ActualizarCate(){
        int id = vistaCategory.pedirIDCate();
       boolean encontrado=buscarCategoria(id);
       List<product>  lista= repoProduct.getListaProductos();
       String nombreActualizado=null;
        if(encontrado==true){
        nombreActualizado = vistaCategory.actualizarLista();
          repoCate.actualizar(id, nombreActualizado);
          modificarCateProductos(id, nombreActualizado,lista);
            System.out.println("Actualizado correctamente");
        }   else{System.out.println("NO se encuentra la categoria");}    
    }
       
       
     public void modificarCateProductos(int idCate, String nombreActualizado, List<product> listaProductos){
       entityCategory categoriaActualizada= new entityCategory ( nombreActualizado,idCate);
      
        for(int i=0; i<listaProductos.size();i++){
           product produ= (product)listaProductos.get(i);
           if(produ.getCategory().getId()==idCate){
           produ.setCategory(categoriaActualizada);
           }
        }
       
    }  
       
       
   public void eliminar() {
    int id = vistaCategory.pedirIDCate();
    boolean encontrado = buscarCategoria(id);
    List<product>  lista= repoProduct.getListaProductos();
    if (encontrado) {
        repoCate.eliminar(id);
        eliminarProductXCategoria(id, lista);
        System.out.println("Eliminado correctamente");
    } else {
        System.out.println("La categoría no se encontró");
    }
    }
   
   public void eliminarProductXCategoria(int idCate, List<product> listaProductos) {
    
        for (int i = 0; i < listaProductos.size(); i++) {
            product producto = listaProductos.get(i);
            if (producto.getCategory().getId() == idCate) {
                repoProduct.eliminar(idCate);
            }
        }
    }

}

