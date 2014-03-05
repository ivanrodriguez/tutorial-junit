package pruebas;

import modelos.Cliente;
import modelos.MockPersistente;

/**
 *
 * @author sabik
 */
public class ClienteMock implements MockPersistente {

    @Override
    public Cliente find(Integer idCliente) {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setIngresosMensuales(new Float("20000"));
        cliente.setNombre("Rolando Ando");
        return cliente;
    }

}
