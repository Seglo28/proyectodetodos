/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionforms.ActionFormSucursales;
import mantenimientos.SucursalesMantenimiento;
import persistencias.Sucursales;
public class ActionSucursales extends org.apache.struts.action.Action{
   private static final String agregarSUC = "agregarSUC";
    private static final String consultarSUC = "consultarSUC";
    private static final String consultarIdSUC = "consultarIdSUC";
    private static final String modificarSUC = "modificarSUC";
    private static final String borrarSUC = "borrarSUC";
    private static final String eliminarSUC = "eliminarSUC";
    private static final String errorSUC = "errorSUC";

    @Override
    public ActionForward execute(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

       ActionFormSucursales af = (ActionFormSucursales) form;
        Integer idSucursal = af.getIdSucursal();
        String sucursal = af.getSucursal();
        String direccion = af.getDireccion();
        String municipio = af.getMunicipio();
        String departamento = af.getDepartamento();
        String telefono = af.getTelefono();
        //String error = af.getError();
        String action = af.getAction();

        if (af == null || action == null) {
            return map.findForward(errorSUC);
        }

        if (action.equals("Limpiar")) {
            af.setIdSucursal(0);
            af.setSucursal("");
            af.setDireccion("");
            af.setMunicipio("");
            af.setTelefono("");
            af.setError("");
            return map.findForward(errorSUC);
        }

        if (action.equals("Agregar")) {
            String adver = "";
            String adver1 = "";
            String adver2 = "";
            String adver3 = "";
            String adver4 = "";
            if (sucursal == null || sucursal.equals("")) {
                adver1 = "<b>*El nombre de la sucursal es requerido.</b><br>";
            }

            if (direccion == null || direccion.equals("")) {
                adver2 = "<b>La dirección de la sucursal es requerida.</b><br>";
            }

            if (municipio == null || municipio.equals("")) {
                adver3 = "<b>El municipio de la sucursal es requerido.</b><br>";
            }

            if (telefono == null || telefono.equals("")) {
                adver4 = "<b>El telefono de la sucursal es requerido.</b><br>";
            }

            if (!adver.equals("")) {
                af.setError("<div class='alert alert-danger'>Por favor complete los espacios vacios" + "<br>" + adver1 +adver2 +adver3 +adver4 + "</div>");
                return map.findForward(errorSUC);
            }

            SucursalesMantenimiento sucMan = new SucursalesMantenimiento();

            Sucursales suc = sucMan.consultarSucursal2(sucursal); //Ojito en esta linea
            if (suc != null) {
                af.setError("<div class='alert alert-danger'>Esta sucursal ya existe</div>");
                return map.findForward(errorSUC);
            }
            int suc2 = sucMan.guardarSucursales(sucursal, direccion, municipio, departamento, telefono);
            System.out.println("Si es 1 Funcionó: " + suc2);
            List<Sucursales> listaSUC = sucMan.consultarTodosSucursales();
            System.out.println("Lista es: " + listaSUC);
            af.setListaSUC(listaSUC);
            return map.findForward(agregarSUC);
        }

        if (action.equals("Eliminar")) {
            SucursalesMantenimiento sucMan = new SucursalesMantenimiento();
            Sucursales suc = sucMan.consultarSucursal(idSucursal);
            if(suc==null){
                af.setError("<div class='alert alert-danger'>Pues fijese man que no se puede realizar la consulta</div>");
                return map.findForward(errorSUC);
            }else{
                af.setIdSucursal(suc.getIdSucursal());
                af.setSucursal(suc.getSucursal());
                af.setDireccion(suc.getDireccion());
                af.setMunicipio(suc.getMunicipio());
                af.setDepartamento(suc.getDepartamento());
                af.setTelefono(suc.getTelefono());
                return map.findForward(eliminarSUC);
            }
        }
        
        if (action.equals("Borrar")) {
            SucursalesMantenimiento sucMan = new SucursalesMantenimiento();
            sucMan.eliminarSucursal(idSucursal);
            af.setError(borrarSUC);
            List<Sucursales> listaSUC = sucMan.consultarTodosSucursales();
            af.setListaSUC(listaSUC);
            return map.findForward(borrarSUC);
        }

        if (action.equals("Consultar")) {
            SucursalesMantenimiento sucMan = new SucursalesMantenimiento();
            List<Sucursales> listaSUC = sucMan.consultarTodosSucursales();
            System.out.println("Lista es: " + listaSUC);
            if (listaSUC == null) {
                af.setError("<div class='alert alert-danger'>Lista vacia - sin datos.</div>");
                return map.findForward(consultarSUC);
            } else {
                af.setListaSUC(listaSUC);
                return map.findForward(consultarSUC);
            }
        }

        // AQUI PONDRE EL CONSULTAR X ID 
        if (action.equals("Actualizar")) {
            SucursalesMantenimiento sucMan = new SucursalesMantenimiento();
            Sucursales suc = sucMan.consultarSucursal(idSucursal);
            if(suc==null){
                af.setError("<div class='alert alert-danger'>Pues fijese man que no se puede realizar la consulta</div>");
                return map.findForward(errorSUC);
            }else{
                af.setIdSucursal(suc.getIdSucursal());
                af.setSucursal(suc.getSucursal());
                af.setDireccion(suc.getDireccion());
                af.setMunicipio(suc.getMunicipio());
                af.setDepartamento(suc.getDepartamento());
                af.setTelefono(suc.getTelefono());
                return map.findForward(modificarSUC);
            }
        }

        // FIN DEL METODO
        if (action.equals("Modificar")) {
            SucursalesMantenimiento sucMan = new SucursalesMantenimiento();
            sucMan.ActualizarSucursales(idSucursal, sucursal, direccion, municipio, departamento, telefono);
            List<Sucursales> suc = sucMan.consultarTodosSucursales();
            af.setListaSUC(suc);
            return map.findForward(consultarSUC);
        }
        
        if (action.equals("Volver")) {
            SucursalesMantenimiento sucMan = new SucursalesMantenimiento();
            List<Sucursales> listaSUC = sucMan.consultarTodosSucursales();
            System.out.println("Lista es: " + listaSUC);
            if (listaSUC == null) {
                af.setError("<div class='alert alert-danger'>Lista vacia - sin datos.</div>");
                return map.findForward(consultarSUC);
            } else {
                af.setListaSUC(listaSUC);
                return map.findForward(consultarSUC);
            }
        }
        
        return null;
    }  
}
