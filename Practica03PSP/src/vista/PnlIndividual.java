package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PnlIndividual extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PnlIndividual() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlBotones = new JPanel();
		add(pnlBotones, BorderLayout.SOUTH);
		pnlBotones.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnCalcular = new JButton("Calcular");
		pnlBotones.add(btnCalcular);
		
		JLabel lblBlanco = new JLabel("");
		pnlBotones.add(lblBlanco);
		
		JButton btnAnterior = new JButton("Anterior");
		pnlBotones.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("Siguiente");
		pnlBotones.add(btnSiguiente);
		
		JPanel pnlVista = new JPanel();
		add(pnlVista, BorderLayout.CENTER);
		pnlVista.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lblNumeroCuenta = new JLabel("Número de Cuenta");
		pnlVista.add(lblNumeroCuenta);
		
		JLabel lblNumCuentaMostrado = new JLabel("");
		pnlVista.add(lblNumCuentaMostrado);
		
		JLabel lblTitular = new JLabel("Titular");
		pnlVista.add(lblTitular);
		
		JLabel lblTitularMostrado = new JLabel("");
		pnlVista.add(lblTitularMostrado);
		
		JLabel lblSaldoMinimo = new JLabel("Saldo mínimo");
		pnlVista.add(lblSaldoMinimo);
		
		JLabel lblSaldoMinimoMostrado = new JLabel("");
		pnlVista.add(lblSaldoMinimoMostrado);
		
		JLabel lblSaldo = new JLabel("Saldo");
		pnlVista.add(lblSaldo);
		
		JLabel lblSaldoMostrado = new JLabel("");
		pnlVista.add(lblSaldoMostrado);
		
		JLabel lblAperturaCuenta = new JLabel("Fecha apertura cuenta");
		pnlVista.add(lblAperturaCuenta);
		
		JLabel lblAperturaCuentaMostrado = new JLabel("");
		pnlVista.add(lblAperturaCuentaMostrado);

	}

}
