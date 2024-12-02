package modelo;


import java.io.Serializable;

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

        if(primero == null){
            primero = nuevo;
            ultimo = primero;
        }else{
            Nodo tmp = ultimo;
            ultimo.setAnterior(tmp);
            tmp.setSiguiente(ultimo);
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
}
