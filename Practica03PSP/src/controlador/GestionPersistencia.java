package controlador;

import modelo.Cuenta;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionPersistencia {
    private static final String NOMBRE_ARCHIVO = "Cuentas.dat";

    public void guardarCuentas(List<Cuenta> cuentas){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))){
            oos.writeObject(cuentas);
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + NOMBRE_ARCHIVO);
        }
    }

    public List<Cuenta> cargarCuentas(String nombreArchivo){
        List<Cuenta> cuentas = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))){
            cuentas = (List<Cuenta>) ois.readObject();
        } catch(ClassNotFoundException | IOException e){
            JOptionPane.showMessageDialog(null, "No se encontro el archivo");
        }
        return cuentas;
    }
}
