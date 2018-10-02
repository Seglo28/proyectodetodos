package mantenimientos;

import mantenimientos.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencias.Clientes;
import  com.myapp.struts.HibernateUtil;

public class ClienteMantenimiento {

    public static void main(String[] args) {
/*
        ClienteMantenimiento m = new ClienteMantenimiento();
        
        List mt=m.consultarTodosClientes();
        System.out.println(mt);
        */
        
        /*--- GUARDAR ---*/
        /*
        Integer idCliente = 0;
        String cliente = "Delmy";
        String tipoPersona = "Natural";
        String direccion = "Tutumacayan";
        String telefono = "Es pobre xD";
        
        int guardar = m.guardarClientes(0, cliente, tipoPersona, direccion, telefono);
        System.out.println(guardar);
*/
        
        /*--- ACTUALIZAR ---*/
        /*
        int actualizar = m.actualizarClientes(3, "Gloria", "Natural", "Sierra Morena, Soyapango", "2287-8991");
        System.out.println(actualizar);
        */
        
        /*--- ELIMINAR ---*/
        /*
        int eliminar = m.eliminarClientes(1);
        System.out.println(eliminar);
        */
        
        /*--- MOSTRAR TODOS ---*/
        
       /* List<Clientes>listcli=m.consultarTodosClientes();
     for( Clientes cli:listcli){
         System.out.println(cli.getIdCliente());
         System.out.println(cli.getCliente());
         System.out.println(cli.getTipoPersona());
         System.out.println(cli.getDireccion());
         System.out.println(cli.getTelefono());
         System.exit(0);
        
     }
        */
        
        /*--- MOSTRAR UNO ---*/
        
   
      /*
         int  idCliente=3;
     Clientes cli =m.consultarClientes(idCliente);
        System.out.println(cli.getIdCliente());
        System.out.println(cli.getCliente());
        System.out.println(cli.getTipoPersona());
        System.out.println(cli.getDireccion());
        System.out.println(cli.getTelefono()); 
        System.out.println(cli);
*/

    }
    
    public int guardarClientes(
            String cliente,
            String tipoPersona,
            String direccion,
            String telefono) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Clientes cli = new Clientes();
        cli.setIdCliente(0);
        cli.setCliente(cliente);
        cli.setTipoPersona(tipoPersona);
        cli.setDireccion(direccion);
        cli.setTelefono(telefono);
        try {
            session.beginTransaction();
            session.save(cli);
            session.getTransaction().commit();;
            flag = 1;
            System.out.println("Cliente registrado exitosamente.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error en registro de cliente "+e.getMessage());
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Clientes consultarClientes(Integer idCliente) {
        Clientes cli = new Clientes();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            
            session.beginTransaction();
            cli = (Clientes) session.get(Clientes.class, idCliente);
            session.getTransaction().commit();
            if(cli==null){
                System.out.println("Los datos sobre el cliente solicitado han sido eliminados previamente del sistema.");
            } else{
                System.out.println("Error al mostrar el datos del cliente. "+idCliente);
            }
            
            
            System.out.println("Consulta unitaria exitosa.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al consultar unitariamente" +e.getMessage());
            }
        } finally {
            session.close();
        }
        return cli;
    }

    public int eliminarClientes(int idCliente) {
        Clientes cli = new Clientes();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        session.beginTransaction(); 
        try {
          
            cli = (Clientes) session.get(Clientes.class, idCliente);
            session.delete(cli);
            session.getTransaction().commit();
            System.out.println("Se a eliminado el elemento seleccionado.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al eliminar. "+e.getMessage());
            }
            flag = 0;
            
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosClientes() {
        List<Clientes> listaClientes = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Clientes");
            listaClientes = (List<Clientes>) q.list();
            System.out.println("Consulta a todos los clientes exitosa");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al consultar todos los clientes. "+e.getMessage());
        } finally {
        }
        return listaClientes;
    }

    public int ActualizarClientes(Integer idCliente,
            String cliente,
            String tipoPersona,
            String direccion,
            String telefono) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Clientes cli = new Clientes();
        cli.setIdCliente(idCliente);
        cli.setCliente(cliente);
        cli.setTipoPersona(tipoPersona);
        cli.setDireccion(direccion);
        cli.setTelefono(telefono);
        try {
            session.beginTransaction();
            session.update(cli);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Actualización exitosa. ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al actualizar. "+e.getMessage());
            }
        } finally {
            session.close();
        }
        return flag;
    }
    
     public Clientes consultarNombreCliente(String cliente) {
         Clientes cli = new Clientes();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
       
        try {
            
            Query q = session.createQuery("FROM Clientes cli where cli.cliente=:cliente").setParameter("cliente", cliente);
            System.out.println("TAMAÑO: "+q.list().size());
            if(q.list().isEmpty()){
                System.out.println("No éxiste el cliente, lo puede ocupar");
                return cli = null;
            } else {
                System.out.println("El cliente ya existe");
                return cli;
            }
            
        } catch (Exception e) {
            System.out.println("Error consultarNombreCliente "+e);
            return cli = null;
        } finally {
            session.close();
        }
    }
}
