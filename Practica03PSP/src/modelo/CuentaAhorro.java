package modelo;

import controlador.DineroInferiorException;

import java.io.Serializable;
import java.util.Calendar;

public class CuentaAhorro extends Cuenta implements Serializable {

	private Double interesAnual;
	private Double porcentajeAhorro;

	public CuentaAhorro(Integer numero, String titular, Double saldo, Double saldoMin, Calendar aperturaCuenta, Double interesAnual, Double porcentajeAhorro) throws DineroInferiorException {
		super(numero, titular, saldo, saldoMin, aperturaCuenta);
		setInteresAnual(interesAnual);
		setPorcentajeAhorro(porcentajeAhorro);
	}

	public Double getInteresAnual() {return interesAnual;}
	public void setInteresAnual(Double interesAnual) {if (interesAnual >= 0) this.interesAnual = interesAnual;}
	public Double getPorcentajeAhorro() {return porcentajeAhorro;}
	public void setPorcentajeAhorro(Double porcentajeAhorro) {if (porcentajeAhorro >= 0) this.porcentajeAhorro = porcentajeAhorro;}

	//Arreglar
	@Override
	public boolean cumple() {
		return false;
	}
}