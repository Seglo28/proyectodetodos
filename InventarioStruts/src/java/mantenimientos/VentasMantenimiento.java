package mantenimientos;

import mantenimientos.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencias.Clientes;
import persistencias.Productos;
import persistencias.Usuario;
import persistencias.Ventas;
import com.myapp.struts.HibernateUtil;
import persistencias.Inventario;
import persistencias.Sucursales;

public class VentasMantenimiento {

    public static void main(String[] args) {
        VentasMantenimiento vm = new VentasMantenimiento();
        Integer idCliente=1;
        Integer idInventario=1;
        Integer idProducto=1; 
        Integer idUsuario=1;
        Integer idSucursal=1;
        Integer cantidad=45;
        Double monto= 20.30;
        String nDocumento="n-hgsdfhg-6";
        String fechaVenta="11/15/16 12:36AM";
        //// ---------------- insertar--------------------//////////
        
        int r= vm. guardarVenta(idCliente, idInventario, nDocumento, idProducto, idUsuario, idSucursal, cantidad, monto, fechaVenta);
        System.out.println(r);
        
        //  /---- actualizar---------------////

        /*
        int r= vm.ActualizarVenta(8, 1, 4, 1, 1, 22, 22.45, "mañana");
        System.out.println(r);
         */
        ////----- eliminar-------///////////
        /*
         int idVenta=3;
      int r=vm.eliminarVentas(idVenta);
      System.out.println(r);
        System.exit(0);
         */
        //////*********** consultar id*/////////////////////
        /*  int idVenta=5;
        Ventas ven= vm.consultarVentas(idVenta);
        System.out.println(ven.getIdVenta());
        System.out.println(ven.getClientes().getIdCliente());
        System.out.println(ven.getProductos().getIdProducto());
        System.out.println(ven.getUsuario().getIdUsuario());
        System.out.println(ven.getCantidad());
        System.out.println(ven.getMonto());
         */
        ////------------- consultar Todos--------------/////
        /*
        vm.eliminarVentas(8);
*/
    }

    public int guardarVenta(Integer idCliente, Integer idInventario,String nDocumento, Integer idProducto, Integer idUsuario, Integer idSucursal, Integer cantidad,
            Double monto, String fechaVenta) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Ventas ven = new Ventas();

        ven.setIdVenta(0);
        ven.setNDocumento(nDocumento);
        
        Clientes cli = new Clientes();
        cli.setIdCliente(idCliente);
        ven.setClientes(cli);
        
        Inventario inv = new Inventario();
        inv.setIdInventario(idInventario);
        ven.setInventario(inv);

        Productos prod = new Productos();
        prod.setIdProducto(idProducto);
        ven.setProductos(prod);

        Usuario usu = new Usuario();
        usu.setIdUsuario(idUsuario);
        ven.setUsuario(usu);

        Sucursales suc = new Sucursales();
        suc.setIdSucursal(idSucursal);
        ven.setSucursales(suc);

        ven.setCantidad(cantidad);
        ven.setMonto(monto);
        ven.setFechaVenta(fechaVenta);
        ven.setEstadoVenta("Disponible");

