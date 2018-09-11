
package action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimientos.ProductosMantenimiento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionforms.ActionFormProductos;
import mantenimientos.FabricantesMantenimiento;
import mantenimientos.ProveedorMantenimiento;
import persistencias.Fabricantes;
import persistencias.Productos;
import persistencias.Proveedores;
public class ActionProductos extends org.apache.struts.action.Action {
    private static final String agregarPROD = "insertarPROD";
    private static final String consultarPROD = "consultarPROD";
    private static final String consultarIdPROD = "consultarIdPROD";
    private static final String modificarPROD = "modificarPROD";
    private static final String eliminarPROD = "eliminarPROD";
    private static final String errorPROD = "errorPROD";
    private static final String errorIngresarProducto = "errorIngresarProducto";
    private static final String borrarPROD = "borrarPROD";   
    private static final String irFormProducto = "irFormProducto";
 

    
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionFormProductos formBean = (ActionFormProductos) form;
        int idProducto = formBean.getIdProducto();
        Integer idFabricante = formBean.getIdFabricante();
        Integer idProveedor = formBean.getIdProveedor();
        String producto = formBean.getProducto();
        String action = formBean.getAction();
        String mensajeProd = formBean.getMensaje();
        String errorProd = formBean.getErrorIngresarProducto();

        if (formBean == null || action == null) {
              formBean.setError("<div class='alert alert-danger'>Lamentamos el inconveniente, Inténtelo más Tarde</div>");
            return mapping.findForward(errorPROD);
        }
        if (action.equals("Insertar")) {
            String adver = "";
            String adver2 = "";
            String adver3 = "";
            
            
            if (idProveedor == null || idProveedor.equals("")) {
                adver2 = "* Elija el ID del proveedor";
               
            }
            if (idFabricante == null || idFabricante.equals("")) {
                adver = "* Elija el ID del fabricante";
               
            }
            if (producto == null || producto.equals("")) {
                adver3 = "* Escriba el nombre del producto";
               
            }
            if (!adver.equals("")) {
               formBean.setError("<div class='alert alert-danger'>Por favor completar las casillas: <br>" +adver +adver2+adver3+ "</div>");          
                return mapping.findForward(errorIngresarProducto);
            }
            ProductosMantenimiento mprod = new ProductosMantenimiento();
            System.out.println("Nombre del producto"+ producto);
            Productos prod = mprod.consultarNombreProducto(producto);
            System.out.println(" consultando producto" +prod);
            if (prod != null) {
                errorProd= ("<div class='alert alert-danger'>Este Producto ya Existe, Ingrese otro no registrado... </div>");             
                return mapping.findForward(errorIngresarProducto);
            }
            int prod2 = mprod.guardarProductos(idFabricante, idProveedor, producto);
            mensajeProd= "<div class='alert alert-success'>Guardando producto de manera exitosa<div>";
             request.setAttribute("mensajeProd", mensajeProd);
             
            System.out.println("Si es 1 Funcionó " + prod2);
            return mapping.findForward(agregarPROD);
        }

        if (action.equals("Consultar")) {
            ProductosMantenimiento mprod = new ProductosMantenimiento();
            List<Productos> listaProd = mprod.consultarTodosProductos();
            System.out.println("lista es :"+listaProd);
            if (listaProd == null) {
                formBean.setError("<div class='alert alert-danger'>No hay Datos Guardados en la base de datos sobre Productos</div>");
                return mapping.findForward(consultarPROD);
            } else {
                formBean.setListaProd(listaProd);
                return mapping.findForward(consultarPROD);
            }
        }

         if (action.equals("Agregar Producto")) {
            ProveedorMantenimiento mprov = new ProveedorMantenimiento();
            List<Proveedores> listaProv = mprov.consultarTodosProveedores();
            formBean.setListaProv(listaProv);
            request.setAttribute("listaProv", listaProv);
            
            FabricantesMantenimiento mfab=new FabricantesMantenimiento();
            List<Fabricantes>listaFab =mfab.consultarTodosFabricantes();
            formBean.setListaFab(listaFab);
            request.setAttribute("listaFab", listaFab);
            
            return mapping.findForward(irFormProducto);
            }        
         
