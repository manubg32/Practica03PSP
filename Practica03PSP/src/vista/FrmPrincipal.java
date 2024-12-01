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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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

		pnlLista = new PnlLista();
		pnlAltas = new PnlAltas();
		pnlIndividual = new PnlIndividual();
	}
	void addListeners(){

		mniLista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(pnlLista);
				revalidate();
				repaint();
			}
		});
		mniIndividual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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

}
