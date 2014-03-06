package modelos;

/**
 *
 * @author sabik
 */
public class Amortizacion {

    private Float saldoInicial;
    private Float pagoCapital;
    private Float pagoInteres;
    private Float saldoFinal;

    public Amortizacion(Float saldoInicial, Float pagoCapital, Float pagoInteres, Float saldoFinal) {
        this.saldoInicial = saldoInicial;
        this.pagoCapital = pagoCapital;
        this.pagoInteres = pagoInteres;
        this.saldoFinal = saldoFinal;
    }

    public Float getSaldoFinal() {
        return saldoFinal;
    }

    public Float getPagoInteres() {
        return pagoInteres;
    }

}
