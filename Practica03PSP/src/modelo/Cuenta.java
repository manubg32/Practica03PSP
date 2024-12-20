package modelo;

import controlador.DineroInferiorException;
import controlador.GestionCuentas;
import controlador.GestionLista;

import java.io.Serializable;
import java.util.Calendar;

public class Cuenta implements ICalculoFechas, Serializable {

	private int numero;

	private static final long serialVersionUID = 1L;
	private transient String titular;
	private Double saldo;
	private Double saldoMin;
	private Calendar aperturaCuenta;

	public Cuenta(String titular, Double saldoMin, Double saldo, Calendar aperturaCuenta) throws DineroInferiorException {
		this.numero = GestionCuentas.numero++;
		setTitular(titular);
		setSaldoMin(saldoMin);
        setSaldo(saldo);

		setAperturaCuenta(aperturaCuenta);
	}

	public Integer getNumero() {return numero;}
	public String getTitular() {return titular;}
	public void setTitular(String titular) {this.titular = titular;}
	public Double getSaldoMin() {return saldoMin;}
	public void setSaldoMin(Double saldoMin) {if (saldoMin >= 0) this.saldoMin = saldoMin;}
	public Double getSaldo() {return saldo;}
	public void setSaldo(Double saldo) throws DineroInferiorException {
		if (saldo >= this.saldoMin){
			this.saldo = saldo;
		}else {
			throw new DineroInferiorException();
		};
	}
	public Calendar getAperturaCuenta() {return aperturaCuenta;}
	public void setAperturaCuenta(Calendar aperturaCuenta) {this.aperturaCuenta = aperturaCuenta;}

	@Override
	public boolean cumple() {
		return aperturaCuenta.get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH) && aperturaCuenta.get(Calendar.DAY_OF_MONTH) == Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}

	@Override
	public String toString() {
		return
				"numero=" + numero +
				", titular='" + titular + '\'' +
				", saldo=" + saldo +
				", saldoMin=" + saldoMin +
				", aperturaCuenta=" + aperturaCuenta.getTime();
	}
}


