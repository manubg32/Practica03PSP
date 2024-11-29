package modelo;

import controlador.DineroInferiorException;

import java.io.Serializable;
import java.util.Calendar;

<<<<<<< HEAD
public class CuentaAhorro extends Cuenta implements Serializable {

=======
public class CuentaAhorro extends Cuenta implements Serializable, ICalculoFechas {
	
>>>>>>> parent of f00c928 (commit)
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