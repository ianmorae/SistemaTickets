public class ColaPrioridad {

    //Cola de prioridad para los tickets pendientes.
    //Los tickets se ordenan por prioridad y, si tienen la misma, por orden de llegada.

    //Atributos.
    private Nodo frente;
    private int tamanioActual;

    //Métodos.
    //Constructor.
    public ColaPrioridad() {
        frente = null;
        tamanioActual = 0;
    }

    public int getTamanioActual() {
        return tamanioActual;
    }

    public void insertar(Ticket nuevoTicket) {
        Nodo nuevoNodo = new Nodo(nuevoTicket);
        if (estaVacia() || nuevoTicket.getPrioridad() < frente.getTicket().getPrioridad()) {
            nuevoNodo.setSiguiente(frente);
            frente = nuevoNodo;
        } else {
            Nodo nodoActual = frente;
            while (nodoActual.getSiguiente() != null
                    && nodoActual.getSiguiente().getTicket().getPrioridad() <= nuevoTicket.getPrioridad()) {
                nodoActual = nodoActual.getSiguiente();
            }
            nuevoNodo.setSiguiente(nodoActual.getSiguiente());
            nodoActual.setSiguiente(nuevoNodo);
        }
        tamanioActual++;
    }

    public Ticket remover() {
        if (estaVacia()) {
            return null;
        }
        Ticket ticketTemp = frente.getTicket();
        frente = frente.getSiguiente();
        tamanioActual--;
        return ticketTemp;
    }

    public Ticket verFrente() {
        if (estaVacia()) {
            return null;
        }
        return frente.getTicket();
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("No hay tickets pendientes.\n");
            return;
        }
        Nodo nodoActual = frente;
        while (nodoActual != null) {
            System.out.println(nodoActual + "\n");
            nodoActual = nodoActual.getSiguiente();
        }
    }
}
