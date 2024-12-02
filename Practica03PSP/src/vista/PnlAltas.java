package vista;

import controlador.DineroInferiorException;
import controlador.GestionCuentas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlAltas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtTitular;
	private JTextField txtSaldoMin;
	private JTextField txtSaldo;
	private JTextField txtFechaApertura;
	private JTextField txtCambiante1;
	private JTextField txtCambiante2;
	private JLabel lblTipo;
	private JComboBox<String> cmbTipo;
	public JLabel lblTitular;
	public JLabel lblSaldoMin;
	public JLabel lblSaldo;
	public JLabel lblAperturaCuenta;
	public JLabel lblCambiante1;
	public JLabel lblCambiante2;
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
				txtTitular.setText("");
				txtSaldoMin.setText("");
				txtSaldo.setText("");
				txtFechaApertura.setText("");
				txtCambiante1.setText("");
				txtCambiante2.setText("");
			}
		});

		btnGuardar.addActionListener(new ActionListener() {

			@Override public void actionPerformed(ActionEvent e) {
				try {
					//Cambiar a gc.ComprobarDatos
					if (ComprobarDatos(cmbTipo.getSelectedItem() ,txtTitular.getText(), txtSaldoMin.getText(), txtSaldo.getText(), txtFechaApertura.getText(), txtCambiante1.getText(), txtCambiante2.getText()))
					{

					}
				} catch (DineroInferiorException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
				} catch (NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Los saldos, intereses y comisiones deben ser un número sin signos", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

	private boolean ComprobarDatos(Object selectedItem, String titular, String saldoMin, String saldo, String fechaApertura, String cambiante1, String cambiante2) throws DineroInferiorException {

		if (comprobarComunes(titular, saldoMin, saldo, fechaApertura)) {
			if (selectedItem.equals("Cuenta corriente")) {

				//Comprobamos la comision de mantenimiento
				if (!cambiante1.isBlank()){
					Double.parseDouble(txtCambiante1.getText());
				} else {
					lblCambiante1.setForeground(Color.RED);
					JOptionPane.showMessageDialog(null, "La comision de mantenimiento no puede quedar vacio", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
					return false;
				}

				//Comprobamos el tipo de comision
				if (cambiante2.isBlank()){
					lblCambiante2.setForeground(Color.RED);
					JOptionPane.showMessageDialog(null, "El tipo de comisión no puede quedar vacio", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
					return false;
				}


			} else if (selectedItem.equals("Cuenta ahorro")) {

			}
		} else {
			return false;
		}


		return true;
	}

	private boolean comprobarComunes(String titular, String saldoMin, String saldo, String fechaApertura) throws DineroInferiorException {
		//Comprobamos el titular
		if (titular.isBlank()){
			lblTitular.setForeground(Color.RED);
			JOptionPane.showMessageDialog(null, "El titular no puede quedar vacio", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		//Comprobamos el saldoMin
		if (!saldoMin.isBlank()) {
			Integer.parseInt(saldoMin);
		} else{
			lblSaldoMin.setForeground(Color.RED);
			JOptionPane.showMessageDialog(null, "El saldoMin no puede quedar vacio", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		//Comprobamos el saldo
		if (!saldo.isBlank()){
			Integer.parseInt(saldo);
			//Comprobamos que sea mayor que el sueldoMin
			if (Integer.parseInt(saldo) < Integer.parseInt(saldoMin)){
				lblSaldo.setForeground(Color.RED);
				lblSaldoMin.setForeground(Color.RED);
				throw new DineroInferiorException();
			}
		} else {
			lblSaldo.setForeground(Color.RED);
			JOptionPane.showMessageDialog(null, "El saldo no puede quedar vacio", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		//Comprobamos la FechaApertura
		if (!fechaApertura.isBlank()) {
			lblAperturaCuenta.setForeground(Color.RED);
			JOptionPane.showMessageDialog(null, "La fecha de apertura  no puede quedar vacio", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
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
