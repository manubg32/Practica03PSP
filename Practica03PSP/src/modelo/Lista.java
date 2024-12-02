package modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Prototipo por consola de la clase Lista
public class Lista implements Serializable {
    static final long serialVersionUID = 1L;
   private Nodo primero;
   private Nodo ultimo;
   public Lista() {}


    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public void agregar(Object valor){
        Nodo nuevo = new Nodo();
        nuevo.setValor(valor);

        if(primero == null) {
            // Si la lista está vacía, el nuevo nodo es el primero y el último
            primero = nuevo;
            ultimo = primero;
        } else {
            // Si la lista no está vacía, agregamos el nuevo nodo al final
            Nodo tmp = ultimo;
            ultimo.setSiguiente(nuevo); // Enlazamos el nodo anterior con el siguiente (nuevo nodo)
            nuevo.setAnterior(tmp);     // Enlazamos el nuevo nodo con el nodo anterior (ultimo nodo)
            ultimo = nuevo;             // Actualizamos el último nodo
        }
    }

   public void eliminar(Object valor){
       Nodo tmp = null; // Nodo a eliminar
       Nodo aux = null; // Nodo anterior al que eliminamos

       if(primero != null){
           if(primero.getValor() == valor){
               // Eliminar el primero
               tmp = primero;
               primero = primero.getSiguiente();
               if(primero == null){ // Si la lista queda vacía
                   ultimo = null;
               } else {
                   primero.setAnterior(null);
               }
           } else if(ultimo.getValor() == valor){
               // Eliminar el último
               tmp = ultimo;
               ultimo = ultimo.getAnterior();
               ultimo.setSiguiente(null);
           } else {
               // Eliminar en el medio
               aux = primero;
               tmp = primero.getSiguiente();
               while(tmp != null){
                   if(tmp.getValor() == valor){
                       aux.setSiguiente(tmp.getSiguiente());
                       if(tmp.getSiguiente() != null){
                           tmp.getSiguiente().setAnterior(aux);
                       }
                       break;
                   }
                   aux = tmp;
                   tmp = tmp.getSiguiente();
               }
           }
       }
   }

   public void recorrerPrimeroUltimo(){
        Nodo tmp = primero;
        while(tmp!=null){
            System.out.println(tmp.getValor().toString() + "\n");
            tmp = tmp.getSiguiente();
        }
   }
   public void recorrerUltimoPrimero(){
       Nodo tmp = ultimo;
       while(tmp!=null){
           System.out.println(tmp.getValor().toString() + "\n");
           tmp = tmp.getAnterior();
       }
       System.out.println();
   }

    /*Este metodo va a verificar si la lista esta vacia
     si no esta vacia va a recorrer la lista enlazada y agregara
     los nodos a la lista de nodos
     */
    public List<Nodo> obtenerNodos() {
        List<Nodo> nodos = new ArrayList<>();
        Nodo tmp = primero;
        while (tmp != null) {
            nodos.add(tmp);
            tmp = tmp.getSiguiente();
        }
        return nodos;
    }
}
