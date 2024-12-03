package vista;

import controlador.DineroInferiorException;
import controlador.GestionCuentas;
import controlador.GestionLista;
import controlador.GestionPersistencia;
import modelo.*;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;

	private PnlLista pnlLista;
	private PnlAltas pnlAltas;
	private PnlIndividual pnlIndividual;

	private JMenuBar menuBar;
	private JMenu mnuAlta;
	private JMenuItem mniAltaCuenta;
	private	JMenu mnuVer;
	private JMenuItem mniLista;
	private JMenuItem mniIndividual;

	private JButton btnCargar;
	private JButton btnGuardar;
	private JButton btnVaciar;
	private JButton btnTest;

	private GestionPersistencia gestionPersistencia;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/vista/icon.png")));
		setTitle("Doblenlazado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		addComponents();
		addListeners();
	}
	void addComponents(){
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnuAlta = new JMenu("Alta");
		menuBar.add(mnuAlta);

		mniAltaCuenta = new JMenuItem("Cuenta");
		mnuAlta.add(mniAltaCuenta);

		mnuVer = new JMenu("Ver");
		menuBar.add(mnuVer);

		mniLista = new JMenuItem("Lista");
		mnuVer.add(mniLista);

		mniIndividual = new JMenuItem("Individual");
		mnuVer.add(mniIndividual);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 4, 0, 0));

		btnCargar = new JButton("Cargar");
		panel.add(btnCargar);

		btnGuardar = new JButton("Guardar");
		panel.add(btnGuardar);

		btnVaciar = new JButton("Vaciar Lista");
		panel.add(btnVaciar);

		btnTest = new JButton("Test");
		panel.add(btnTest);


		Image tmp = new ImageIcon(FrmPrincipal.class.getResource("/vista/icon.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon logo = new ImageIcon(tmp);
		JLabel lblLogo = new JLabel(logo);

		contentPane.add(lblLogo, BorderLayout.CENTER);


		pnlAltas = new PnlAltas();
		pnlLista = new PnlLista();
		pnlIndividual = new PnlIndividual();

		gestionPersistencia = new GestionPersistencia();
	}
	void addListeners(){
		btnCargar.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				Lista listaCuentas = gestionPersistencia.cargarCuentas();
				if (listaCuentas != null) {
					GestionLista.setLista(listaCuentas);
					JOptionPane.showMessageDialog(null, "Cuentas cargadas correctamente", "Cargar", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "No se pudieron cargar las cuentas", "Error", JOptionPane.ERROR_MESSAGE);
				}			}

		});
		btnGuardar.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				if(GestionLista.getLista() != null){
					Lista l = GestionLista.getLista();
					gestionPersistencia.guardarCuentas(GestionLista.getLista());
				}
			}
		});
		btnVaciar.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				GestionLista.setLista(new Lista());
				JOptionPane.showMessageDialog(null,"Lista vaciada correctamente", "Vaciar Lista", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnTest.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				Random random = new Random();

				// Crear cuentas de prueba con valores aleatorios
				try {
					CuentaAhorro cuentaAhorro1 = crearCuentaAhorro(random);
					CuentaAhorro cuentaAhorro2 = crearCuentaAhorro(random);
					CuentaCorriente cuentaCorriente1 = crearCuentaCorriente(random);
					CuentaCorriente cuentaCorriente2 = crearCuentaCorriente(random);
					// Agregar las cuentas a la lista (gestionada por GestionLista)

					GestionLista.agregarCuenta(cuentaAhorro1);
					GestionLista.agregarCuenta(cuentaAhorro2);
					GestionLista.agregarCuenta(cuentaCorriente1);
					GestionLista.agregarCuenta(cuentaCorriente2);


					int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres Generar 1000 cuentas?", "Generar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (opcion == JOptionPane.YES_OPTION) {
						for(int i = 0 ; i<500; i++){
							CuentaCorriente cuenta1 = crearCuentaCorriente(random);
							CuentaAhorro cuenta2 = crearCuentaAhorro(random);
							GestionLista.agregarCuenta(cuenta2);
							GestionLista.agregarCuenta(cuenta1);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Opcion Cancelada, se generarán 4 cuentas.", "Cancelar", JOptionPane.INFORMATION_MESSAGE);
					}


				}catch(DineroInferiorException ex){
					JOptionPane.showMessageDialog(null, ex.mensaje, "Error", JOptionPane.ERROR_MESSAGE);
				}

				// Mensaje para indicar que se han agregado las cuentas
				JOptionPane.showMessageDialog(null, "Se han agregado cuentas de prueba aleatorias.", "Test", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		mniLista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(pnlLista);
				pnlLista.mostrarListaIndividual(GestionLista.getLista());
				revalidate();
				repaint();
			}
		});
		mniIndividual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlIndividual.mostrarPrimero();
				setContentPane(pnlIndividual);
				revalidate();
				repaint();

			}
		});
		mniAltaCuenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(pnlAltas);
				revalidate();
				repaint();
			}
		});


	}
	private CuentaAhorro crearCuentaAhorro(Random random) throws DineroInferiorException {
		DecimalFormat formato = new DecimalFormat("#.00");
		String titular = "Titular Cuenta: " + random.nextInt(100); // Titular aleatorio

		double saldoMinimo = 100 + random.nextDouble(1000); // Saldo mínimo aleatorio entre 100 y 1100
		String saldoMinFormat = formato.format(saldoMinimo);
		saldoMinFormat = saldoMinFormat.replace(",", ".");
		saldoMinimo = Double.parseDouble(saldoMinFormat);

		double saldo = saldoMinimo + random.nextDouble(10000); // Saldo aleatorio entre 500 y 10500
		String saldoFormat = formato.format(saldo);
		saldoFormat = saldoFormat.replace(",", ".");
		saldo = Double.parseDouble(saldoFormat);

		double interesAnual = 0.5 + random.nextDouble() * 4.5; // Interés anual entre 0.5% y 5%
		String interesFormat = formato.format(interesAnual);
		interesFormat = interesFormat.replace(",",".");
		interesAnual = Double.parseDouble(interesFormat);

		double porcentajeAhorro = 10 + random.nextDouble() * 30; // Porcentaje de ahorro entre 10% y 40%
		String porcentajeFormat = formato.format(porcentajeAhorro);
		porcentajeFormat = porcentajeFormat.replace(",", ".");
		porcentajeAhorro = Double.parseDouble(porcentajeFormat);

		Calendar aperturaCuenta = Calendar.getInstance();
		aperturaCuenta.set(Calendar.YEAR, 2010 + random.nextInt(15));
		aperturaCuenta.set(Calendar.MONTH, random.nextInt(12)); // Mes aleatorio entre 0 y 11
		aperturaCuenta.set(Calendar.DAY_OF_MONTH, random.nextInt(28) + 1); // Día aleatorio entre 1 y 28




		return new CuentaAhorro( titular, saldoMinimo, saldo, aperturaCuenta, interesAnual, porcentajeAhorro);
	}

	private CuentaCorriente crearCuentaCorriente(Random random) throws DineroInferiorException {
		DecimalFormat formato = new DecimalFormat("#.00");
		String titular = "Titular Cuenta: " + random.nextDouble(100); // Titular aleatorio

		double saldoMinimo = 100 + random.nextDouble(1000); // Saldo mínimo aleatorio entre 100 y 1100
		String saldoMinFormat = formato.format(saldoMinimo);
		saldoMinFormat = saldoMinFormat.replace(",", ".");
		saldoMinimo = Double.parseDouble(saldoMinFormat);

		double saldo = saldoMinimo + random.nextDouble(10000); // Saldo aleatorio entre 500 y 10500
		String saldoFormat = formato.format(saldo);
		saldoFormat = saldoFormat.replace(",", ".");
		saldo = Double.parseDouble(saldoFormat);

		double comisionMantenimiento = 5 + random.nextDouble() * 15; // Comisión de mantenimiento entre 5 y 20
		String comisionFormat = formato.format(comisionMantenimiento);
		comisionFormat = comisionFormat.replace(",", ".");
		comisionMantenimiento = Double.parseDouble(comisionFormat);

		String tipoComision = random.nextBoolean() ? "Fija" : "Variable"; // Tipo de comisión aleatorio
		Calendar aperturaCuenta = Calendar.getInstance();
		aperturaCuenta.set(Calendar.YEAR, 2010 + random.nextInt(15));
		aperturaCuenta.set(Calendar.MONTH, random.nextInt(12)); // Mes aleatorio entre 0 y 11
		aperturaCuenta.set(Calendar.DAY_OF_MONTH, random.nextInt(28) + 1); // Día aleatorio entre 1 y 28


		return new CuentaCorriente(titular, saldoMinimo,saldo, aperturaCuenta, comisionMantenimiento, tipoComision);


	}

}
