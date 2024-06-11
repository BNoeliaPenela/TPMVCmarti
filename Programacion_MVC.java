
package programacion_mvc;

import category.controller.controllerCategory;
import category.model.entityCategory;
import category.model.repositoryCategory;
import category.view.viewCate;
import java.util.List;
import java.util.Scanner;
import productController.controllerProduct;
import productModel.product;
import productModel.repositoryProduct;
import productView.viewProduct;


public class Programacion_MVC {

    public static void main(String[] args) {
        
        viewProduct viewProduct = new viewProduct();
        viewCate viewCategory = new viewCate();
        product producto = new product();
        repositoryProduct repoProduct = new repositoryProduct();
        entityCategory categoria= new entityCategory();
        repositoryCategory repoCate=new repositoryCategory();
        
        
        
        controllerCategory controllerCategory= new controllerCategory(categoria, repoCate, viewCategory, repoProduct);
        controllerProduct controllerproduct =new controllerProduct( repoProduct, viewProduct, repoCate);
        boolean continuar = true;
       Scanner teclado = new Scanner(System.in);
            
         while(continuar==true){
             System.out.print("Seleccione una opción: ");
            System.out.println("");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Agregar Categoria");
            System.out.println("6. Mostrar categorias");
            System.out.println("7. Actualizar categoria");
            System.out.println("8. Eliminar categoria");
            System.out.println("9. Salir");
            int opcion = teclado.nextInt();
             switch(opcion){
                 case 1:
                     
                     controllerproduct.cargarLista();
                    break;
                 case 2:
                     controllerproduct.mostrarProducts();
                    break;
                     
                 case 3:
                     controllerproduct.ActualizarProd();
                    break;
                 case 4:
                     controllerproduct.eliminar();
                    break;
                 case 5:
                     controllerCategory.cargarLista();
                    break;
                 case 6:
                     controllerCategory.mostrarCate();
                     break;
                 case 7: 
                     controllerCategory.ActualizarCate();
                     break;
                 case 8:
                     controllerCategory.eliminar();
                     break;
                 case 9:
                     continuar=false;
                     break;
                    
             }
         
         
         }

        
        
        
        
    }
        
        
    

    public Programacion_MVC() {
    }

    
    
}



