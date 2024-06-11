
package category.model;

import category.view.viewCate;
import java.util.ArrayList;
import java.util.List;

public class repositoryCategory {
   List<entityCategory> categorias= new ArrayList<>();
   viewCate viewCategory = new viewCate();

    public repositoryCategory(List<entityCategory> categorias) {
        this.categorias = categorias;
    }

    public repositoryCategory() {
        this.categorias=new ArrayList<>();
    }
    

    public List<entityCategory> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<entityCategory> categorias) {
        this.categorias = categorias;
    }
     public void agregar(entityCategory cate){
        categorias.add(cate);
    
    }

    public boolean buscarCateList(int id, entityCategory cateBuscada) {
    boolean encontrado = false;
    for (int i = 0; i < categorias.size(); i++) {
        entityCategory cate = categorias.get(i);
        if (id == cate.getId()) {
            encontrado = true;
            break;
        }
    } 
    return encontrado;
    }
    
      public entityCategory getIdCategory(int id) {
        for (entityCategory categoria : categorias) {
            if (categoria.getId() == id) {
                return categoria;
                
            }
        }
        return null; 
    }
    
    
   public void actualizar(int idcate, String valorActualizado){
   
   for (int i = 0; i < categorias.size(); i++) {
           entityCategory cate = categorias.get(i);
            if (cate.getId() == idcate) {
               
                    cate.setCategoriaName((String)valorActualizado);
                    System.out.println("Actualizada correctamente");
                  
            }
        }      
   
   }
     
     public void eliminar(int id) {
    for (int i = 0; i < categorias.size(); i++) {
        entityCategory cate = categorias.get(i);
        if (cate.getId() == id) {
            categorias.remove(i);
            return; 
        }
    }
}

}
