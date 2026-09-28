# Sistema de Gestión de Tickets

Universidad CENFOTEC. <br>
SOFT-10 Estructuras de Datos. <br>
C3-2026.  <br>
Docente: Romario Salas Cerdas. <br>
Estudiante: Ian Aarón Mora Espinoza. 

## Descripción

Programa de consola en Java para gestionar tickets de soporte. Tiene un menú de usuario (crear y buscar tickets) y un menú de administrador (ver y resolver tickets).

- Los tickets **pendientes** se guardan en una **cola de prioridad** (`ColaPrioridad`).
- Los tickets **resueltos** se guardan en una **lista enlazada simple** (`ListaEnlazadaSimple`).

## Clases

- **Ticket:** `id`, `descripcion`, `nombreCompleto`, `fechaCreacion`, `fechaResolucion` (inicia en `null`) y `prioridad` (1 = Alta, 2 = Media, 3 = Baja). El `id` se genera con el contador estático `cantidad`.
- **Nodo:** guarda un `Ticket` y la referencia al `siguiente` nodo.
- **ColaPrioridad:** `insertar()`, `remover()`, `verFrente()`, `estaVacia()`, `mostrarCola()`. Al insertar, el ticket se ubica según su prioridad; si hay empate, queda detrás de los que llegaron antes.
- **ListaEnlazadaSimple:** `insertarNodoFinal()`, `buscarNodo()`, `mostrarLista()`.
- **Main:** contiene el `main()` y los menús.

## Menús

**Usuario**
1. Crear ticket: pide nombre, descripción y prioridad, y lo inserta en la cola.
2. Buscar ticket: busca el id en la lista de resueltos. Si no está, indica que el ticket está pendiente.

**Administrador**
1. Ver el ticket al frente de la cola.
2. Resolver el ticket al frente: se remueve de la cola, se le asigna la `fechaResolucion` y se agrega a la lista de resueltos.
3. Ver tickets pendientes.
4. Ver tickets resueltos.

## Pasos realizados

1. Se definieron las clases `Ticket` y `Nodo`.
2. Se implementó la cola de prioridad con nodos enlazados.
3. Se implementó la lista enlazada simple.
4. Se creó el `main()` con los menús de usuario y administrador.
5. Se probaron la creación, resolución y búsqueda de tickets.
