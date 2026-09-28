public class Nodo {

    //Clase nodo para la cola de prioridad y la lista enlazada simple.
    //El último atributo es de la misma clase y representa la referencia al siguiente nodo.

    //Atributos.
    private Ticket ticket;
    private Nodo siguiente;

    //Métodos.
    //Constructor.
    public Nodo(Ticket ticket) {
        this.ticket = ticket;
        this.siguiente = null;
    }

    //Getters.
    public Ticket getTicket() {
        return ticket;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    //Setters.
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return ticket.toString();
    }
}
