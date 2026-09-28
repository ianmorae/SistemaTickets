public class ListaEnlazadaSimple {

    //Lista enlazada simple para los tickets resueltos.
    //El único atributo que contiene es la referencia al primer nodo de la lista.

    //Atributos.
    private Nodo primero;

    //Métodos.
    //Constructor.
    public ListaEnlazadaSimple() {
        primero = null;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public void insertarNodoFinal(Ticket ticketNodo) {
        Nodo nuevoNodo = new Nodo(ticketNodo);
        if (primero == null) {
            setPrimero(nuevoNodo);
            return;
        }
        Nodo nodoTemp = primero;
        while (nodoTemp.getSiguiente() != null) {
            nodoTemp = nodoTemp.getSiguiente();
        }
        nodoTemp.setSiguiente(nuevoNodo);
    }

    public Ticket buscarNodo(int idBuscar) {
        Nodo nodoActual = primero;
        while (nodoActual != null && nodoActual.getTicket().getId() != idBuscar) {
            nodoActual = nodoActual.getSiguiente();
        }
        if (nodoActual == null) {
            return null;
        }
        return nodoActual.getTicket();
    }

    public void mostrarLista() {
        if (primero == null) {
            System.out.println("No hay tickets resueltos.\n");
            return;
        }
        Nodo nodoActual = primero;
        while (nodoActual != null) {
            System.out.println(nodoActual + "\n");
            nodoActual = nodoActual.getSiguiente();
        }
    }
}
