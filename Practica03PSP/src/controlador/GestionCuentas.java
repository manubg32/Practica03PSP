package controlador;

import modelo.Cuenta;
import modelo.Lista;
import modelo.Nodo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GestionCuentas {
    private static Lista lstCuentas;
    public GestionCuentas(){

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
