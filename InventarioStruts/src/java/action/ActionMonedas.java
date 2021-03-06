package action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimientos.MonedasMantenimiento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionforms.ActionFormMoneda;
import persistencias.Monedas;

public class ActionMonedas extends org.apache.struts.action.Action {

    private static final String agregarMON = "agregarMON";
    private static final String consultarMON = "consultarMON";
    private static final String consultarIdMON = "consultarIdMON";
    private static final String modificarMON = "modificarMON";
    private static final String errorMON = "errorMON";
    private static final String borrarMON = "borrarMON";

    @Override
    public ActionForward execute(ActionMapping map, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionFormMoneda af = (ActionFormMoneda) form;
        Integer idMoneda = af.getIdMoneda();
        String moneda = af.getMoneda();
        String abreviatura = af.getAbreviatura();
        String simbolo = af.getSimbolo();
        Double equivalencia = af.getEquivalencia();
        String equivalente = af.getEquivalente();
        String action = af.getAction();
        String mensaje = "";

        if (af == null || action == null) {
            mensaje = "Hay un problema en el Sistema";
            request.setAttribute("error", mensaje);
            return map.findForward(errorMON);
        }

        if (action.equals("Agregar")) {
            String adver = "";
            String adver1 = "";
            String adver2 = "";
            String adver3 = "";
            String adver4 = "";

            if (moneda == null || moneda.equals("")) {
                adver = "- Nombre de la moneda <br>";
            }
            if (abreviatura == null || abreviatura.equals("")) {
                adver1 = "- Abreviatura <br>";
            }
            if (simbolo == null || simbolo.equals("")) {
                adver2 = "- Símbolo <br>";
            }
            if (equivalencia == null || equivalencia.equals("")) {
                adver3 = "- Equivalencia <br>";
            }
            if (equivalente == null || equivalente.equals("")) {
                adver4 = "- Equivalente de moneda <br>";
            }
            if (!adver.equals("")) {
                mensaje = "Por favor completar las casillas: <br>" + adver + adver1 + adver2 + adver3 + adver4 + "";
                request.setAttribute("error", mensaje);
                return map.findForward(errorMON);

            }
            MonedasMantenimiento mom = new MonedasMantenimiento();
            Monedas money = mom.consultarNombreMoneda(moneda);

            if (money != null) {
                mensaje = "La moneda ya fue registrada en el sistema";
                request.setAttribute("error", mensaje);
                return map.findForward(errorMON);
            }
            
            List<Monedas> listaMon = mom.consultarTodosMonedas();
            af.setListaMon(listaMon);
            
            mom.guardarMonedas(moneda, abreviatura, simbolo, equivalencia, equivalente);
            mensaje = "Guardado Moneda de manera exitosa";
            request.setAttribute("mensaje", mensaje);
            return map.findForward(agregarMON);
        }

        if (action.equals("Consultar")) {
            MonedasMantenimiento mom = new MonedasMantenimiento();
            List<Monedas> listaMon = mom.consultarTodosMonedas();
            System.out.println("Lista es: " + listaMon);
            if (listaMon.isEmpty()) {
                mensaje = "No Se ha  registrado moneda alguna, Aún";
                request.setAttribute("info", mensaje);
            } else {
                af.setListaMon(listaMon);
            }
            return map.findForward(consultarMON);
        }

        if (action.equals("Borrar")) {
            MonedasMantenimiento mom = new MonedasMantenimiento();
            int r = mom.eliminarMoneda(idMoneda);

            if (r == 1) {
                System.out.println("Sirvio la eliminación de moneda");
            } else {
                System.out.println("No sirvio la eliminación de la moneda");
            }

            List<Monedas> listaMon = mom.consultarTodosMonedas();
            af.setListaMon(listaMon);
            return map.findForward(borrarMON);

        }

        if (action.equals("Actualizar")) {
            MonedasMantenimiento mom = new MonedasMantenimiento();
            System.out.println("moneda: " + moneda);
            Monedas money = mom.consultarMoneda(idMoneda);

            if (money == null) {
                mensaje = "Hay un problema en el Sistema!";
                request.setAttribute("error", mensaje);
                return map.findForward(errorMON);
            } else {
                af.setIdMoneda(money.getIdMoneda());
                af.setMoneda(money.getMoneda());
                af.setAbreviatura(money.getAbreviatura());
                af.setSimbolo(money.getSimbolo());
                af.setEquivalencia(money.getEquivalencia());
                af.setEquivalente(money.getEquivalente());

                return map.findForward(modificarMON);
            }
        }

        if (action.equals("Modificar")) {
            MonedasMantenimiento mom = new MonedasMantenimiento();
            int r = mom.ActualizarMonedas(idMoneda, moneda, abreviatura, simbolo, equivalencia, equivalente);

            if (r == 1) {
                mensaje = "Se ha modificado con Éxito!";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "Error al modificar!";
                request.setAttribute("error", mensaje);
            }

            List<Monedas> listaMon = mom.consultarTodosMonedas();
            af.setListaMon(listaMon);
            return map.findForward(consultarMON);
        }

        if (action.equals("Volver")) {
            MonedasMantenimiento mom = new MonedasMantenimiento();
            List<Monedas> listaMon = mom.consultarTodosMonedas();
            System.out.println("Lista es: " + listaMon);
            if (listaMon.isEmpty()) {
                mensaje = "No Se ha  registrado moneda alguna, Aún";
                request.setAttribute("info", mensaje);
            } else {
                af.setListaMon(listaMon);
            }
            return map.findForward(consultarMON);
        }

        return null;
    }
}
