package mantenimientos;

import mantenimientos.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencias.Fabricantes;
import persistencias.Productos;
import persistencias.Proveedores;
import  com.myapp.struts.HibernateUtil;

public class ProductosMantenimiento {

    public static void main(String[] args) {

        ProductosMantenimiento man = new ProductosMantenimiento();
        // --- GUARDAR ---
        /*
        int r = man.guardarProductos(idFabricantes, idProveedores, producto);
        System.out.println();
        */
        
        // --- MODIFICAR ---
        
        int r = man.ActualizarProductos(4, 2, 1, "Porozas");
        System.out.println("R: "+r);
        
        
    }

    public int guardarProductos(int idFabricantes, int idProveedores, String producto) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        Productos prod = new Productos();
        

        Fabricantes fabr = new Fabricantes();
        fabr.setIdFabricante(idFabricantes);
        prod.setFabricantes(fabr);

        Proveedores prov = new Proveedores();
        prov.setIdProveedor(idProveedores);
        prod.setProveedores(prov);

        prod.setProducto(producto);
        try {
            session.beginTransaction();
            session.save(prod);
            session.getTransaction().commit();
            flag = 1;
            System.out.println(" exito al  guardar  el producto");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error el ingresar los datos del porducto " + e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int ActualizarProductos(Integer idProducto, Integer idFabricantes, Integer idProveedores, String producto) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        Productos prod = new Productos();
        prod.setIdProducto(idProducto);
        prod.setProducto(producto);

        Fabricantes fabr = new Fabricantes();
        fabr.setIdFabricante(idFabricantes);
        prod.setFabricantes(fabr);

        Proveedores prov = new Proveedores();
        prov.setIdProveedor(idProveedores);
        prod.setProveedores(prov);

        session.beginTransaction();
        
        try {
            
            session.update(prod);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Exito al actualizar el producto");

        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error al  actualizar el producto "+e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Productos consultarProductoId(int idProducto) {
        Productos prod = new Productos();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            prod = (Productos) session.get(Productos.class, idProducto);
            session.getTransaction().commit();
            System.out.println(" exito al consulatar los datos de producto");
            return prod;

        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println(" error al consultar el productos");
            }

        } finally {
            session.close();
        }
        return prod;

    }

    public int eliminarProducto(int idProducto) {
        Productos prod = new Productos();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        int flag = 0;

        try {
            session.beginTransaction();
            prod = (Productos) session.get(Productos.class, idProducto);
            session.delete(prod);

            session.getTransaction().commit();
            flag = 1;
            System.out.println(" exito al eliminar el producto");

        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println(" error al eliminar  el producto "+e);
            }

        } finally {
            session.close();
        }

        return flag;

    }

    public List consultarTodosProductos() {
        List<Productos> listaProductos = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Productos");
            listaProductos = (List<Productos>) q.list();
            System.out.println(" exitpo al al consulatr los productos");

        } catch (Exception e) {
            System.out.println("Error al consulatr los productos "+e);
        } finally {

        }
        return listaProductos;
    }
    
    public Productos consultarNombreProducto(String producto) {
        Productos prod = new Productos();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            
            Query q = session.createQuery("FROM  Productos prod where prod.producto=:producto").setParameter("producto", producto);
            System.out.println("TAMAÑO: "+q.list().size());
            if(q.list().isEmpty()){
                System.out.println("No éxiste el producto, puede ocupar este nombre");
                return prod = null;
            } else {
                System.out.println("El producto ya existe en el sistema.....");
                return prod;
            }
            
        } catch (Exception e) {
            System.out.println("Error consultarNombreProducto"+e);
            return prod = null;
        } finally {
            session.close();
        }

    }

}
