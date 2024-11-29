package controlador;


//Prototipo por consola de la clase Lista
public class Lista<E> {
   private Nodo<E> inicio;
   public Lista() {
       this.inicio = null;
   }


   public void mostrarLista(){
       Nodo<E> aux = this.inicio;
       while(aux != null){
           System.out.println(aux.getPrincipal().toString());
           aux = aux.getSiguiente();
       }
   }

   public void insertarNodo(E p){
       Nodo<E> nuevoNodo = this.inicio;
       nuevoNodo.setSiguiente(this.inicio);
       this.inicio = nuevoNodo;
   }
}
