package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class PnlAltas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtTitular;
	private JTextField txtSaldoMin;
	private JTextField txtSaldo;
	private JTextField textField_3;
	private JTextField txtCambiante1;
	private JTextField txtCambiante2;

	/**
	 * Create the panel.
	 */
	public PnlAltas() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(7, 2, 0, 0));
		
		JLabel lblTipo = new JLabel("Tipo de Cuenta");
		panel.add(lblTipo);
		
		String[] cuentas = {"Cuenta corriente", "Cuenta ahorro"};
		JComboBox<String> cmbTipo = new JComboBox<>(cuentas);
		panel.add(cmbTipo);
		
		JLabel lblTitular = new JLabel("Titular");
		panel.add(lblTitular);
		
		txtTitular = new JTextField();
		txtTitular.setColumns(10);
		panel.add(txtTitular);
		
		JLabel lblSaldoMin = new JLabel("Saldo mínimo");
		panel.add(lblSaldoMin);
		
		txtSaldoMin = new JTextField();
		txtSaldoMin.setColumns(10);
		panel.add(txtSaldoMin);
		
		JLabel lblSaldo = new JLabel("Saldo");
		panel.add(lblSaldo);
		
		txtSaldo = new JTextField();
		txtSaldo.setColumns(10);
		panel.add(txtSaldo);
		
		JLabel lblAperturaCuenta = new JLabel("Fecha apertura cuenta");
		panel.add(lblAperturaCuenta);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		JLabel lblCambiante1 = new JLabel("Interés Anual");
		panel.add(lblCambiante1);
		
		txtCambiante1 = new JTextField();
		txtCambiante1.setColumns(10);
		txtCambiante1.setVisible(false);
		panel.add(txtCambiante1);
		
		
		JLabel lblCambiante2 = new JLabel("Porcentaje Ahorro");
		lblCambiante2.setVisible(false);
		panel.add(lblCambiante2);
		
		txtCambiante2 = new JTextField();
		panel.add(txtCambiante2);
		txtCambiante2.setColumns(10);
		txtCambiante2.setVisible(false);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnBorrar = new JButton("Borrar");
		panel_1.add(btnBorrar);
		
		JButton btnGuardar = new JButton("Guardar");
		panel_1.add(btnGuardar);

	}

}
