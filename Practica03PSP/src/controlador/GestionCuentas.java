package controlador;

import modelo.*;
import vista.PnlAltas;
import vista.PnlIndividual;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GestionCuentas {
    private static Lista lstCuentas;
    public static Nodo actual;
    public GestionCuentas(){
        lstCuentas = GestionLista.getLista();
    }

    public static void mostrarSiguiente() {
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
    public static void mostrarAnterior() {
        if (actual == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía", "Lista Vacía", JOptionPane.WARNING_MESSAGE);
        } else {
            if (actual.getAnterior() != null) {
                actual = actual.getAnterior();  // Solo movemos a la cuenta anterior si existe
                mostrarCuentaActual();  // Mostrar la cuenta actual
            } else {
                JOptionPane.showMessageDialog(null, "Ya estás en la primera cuenta", "Inicio de la lista", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    // Método para mostrar la cuenta actual
    private static void mostrarCuentaActual() {
        if (actual != null) {
            Cuenta cuentaActual = (Cuenta) actual.getValor();  // Obtener la cuenta del nodo actual
            // Aquí se llama a un método en PnlIndividual para actualizar la vista
            PnlIndividual.actualizarVista(cuentaActual);
        }
    }




    public boolean ComprobarDatos(Object selectedItem, String titular, String saldoMin, String saldo, String fechaApertura, String cambiante1, String cambiante2) throws DineroInferiorException {

        if (comprobarComunes(titular, saldoMin, saldo, fechaApertura)) {
            if (selectedItem.equals("Cuenta corriente")) {

                //Comprobamos la comision de mantenimiento
                if (!cambiante1.isBlank()){
                    Double.parseDouble(PnlAltas.txtCambiante1.getText());
                } else {
                    PnlAltas.lblCambiante1.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, "La comision de mantenimiento no puede quedar vacio", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
                    return false;
                }

                //Comprobamos el tipo de comision
                if (cambiante2.isBlank()){
                    PnlAltas.lblCambiante2.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, "El tipo de comisión no puede quedar vacio", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
                    return false;
                }


            } else if (selectedItem.equals("Cuenta ahorro")) {

                //Comprobamos el interés anual
                if (!cambiante1.isBlank()){
                    Double.parseDouble(PnlAltas.txtCambiante1.getText());
                } else {
                    PnlAltas.lblCambiante1.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, "El interés anual no puede quedar vacio", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
                    return false;
                }

                //Comprobamos el porcentaje de ahorro
                if (!cambiante2.isBlank()){
                    Double.parseDouble(PnlAltas.txtCambiante2.getText());
                } else {
                    PnlAltas.lblCambiante2.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, "El porcentaje de ahorro no puede quedar vacio", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
        } else {
            return false;
        }
        //Si to-do es correcto retornamos un true
        return true;
    }

    private boolean comprobarComunes(String titular, String saldoMin, String saldo, String fechaApertura) throws DineroInferiorException {
        //Comprobamos el titular
        if (titular.isBlank()){
            PnlAltas.lblTitular.setForeground(Color.RED);
            JOptionPane.showMessageDialog(null, "El titular no puede quedar vacio", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        //Comprobamos el saldoMin
        if (!saldoMin.isBlank()) {
            Double.parseDouble(saldoMin);
        } else{
            PnlAltas.lblSaldoMin.setForeground(Color.RED);
            JOptionPane.showMessageDialog(null, "El saldoMin no puede quedar vacio", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        //Comprobamos el saldo
        if (!saldo.isBlank()){
            Double.parseDouble(saldo);
            //Comprobamos que sea mayor que el sueldoMin
            if (Integer.parseInt(saldo) < Integer.parseInt(saldoMin)){
                PnlAltas.lblSaldo.setForeground(Color.RED);
                PnlAltas.lblSaldoMin.setForeground(Color.RED);
                throw new DineroInferiorException();
            }
        } else {
            PnlAltas.lblSaldo.setForeground(Color.RED);
            JOptionPane.showMessageDialog(null, "El saldo no puede quedar vacio", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        //Comprobamos la FechaApertura
        if (!fechaApertura.isBlank()) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            try {
                // Parsear el texto a Date
                Date fecha = formato.parse(fechaApertura);

                // Convertir Date a Calendar
                Calendar calendario = Calendar.getInstance();
                calendario.setTime(fecha);

            } catch (ParseException ex) {
                // Manejar el error de formato
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Usa dd/MM/yyyy", "Hay un problemilla", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            PnlAltas.lblAperturaCuenta.setForeground(Color.RED);
            JOptionPane.showMessageDialog(null, "La fecha de apertura  no puede quedar vacio", "Hay un problemilla", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

}
