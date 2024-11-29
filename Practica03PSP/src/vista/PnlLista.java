package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;

public class PnlLista extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PnlLista() {
		setLayout(new BorderLayout(0, 0));
		
		JList lstLista = new JList();
		add(lstLista, BorderLayout.CENTER);

	}

}