        try {
            session.beginTransaction();
            session.save(ven);
            session.getTransaction().commit();
            flag = 1;
            System.out.println(" exito al guardar la venta");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error al guardar la venta " + e);
            }
        } finally {
            session.close();
        }
        return flag;

    }
    public Ventas valNDoc(String NDocumento){
        Ventas com = new Ventas();
        SessionFactory fac = HibernateUtil.getSessionFactory();
        Session sess = fac.openSession();
        
        try {
            
            Query q = sess.createQuery("FROM Ventas v where v.NDocumento=:NDocumento").setParameter("NDocumento", NDocumento);
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

    public int ActualizarVenta(Integer idVenta,Integer idCliente, Integer idInventario,String nDocumento, Integer idProducto, Integer idUsuario, Integer idSucursal, Integer cantidad,
            Double monto, String fechaVenta,String estadoVenta) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        Ventas ven = new Ventas();

        ven.setIdVenta(idVenta);
        
        Clientes cli = new Clientes();
        cli.setIdCliente(idCliente);
        ven.setClientes(cli);

        Productos prod = new Productos();
        prod.setIdProducto(idProducto);
        ven.setProductos(prod);

        Usuario usu = new Usuario();
        usu.setIdUsuario(idUsuario);
        ven.setUsuario(usu);

        Sucursales suc = new Sucursales();
        suc.setIdSucursal(idSucursal);
        ven.setSucursales(suc);

        ven.setCantidad(cantidad);
        ven.setMonto(monto);
        ven.setFechaVenta(fechaVenta);
        ven.setEstadoVenta(estadoVenta);

        try {
            session.beginTransaction();
            session.saveOrUpdate(ven);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Exito al actualizar la venta");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error al actualizar la venta " + e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Ventas consultarVentas(Integer idVenta) {

        Ventas ven = new Ventas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            ven = (Ventas) session.get(Ventas.class, idVenta);
            session.getTransaction().commit();
            System.out.println("Exito al consultar por Id la venta");
            return ven;
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al Consultar  por las Ventas " + ex);
            }
        } finally {
            session.close();
        }
        return ven;
    }

    public int eliminarVentas(Integer idVenta) {

        Ventas ven = new Ventas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
            ven = (Ventas) session.get(Ventas.class, idVenta);
            session.delete(ven);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Exito al eliminar Venta");

        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error al eliminar Venta " + ex);
            }

        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosVentas() {
        List<Ventas> listaVentas = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Ventas");
            listaVentas = (List<Ventas>) q.list();
            System.out.println("exito al consultar todo");
        } catch (Exception e) {
            System.out.println("Error Consultar Lista Ventas " + e);
        } finally {
        }
        return listaVentas;
    }
    
    
     public List consultarVentasDisponibles() {
        List<Ventas> listaVentas = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            
            Query q = session.createQuery("FROM Ventas v where v.estadoVenta='Disponible'");
            System.out.println("TAMAÑO: "+q.list().size());
            listaVentas = q.list();
            
            System.out.println("Éxito Consulta Ventas Disponibles");
        } catch (Exception e) {
            System.out.println("Falló consultar Ventas Disponibles "+e);
        } finally {

        }
        return listaVentas;

    }

    public List consultarVentasArchivadas() {
        List<Ventas> listaVentas = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            
            Query q = session.createQuery("FROM Ventas v where v.estadoVenta='Archivado'");
            System.out.println("TAMAÑO: "+q.list().size());
            listaVentas = q.list();
            
            System.out.println("Éxito  Consulta Ventas Archivadas");
        } catch (Exception e) {
            System.out.println("Falló  Consulta Ventas Archivadas "+e);
        } finally {

        }
        return listaVentas;

    }
    
     public int archivarVenta(Integer idVenta,Integer idCliente, Integer idInventario,String nDocumento, Integer idProducto, Integer idUsuario, Integer idSucursal, Integer cantidad,
            Double monto, String fechaVenta) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        Ventas ven = new Ventas();

        ven.setIdVenta(idVenta);
        
        Clientes cli = new Clientes();
        cli.setIdCliente(idCliente);
        ven.setClientes(cli);
        
        Inventario inv = new Inventario();
        inv.setIdInventario(idInventario);
        ven.setInventario(inv);
        
        ven.setNDocumento(nDocumento);

        Productos prod = new Productos();
        prod.setIdProducto(idProducto);
        ven.setProductos(prod);

        Usuario usu = new Usuario();
        usu.setIdUsuario(idUsuario);
        ven.setUsuario(usu);

        Sucursales suc = new Sucursales();
        suc.setIdSucursal(idSucursal);
        ven.setSucursales(suc);

        ven.setCantidad(cantidad);
        ven.setMonto(monto);
        ven.setFechaVenta(fechaVenta);
        ven.setEstadoVenta("Archivado");

        try {
            session.beginTransaction();
            session.update(ven);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Exito al actualizar la venta");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error al actualizar la venta " + e);
            }
        } finally {
            session.close();
        }
        return flag;
    }
    
    public int activarVenta(Integer idVenta,Integer idCliente, Integer idInventario,String nDocumento, Integer idProducto, Integer idUsuario, Integer idSucursal, Integer cantidad,
            Double monto, String fechaVenta) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        Ventas ven = new Ventas();

        ven.setIdVenta(idVenta);
        
        Clientes cli = new Clientes();
        cli.setIdCliente(idCliente);
        ven.setClientes(cli);
        
        Inventario inv = new Inventario();
        inv.setIdInventario(idInventario);
        ven.setInventario(inv);
        
        ven.setNDocumento(nDocumento);

        Productos prod = new Productos();
        prod.setIdProducto(idProducto);
        ven.setProductos(prod);

        Usuario usu = new Usuario();
        usu.setIdUsuario(idUsuario);
        ven.setUsuario(usu);

        Sucursales suc = new Sucursales();
        suc.setIdSucursal(idSucursal);
        ven.setSucursales(suc);

        ven.setCantidad(cantidad);
        ven.setMonto(monto);
        ven.setFechaVenta(fechaVenta);
        ven.setEstadoVenta("Disponible");

        try {
            session.beginTransaction();
            session.update(ven);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Exito al actualizar la venta");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error al actualizar la venta " + e);
            }
        } finally {
            session.close();
        }
        return flag;
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
}
