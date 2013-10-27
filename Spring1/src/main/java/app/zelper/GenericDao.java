package app.zelper;

import java.util.List;

public interface GenericDao<T> {

    //T = LISTAR LA CLASE CUALQUIERA GENERIC SE VA REPETIR EN TODA LA APLICACION
    
    public List<T> list();

    public T get(T t);

    public void save(T t);

    public void update(T t);

    public void delete(T t);

}
