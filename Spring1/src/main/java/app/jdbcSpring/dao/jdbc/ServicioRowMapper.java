/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.jdbcSpring.dao.jdbc;

import app.jdbcSpring.model.Servicio;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Administrador
 */
public class ServicioRowMapper implements RowMapper<Servicio> {

    public Servicio mapRow(ResultSet rs, int i) throws SQLException {

        Servicio servicio = new Servicio();
        servicio.setId(rs.getLong(1));
        servicio.setDescripcion(rs.getString(2));
        servicio.setCostoHora(rs.getLong(3));
       
        return servicio;


    }
}
