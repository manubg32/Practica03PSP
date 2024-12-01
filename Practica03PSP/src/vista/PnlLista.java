package vista;

import controlador.GestionCuentas;
import modelo.Nodo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PnlLista extends JPanel {

	private static final long serialVersionUID = 1L;

	private JList<Nodo> lstLista;
	private JScrollPane scroll;
	private DefaultListModel<Nodo> listModel;

	public PnlLista() {
		setLayout(new BorderLayout(0, 0));
		addComponents();
		mostrarListaIndividual();
	}

	private void addComponents(){
		scroll = new JScrollPane();


		listModel = new DefaultListModel<>();
		lstLista = new JList<>(listModel);
		lstLista.setCellRenderer(new NodoCellRenderer());

		scroll.setViewportView(lstLista);
		add(scroll, BorderLayout.CENTER);
	}

	// Obtiene la lista  de nodos desde gestion cuentas y agrega
	// los nodos a la lista modelo
	public void mostrarListaIndividual(){
		List<Nodo> nodoList = GestionCuentas.obtenerNodos();
		listModel.clear();

		for (Nodo nodo : nodoList) {
			listModel.addElement(nodo);
		}
	}

	// Esto es un renderer personalizado para mostrar los nodos de manera mas clara
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
