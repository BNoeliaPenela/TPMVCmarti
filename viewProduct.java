
package productView;

import category.model.entityCategory;
import java.util.List;
import java.util.Scanner;
import productModel.product;
import productModel.repositoryProduct;



public class viewProduct {
    private repositoryProduct repoProd;
    private entityCategory category;
     Scanner teclado = new Scanner(System.in);
    
    public product valoresACargar(List<entityCategory> listaCate, List<product> listaProductos){
       
        System.out.println("Ingrese el ID del producto");
        int ID=teclado.nextInt();
        teclado.nextLine(); 
        boolean idEncontrado=buscarSiExisteId(ID, listaProductos);
        if(!idEncontrado){
        System.out.println("Ingrese el nombre del producto");
        String nombre=teclado.nextLine();
        teclado.nextLine(); 
        System.out.println("Ingrese el precio del producto");
        double precio=teclado.nextDouble();
        teclado.nextLine(); 
        mostrarCategorias(listaCate);
        int idCateg=teclado.nextInt();
        entityCategory category=buscarCate(listaCate, idCateg);
        if(category!=null){
           
           return new product(ID, nombre,precio, category);
        }
        else {
            System.out.println("La Categoria no se encuentra, primero cargue la categoria");
        }
        } else{
            System.out.println("El id ya se encuentra, vuelva a intentar con otro");
        }
        return null;
        
        
    }
    public boolean buscarSiExisteId(int id,List<product> listaProductos){
        boolean encontrado=false;
        for(int i=0; i<listaProductos.size();i++){
               product producto = (product) listaProductos.get(i);
                if(producto.getId()==id){
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
            System.out.println("A cual de estas categorias pertenece tu producto? Ingresa el Id");
            for(int i=0; i<listado.size();i++){
               entityCategory cate = (entityCategory) listado.get(i);
                System.out.println(cate);
            }
        }
    }
    
    
    public entityCategory buscarCate(List<entityCategory> listaCate, int id){
        boolean encontrado = false;
        entityCategory cate=null;
        for (int i = 0; i < listaCate.size(); i++) {
             cate = listaCate.get(i);
            if (id == cate.getId()) {
               encontrado = true;
               break;
            }
        }
       return cate;
    
    }
    
    
    
    public void mostrarLista( List<product> listaProductos){
        if(listaProductos.isEmpty()){
            System.out.println("La lista esta vacia");
        }
        else {
            System.out.println("La lista es;");
            for(int i=0; i<listaProductos.size();i++){
               product producto = (product) listaProductos.get(i);
                System.out.println(producto);
            }
        }
    }
    public int pedirID(){
        System.out.println("Ingresa el ID del producto ");
        int id=teclado.nextInt();
        return id;
    }
    public Object[] actualizarLista(int id){
        
            System.out.println("Que desea modificar? 1- nombre. 2-precio. 3-categoria, 4-todo");
            int modif=teclado.nextInt();
            if(modif<6&&modif>0){
            switch (modif) {
                    
                    case 1:
                        System.out.println("Ingrese el nombre actualizado");
                        teclado.nextLine(); 
                        String nuevoNombre=teclado.nextLine();
                        return new Object[] {id,"nombre", nuevoNombre};
                    case 2:
                        System.out.println("Ingrese el precio actualizado");
                        teclado.nextLine(); 
                        double nuevoPrecio=teclado.nextDouble();
                        return new Object[] {id,"precio", nuevoPrecio};
                    case 3:
                        System.out.println("Ingrese la categoria actualizado");
                        teclado.nextLine(); 
                        String nuevaCategoria=teclado.nextLine();
                    return new Object[] {id,"categoria", nuevaCategoria};
                    case 4:
                            
                        System.out.println("Ingrese el nombre actualizado");
                        nuevoNombre=teclado.nextLine();
                        teclado.nextLine(); 
                        System.out.println("Ingrese el precio actualizado");
                        nuevoPrecio=teclado.nextDouble();
                        teclado.nextLine(); 
                        System.out.println("Ingrese la categoria actualizado");
                        nuevaCategoria=teclado.nextLine(); 
                        System.out.println("Ingrese el id de la categoria");
                        int idCateg = teclado.nextInt();
                        entityCategory category= new entityCategory(nuevaCategoria, idCateg);
                        
                        return new Object[] {id,"todo", nuevoNombre, nuevoPrecio, nuevaCategoria};
                        
             }}   else{System.out.println("el valor no es correcto");}          
                
        
            return null;
        
    }
    public int productoAEliminar(boolean encontrado, int id){
        if(encontrado==false){
            System.out.println("No se ha encontrado el producto");
             return -1;
        } else{
            
            return id;
        }
    
    }

}
