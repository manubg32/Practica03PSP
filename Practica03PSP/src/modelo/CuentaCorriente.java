package modelo;

import java.util.Calendar;

public class CuentaCorriente extends Cuenta {
	
	private Double comisionMantenimiento;
	private String tipoComision;

	public CuentaCorriente(Integer numero, String titular, Double saldo, Double saldoMin, Calendar aperturaCuenta, Double comisionMantenimiento, String tipoComision) {
		super(numero, titular, saldo, saldoMin, aperturaCuenta);
		setComisionMantenimiento(comisionMantenimiento);
		setTipoComision(tipoComision);
	}

	public Double getComisionMantenimiento() {return comisionMantenimiento;}
	public void setComisionMantenimiento(Double comisionMantenimiento) {if (comisionMantenimiento >= 0) this.comisionMantenimiento = comisionMantenimiento;}
	public String getTipoComision() {return tipoComision;}
	public void setTipoComision(String tipoComision) {if (!tipoComision.isEmpty() && !tipoComision.isEmpty()) this.tipoComision = tipoComision;}
	
}
