package pruebas;

import java.util.Arrays;
import modelos.Calculadora;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author ivansabik
 */
@RunWith(Parameterized.class)
public class SaldosTest {

    private static final Double MARGEN_ERROR = 0.45;
    private final Float saldo;
    private final Integer mes;

    public SaldosTest(Integer mes, Float saldo) {
        this.saldo = saldo;
        this.mes = mes;
    }

    @Parameters
    public static Iterable datosPrueba() {
        return Arrays.asList(
                new Object[][]{
                    {1, new Float("92613.65")},
                    {2, new Float("85067.27")},
                    {3, new Float("77357.38")},
                    {4, new Float("69480.44")},
                    {5, new Float("61432.84")},
                    {6, new Float("53210.87")},
                    {7, new Float("44810.76")},
                    {8, new Float("36228.64")},
                    {9, new Float("27460.58")},
                    {10, new Float("18502.55")},
                    {11, new Float("9350.42")},
                    {12 ,new Float("0.00")},
                }
        );
    }

    @Test
    public void testGetSaldosRemanentes() throws Exception {
        Calculadora calcPruebas = new Calculadora();
        ClienteMock cliente = new ClienteMock();
        calcPruebas.setCliente(cliente.find(1));
        calcPruebas.setTasaInteres(0.26);
        calcPruebas.setPlazo(12);
        assertEquals(calcPruebas.getSaldoRemanente(mes), saldo, MARGEN_ERROR);
    }

}