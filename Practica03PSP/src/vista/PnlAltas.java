package vista;

import controlador.DineroInferiorException;
import controlador.GestionCuentas;
import controlador.GestionLista;
import modelo.CuentaAhorro;
import modelo.CuentaCorriente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PnlAltas extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JTextField txtTitular;
	public static JTextField txtSaldoMin;
	public static JTextField txtSaldo;
	public static JTextField txtFechaApertura;
	public static JTextField txtCambiante1;
	public static JTextField txtCambiante2;
	public static JLabel lblTipo;
	public static JComboBox<String> cmbTipo;
	public static JLabel lblTitular;
	public static JLabel lblSaldoMin;
	public static JLabel lblSaldo;
	public static JLabel lblAperturaCuenta;
	public static JLabel lblCambiante1;
	public static JLabel lblCambiante2;
	private JButton btnBorrar;
	private JButton btnGuardar;

	GestionCuentas gc = new GestionCuentas();


	/**
	 * Create the panel.
	 */
	public PnlAltas() {
		setLayout(new BorderLayout(0, 0));

		initComponents();
		setListeners();

	}

	private void setListeners() {

		cmbTipo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Obtener la opción seleccionada
				String seleccion = (String) cmbTipo.getSelectedItem();
				if (seleccion.equals("Cuenta corriente")) {
					ActivarTodo();
					lblCambiante1.setText("Comision de mantenimiento");
					lblCambiante2.setText("Tipo de comisión");
				} else if (seleccion.equals("Cuenta ahorro")) {
					ActivarTodo();
					lblCambiante1.setText("Interés anual");
					lblCambiante2.setText("Porcentaje de mantenimiento");
				} else if (seleccion.equals("Seleccione una opción...")) {
					DesactivarTodo();
				}
			}
		});

		btnBorrar.addActionListener(new ActionListener() {
			 @Override public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {

				//Cada vez que pulsemos el boton ponemos las etiquetas a negro para hacer el resto de comprobaciones
				ponerTodosNegros();
				try {
					//Comprobamos que estén los datos introducidos y sean del tipo que se esperan
					if (gc.ComprobarDatos(cmbTipo.getSelectedItem() ,txtTitular.getText(), txtSaldoMin.getText(), txtSaldo.getText(), txtFechaApertura.getText(), txtCambiante1.getText(), txtCambiante2.getText()))
					{
						String seleccion = (String) cmbTipo.getSelectedItem();

						Calendar calendario = Calendar.getInstance();

						//Parseamos el texto a Date y aunque no deberia haber problemas capturamos el error que pueda haber
						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
						try {
							// Parsear el texto a Date
							Date fecha = formato.parse(txtFechaApertura.getText());

							// Convertir Date a Calendar
							calendario = Calendar.getInstance();
							calendario.setTime(fecha);

						} catch (ParseException ex) {
							// Manejar el error de formato
							JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Usa dd/MM/yyyy", "Hay un problemilla", JOptionPane.ERROR_MESSAGE);
						}

						//Depende del elemento que se esté dando de alta se crea uno u otro y se añade
						if (seleccion.equals("Cuenta corriente")) {

							//Creamos una cuenta corriente y la agregamos a la lista
							CuentaCorriente cc = new CuentaCorriente(txtTitular.getText(), Double.parseDouble(txtSaldoMin.getText()), Double.parseDouble(txtSaldo.getText()), calendario, Double.parseDouble(txtCambiante1.getText()), txtCambiante2.getText());
							GestionLista.agregarCuenta(cc);
							JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente", "Cuenta creada", JOptionPane.INFORMATION_MESSAGE);
							vaciarCampos();
						} else if (seleccion.equals("Cuenta ahorro")) {

							//Creamos una cuenta ahorro y la agregamos a la lista
							CuentaAhorro ca = new CuentaAhorro(txtTitular.getText(), Double.parseDouble(txtSaldoMin.getText()), Double.parseDouble(txtSaldo.getText()), calendario, Double.parseDouble(txtCambiante1.getText()), Double.parseDouble(txtCambiante2.getText()));
							GestionLista.agregarCuenta(ca);
							JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente", "Cuenta creada", JOptionPane.INFORMATION_MESSAGE);
							vaciarCampos();
						}

					}
				} catch (DineroInferiorException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
				} catch (NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Los saldos, intereses y comisiones deben ser un número sin signos", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

	private void vaciarCampos() {
		txtTitular.setText("");
		txtSaldoMin.setText("");
		txtSaldo.setText("");
		txtFechaApertura.setText("");
		txtCambiante1.setText("");
		txtCambiante2.setText("");
	}

	private void ponerTodosNegros() {
		lblTitular.setForeground(Color.BLACK);
		lblSaldoMin.setForeground(Color.BLACK);
		lblSaldo.setForeground(Color.BLACK);
		lblAperturaCuenta.setForeground(Color.BLACK);
		lblCambiante1.setForeground(Color.BLACK);
		lblCambiante2.setForeground(Color.BLACK);
	}

	private void DesactivarTodo(){
		txtTitular.setVisible(false);
		txtSaldoMin.setVisible(false);
		txtSaldo.setVisible(false);
		txtFechaApertura.setVisible(false);
		txtCambiante1.setVisible(false);
		txtCambiante2.setVisible(false);

		lblTitular.setVisible(false);
		lblSaldoMin.setVisible(false);
		lblSaldo.setVisible(false);
		lblAperturaCuenta.setVisible(false);
		lblCambiante1.setVisible(false);
		lblCambiante2.setVisible(false);

		btnGuardar.setVisible(false);
		btnBorrar.setVisible(false);
	}

	private void ActivarTodo() {
		txtTitular.setVisible(true);
		txtSaldoMin.setVisible(true);
		txtSaldo.setVisible(true);
		txtFechaApertura.setVisible(true);
		txtCambiante1.setVisible(true);
		txtCambiante2.setVisible(true);

		lblTitular.setVisible(true);
		lblSaldoMin.setVisible(true);
		lblSaldo.setVisible(true);
		lblAperturaCuenta.setVisible(true);
		lblCambiante1.setVisible(true);
		lblCambiante2.setVisible(true);

		btnGuardar.setVisible(true);
		btnBorrar.setVisible(true);
	}

	private void initComponents() {
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(7, 2, 0, 0));

		lblTipo = new JLabel("Tipo de Cuenta");
		panel.add(lblTipo);

		String[] cuentas = {"Seleccione una opción...", "Cuenta corriente", "Cuenta ahorro"};
		cmbTipo = new JComboBox<>(cuentas);
		cmbTipo.setSelectedIndex(0);
		panel.add(cmbTipo);

		lblTitular = new JLabel("Titular");
		panel.add(lblTitular);

		txtTitular = new JTextField();
		txtTitular.setColumns(10);
		panel.add(txtTitular);

		lblSaldoMin = new JLabel("Saldo mínimo");
		panel.add(lblSaldoMin);

		txtSaldoMin = new JTextField();
		txtSaldoMin.setColumns(10);
		panel.add(txtSaldoMin);

		lblSaldo = new JLabel("Saldo");
		panel.add(lblSaldo);

		txtSaldo = new JTextField();
		txtSaldo.setColumns(10);
		panel.add(txtSaldo);

		lblAperturaCuenta = new JLabel("Fecha apertura cuenta");
		panel.add(lblAperturaCuenta);

		txtFechaApertura = new JTextField();
		txtFechaApertura.setColumns(10);
		panel.add(txtFechaApertura);

		lblCambiante1 = new JLabel("Interés Anual");
		panel.add(lblCambiante1);

		txtCambiante1 = new JTextField();
		txtCambiante1.setColumns(10);
		panel.add(txtCambiante1);


		lblCambiante2 = new JLabel("Porcentaje Ahorro");
		panel.add(lblCambiante2);

		txtCambiante2 = new JTextField();
		panel.add(txtCambiante2);
		txtCambiante2.setColumns(10);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);

		btnBorrar = new JButton("Borrar");
		panel_1.add(btnBorrar);

		btnGuardar = new JButton("Guardar");
		panel_1.add(btnGuardar);

		DesactivarTodo();

	}

}
