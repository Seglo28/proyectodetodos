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
        /*/
        List<Compras> list;
        list = mant.consultarTodosCompras();
        System.out.println(list);
        System.exit(0);
        */

        /* ----- Eliminar ----- */
        /*
        int borrar = mant.eliminarCompra(2);
*/
        ////////// - consultar Por id-//////
        
     /*   int idCompra = 2;
        List<Compras> listaCompras = null;
        listaCompras = (List<Compras>) mant.consultarCompra(idCompra);
        System.out.println(listaCompras);
        System.exit(0);
*/
        
    }

    public int guardarCompras(String nDocumento, Integer idProductos, Integer idProveedores, Integer cantidad,
            Double monto, String fechaCompras) {
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Compras com = new Compras();
        
        com.setIdCompra(0);
        com.setnDocumento(nDocumento);
        
        Productos producto = new Productos();
        producto.setIdProducto(idProductos);
        com.setProductos(producto);
        
        Proveedores proveedor = new Proveedores();
        proveedor.setIdProveedor(idProveedores);
        com.setProveedores(proveedor);
        
        com.setCantidad(cantidad);
        com.setMonto(monto);
        com.setFechaCompra(fechaCompras);

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
    public int ActualizarCompras(Integer idCompra, Integer idProductos, Integer idProveedores, Integer cantidad,
            Double monto, String fechaCompras) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Compras com = new Compras();
        com.setIdCompra(idCompra);
        
        Productos producto = new Productos();
        producto.setIdProducto(idProductos);
        com.setProductos(producto);
        
        Proveedores proveedor = new Proveedores();
        proveedor.setIdProveedor(idProveedores);
        com.setProveedores(proveedor);
        
        com.setCantidad(cantidad);
        com.setMonto(monto);
        com.setFechaCompra(fechaCompras);

        try {
            session.beginTransaction();
            session.update(com);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Si modificó la Compra");
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

    public List consultarTodosCompras() {
        List<Compras> listaCompras = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Compras");
            listaCompras = (List<Compras>) q.list();
            
            System.out.println("Consulta Exitosa Compras");
        } catch (Exception e) {
            System.out.println("Falló consultar Compras "+e);
        } finally {

        }
        return listaCompras;
    }


}