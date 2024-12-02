package modelo;

import controlador.DineroInferiorException;

import java.io.Serializable;
import java.util.Calendar;


public class CuentaAhorro extends Cuenta implements Serializable, ICalculoFechas {

	private Double interesAnual;
	private Double porcentajeAhorro;

	public CuentaAhorro(String titular, Double saldoMin, Double saldo, Calendar aperturaCuenta, Double interesAnual, Double porcentajeAhorro) throws DineroInferiorException {
		super(titular, saldoMin, saldo, aperturaCuenta);
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

	@Override
	public String toString() {
		return "CuentaAhorro{" +
				"interesAnual=" + interesAnual +
				", porcentajeAhorro=" + porcentajeAhorro +
				"} " + super.toString();
	}
}