        if(action.equals("Eliminar")){
             ProductosMantenimiento mprod = new ProductosMantenimiento();
             Productos prod=mprod.consultarProductoId(idProducto);
             if(prod==null){
                formBean.setError("<div class='alert alert-danger'>No se pudo realizar la consulat par poder eliminar el ID</div>");
                return mapping.findForward(errorPROD);
            }else{
                 formBean.setIdProducto(prod.getIdProducto());
                 formBean.setIdProveedor(prod.getProveedores().getIdProveedor());
                 formBean.setIdFabricante(prod.getFabricantes().getIdFabricante());
                 formBean.setProducto(prod.getProducto());
                 
                 ProveedorMantenimiento mprov = new ProveedorMantenimiento();
                 List<Proveedores> listaProv = mprov.consultarTodosProveedores();
                 formBean.setListaProv(listaProv);
                 request.setAttribute("listaProv", listaProv);

                FabricantesMantenimiento mfab = new FabricantesMantenimiento();
                List<Fabricantes> listaFab = mfab.consultarTodosFabricantes();
                formBean.setListaFab(listaFab);
                request.setAttribute("listaFab", listaFab);
               
             return mapping.findForward(eliminarPROD);
            
          }
        }
         if (action.equals("Borrar")) {
            ProductosMantenimiento mprod = new ProductosMantenimiento();
            mprod.eliminarProducto(idProducto);
            formBean.setError(borrarPROD);
            List<Productos> listaProd = mprod.consultarTodosProductos();
            formBean.setListaProd(listaProd);
            return mapping.findForward(borrarPROD);
        }
         
         if (action.equals("Actualizar")) {
             ProductosMantenimiento mprod = new ProductosMantenimiento();
             Productos prod=mprod.consultarProductoId(idProducto);

            if(prod==null){
                formBean.setError("<div class='alert alert-danger'> No se puede realizar la consulta para actualizar...</div>");
                return mapping.findForward(errorPROD);
            }else{
                formBean.setIdProducto(prod.getIdProducto());
                 formBean.setIdProveedor(prod.getProveedores().getIdProveedor());
                 formBean.setIdFabricante(prod.getFabricantes().getIdFabricante());
                 formBean.setProducto(prod.getProducto());
                 ProveedorMantenimiento mprov = new ProveedorMantenimiento();
                List<Proveedores> listaProv = mprov.consultarTodosProveedores();
                formBean.setListaProv(listaProv);
                request.setAttribute("listaProv", listaProv);

                FabricantesMantenimiento mfab = new FabricantesMantenimiento();
                List<Fabricantes> listaFab = mfab.consultarTodosFabricantes();
                formBean.setListaFab(listaFab);
                request.setAttribute("listaFab", listaFab);
                return mapping.findForward(modificarPROD);
            }
        }
        if (action.equals("Modificar")) {
            ProductosMantenimiento mprod = new ProductosMantenimiento();
            mprod.ActualizarProductos(idProducto, idFabricante, idProveedor, producto);
            List<Productos> listaProd = mprod.consultarTodosProductos();
            formBean.setListaProd(listaProd);
            return mapping.findForward(consultarPROD);
        }
         if (action.equals("Volver")) {
            ProductosMantenimiento mprod = new ProductosMantenimiento();
            List<Productos> listaProd = mprod.consultarTodosProductos();
            System.out.println("Lista es: " + listaProd);
            if (listaProd == null) {
                formBean.setError("<div class='alert alert-danger'>Lista vacia - sin datos.</div>");
                return mapping.findForward(consultarPROD);
            } else {
                formBean.setListaProd(listaProd);
                return mapping.findForward(consultarPROD);
            }
        }
        
        
        
        return null;
    }
}
