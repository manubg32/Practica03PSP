package controlador;

import modelo.Cuenta;
import modelo.Lista;

public class GestionLista {
    static GestionPersistencia gp = new GestionPersistencia();
    private static Lista cuentas = gp.cargarCuentas();

    public static Lista getLista(){
        return cuentas;
    }
    public static void setLista(Lista c){
        cuentas = c;
    }
    public static void sobreescribir(){
        gp.guardarCuentas(cuentas);
    }
    public static void agregarCuenta(Cuenta c){
        cuentas.agregar(c);
    }

    public static void borrarLista(){
        setLista(new Lista());
    }
}
