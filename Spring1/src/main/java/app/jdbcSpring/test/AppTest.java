/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.jdbcSpring.test;

import app.jdbcSpring.dao.ServicioDAO;
import app.jdbcSpring.model.Servicio;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrador
 */
public class AppTest {

    public static void main(String[] args) {

        AppTest.deleteServicio();
        AppTest.getAll();

    }

    public static void saveServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");

        Servicio servicio = new Servicio();
        servicio.setDescripcion("Barra x hora");
        servicio.setCostoHora(10.50);

        servicioDAO.save(servicio);
    }

    public static void updateServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");

        Servicio servicio = new Servicio();
        servicio.setId(4);
        servicio.setDescripcion("Barra x horasssss");
        servicio.setCostoHora(0.50);


        servicioDAO.update(servicio);
    }

    public static void deleteServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");

        Servicio servicio = new Servicio();
        servicio.setId(3);
        servicioDAO.delete(servicio);
    }

    public static void getAll() {


        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");

        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        List<Servicio> servicios = servicioDAO.list();
        for (Servicio servicio : servicios) {
            System.out.println(servicio.getDescripcion() + " " + servicio.getCostoHora());
        }




    }
}
