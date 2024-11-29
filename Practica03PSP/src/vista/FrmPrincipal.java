package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnuAlta = new JMenu("Alta");
		menuBar.add(mnuAlta);
		
		JMenuItem mniAltaCuenta = new JMenuItem("Cuenta");
		mnuAlta.add(mniAltaCuenta);
		
		JMenu mnuVer = new JMenu("Ver");
		menuBar.add(mnuVer);
		
		JMenuItem mniLista = new JMenuItem("Lista");
		mnuVer.add(mniLista);
		
		JMenuItem mniIndividual = new JMenuItem("Individual");
		mnuVer.add(mniIndividual);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnCargar = new JButton("Cargar");
		panel.add(btnCargar);
		
		JButton btnGuardar = new JButton("Guardar");
		panel.add(btnGuardar);
		
		JButton btnVaciar = new JButton("Vaciar Lista");
		panel.add(btnVaciar);
		
		JButton btnTest = new JButton("Test");
		panel.add(btnTest);
		
		
		Image tmp = new ImageIcon(FrmPrincipal.class.getResource("/vista/icon.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon logo = new ImageIcon(tmp);
		JLabel lblLogo = new JLabel(logo);
		
		contentPane.add(lblLogo, BorderLayout.CENTER);
		
		
	}

}
