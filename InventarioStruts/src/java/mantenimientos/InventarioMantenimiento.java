package mantenimientos;

import mantenimientos.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencias.Inventario;
import  persistencias.Productos;
import  persistencias.Proveedores;
import  persistencias.Sucursales;
import  com.myapp.struts.HibernateUtil;

public class InventarioMantenimiento {

    public static void main(String[] args) {
        
        InventarioMantenimiento m = new InventarioMantenimiento();
        
        /*-- GUARDAR --*/
        
        /*
        int idInventario = 0;
        int idProducto = 1;
        int cant = 7;
        int stock = 3;
        String estado = "yoooo";
        int idProveedor = 1;
        int idSucursal = 1;
        
        int r = m.guardarInventario(idInventario, idProducto, cant, stock, estado, idProveedor, idSucursal);
        System.exit(0);
        */
        
        /*-- ACTUALIZAR --*/
        /*
        m.ActualizarInventario(1, 1, 10, 5, "Disponible", 1, 1);
        */
        
        /*--- CONSULTAR TODOS---*/
        /*
        List<Inventario> list = m.consultarTodosInventario();
        System.out.println(list);
        */
        
        /* --- CONSULTAR UNO ---*/
        /*
        Inventario mostrarU = m.consultarInventario(5);
        System.out.println(mostrarU);
        */
        
        // --- CONSULTAR UNO ---
        
        Inventario mostrarU = m.consultarInventarioProducto(1);
        System.out.println(mostrarU);
        
        
        /* --- ELIMINAR ---*/
        /*
        int eliminar = m.eliminarInventario(1);
        */
    }

    public int guardarInventario(Integer idInventario, int idProducto, Integer cant, Integer stock, String estado,
        int idProveedor, int idSucursal) {
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Inventario inv = new Inventario();
        inv.setIdInventario(idInventario);
        
        Productos r = new Productos();
        r.setIdProducto(idProducto);
        inv.setProductos(r);
        
        inv.setCant(cant);
        inv.setStock(stock);
        inv.setEstado(estado);
        
        Proveedores prov = new Proveedores(); 
        prov.setIdProveedor(idProveedor);
        inv.setProveedores(prov);
        
        Sucursales s = new Sucursales();
        s.setIdSucursal(idSucursal);
        inv.setSucursales(s);
        
        try {
            session.beginTransaction();
            session.save(inv);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Se ha guardado el inventario.");
            
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            System.out.println("Ha ocurrido un error al guardar el inventario "+e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int ActualizarInventario(Integer idInventario, int idProducto, Integer cant, Integer stock,
        String estado, int idProveedor, int idSucursal) {
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Inventario inv = new Inventario();
        inv.setIdInventario(idInventario);

        Productos r = new Productos();
        r.setIdProducto(idProducto);
        inv.setProductos(r);

        inv.setCant(cant);
        inv.setStock(stock);
        inv.setEstado(estado);
        
        Proveedores p = new Proveedores(); 
        p.setIdProveedor(idProveedor);
        inv.setProveedores(p);

        Sucursales s = new Sucursales();
        s.setIdSucursal(idSucursal);
        inv.setSucursales(s);
        
        session.beginTransaction();
        
        try {
            
            session.update(inv);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Se ha actualizado el inventario.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error Actualizar Inventario "+e);
            }
        } finally {
            session.close();
        }
        return flag;
    }
        
    public Inventario consultarInventario(Integer idInventario) {
        Inventario inv = new Inventario();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            inv = (Inventario) session.get(Inventario.class, idInventario);
            session.getTransaction().commit();
            System.out.println("Consulta de inventario exitosa.");
            return inv;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al intentar consultar "+e.getMessage());
            }
        } finally {
            session.close();
        }
        return inv;
    }
    
    public Inventario consultarInventarioProducto(int idProducto) {
        
        Inventario inv = new Inventario();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        try {
            
            Query q = session.createQuery("FROM Inventario i where i.productos.idProducto=:producto").setParameter("producto", idProducto);
            System.out.println("TAMAÑO: "+q.list().size());
            if(q.list().isEmpty()){
                System.out.println("No éxiste el producto, puede ocuparlo");
                return inv = null;
            } else {
                System.out.println("El producto ya existe en el Inventario");
                return inv;
            }
            
        } catch (Exception e) {
            System.out.println("Error consultarInventarioProducto "+e);
            return inv;
        } finally {
            
        }

    }

    public int eliminarInventario(Integer idInventario) {
        Inventario inv = new Inventario();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        session.beginTransaction();
        
        try {
            
            inv = (Inventario) session.get(Inventario.class, idInventario);
            session.delete(inv);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Registro eliminado.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error Eliminar Inventario "+e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosInventario() {
        List<Inventario> listaInventario = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        
        try {
            
            Query q = session.createQuery("from Inventario");
            listaInventario = (List<Inventario>) q.list();
            System.out.println("Consulta de inventario exitosa");
        } catch (Exception e) {
            System.out.println("Error Consultar Inventario "+e);
        } finally {
            
        }
        return listaInventario;
    }
}
