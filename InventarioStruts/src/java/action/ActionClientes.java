
package action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimientos.ClienteMantenimiento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionforms.ActionFormClientes;
import java.util.List;
import persistencias.Clientes;

public class ActionClientes extends org.apache.struts.action.Action {
    private static final String insertarCli = "insertarCli";
    private static final String consultarCli = "consultarCli";
    private static final String consultarIdCli = "consultarIdCli";
    private static final String modificarCli = "modificarCli";
    private static final String eliminarCli = "eliminarCli";
    private static final String borrarCli = "borrarCli";
    private static final String errorCli = "errorCli";

    public ActionForward execute(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        
        ActionFormClientes formBean = (ActionFormClientes) form;
        Integer idCliente = formBean.getIdCliente();
        String cliente = formBean.getCliente();
        String tipoPersona = formBean.getTipoPersona();
        String direccion = formBean.getDireccion();
        String telefono = formBean.getTelefono();
        String action = formBean.getAction();
        String mensaje = formBean.getMensaje();

        if (formBean == null || action == null) {
            formBean.setError("<div class='alert alert-danger'>Lamentamos el inconveniente, Inténtelo más Tarde</div>");
            return map.findForward(errorCli);
        }
        if (action.equals("Insertar")) {
            String adver = "";
            String adver2 = "";
            String adver3 = "";
            String adver4 = "";

            if (cliente == null || cliente.equals("")) {
                adver = "* Nombre del cliente <br>";
            }
            if (tipoPersona == null || tipoPersona.equals("")) {
                adver3 = "* Telefono del cliente <br>";
            }
            if (direccion == null || direccion.equals("")) {
                adver2 = "* Direccion del cliente <br>";
            }

            if (telefono == null || telefono.equals("")) {
                adver4 = "* Telefono del cliente <br>";
            }
            if (!adver.equals("") || !adver2.equals("") || !adver3.equals("")) {
                formBean.setError("<div class='alert alert-danger'>Por favor completar las casillas: <br>" + adver + adver2 + adver3 + adver4 + "<div>");
                return map.findForward(errorCli);
            }

            ClienteMantenimiento mc = new ClienteMantenimiento();
            System.out.println("Nombre del cliente:" + cliente);
            Clientes cli = mc.consultarNombreCliente(cliente);
            System.out.println(" consultando cliente:" + cli);
            if (cli != null) {
                formBean.setError("<div class='alert alert-danger'>El fabricante ya Existe, Ingrese otro no regristrado :<div>");
                return map.findForward(errorCli);
            }
            mc.guardarClientes(cliente, tipoPersona, direccion, telefono);
            mensaje = "<div class='alert alert-success'>Guardando  el cliente de manera exitosa<div>";
            request.setAttribute("mensaje", mensaje);
            return map.findForward(insertarCli);
        }

        if (action.equals("Consultar")) {
            ClienteMantenimiento mc = new ClienteMantenimiento();
            List<Clientes> listaClientes = mc.consultarTodosClientes();
            System.out.println("Lista es: " + listaClientes);
            if (listaClientes == null) {
                formBean.setError("<div class='alert alert-danger'>Lista vacia - sin datos.</div>");
                System.out.println("esto esta fallando esta lista");
                return map.findForward(consultarCli);
            } else {
                formBean.setListaClientes(listaClientes);
                return map.findForward(consultarCli);
            }
        }

        if (action.equals("Eliminar")) {
            ClienteMantenimiento mc = new ClienteMantenimiento();
            Clientes cli = mc.consultarClientes(idCliente);
            if (cli == null) {
                formBean.setError("<div class='alert alert-danger'>error  de actualización  de cliente</div>");
                return map.findForward(errorCli);
            } else {
                formBean.setIdCliente(cli.getIdCliente());
                formBean.setCliente(cli.getCliente());
                formBean.setTipoPersona(cli.getTipoPersona());
                formBean.setDireccion(cli.getDireccion());
                formBean.setTelefono(cli.getTelefono());
                return map.findForward(eliminarCli);
            }
        }

        if (action.equals("Borrar")) {
            ClienteMantenimiento mc = new ClienteMantenimiento();
            mc.eliminarClientes(idCliente);
            formBean.setError(borrarCli);
            List<Clientes> listaClientes = mc.consultarTodosClientes();
            formBean.setListaClientes(listaClientes);
            return map.findForward(borrarCli);
        }

        if (action.equals("Actualizar")) {
            ClienteMantenimiento mc = new ClienteMantenimiento();
            Clientes cli = mc.consultarClientes(idCliente);
            System.out.println("Actualizar" + cli);
            System.out.println("id:" + idCliente);
            System.out.println("cli:" + cli.getCliente());
            System.out.println("direccion:" + direccion);

            if (cli == null) {
                formBean.setError("<div class='alert alert-danger'>error  de actualización cliente </div>");
                return map.findForward(errorCli);
            } else {
                formBean.setIdCliente(cli.getIdCliente());
                formBean.setCliente(cli.getCliente());
                formBean.setTipoPersona(cli.getTipoPersona());
                formBean.setDireccion(cli.getDireccion());
                formBean.setTelefono(cli.getTelefono());
                return map.findForward(modificarCli);
            }
        }
        if (action.equals("Modificar")) {
            ClienteMantenimiento mc = new ClienteMantenimiento();
            mc.ActualizarClientes(idCliente, cliente, tipoPersona, direccion, telefono);
            List<Clientes> listaClientes = mc.consultarTodosClientes();
            formBean.setListaClientes(listaClientes);
            return map.findForward(consultarCli);
        }

        if (action.equals("Volver")) {
            ClienteMantenimiento mc = new ClienteMantenimiento();
            List<Clientes> listaClientes = mc.consultarTodosClientes();
            System.out.println("Lista es: " + listaClientes);
            if (listaClientes == null) {
                formBean.setError("<div class='alert alert-danger'>Lista vacia - sin datos.</div>");
                return map.findForward(consultarCli);
            } else {
                formBean.setListaClientes(listaClientes);
                return map.findForward(consultarCli);
            }
        }

        return null;

    }
}
