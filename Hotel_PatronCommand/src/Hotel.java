import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Clase Receptora (Hotel)
class Hotel {
    private Map<Integer, String> habitacionesOcupadas = new HashMap<>();
    private Map<String, Boolean> checkIns = new HashMap<>();
    private Map<String, List<String>> serviciosSolicitados = new HashMap<>();

    public String realizarCheckIn(String cliente, int numeroHabitacion) {
        if (checkIns.containsKey(cliente)) {
            return cliente + " ya ha realizado el check-in en otra habitación.";
        } else if (numeroHabitacion <= 0) {
            return "El número de habitación debe ser mayor que 0.";
        } else if (habitacionesOcupadas.containsKey(numeroHabitacion)) {
            return "La habitación " + numeroHabitacion + " ya está ocupada por "
                    + habitacionesOcupadas.get(numeroHabitacion);
        } else {
            checkIns.put(cliente, true);
            habitacionesOcupadas.put(numeroHabitacion, cliente);
            return cliente + " ha realizado el check-in en la habitación " + numeroHabitacion;
        }
    }

    public String realizarCheckOut(String cliente) {
        if (checkIns.containsKey(cliente)) {
            int numeroHabitacion = obtenerNumeroHabitacion(cliente);
            if (numeroHabitacion > 0) {
                checkIns.remove(cliente);
                habitacionesOcupadas.remove(numeroHabitacion);
                if (serviciosSolicitados.containsKey(cliente)) {
                    serviciosSolicitados.remove(cliente);
                }
                return cliente + " ha realizado el check-out de la habitacion #" + numeroHabitacion;
            }
        }
        return cliente + " no puede realizar check-out. No ha realizado el check-in.";
    }

    public String realizarSolicitudServicio(String cliente, String servicio) {
        if (checkIns.containsKey(cliente)) {
            if (!serviciosSolicitados.containsKey(cliente)) {
                serviciosSolicitados.put(cliente, new ArrayList<>());
            }
            serviciosSolicitados.get(cliente).add(servicio);
            return cliente + " ha solicitado el servicio de " + servicio;
        } else {
            return cliente + " no puede solicitar un servicio. No ha realizado el check-in.";
        }
    }

    public String verClientes() {
        StringBuilder clientesInfo = new StringBuilder(
                "Clientes que han realizado check-in y servicios solicitados:\n");
        for (String cliente : checkIns.keySet()) {
            clientesInfo.append("- ").append(cliente);
            int numeroHabitacion = obtenerNumeroHabitacion(cliente);
            if (numeroHabitacion > 0) {
                clientesInfo.append(" se esta hospendando en la habitación #")
                        .append(numeroHabitacion).append(" ");
            }
            if (serviciosSolicitados.containsKey(cliente)) {
                clientesInfo.append("→ Servicios solicitados: ");
                List<String> servicios = serviciosSolicitados.get(cliente);
                for (String servicio : servicios) {
                    clientesInfo.append(servicio).append(", ");
                }
                // Eliminar la última coma y espacio
                clientesInfo.delete(
                        clientesInfo.length() - 2, clientesInfo.length());
            } else {
                clientesInfo.append("Ningún servicio solicitado.");
            }
            clientesInfo.append("\n");
        }
        return clientesInfo.toString();
    }

    private int obtenerNumeroHabitacion(String cliente) {
        for (Map.Entry<Integer, String> entry : habitacionesOcupadas.entrySet()) {
            if (entry.getValue().equals(cliente)) {
                return entry.getKey();
            }
        }
        return -1; // Devuelve -1 si no se encuentra la habitación
    }
}
