package controlador;

import modelo.Cuenta;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionPersistencia {

    public void guardarCuentas(List<Cuenta> cuentas, String nombreArchivo){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))){
            oos.writeObject(cuentas);
        }catch (FileNotFoundException e){
            //Hacer que salga un mensaje
        }catch(IOException e){
            //Hacer que salga otro mensaje
        }
    }

    public List<Cuenta> cargarCuentas(String nombreArchivo){
        List<Cuenta> cuentas = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))){
            cuentas = (List<Cuenta>) ois.readObject();
        } catch(ClassNotFoundException | IOException e){
            //Hacer mensaje
        }
        return cuentas;
    }
}
