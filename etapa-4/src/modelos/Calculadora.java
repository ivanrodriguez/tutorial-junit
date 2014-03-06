package modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivansabik
 */
public class Calculadora {

    private Integer plazo;
    private Double tasaInteres;
    private Float montoCredito;

    private Cliente cliente;

    private List<Amortizacion> amortizaciones;

    public Calculadora() {
    }

    public void setTasaInteres(Double tasaAnual) {
        this.tasaInteres = tasaAnual;
    }

    public void setPlazo(Integer plazoMeses) {
        this.plazo = plazoMeses;
    }

    public Float getTotalIntereses() {
        Float totalIntereses = new Float(0);
        for (Amortizacion amort : amortizaciones) {
            totalIntereses += amort.getPagoInteres();
        }
        return totalIntereses;
    }

    public Float getPagoFijo() {
        int n = this.plazo;
        Float r = new Float(this.tasaInteres / 12);
        Float PV = new Float(this.montoCredito);
        Float a = new Float(r * PV);
        Float b = new Float((1 - Math.pow(1 + r, -n)));
        return a / b;
    }

    public Float getSaldoRemanente(Integer mes) {
        Amortizacion amort = (Amortizacion) amortizaciones.get(mes - 1);
        return amort.getSaldoFinal();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        montoCredito = cliente.getIngresosMensuales() * 5;
    }

    public Float getMontoCredito() {
        return montoCredito;
    }

    public void calculaAmortizaciones() {
        amortizaciones = new ArrayList<Amortizacion>();
        // TODO: Aquí se construye el array
    }

}
