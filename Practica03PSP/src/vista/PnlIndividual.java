package vista;

import controlador.GestionCuentas;
import modelo.Cuenta;
import modelo.CuentaAhorro;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PnlIndividual extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel pnlBotones;
	private JPanel pnlVista;

	private JButton btnCalcular;
	private JButton btnAnterior;
	private JButton btnSiguiente;

	private JLabel lblBlanco;
	private JLabel lblNumeroCuenta;
	private JLabel lblNumCuentaMostrado;
	private JLabel lblTitular;
	private JLabel lblTitularMostrado;
	private JLabel lblSaldo;
	private JLabel lblSaldoMostrado;
	private JLabel lblSaldoMinimo;
	private JLabel lblSaldoMinimoMostrado;
	private JLabel lblAperturaCuenta;
	private JLabel lblAperturaCuentaMostrado;

	public PnlIndividual() {
		setLayout(new BorderLayout(0, 0));
		addComponents();
		addListeners();
	}

	private void addComponents(){
		pnlBotones = new JPanel();
		add(pnlBotones, BorderLayout.SOUTH);
		pnlBotones.setLayout(new GridLayout(0, 4, 0, 0));

		btnCalcular = new JButton("Calcular");
		pnlBotones.add(btnCalcular);

		lblBlanco = new JLabel("");
		pnlBotones.add(lblBlanco);

		btnAnterior = new JButton("Anterior");
		pnlBotones.add(btnAnterior);

		btnSiguiente = new JButton("Siguiente");
		pnlBotones.add(btnSiguiente);

		pnlVista = new JPanel();
		add(pnlVista, BorderLayout.CENTER);
		pnlVista.setLayout(new GridLayout(5, 2, 0, 0));

		lblNumeroCuenta = new JLabel("Número de Cuenta");
		pnlVista.add(lblNumeroCuenta);

		lblNumCuentaMostrado = new JLabel("");
		pnlVista.add(lblNumCuentaMostrado);

		lblTitular = new JLabel("Titular");
		pnlVista.add(lblTitular);

		lblTitularMostrado = new JLabel("");
		pnlVista.add(lblTitularMostrado);

		lblSaldoMinimo = new JLabel("Saldo mínimo");
		pnlVista.add(lblSaldoMinimo);

		lblSaldoMinimoMostrado = new JLabel("");
		pnlVista.add(lblSaldoMinimoMostrado);

		lblSaldo = new JLabel("Saldo");
		pnlVista.add(lblSaldo);

		lblSaldoMostrado = new JLabel("");
		pnlVista.add(lblSaldoMostrado);

		lblAperturaCuenta = new JLabel("Fecha apertura cuenta");
		pnlVista.add(lblAperturaCuenta);

		lblAperturaCuentaMostrado = new JLabel("");
		pnlVista.add(lblAperturaCuentaMostrado);
	}
	private void addListeners(){

	}
	private void actualizarVista(){
		Cuenta cuentaActual = (Cuenta) GestionCuentas.actual.getValor() ;
		lblTitularMostrado.setText(cuentaActual.getTitular());
		lblSaldoMostrado.setText(cuentaActual.getSaldo().toString());
		lblSaldoMinimoMostrado.setText(cuentaActual.getSaldoMin().toString());
		lblAperturaCuentaMostrado.setText(cuentaActual.getAperturaCuenta().toString());
	}
}
