package controlador;


import modelo.Cuenta;

//Prototipo por consola de la clase Lista
public class Lista {
   private Nodo primero;
   private Nodo ultimo;
   public Lista() {}


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

       if(primero !=null){
           if(primero.getValor() == valor){
               //Eliminar el primero
               tmp = primero;
               primero = tmp.getSiguiente();
               if(primero == null){
                   ultimo = null;
               }else {
                   primero.setAnterior(null);
               }
           } else if(ultimo.getValor() == valor){
               tmp = ultimo;
               ultimo = tmp.getAnterior();
               ultimo.setSiguiente(null);
           } else{
               aux = primero;
               tmp = primero.getSiguiente();

               while(tmp != null){
                   if(tmp.getValor() == valor){
                       aux.setSiguiente(tmp.getSiguiente());
                       tmp.getSiguiente().setAnterior(aux);

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
