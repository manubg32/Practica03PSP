package vista;

import controlador.GestionCuentas;
import controlador.GestionLista;
import modelo.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PnlIndividual extends JPanel {

	static Lista lista = GestionLista.getLista();
	private static LocalDate fechaActual = LocalDate.now();
	private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static String fechaFormateada = fechaActual.format(formato);
	private static Nodo actual;


	private static final long serialVersionUID = 1L;

	private JPanel pnlBotones;
	private JPanel pnlVista;

	private static JButton btnCalcular;
	private static JButton btnAnterior;
	private static JButton btnSiguiente;

	private JLabel lblBlanco;
	private JLabel lblNumeroCuenta;
	private static JLabel lblNumCuentaMostrado;
	private JLabel lblTitular;
	private static JLabel lblTitularMostrado;
	private JLabel lblSaldo;
	private static JLabel lblSaldoMostrado;
	private JLabel lblSaldoMinimo;
	private static JLabel lblSaldoMinimoMostrado;
	private JLabel lblAperturaCuenta;
	private static JLabel lblAperturaCuentaMostrado;



	public PnlIndividual() {
		setLayout(new BorderLayout(0, 0));
		addComponents();
		addListeners();

	}

	public static void mostrarPrimero() {

		Nodo primero = lista.getPrimero();
		Cuenta c = (Cuenta)primero.getValor();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// Convertir Calendar a String
		String fechaComoTexto = sdf.format(c.getAperturaCuenta().getTime());

		lblNumCuentaMostrado.setText(c.getNumero().toString());
		lblAperturaCuentaMostrado.setText(fechaComoTexto);
		lblTitularMostrado.setText(c.getTitular());
		lblSaldoMostrado.setText(c.getSaldo().toString());
		lblSaldoMinimoMostrado.setText(c.getSaldoMin().toString());

	}
	public static boolean mostrarSiguiente() {

		if (actual == null) {

			actual = lista.getPrimero();

			if (actual == null) {
				JOptionPane.showMessageDialog(null, "¡Lista Vacía!", "Información", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		} else {
			actual = actual.getSiguiente();

			if (actual == null) {
				JOptionPane.showMessageDialog(null, "¡Has llegado al final de la lista!", "Información", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		}

		mostrarCuenta();

		return true;
	}
	public static boolean mostrarAnterior() {
		if (actual == null) {
			JOptionPane.showMessageDialog(null, "¡No hay nodo anterior!", "Información", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		actual = actual.getAnterior();

		if (actual == null) {
			JOptionPane.showMessageDialog(null, "¡Estás en el primer nodo de la lista!", "Información", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		mostrarCuenta();

		return true;
	}



	private static void mostrarCuenta() {
		CuentaAhorro cca;
		CuentaCorriente ccc;
		try{

			cca = (CuentaAhorro) actual.getValor();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			// Convertir Calendar a String
			String fechaComoTexto = sdf.format(cca.getAperturaCuenta().getTime());


			lblNumCuentaMostrado.setText(cca.getNumero().toString());
			lblTitularMostrado.setText(cca.getTitular());
			lblSaldoMinimoMostrado.setText(cca.getSaldoMin().toString());
			lblSaldoMostrado.setText(cca.getSaldo().toString());
			lblAperturaCuentaMostrado.setText(fechaComoTexto);

		}catch(Exception e){

			ccc = (CuentaCorriente) actual.getValor();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			// Convertir Calendar a String
			String fechaComoTexto = sdf.format(ccc.getAperturaCuenta().getTime());

			lblNumCuentaMostrado.setText(ccc.getNumero().toString());
			lblTitularMostrado.setText(ccc.getTitular());
			lblSaldoMinimoMostrado.setText(ccc.getSaldoMin().toString());
			lblSaldoMostrado.setText(ccc.getSaldo().toString());
			lblAperturaCuentaMostrado.setText(fechaComoTexto);


		}


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
	private void addListeners() {
		btnSiguiente.addActionListener(e -> {
			// Llamamos al méto do para mostrar la siguiente cuenta
			mostrarSiguiente();
		});

		btnAnterior.addActionListener(e -> {
			// Llamamos al méto do para mostrar la cuenta anterior
			mostrarAnterior();
		});
	}

	public static void actualizarVista(Cuenta cuentaActual) {
		if (cuentaActual != null) {
			lblNumCuentaMostrado.setText(cuentaActual.getNumero().toString());
			lblTitularMostrado.setText(cuentaActual.getTitular());
			lblSaldoMostrado.setText(cuentaActual.getSaldo().toString());
			lblSaldoMinimoMostrado.setText(cuentaActual.getSaldoMin().toString());
			lblAperturaCuentaMostrado.setText(cuentaActual.getAperturaCuenta().toString());
		}
	}


}
