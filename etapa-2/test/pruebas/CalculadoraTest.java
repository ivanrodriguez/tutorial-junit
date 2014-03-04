package pruebas;

import modelos.Calculadora;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author ivansabik
 */
public class CalculadoraTest {

    private static final Double MARGEN_ERROR = 0.45;
    private static Calculadora calcPruebas;

    public CalculadoraTest() {
    }

    @Test
    public void testGetPagoFijo() {
        assertEquals(calcPruebas.getPagoFijo(), new Float("9553.01"), MARGEN_ERROR);
    }

    @Test
    public void testGetTotalIntereses() {
        assertEquals(calcPruebas.getTotalIntereses(), new Float("14636.17"), MARGEN_ERROR);
    }

    @Test
    public void testGetSaldoRemanente() {
        assertEquals(calcPruebas.getSaldoRemanente(12), new Float(0.0), MARGEN_ERROR);
    }

    @Before
    public void setUp() {
        this.calcPruebas = new Calculadora(new Float("100000.0"));
        this.calcPruebas.setTasaInteres(0.26);
        this.calcPruebas.setPlazo(12);
    }
}
