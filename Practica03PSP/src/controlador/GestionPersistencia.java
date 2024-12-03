package controlador;

import modelo.Lista;

import javax.swing.*;
import java.io.*;

public class GestionPersistencia {
    private static final String NOMBRE_ARCHIVO = "Cuentas.dat";
    private static Lista cuentas = null; // Inicializa con una nueva lista vacía
    // Guardar cuentas en el archivo
    public static void guardarCuentas(Lista cuenta) {
        cuentas = cuenta;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            oos.writeObject(cuentas);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + NOMBRE_ARCHIVO + "\n" + e.getMessage());
        }
    }

    // Cargar cuentas desde el archivo
    public static Lista cargarCuentas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
            cuentas = (Lista) ois.readObject();
            return cuentas;
        } catch (ClassNotFoundException | IOException e) {
            // Si hay un error al cargar, puedes dejar cuentas como una lista vacía o mostrar un mensaje específico
            JOptionPane.showMessageDialog(null, "No se encontró o no se pudo cargar el archivo.");
        }
        return cuentas;  // Retorna la lista, que podría estar vacía si hubo un error
    }

    public static Lista getListaCuentas() {
        if (cuentas == null) {
            cargarCuentas(); // Cargar si aún no está inicializada
        }
        return cuentas;
    }
}
