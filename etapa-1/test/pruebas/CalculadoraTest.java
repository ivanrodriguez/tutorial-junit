package pruebas;

import modelos.Calculadora;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ivansabik
 */
public class CalculadoraTest {

    private static final Double MARGEN_ERROR = 0.45;

    public CalculadoraTest() {
    }

    @Test
    public void testGetPagoFijo() {
        Calculadora calcPruebas = new Calculadora(new Float("100000.0"));
        calcPruebas.setTasaInteres(0.26);
        calcPruebas.setPlazo(12);
        assertEquals(calcPruebas.getPagoFijo(), new Float(9553.01), MARGEN_ERROR);
    }

    @Test
    public void testGetTotalIntereses() {
        Calculadora calcPruebas = new Calculadora(new Float("100000.0"));
        calcPruebas.setTasaInteres(0.26);
        calcPruebas.setPlazo(12);
        assertEquals(calcPruebas.getTotalIntereses(), new Float(14636.17), MARGEN_ERROR);
    }

    @Test
    public void testGetSaldoRemanente() {
        Calculadora calcPruebas = new Calculadora(new Float("100000.0"));
        calcPruebas.setTasaInteres(0.26);
        calcPruebas.setPlazo(12);
        assertEquals(calcPruebas.getSaldoRemanente(12), 0.0, MARGEN_ERROR);
    }

}
