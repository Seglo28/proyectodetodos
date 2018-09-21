
package mantenimientos;

import org.hibernate.SessionFactory;
import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencias.Usuario;

public class MantenimientoUsuario {
    
    public static void main(String[] args) {
        MantenimientoUsuario mant = new MantenimientoUsuario();
        
        //---- CONSULTAR POR ID ----
    /*    int id = 1;
        Usuario user = mant.consultaUserId(id);
        System.out.println("Consulta por Id: "+id);
        System.out.println("Datos: "+user.toString());
    */    
    
        //--- MODIFICAR ---
    /*
        mant.modificarUser(3, "Memy", "memyta@usam.com", "memyta@usam.com", "Secretaria1");
    */
    
    }
    
    public int guardarUser(String usuario, String correo, String contra, String cargo){
        SessionFactory fac = HibernateUtil.getSessionFactory();
        Session sess = fac.openSession();
        int flag = 0;
        
        Usuario user = new Usuario();
        user.setIdUsuario(0);
        user.setUsuario(usuario);
        user.setCorreo(correo);
        user.setContra(contra);
        user.setCargo(cargo);
        sess.beginTransaction();
        
        try {
            
            sess.save(user);
            sess.getTransaction().commit();
            flag = 1;
            System.out.println("Éxito al guardar usuario");
            
        } catch (Exception e) {
            if(sess.getTransaction().isActive()){
                sess.getTransaction().rollback();
                flag = 0;
                System.out.println("Error Guardar Usuario "+e);
            }
        } finally {
            sess.close();
        }
        
        return flag;
    }
    
    public List consultarUser(){
        List<Usuario> list = null;
        
        SessionFactory fac = HibernateUtil.getSessionFactory();
        Session sess = fac.openSession();
        sess.beginTransaction();
        
        try {
            
            Query q = sess.createQuery("from Usuario");
            list = (List<Usuario>) q.list();
            System.out.println("Éxito ConsultarUser");
            
        } catch (Exception e) {
            System.out.println("Error ConsultarUser "+e);
        } finally {
            sess.close();
        }
        
        return list;
    }
    
    public Usuario consultaUserId(int idUsuario){
        Usuario user = new Usuario();
        SessionFactory fac = HibernateUtil.getSessionFactory();
        Session sess = fac.openSession();
        sess.beginTransaction();
        
        try {
            
            user = (Usuario) sess.get(Usuario.class, idUsuario);
            sess.getTransaction().commit();
            System.out.println("Éxito consultaUserID");
            
        } catch (Exception e) {
            if(sess.getTransaction().isActive()){
                sess.getTransaction().rollback();
                System.out.println("Error consultaUserId "+e);
            }
        } finally {
            sess.close();
        }
        
        return user;
    }
    
    public Usuario consultaUserUsuario(String correo){
        Usuario user = new Usuario();
        SessionFactory fac = HibernateUtil.getSessionFactory();
        Session sess = fac.openSession();
        sess.beginTransaction();
        
        try {
            
            Query q = sess.createQuery("FROM Usuario us where us.correo=:correo").setParameter("correo", correo);
            System.out.println("TAMAÑO: "+q.list().size());
            if(q.list().isEmpty()){
                System.out.println("No éxiste correo, lo puede ocupar");
                return user = null;
            } else {
                System.out.println("El correo ya existe");
                return user;
            }
            
        } catch (Exception e) {
            System.out.println("Error consultaUserUsuario "+e);
            return user = null;
        } finally {
            sess.close();
        }

    }
    
    public int modificarUser(int id, String usuario, String correo, String contra, String cargo){
        SessionFactory fac = HibernateUtil.getSessionFactory();
        Session sess = fac.openSession();
        int flag = 0;
        
        Usuario user = new Usuario();
        user.setIdUsuario(id);
        user.setUsuario(usuario);
        user.setCorreo(correo);
        user.setContra(contra);
        user.setCargo(cargo);
        sess.beginTransaction();
        
        try {
            
            sess.update(user);
            sess.getTransaction().commit();
            flag = 1;
            System.out.println("Éxito al modificar usuario");
            
        } catch (Exception e) {
            if(sess.getTransaction().isActive()){
                sess.getTransaction().rollback();
                flag = 0;
                System.out.println("Error Modificar Usuario "+e);
            }
        } finally {
            sess.close();
        }
        
        return flag;
    }
    
    public int eliminarUser(int id){
        Usuario user = new Usuario();
        SessionFactory fac = HibernateUtil.getSessionFactory();
        Session sess = fac.openSession();
        sess.beginTransaction();
        int flag = 0;
        
        try {
            
            user = (Usuario) sess.get(Usuario.class, id);
            sess.delete(user);
            sess.getTransaction().commit();
            flag = 1;
            System.out.println("Éxito eliminar User");
            
        } catch (Exception e) {
            if(sess.getTransaction().isActive()){
                sess.getTransaction().rollback();
                flag = 0;
                System.out.println("Error eliminar Mant User "+e);
            }
        } finally {
            sess.close();
        }
        
        return flag;
    }

    public Usuario entrar(String correo, String contra){
        Usuario user = new Usuario();
        SessionFactory fac = HibernateUtil.getSessionFactory();
        Session sess = fac.openSession();
        try {
            //sess.beginTransaction();
            Query q = sess.createQuery("FROM Usuario us where us.correo=:correo AND us.contra=:contra").setParameter("correo", correo).setParameter("contra", contra);
            System.out.println("TAMAÑO: "+q.list().size());
        //    user = q.list().size()>0?(Usuario) q.list().get(0):null;
            if(q.list().isEmpty()){
                System.out.println("El registro es incorrecto");
                return user = null;
            } else {
                System.out.println("Éxito Entrar");
                return user;
            }
            
        } catch (Exception e) {
            System.out.println("Error entrar "+e);
            return user = null;
        } finally {
            sess.close();
        }
    }
    
     public List consultarTodosUsuarios() {
        List<Usuario> listaUsu = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction(); 
            Query q = session.createQuery("from Usuario");
            listaUsu = (List<Usuario>) q.list();
            System.out.println("Consulta a todos los usuarios exitosa");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al consultar todos los usuario. "+e.getMessage());
        } finally {
        }
        return listaUsu;
    }
    
}
