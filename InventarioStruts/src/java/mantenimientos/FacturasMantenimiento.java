package mantenimientos;

import mantenimientos.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencias.Facturas;
import persistencias.Sucursales;
import  persistencias.Ventas;
import  com.myapp.struts.HibernateUtil;

public class FacturasMantenimiento {

    public static void main(String[] args) {
        FacturasMantenimiento m = new FacturasMantenimiento();
        /*
        int idFactura=0;
        int idVentas=1;
        String fechaVenta = "12/6/93";
        int idSucursales=2;

        FacturasMantenimiento m = new FacturasMantenimiento();
int r=m.guardarFacturas(idFactura, idVentas, fechaVenta, idSucursales);
        
         */
 /*
         int idFactura=3;
        int idVentas=1;
        String fechaVenta = "12/6/93";
        int idSucursales=2;

        FacturasMantenimiento m = new FacturasMantenimiento();
int r=m.ActualizarFacturas(idFactura, idVentas, fechaVenta, idSucursales);
         */
        //// eliminar///////////
        /*
         int idFactura=4;
        int r=m.eliminarFactura(0);
        System.exit(0);
         */

 /*--- MOSTRAR TODOS ---*/
 /* List<Facturas>listfac=m.consultarTodosFacturas();
     for(Facturas fac:listfac){
          System.out.println(fac.getIdFactura());
        System.out.println(fac.getVentas().getIdVenta());
        System.out.println(fac.getFechaVenta());
        System.out.println(fac.getSucursales().getIdSucursal());
         System.exit(0);
        
     }
         */
 /*--- MOSTRAR UNO ---*/
        /*
        int idFactura = 2;
        Facturas fac = m.consultarFactura(idFactura);
        System.out.println(fac.getIdFactura());
        System.out.println(fac.getVentas().getIdVenta());
        System.out.println(fac.getFechaVenta());
        System.out.println(fac.getSucursales().getIdSucursal());

        System.exit(0);
        */
    }

    public int guardarFacturas(String nDocumento, String fechaVenta, Integer idSucursales) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Facturas fac = new Facturas();
        fac.setIdFactura(0);
        fac.setNDocumento(nDocumento);

        fac.setFechaVenta(fechaVenta);

        Sucursales sucur = new Sucursales();
        sucur.setIdSucursal(idSucursales);
        fac.setSucursales(sucur);
        
        fac.setEstadoFactura("Disponible");

