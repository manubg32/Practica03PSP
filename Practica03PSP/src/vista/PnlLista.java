package vista;

import controlador.GestionLista;
import modelo.Lista;
import modelo.Nodo;

import javax.swing.*;
import java.awt.*;

public class PnlLista extends JPanel {
	private static final long serialVersionUID = 1L;

	private JList<Nodo> lstLista;
	private JScrollPane scroll;
	private DefaultListModel<Nodo> listModel;

	public PnlLista() {
		setLayout(new BorderLayout(0, 0));
		addComponents();
	}

	private void addComponents() {
		scroll = new JScrollPane();
		listModel = new DefaultListModel<>();
		lstLista = new JList<>(listModel);
		lstLista.setCellRenderer(new NodoCellRenderer());

		scroll.setViewportView(lstLista);
		add(scroll, BorderLayout.CENTER);
	}

	public void mostrarListaIndividual(Lista lista) {
		listModel.clear();
		for (Nodo nodo : lista.obtenerNodos()) {
			listModel.addElement(nodo);
		}
	}

	class NodoCellRenderer extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			Nodo nodo = (Nodo) value;
			JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			label.setText(nodo.toString());
			return label;
		}
	}
}
