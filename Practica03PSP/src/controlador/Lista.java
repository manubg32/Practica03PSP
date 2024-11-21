package controlador;


//Prototipo por consola de la clase Lista
public class Lista {
    Nodo primero;

    public Lista(){
        primero = null;
    }

    public void agregarAlFinal(int valor){
        Nodo nuevoNodo = new Nodo(valor);

        if(primero == null){
            primero = nuevoNodo;
        } else {
            Nodo actual = primero;

            while(actual.siguiente != null){
                actual = actual.siguiente;
            }

            actual.siguiente = nuevoNodo;
        }
    }

    public void mostrarLista(){
        Nodo actual = primero;

        if(actual == null){
            //Para rellenar
            System.out.println("Lista vacia");
        } else {
            while(actual!=null){
                //Para rellenar
                System.out.println(actual.valor+" -> ");
                actual = actual.siguiente;
            }
            //Relleno
            System.out.println("null");
        }
    }

    public void eliminarPrimero(){
        if(primero != null){
            primero =primero.siguiente;
        }
    }
}
