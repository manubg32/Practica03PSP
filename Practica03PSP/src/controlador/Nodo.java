package controlador;

public class Nodo<E> {
    private Nodo<E> siguiente;
    E principal;
    public Nodo(E p) {
        this.siguiente = null;
        this.principal = p;
    }

    public Nodo<E> getSiguiente() {
        return this.siguiente;

    }

    public void setSiguiente(Nodo<E> siguiente) {
        this.siguiente = siguiente;
    }

    public E getPrincipal() {
        return principal;
    }

    public void setPrincipal(E principal) {
        this.principal = principal;
    }
}
