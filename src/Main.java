import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    //Sistema de gestión de tickets en línea.
    //Los tickets pendientes van en una cola de prioridad y los resueltos en una lista enlazada simple.

    private static Scanner scanner = new Scanner(System.in);
    private static ColaPrioridad ticketsPendientes = new ColaPrioridad();
    private static ListaEnlazadaSimple ticketsResueltos = new ListaEnlazadaSimple();

    public static void main(String[] args) {
        int opcion;
        //El menú principal se repite hasta que el usuario elige salir.
        do {
            System.out.println("===== SISTEMA DE TICKETS =====");
            System.out.println("1. Menú de usuario");
            System.out.println("2. Menú de administrador");
            System.out.println("0. Salir");
            opcion = leerEntero("Seleccione una opción: ");
            System.out.println();

            //Se envía al usuario al menú que eligió.
            switch (opcion) {
                case 1:
                    menuUsuario();
                    break;
                case 2:
                    menuAdministrador();
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción inválida.\n");
            }
        } while (opcion != 0);

        scanner.close();
    }

    public static void menuUsuario() {
        int opcion;
        do {
            System.out.println("----- MENÚ DE USUARIO -----");
            System.out.println("1. Crear ticket");
            System.out.println("2. Buscar ticket");
            System.out.println("0. Volver");
            opcion = leerEntero("Seleccione una opción: ");
            System.out.println();

            switch (opcion) {
                case 1:
                    crearTicket();
                    break;
                case 2:
                    buscarTicket();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.\n");
            }
        } while (opcion != 0);
    }

    public static void menuAdministrador() {
        int opcion;
        do {
            System.out.println("----- MENÚ DE ADMINISTRADOR -----");
            System.out.println("1. Ver ticket al frente de la cola");
            System.out.println("2. Resolver ticket al frente de la cola");
            System.out.println("3. Ver tickets pendientes");
            System.out.println("4. Ver tickets resueltos");
            System.out.println("0. Volver");
            opcion = leerEntero("Seleccione una opción: ");
            System.out.println();

            switch (opcion) {
                case 1:
                    verFrente();
                    break;
                case 2:
                    resolverTicket();
                    break;
                case 3:
                    ticketsPendientes.mostrarCola();
                    break;
                case 4:
                    ticketsResueltos.mostrarLista();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.\n");
            }
        } while (opcion != 0);
    }

    public static void crearTicket() {
        String nombreCompleto = leerTexto("Nombre completo: ");
        String descripcion = leerTexto("Descripción: ");

        int prioridad = leerEntero("Prioridad (1 = Alta, 2 = Media, 3 = Baja): ");
        while (prioridad < 1 || prioridad > 3) {
            prioridad = leerEntero("Prioridad inválida, ingrese 1, 2 o 3: ");
        }

        Ticket nuevoTicket = new Ticket(descripcion, nombreCompleto, prioridad);
        ticketsPendientes.insertar(nuevoTicket);
        System.out.println("\nTicket creado. Su número de ticket es #" + nuevoTicket.getId() + "\n");
    }

    public static void buscarTicket() {
        int id = leerEntero("Ingrese el id del ticket: ");
        if (id < 1 || id > Ticket.getCantidad()) {
            System.out.println("\nNo existe un ticket con ese id.\n");
            return;
        }
        Ticket ticket = ticketsResueltos.buscarNodo(id);
        if (ticket != null) {
            System.out.println("\n" + ticket + "\n");
        } else {
            System.out.println("\nEl ticket #" + id + " está pendiente.\n");
        }
    }

    public static void verFrente() {
        Ticket ticket = ticketsPendientes.verFrente();
        if (ticket == null) {
            System.out.println("No hay tickets pendientes.\n");
        } else {
            System.out.println(ticket + "\n");
        }
    }

    //Remueve el ticket del frente, le asigna la fecha de resolución y lo pasa a la lista de resueltos.
    public static void resolverTicket() {
        Ticket ticket = ticketsPendientes.remover();
        if (ticket == null) {
            System.out.println("No hay tickets pendientes.\n");
            return;
        }
        ticket.setFechaResolucion(LocalDateTime.now());
        ticketsResueltos.insertarNodoFinal(ticket);
        System.out.println("Ticket resuelto:\n" + ticket + "\n");
    }

    //Lee un número entero y lo vuelve a pedir si el usuario escribe algo inválido.
    public static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número.");
            }
        }
    }

    //Lee un texto y lo vuelve a pedir si el usuario lo deja vacío.
    public static String leerTexto(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }
}
