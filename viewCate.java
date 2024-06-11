
package category.view;

import category.model.entityCategory;
import category.model.repositoryCategory;
import java.util.List;
import java.util.Scanner;
import productModel.product;

public class viewCate {
    private repositoryCategory repoCateg;
     Scanner teclado = new Scanner(System.in);

    public viewCate(repositoryCategory repoCateg) {
        this.repoCateg = repoCateg;
    }

    public viewCate() {
    }
     
    public entityCategory cateACargar(List<entityCategory> listaCategoria){
       
        System.out.println("Ingrese el ID de la categoria");
        int IDCate=teclado.nextInt();
        teclado.nextLine(); 
         boolean idEncontrado=buscarSiExisteId(IDCate, listaCategoria);
         if(!idEncontrado){
            System.out.println("Ingrese el nombre de la categoria");
            String nombreCate=teclado.nextLine();
            teclado.nextLine(); 
            return new entityCategory (nombreCate, IDCate);
        } else{
             System.out.println("El id de la categoria ya se encuentra, intente nuevamente");
         }
        return null;
    }
    public boolean buscarSiExisteId(int id,List<entityCategory> listaCategoria){
        boolean encontrado=false;
        for(int i=0; i<listaCategoria.size();i++){
               entityCategory categoria = (entityCategory) listaCategoria.get(i);
                if(categoria.getId()==id){
                    encontrado=true;
                }
        }
        return encontrado;
    
    }
    
    
    public void mostrarCategorias( List<entityCategory> listado){
        if(listado.isEmpty()){
            System.out.println("La lista esta vacia");
        }
        else {
            System.out.println("La lista es;");
            for(int i=0; i<listado.size();i++){
               entityCategory cate = (entityCategory) listado.get(i);
                System.out.println(cate);
            }
        }
    }
    
    public int pedirIDCate(){
        System.out.println("Ingresa el ID de la categoria ");
        int idcate=teclado.nextInt();
        return idcate;
    }
    
    public String actualizarLista(){
        
            System.out.println("Usted desea modificar el nombre de la categoria");
            System.out.println("Ingrese el nombre actualizado"); 
            teclado.nextLine();
            String nuevoNombre=teclado.nextLine();
            return nuevoNombre;
    
    }
    
     public int categoriaAEliminar(boolean encontrado, int id){
        if(encontrado==false){
            System.out.println("No se ha encontrado la categoria");
             return -1;
        } else{
            
            return id;
        }
    
    }

   
}
