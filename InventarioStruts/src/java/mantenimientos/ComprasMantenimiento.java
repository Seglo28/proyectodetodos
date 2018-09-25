package mantenimientos;

import mantenimientos.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencias.Compras;
import persistencias.Productos;
import persistencias.Proveedores;
import  com.myapp.struts.HibernateUtil;

public class ComprasMantenimiento {

public static void main(String[] args) {
        ComprasMantenimiento mant = new ComprasMantenimiento();
        
        // ------ Guardar -------- 
        /*
        int r = mant.guardarCompras("F-010203-N", 1, 1, 10, 10.0, "24/09/2018 04:24 PM");
        System.out.println("Respuesta: "+r);
        System.exit(0);
        */
        
        // ----- Actualizar -----
        /*
        int actua = mant.ActualizarCompras(1, 1, 2, 20, 6.50, "10/01/2018 17:32");
        */
        
        // ----- Consultar -----
        /*
        List<Compras> list;
        list = mant.consultarTodosCompras();
        System.out.println(list.toString());
        
        List<Compras> list2;
        list2 = mant.consultarComprasDisponibles();
        System.out.println(list2.toString());
        System.exit(0);
        */

        // ----- Eliminar ----- 
        /*
        int borrar = mant.eliminarCompra(2);
        */
        // ---- consultar Por ID ----
        
        /*   
        int idCompra = 2;
        List<Compras> listaCompras = null;
        listaCompras = (List<Compras>) mant.consultarCompra(idCompra);
        System.out.println(listaCompras);
        System.exit(0);
        */
        
    }

    public int guardarCompras(String nDocumento, Integer idProducto, Integer cantidad, Double monto, Integer idProveedor,
            String fechaCompra) {
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Compras com = new Compras();
        
        com.setIdCompra(0);
        com.setNDocumento(nDocumento);
        
        Productos producto = new Productos();
        producto.setIdProducto(idProducto);
        com.setProductos(producto);
        
        com.setCantidad(cantidad);
        com.setMonto(monto);
        
        Proveedores proveedor = new Proveedores();
        proveedor.setIdProveedor(idProveedor);
        com.setProveedores(proveedor);
        
        com.setFechaCompra(fechaCompra);
        com.setEstadoCompra("Disponible");

        try {
            session.beginTransaction();
            session.save(com);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Éxito al guardar Compra");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error al guardar Compra "+e);
            }
        } finally {
            session.close();
        }
        return flag;

    }
    public int actualizarCompras(Integer idCompra, String nDocumento, Integer idProducto, Integer cantidad, Double monto, 
            Integer idProveedor, String fechaCompra, String estadoCompra) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Compras com = new Compras();
        com.setIdCompra(idCompra);
        com.setNDocumento(nDocumento);
        
        Productos producto = new Productos();
        producto.setIdProducto(idProducto);
        com.setProductos(producto);
        
        com.setCantidad(cantidad);
        com.setMonto(monto);
        
        Proveedores proveedor = new Proveedores();
        proveedor.setIdProveedor(idProveedor);
        com.setProveedores(proveedor);
        
        com.setFechaCompra(fechaCompra);
        com.setEstadoCompra(estadoCompra);

        try {
            session.beginTransaction();
            session.update(com);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Se modificó la Compra");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("No se actualizó la Compra "+e);
            }
        } finally {
            session.close();
        }
        return flag;

    }

    public Compras consultarCompra(Integer idCompra) {
        Compras com = new Compras();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            
            com = (Compras) session.get(Compras.class, idCompra);
            session.getTransaction().commit();
            System.out.println("Exito ConsultaPorId Compra" );
            return com;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error consultaPorId Compra "+e);
            }
            
        } finally {
            session.close();
        }
        return com;
    }
    
    public Compras valNDoc(String NDocumento){
        Compras com = new Compras();
        SessionFactory fac = HibernateUtil.getSessionFactory();
        Session sess = fac.openSession();
        
        try {
            
            Query q = sess.createQuery("FROM Compras c where c.NDocumento=:NDocumento").setParameter("NDocumento", NDocumento);
            System.out.println("TAMAÑO: "+q.list().size());
        
            if(q.list().isEmpty()){
                System.out.println("Sirve");
                return com = null;
            } else {
                System.out.println("No funciona para factura");
                return com;
            }
            
        } catch (Exception e) {
            System.out.println("Error valNDoc "+e);
            return com = null;
        } finally {
            sess.close();
        }
    }

    public int eliminarCompra(Integer idCompra) {
        Compras com = new Compras();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
       
        try {
            session.beginTransaction();
            com = (Compras) session.get(Compras.class, idCompra);
            session.delete(com);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Elimina Correctamente Compras");

        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error Eliminar Compra "+e);
            }
        } finally {
            session.close();
        }

        return flag;

    }

    public List consultarComprasDisponibles() {
        List<Compras> listaCompras = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            
            Query q = session.createQuery("FROM Compras c where c.estadoCompra='Disponible'");
            System.out.println("TAMAÑO: "+q.list().size());
            listaCompras = q.list();
            
            System.out.println("Éxito Consulta Compras Disponibles");
        } catch (Exception e) {
            System.out.println("Falló consultar Compras Disponibles "+e);
        } finally {

        }
        return listaCompras;

    }

    public List consultarComprasArchivadas() {
        List<Compras> listaCompras = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            
            Query q = session.createQuery("FROM Compras c where c.estadoCompra='Archivado'");
            System.out.println("TAMAÑO: "+q.list().size());
            listaCompras = q.list();
            
            System.out.println("Éxito Consulta Compras Archivadas");
        } catch (Exception e) {
            System.out.println("Falló consultar Compras Archivadas "+e);
        } finally {

        }
        return listaCompras;

    }
    
    public int archivarCompras(Integer idCompra, String nDocumento, Integer idProducto, Integer cantidad, Double monto, 
            Integer idProveedor, String fechaCompra) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Compras com = new Compras();
        com.setIdCompra(idCompra);
        com.setNDocumento(nDocumento);
        
        Productos producto = new Productos();
        producto.setIdProducto(idProducto);
        com.setProductos(producto);
        
        Proveedores proveedor = new Proveedores();
        proveedor.setIdProveedor(idProveedor);
        com.setProveedores(proveedor);
        
        com.setCantidad(cantidad);
        com.setMonto(monto);
        com.setFechaCompra(fechaCompra);
        com.setEstadoCompra("Archivado");

        try {
            session.beginTransaction();
            session.update(com);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Se archivó la Compra");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("No se archivó la Compra "+e);
            }
        } finally {
            session.close();
        }
        return flag;

    }
    
    public int activarCompra(Integer idCompra, String nDocumento, Integer idProducto, Integer cantidad, Double monto, 
            Integer idProveedor, String fechaCompra) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Compras com = new Compras();
        com.setIdCompra(idCompra);
        com.setNDocumento(nDocumento);
        
        Productos producto = new Productos();
        producto.setIdProducto(idProducto);
        com.setProductos(producto);
        
        Proveedores proveedor = new Proveedores();
        proveedor.setIdProveedor(idProveedor);
        com.setProveedores(proveedor);
        
        com.setCantidad(cantidad);
        com.setMonto(monto);
        com.setFechaCompra(fechaCompra);
        com.setEstadoCompra("Disponible");

        try {
            session.beginTransaction();
            session.update(com);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Se archivó la Compra");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("No se archivó la Compra "+e);
            }
        } finally {
            session.close();
        }
        return flag;

    }

}