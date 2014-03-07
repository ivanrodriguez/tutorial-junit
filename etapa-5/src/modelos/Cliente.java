package modelos;

/**
 *
 * @author sabik
 */
public class Cliente implements MockPersistente {

    Integer id;
    String nombre;
    Float ingresosMensuales;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getIngresosMensuales() {
        return ingresosMensuales;
    }

    public void setIngresosMensuales(Float ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }

    @Override
    public Cliente find(Integer idCliente) {
        return null;
    }

}
