package mantenimientos;

import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencias.Sucursales;

public class SucursalesMantenimiento {

    public static void main(String[] args) {

        SucursalesMantenimiento m = new SucursalesMantenimiento();

        /*--- AGREGAR ---*/
 /*
        String sucursal="ae";
        String direccion="ae";
        String municipio="ae";
        String departamento="ae";
        String telefono="ae";
        
        m.guardarSucursales(sucursal, direccion, municipio, departamento, telefono);
         */
 /*--- MOSTRAR UNO ---*/
 /*
        Sucursales mu = m.consultarSucursal(2);
        System.out.println(mu);
         */
 /*--- MOSTRAR UNA SUCURSAL ---*/
 /*
        Sucursales mu = m.consultarSucursal2("a");
        System.out.println(mu);
         */
 /*--- ELIMINAR ---*/
 
       int r= m.eliminarSucursal(3);
          System.out.println(r);

        
 /*--- MOSTRAR TODOS ---*/
 /*
        List mt = m.consultarTodosSucursales();
        System.out.println(mt);
         */
 /*--- ACTUALIZAR ---*/
 /*
        m.ActualizarSucursales(2, "sucursal", "direccion", "municipio", "departamento", "telefono");
         */
    }

    public int guardarSucursales(String sucursal, String direccion, String municipio, String departamento, String telefono) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Sucursales sucur = new Sucursales();
        sucur.setIdSucursal(0);
        sucur.setSucursal(sucursal);
        sucur.setDireccion(direccion);
        sucur.setMunicipio(municipio);
        sucur.setDepartamento(departamento);
        sucur.setTelefono(telefono);
        try {
            session.beginTransaction();
            session.save(sucur);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Sucursal agregada correctamente.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error al agregar sucursal. " + e.getMessage());
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int ActualizarSucursales(Integer idSucursal, String sucursal, String direccion, String municipio, String departamento, String telefono) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        
        Sucursales sucur = new Sucursales();
        sucur.setIdSucursal(idSucursal);
        sucur.setSucursal(sucursal);
        sucur.setDireccion(direccion);
        sucur.setMunicipio(municipio);
        sucur.setDepartamento(departamento);
        sucur.setTelefono(telefono);
        
        System.out.println("idSucursal: "+idSucursal);
        System.out.println("Sucursal: "+sucursal);
        session.beginTransaction();
        try {
            session.update(sucur);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Sucursal actualizada correctamente.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error al actualizar sucursal. " + e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Sucursales consultarSucursal(Integer idSucursal) {
        Sucursales suc = new Sucursales();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            suc = (Sucursales) session.get(Sucursales.class, idSucursal);
            session.getTransaction().commit();
            if (suc == null) {
                System.out.println("Los datos sobre la sucursal solicitada se han eliminado anteriormente.");
            } else {
                System.out.println("Mostrar datos de sucursal.");
            }
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al mostrar sucursal. " + e.getMessage());
            }
        } finally {
            session.close();
        }
        return suc;
    }

    public Sucursales consultarSucursal2(String sucursal) {
        Sucursales suc = new Sucursales();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {

            Query q = session.createQuery("from Sucursales s where s.sucursal = :sucursal").setParameter("sucursal", sucursal);
            System.out.println("TAMAÑO: " + q.list().size());
            if (q.list().isEmpty()) {
                System.out.println("No éxiste la Sucursal, lo puede ocupar");
                return suc = null;
            } else {
                System.out.println("La Sucursal ya existe");
                return suc;
            }

        } catch (Exception e) {
            System.out.println("Error consultarSucursal2 " + e);
            return suc = null;
        } finally {
            session.close();
        }

    }
    
    public int eliminarSucursal(int idSucursal) {
        Sucursales suc = new Sucursales();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        session.beginTransaction();
        
        try {
            
            suc = (Sucursales) session.get(Sucursales.class, idSucursal);
            session.delete(suc);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Datos de la sucursal eliminados correctamente.");
            
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Los datos no se han eliminado " + e);
            }
           
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosSucursales() {
        List<Sucursales> listaSucursales = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Sucursales");
            listaSucursales = (List<Sucursales>) q.list();
            System.out.println("Datos totales de las sucursales.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al mostrar datos. " + e.getMessage());
        } finally {
        }
        return listaSucursales;
    }
}
