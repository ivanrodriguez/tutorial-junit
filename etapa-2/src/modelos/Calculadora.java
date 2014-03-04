package modelos;

/**
 *
 * @author ivansabik
 */
public class Calculadora {

    private Integer plazo;
    private Double tasaInteres;
    private Float montoCredito;

    public Calculadora(Float montoCredito) {
        this.montoCredito = montoCredito;
    }

    public void setTasaInteres(Double tasaAnual) {
        this.tasaInteres = tasaAnual;
    }

    public void setPlazo(Integer plazoMeses) {
        this.plazo = plazoMeses;
    }

    public Float getTotalIntereses() {
        return null;
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
        return null;
    }

}
