package modelo;

import java.util.Calendar;

public class Cuenta {

	private Integer numero;
	private transient String titular;
	private Double saldo;
	private Double saldoMin;
	private Calendar aperturaCuenta;
	
	public Cuenta(Integer numero, String titular, Double saldo, Double saldoMin, Calendar aperturaCuenta) {
		setNumero(numero);
		setTitular(titular);
		setSaldo(saldo);
		setSaldoMin(saldoMin);
		setAperturaCuenta(aperturaCuenta);
	}

	public Integer getNumero() {return numero;}
	public void setNumero(Integer numero) {if (numero <= 1000 && numero >= 1) this.numero = numero;}
	public String getTitular() {return titular;}
	public void setTitular(String titular) {this.titular = titular;}
	public Double getSaldoMin() {return saldoMin;}
	public void setSaldoMin(Double saldoMin) {if (saldoMin >= 0) this.saldoMin = saldoMin;}
	public Double getSaldo() {return saldo;}
	public void setSaldo(Double saldo) {if (saldo >= this.saldoMin) this.saldo = saldo;}
	public Calendar getAperturaCuenta() {return aperturaCuenta;}
	public void setAperturaCuenta(Calendar aperturaCuenta) {this.aperturaCuenta = aperturaCuenta;}
	
}
