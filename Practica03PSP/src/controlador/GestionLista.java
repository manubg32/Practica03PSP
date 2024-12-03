package controlador;

import modelo.Cuenta;
import modelo.Lista;

public class GestionLista {
    private static Lista cuentas = GestionPersistencia.cargarCuentas();
    private static int size= 0;


    public static Lista getLista(){
        if(cuentas == null){
            cuentas = new Lista();
        }
        return cuentas;
    }
    public static void setLista(Lista c){
        cuentas = c;
    }
    public static void sobreescribir(){
        GestionPersistencia.guardarCuentas(cuentas);
    }
    public static void agregarCuenta(Cuenta c){
        cuentas.agregar(c);
        size++;
    }

    public static void borrarLista(){
        setLista(new Lista());
    }
    public static int getSize(){
        return size;
    }
}
