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

    public void setTasaInteres(Double tasaAnual) throws Exception {
        if (tasaAnual <= 0.0) {
            throw new Exception("La tasa de interes debe ser mayor a 0");
        }
        this.tasaInteres = tasaAnual;
    }

    public void setPlazo(Integer plazoMeses) throws Exception {
        if (plazoMeses % 6 != 0 || plazoMeses > 36) {
            throw new Exception("El plazo debe ser 6,12,18,24,30 o 36");
        }
        this.plazo = plazoMeses;
    }

    public Float getTotalIntereses() {
        calculaAmortizaciones();
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
        calculaAmortizaciones();
        Amortizacion amort = (Amortizacion) amortizaciones.get(mes - 1);
        return amort.getSaldoFinal();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        montoCredito = this.cliente.getIngresosMensuales() * 5;
    }

    public Float getMontoCredito() {
        return montoCredito;
    }

    private void calculaAmortizaciones() {
        amortizaciones = new ArrayList<Amortizacion>();
        // Primer mes
        Float pagoInteres = montoCredito * new Float(tasaInteres / 12);
        Float pagoCapital = getPagoFijo() - pagoInteres;
        Float saldoFinal = montoCredito - pagoCapital;
        Amortizacion amort = new Amortizacion(montoCredito, pagoCapital, pagoInteres, saldoFinal);
        amortizaciones.add(amort);
        // Otros meses
        for (int mes = 2; mes <= plazo; mes++) {
            pagoInteres = amortizaciones.get(mes - 2).getSaldoFinal() * new Float(tasaInteres / 12);
            pagoCapital = getPagoFijo() - pagoInteres;
            saldoFinal = amortizaciones.get(mes - 2).getSaldoFinal() - pagoCapital;
            amort = new Amortizacion(amortizaciones.get(mes - 2).getSaldoFinal(), pagoCapital, pagoInteres, saldoFinal);
            amortizaciones.add(amort);
        }
    }

}
