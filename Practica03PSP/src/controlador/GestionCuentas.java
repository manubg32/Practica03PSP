package controlador;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GestionCuentas {
    private static Lista lstCuentas;
    public static Nodo actual;
    public GestionCuentas(){
        lstCuentas = GestionLista.getLista();
    }

    public void mostrarSiguiente() {
        if (actual == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía", "Lista Vacia", JOptionPane.WARNING_MESSAGE);
        } else {
            if (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
                mostrarCuentaActual();
            } else {
                JOptionPane.showMessageDialog(null, "Ya estás en la última cuenta", "Final de la lista", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    private void mostrarAnterior(){
        if(actual == null){
            JOptionPane.showMessageDialog(null,"La lista esta vacia", "Lista Vacia", JOptionPane.WARNING_MESSAGE);
        } else {
            if(actual.getAnterior() == null){
                actual = actual.getAnterior();
                mostrarCuentaActual();
            } else {
                JOptionPane.showMessageDialog(null, "Ya estas en la primera cuenta", "Inicio de la lista", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    // Método para mostrar la cuenta actual
    private void mostrarCuentaActual() {
        if (actual != null) {
            Cuenta cuentaActual = (Cuenta) actual.getValor(); // Obtener la cuenta del nodo actual
            // Mostrar información dependiendo del tipo de cuenta
            if (cuentaActual instanceof CuentaAhorro) {
                CuentaAhorro cuentaAhorro = (CuentaAhorro) cuentaActual; // Convertir a CuentaAhorro
                JOptionPane.showMessageDialog(null, "Cuenta Ahorro - " + cuentaAhorro.toString(), "Cuenta Actual", JOptionPane.INFORMATION_MESSAGE);
            } else if (cuentaActual instanceof CuentaCorriente) {
                CuentaCorriente cuentaCorriente = (CuentaCorriente) cuentaActual; // Convertir a CuentaCorriente
                JOptionPane.showMessageDialog(null, "Cuenta Corriente - " + cuentaCorriente.toString(), "Cuenta Actual", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cuenta - " + cuentaActual.toString(), "Cuenta Actual", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    /*Este metodo va a verificar si la lista esta vacia
    si no esta vacia va a recorrer la lista enlazada y agregara
    los nodos a la lista de nodos
    */
    public static List<Nodo> obtenerNodos() {
        if(lstCuentas==null){
            lstCuentas = new Lista();
        }
        List<Nodo> nodoList = new ArrayList<>();
        Nodo current = lstCuentas.getPrimero();

        // Recorrer la lista enlazada y agregar los nodos a la lista
        while (current != null) {
            nodoList.add(current);
            current = current.getSiguiente();
        }

        return nodoList;
    }
}
