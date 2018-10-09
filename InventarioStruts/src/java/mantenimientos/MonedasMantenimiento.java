package mantenimientos;

import mantenimientos.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencias.Monedas;
import com.myapp.struts.HibernateUtil;

public class MonedasMantenimiento {

    public static void main(String[] args) {

    }

    public int guardarMonedas(String moneda, String abreviatura, String simbolo, Double equivalencia, String equivalente) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Monedas mon = new Monedas();
        mon.setIdMoneda(0);
        mon.setMoneda(moneda);
        mon.setAbreviatura(abreviatura);
        mon.setSimbolo(simbolo);
        mon.setEquivalencia(equivalencia);
        mon.setEquivalente(equivalente);

        try {
            session.beginTransaction();
            session.save(mon);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Éxito al guardar la moneda");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error al guardar la moneda " + e);
            }
        } finally {
            session.close();
        }
        return flag;

    }

    public int ActualizarMonedas(Integer idMoneda, String moneda, String abreviatura, String simbolo, Double equivalencia, String equivalente) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Monedas mon = new Monedas();
        mon.setIdMoneda(idMoneda);
        mon.setMoneda(moneda);
        mon.setAbreviatura(abreviatura);
        mon.setSimbolo(simbolo);
        mon.setEquivalencia(equivalencia);
        mon.setEquivalente(equivalente);

        try {
            session.beginTransaction();
            session.update(mon);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Éxito al actualizar la moneda");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error al actualizar la moneda " + e);
            }
        } finally {
            session.close();
        }
        return flag;

    }

    public Monedas consultarMoneda(Integer idMoneda) {
        Monedas mon = new Monedas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            mon = (Monedas) session.get(Monedas.class, idMoneda);
            session.getTransaction().commit();
            System.out.println("Exito ConsultaPorId Monedas");
            return mon;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error consultaPorId Monedas " + e);
            }

        } finally {
            session.close();
        }
        return mon;

    }

    public int eliminarMoneda(Integer idMoneda) {
        Monedas mon = new Monedas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        try {
            session.beginTransaction();
            mon = (Monedas) session.get(Monedas.class, idMoneda);
            session.delete(mon);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Elimina Correctamente Monedas");

        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error Eliminar Monedas " + e);
            }
        } finally {
            session.close();
        }

        return flag;

    }

    public List consultarTodosMonedas() {

        List<Monedas> listaMonedas = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Monedas");
            listaMonedas = (List<Monedas>) q.list();
            System.out.println("exito al consultar todo");
        } catch (Exception e) {
            System.out.println("Error Consultar Lista Monedas" + e);
        } finally {
        }
        return listaMonedas;

    }

    public Monedas consultarNombreMoneda(String moneda) {
        Monedas mon = new Monedas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {

            Query q = session.createQuery("FROM Monedas m where m.moneda=:moneda").setParameter("moneda", moneda);
            System.out.println("TAMAÑO: " + q.list().size());
            if (q.list().isEmpty()) {
                System.out.println("No éxiste la moneda en el sistema, puede ingresarla");
                return mon = null;
            } else {
                System.out.println("La Moneda ya existe en el sistema");
                return mon;
            }

        } catch (Exception e) {
            System.out.println("Error consultarNombreMoneda " + e);
            return mon = null;
        } finally {
            session.close();
        }
    }

}
