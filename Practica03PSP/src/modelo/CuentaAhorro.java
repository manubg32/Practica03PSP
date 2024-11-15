package modelo;

import java.util.Calendar;

public class CuentaAhorro extends Cuenta {
	
	private Double interesAnual;
	private Double porcentajeAhorro;

	public CuentaAhorro(Integer numero, String titular, Double saldo, Double saldoMin, Calendar aperturaCuenta, Double interesAnual, Double porcentajeAhorro) {
		super(numero, titular, saldo, saldoMin, aperturaCuenta);
		setInteresAnual(interesAnual);
		setPorcentajeAhorro(porcentajeAhorro);
	}

	public Double getInteresAnual() {return interesAnual;}
	public void setInteresAnual(Double interesAnual) {if (interesAnual >= 0) this.interesAnual = interesAnual;}
	public Double getPorcentajeAhorro() {return porcentajeAhorro;}
	public void setPorcentajeAhorro(Double porcentajeAhorro) {if (porcentajeAhorro >= 0) this.porcentajeAhorro = porcentajeAhorro;}
	
	

}
