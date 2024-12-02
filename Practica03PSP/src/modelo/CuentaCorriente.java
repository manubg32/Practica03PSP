package modelo;

import controlador.DineroInferiorException;

import java.io.Serializable;
import java.util.Calendar;

public class CuentaCorriente extends Cuenta implements Serializable, ICalculoFechas {

	private Double comisionMantenimiento;
	private String tipoComision;

	public CuentaCorriente(String titular, Double saldoMin, Double saldo, Calendar aperturaCuenta, Double comisionMantenimiento, String tipoComision) throws DineroInferiorException {
		super(titular, saldoMin, saldo, aperturaCuenta);
		setComisionMantenimiento(comisionMantenimiento);
		setTipoComision(tipoComision);
	}

	public Double getComisionMantenimiento() {return comisionMantenimiento;}
	public void setComisionMantenimiento(Double comisionMantenimiento) {if (comisionMantenimiento >= 0) this.comisionMantenimiento = comisionMantenimiento;}
	public String getTipoComision() {return tipoComision;}
	public void setTipoComision(String tipoComision) {if (!tipoComision.isEmpty() && !tipoComision.isEmpty()) this.tipoComision = tipoComision;}

	//Arreglar
	@Override
	public boolean cumple() {
		return false;
	}

	@Override
	public String toString() {
		return "CuentaCorriente{" +
				"comisionMantenimiento=" + comisionMantenimiento +
				", tipoComision='" + tipoComision + '\'' +
				"} " + super.toString();
	}
}