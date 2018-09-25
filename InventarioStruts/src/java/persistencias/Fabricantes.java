package persistencias;
// Generated 09-25-2018 08:37:16 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Fabricantes generated by hbm2java
 */
public class Fabricantes  implements java.io.Serializable {


     private Integer idFabricante;
     private String fabricante;
     private String direccion;
     private String telefono;
     private Set productoses = new HashSet(0);

    public Fabricantes() {
    }

    public Fabricantes(String fabricante, String direccion, String telefono, Set productoses) {
       this.fabricante = fabricante;
       this.direccion = direccion;
       this.telefono = telefono;
       this.productoses = productoses;
    }
   
    public Integer getIdFabricante() {
        return this.idFabricante;
    }
    
    public void setIdFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }
    public String getFabricante() {
        return this.fabricante;
    }
    
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Set getProductoses() {
        return this.productoses;
    }
    
    public void setProductoses(Set productoses) {
        this.productoses = productoses;
    }




}


