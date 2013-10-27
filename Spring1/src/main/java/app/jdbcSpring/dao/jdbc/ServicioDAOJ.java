package app.jdbcSpring.dao.jdbc;

import app.jdbcSpring.dao.ServicioDAO;
import app.jdbcSpring.model.Servicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class ServicioDAOJ extends JdbcDaoSupport implements ServicioDAO {

    public List<Servicio> list() {

        String sql = "select * from servicio";

        List<Servicio> servicios = new ArrayList<Servicio>();

        List<Map<String, Object>> rows = this.getJdbcTemplate().queryForList(sql);

        for (Map row : rows) {

            Servicio servicio = new Servicio();
            servicio.setId(Long.parseLong(String.valueOf(row.get("ID"))));
            servicio.setDescripcion((String) row.get("descripcion"));
            servicio.setCostoHora((Double) row.get("costo_hora"));
            servicios.add(servicio);

        }
        return servicios;
    }

    public Servicio get(Servicio t) {
        String sql = "select * from servicio where id = ?";

        Servicio servicio = (Servicio) this.getJdbcTemplate().queryForObject(
                sql, new Object[]{t.getId()}, new ServicioRowMapper());

        return servicio;
    }

    public void save(Servicio t) {

        String sql = "insert into servicio ( descripcion, costo_hora) "
                + "values(?, ?);";

        try {

            this.getJdbcTemplate().update(sql, new Object[]{
                t.getDescripcion(),
                t.getCostoHora()
            });

        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }

    }

    public void update(Servicio t) {
        String sql = "update servicio set descripcion=?, costo_hora=? "
                + " where id=?";

        try {
            this.getJdbcTemplate().update(sql, new Object[]{
                t.getDescripcion(),
                t.getCostoHora(),
                t.getId()
            });
        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public void delete(Servicio t) {
        this.getJdbcTemplate().update("delete from servicio where id=?",
                new Object[]{t.getId()});
    }
}
