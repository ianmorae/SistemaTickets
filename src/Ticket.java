import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {

    //Clase que representa un ticket del sistema.

    //Atributos.
    private static int cantidad = 0;
    private int id;
    private String descripcion;
    private String nombreCompleto;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaResolucion;
    private int prioridad; //1 = Alta, 2 = Media, 3 = Baja.

    //Métodos.
    //Constructor.
    public Ticket(String descripcion, String nombreCompleto, int prioridad) {
        cantidad++;
        this.id = cantidad;
        this.descripcion = descripcion;
        this.nombreCompleto = nombreCompleto;
        this.prioridad = prioridad;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaResolucion = null;
    }

    //Getters.
    public static int getCantidad() {
        return cantidad;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    //Setters.
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setFechaResolucion(LocalDateTime fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getPrioridadTexto() {
        if (prioridad == 1) {
            return "Alta";
        } else if (prioridad == 2) {
            return "Media";
        } else {
            return "Baja";
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String resolucion = "Pendiente";
        if (fechaResolucion != null) {
            resolucion = fechaResolucion.format(formato);
        }
        return "Ticket #" + id
                + "\n  Usuario: " + nombreCompleto
                + "\n  Descripción: " + descripcion
                + "\n  Prioridad: " + getPrioridadTexto()
                + "\n  Fecha de creación: " + fechaCreacion.format(formato)
                + "\n  Fecha de resolución: " + resolucion;
    }
}
