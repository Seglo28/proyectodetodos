package mantenimientos;

import mantenimientos.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencias.Fabricantes;
import  com.myapp.struts.HibernateUtil;

public class FabricantesMantenimiento {

    public static void main(String[] args) {

        FabricantesMantenimiento m = new FabricantesMantenimiento();
        
        /*--- AGREGAR ---*/
        /*
        Integer idFabricante = 0;
        String fabricante = "Gloria";
        String direccion = "Sierra Morena, Soyapango";
        String telefono = "7869-4826";
        
        int agregar = m.guardarFabricantes(idFabricante, fabricante, direccion, telefono);
        System.out.println(agregar);
        */
        
        /*--- MOSTRAR UNO ---*/
        /*
        Fabricantes mt = m.consultarFabricante(6);
        System.out.println(mt);
        */
        
        /*--- ELIMIMAR ---*/
        /*
        int r= m.eliminarFabricante(6);
          System.out.println(r);
*/
        
        /*--- MOSTRAR TODOS ---*/
        /*
        List<Fabricantes>listfabricantes=m.consultarTodosFabricantes();
     for( Fabricantes fabr:listfabricantes()){
         System.out.println( fabr.getIdFabricante());
         System.out.println(fabr.getFabricante());
         System.out.println(fabr.getDireccion());
         System.out.println(fabr.getTelefono());
  
         System.exit(0);
        */
        
        /*--- MOSTRAR UNO ---*/
        /*
        Fabricantes mu = m.consultarFabricante(2);
        System.out.println(mu);
        */
        
        /*--- ACTUALIZAR ---*/
        /*
        m.ActualizarFabricantes(3, "fabricante", "direccion", "telefono");
        */
        ///// consultar por id----/////
        /*
        int idFabricante = 1;
        Fabricantes fabr = m.consultarFabricante(idFabricante);
         System.out.println( fabr.getIdFabricante());
         System.out.println(fabr.getFabricante());
         System.out.println(fabr.getDireccion());
         System.out.println(fabr.getTelefono());
  
         System.exit(0);
        
        */
        
        
    }

    public int guardarFabricantes(String fabricante, String direccion, String telefono) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Fabricantes fabr = new Fabricantes();
        fabr.setIdFabricante(0);
        fabr.setFabricante(fabricante);
        fabr.setDireccion(direccion);
        fabr.setTelefono(telefono);
        try {
            session.beginTransaction();
            session.save(fabr);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Registro de fabricante exitoso.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error al intentar registrar fabricante: "+e);
            }
        } finally {
            session.close();
        }
        return flag;
    }
    
    public int ActualizarFabricantes(Integer idFabricante,
            String fabricante,
            String direccion,
            String telefono) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Fabricantes fabr = new Fabricantes();
        fabr.setIdFabricante(idFabricante);
        fabr.setFabricante(fabricante);
        fabr.setDireccion(direccion);
        fabr.setTelefono(telefono);
        try {
            session.beginTransaction();
            session.update(fabr);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Actualización de fabricante exitoso.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al intentar actualizar fabricante.");
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Fabricantes consultarFabricante(Integer idFabricante) {
        Fabricantes fab = new Fabricantes();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            fab = (Fabricantes) session.get(Fabricantes.class, idFabricante);
            session.getTransaction().commit();
            if(fab==null){
                System.out.println("Los datos sobre el Fabricante solicitado han sido eliminados previamente del sistema.");
            } else{
                System.out.println("Este es el fabricante solicitado. "+idFabricante);
            }
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al mostrar dato de fabricante." +e.getMessage());
            }
        } finally {
            session.close();
        }
        System.out.println("retutn "+fab);
        return fab;
    }

    public int eliminarFabricante(int idFabricante) {
        Fabricantes fab = new Fabricantes();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        session.beginTransaction();
        try {
            fab = (Fabricantes) session.get(Fabricantes.class, idFabricante);
            session.delete(fab);
            session.getTransaction().commit();
              flag = 1;
            System.out.println("Se han eliminado los registros del fabricante seleccionado.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                  flag = 1;
                System.out.println("Error al eliminar el fabricante. "+e.getMessage());
            }
          
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosFabricantes() {
        List<Fabricantes> listaFabricantes = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Fabricantes");
            listaFabricantes = (List<Fabricantes>) q.list();
            
            System.out.println("Todos los fabricantes se estan mostrando.");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al mostrar todos los fabricantes. "+e.getMessage());
        } finally {
        }
        return listaFabricantes;
    }
     public Fabricantes consultarNombreFabricante(String fabricante) {
        Fabricantes fab = new Fabricantes();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            
            Query q = session.createQuery("FROM Fabricantes f where f.fabricante=:fabricante").setParameter("fabricante", fabricante);
            System.out.println("TAMAÑO: "+q.list().size());
            if(q.list().isEmpty()){
                System.out.println("No éxiste el fabricante, lo puede ocupar");
                return fab = null;
            } else {
                System.out.println("El fabricante ya existe");
                return fab;
            }
            
        } catch (Exception e) {
            System.out.println("Error consultarNombreFabricante "+e);
            return fab = null;
        } finally {
            session.close();
        }
    }
}