        try {
            session.beginTransaction();
            session.save(fac);
            session.getTransaction().commit();
            flag = 1;
            System.out.println(" exito al guaradar al factura");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al guaradar la factura");
            }
        } finally {
            session.close();
        }
        return flag;

    }
 public int ActualizarFacturas(Integer idFactura, String nDocumento, String fechaVenta, Integer idSucursal, String estadoFactura) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Facturas fac = new Facturas();
        fac.setIdFactura(idFactura);
        fac.setNDocumento(nDocumento);

        fac.setFechaVenta(fechaVenta);

        Sucursales sucur = new Sucursales();
        sucur.setIdSucursal(idSucursal);
        fac.setSucursales(sucur);
        
        fac.setEstadoFactura(estadoFactura);

        try {
            session.beginTransaction();
            session.update(fac);
            session.getTransaction().commit();
            flag = 1;
            System.out.println(" exito al guaradar al factura");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al guaradar la factura");
            }
        } finally {
            session.close();
        }
        return flag;

    }
  

    public Facturas consultarFacturaId(int idFactura) {
        Facturas fac = new Facturas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            fac = (Facturas) session.get(Facturas.class, idFactura);
            session.getTransaction().commit();
            System.out.println(" exito al  consultar la factura");
            return fac;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("error al consultar la factura");
            }

        } finally {
            session.close();
        }
        return fac;

    }
    
    public Facturas consultarInventarioVenta(String nDocumento, int idSucursal) {
        
        Facturas inv = new Facturas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        try {
            
            Query q = session.createQuery("FROM Facturas f where f.NDocumento=:NDocumento and f.sucursales.idSucursal=:idSucursal").setParameter("NDocumento", nDocumento).setParameter("idSucursal", idSucursal);
            System.out.println("TAMAÑO: "+q.list().size());
            if(q.list().isEmpty()){
                System.out.println("TODO BIEN");
                return inv = null;
            } else {
                System.out.println("SAD SO SAD");
                inv = (Facturas) q.list().get(0);
                return inv;
            }
            
        } catch (Exception e) {
            System.out.println("Error consultarInventarioProducto "+e);
            return inv;
        } finally {
            
        }

    }

    public int eliminarFactura(int idFactura) {
        Facturas fac = new Facturas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            fac = (Facturas) session.get(Facturas.class, idFactura);
            session.delete(fac);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("exito al eliminar la factura");

        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("no se pudo eliminar la factura");
            }

        } finally {
            session.close();
        }

        return flag;

    }

    public List consultarTodosFacturas() {
        List<Facturas> listaFacturas = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

       
        try {
             session.beginTransaction();
            Query q = session.createQuery("from Facturas");
            listaFacturas = (List<Facturas>) q.list();
            System.out.println("exito al consultar las facturas" +q);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al consultar las facturas. "+e.getMessage());
        } finally {

        }
        return listaFacturas;
    }
    
     public List consultarFacturasDisponibles() {
        List<Facturas> listaFacturas = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

       
        try {
             session.beginTransaction();
            Query q = session.createQuery("from Facturas f where f.estadoFactura='Disponible'");
            listaFacturas = (List<Facturas>) q.list();
            System.out.println("exito al consultar las facturas" +q);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al consultar las facturas. "+e.getMessage());
        } finally {

        }
        return listaFacturas;
    }
    
    
    
    
    
    
     public List consultarFacturasArchivadas() {
        List<Facturas> listaFacturas = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

       
        try {
             session.beginTransaction();
            Query q = session.createQuery("from Facturas f where f.estadoFactura='Archivado'");
            listaFacturas = (List<Facturas>) q.list();
            System.out.println("exito al consultar las facturas" +q);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al consultar las facturas. "+e.getMessage());
        } finally {

        }
        return listaFacturas;
    }
     
    public int ActivarFacturas(Integer idFactura,String nDocumento, String fechaVenta, Integer idSucursal) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Facturas fac = new Facturas();
        fac.setIdFactura(idFactura);
        fac.setNDocumento(nDocumento);

        fac.setFechaVenta(fechaVenta);

        Sucursales sucur = new Sucursales();
        sucur.setIdSucursal(idSucursal);
        fac.setSucursales(sucur);
        
        fac.setFechaVenta(fechaVenta);
        fac.setEstadoFactura("Disponible");

        try {
            session.beginTransaction();
            session.update(fac);
            session.getTransaction().commit();
            flag = 1;
            System.out.println(" exito al guaradar al factura");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al guaradar la factura");
            }
        } finally {
            session.close();
        }
        return flag;

    }
     public int ArchivarFacturas(Integer idFactura,String nDocumento, String fechaVenta, Integer idSucursal) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Facturas fac = new Facturas();
        fac.setIdFactura(idFactura);
        fac.setNDocumento(nDocumento);

        fac.setFechaVenta(fechaVenta);

        Sucursales sucur = new Sucursales();
        sucur.setIdSucursal(idSucursal);
        fac.setSucursales(sucur);
        
        fac.setFechaVenta(fechaVenta);
        fac.setEstadoFactura("Archivado");

        try {
            session.beginTransaction();
            session.update(fac);
            session.getTransaction().commit();
            flag = 1;
            System.out.println(" exito al guaradar al factura");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al guaradar la factura");
            }
        } finally {
            session.close();
        }
        return flag;

    }

}
