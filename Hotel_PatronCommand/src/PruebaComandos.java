import javax.swing.JOptionPane;
public class PruebaComandos {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Recepcion recepcion = new Recepcion();
        
        // Menú de selección del modo de entrada y salida
        String[] opciones = { "Entrada Consola y Salida Consola",
            "Entrada GUI y Salida GUI", "Entrada GUI y Salida Archivo" };
        int modo = JOptionPane.showOptionDialog(
            null,
            "Seleccione el modo de entrada y salida:",
            "Modo de Entrada/Salida",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );

        Entrada entrada;
        Salida salida;
        
        // Configuración del modo de entrada y salida
        switch (modo) {
            case 0:
                entrada = new EntradaConsola();
                salida = new SalidaConsola();
                break;
            case 1:
                entrada = new EntradaGUI();
                salida = new SalidaGUI();
                break;
            case 2:
                entrada = new EntradaGUI();
                salida = new SalidaArchivo();
                break;
            default:
                JOptionPane.showMessageDialog(null,
                        "Opción no válida. Saliendo del programa.");
                return;
        }

        while (true) {
            // Menú de opciones
            salida.mostrarSalida("""
                                 Menu de opciones: 
                                 1. Realizar check-in 
                                 2. Realizar check-out 
                                 3. Realizar solicitud de servicio
                                 4. Ver clientes
                                 5. Salir 
                                 """);
            
            int opcion = Integer.parseInt(entrada.obtenerEntrada());
            
            // Manejo de las opciones seleccionadas por el usuario
            switch (opcion) {
                case 1:
                    salida.mostrarSalida("Nombre del cliente: ");
                    String nombreCliente = entrada.obtenerEntrada();
                    salida.mostrarSalida("Número de habitación: ");
                    int numeroHabitacion = Integer.parseInt(entrada.obtenerEntrada());
                    Comando comandoCheckIn = new ComandoCheckIn(nombreCliente,
                            numeroHabitacion, hotel);
                    recepcion.setComando(comandoCheckIn);
                    recepcion.ejecutarComando();
                    String resultadoCheckIn = recepcion.getResultado();
                    salida.mostrarSalida(resultadoCheckIn);
                    break;
                case 2:
                    salida.mostrarSalida("Nombre del cliente: ");
                    nombreCliente = entrada.obtenerEntrada();
                    Comando comandoCheckOut = new ComandoCheckOut(nombreCliente, hotel);
                    recepcion.setComando(comandoCheckOut);
                    recepcion.ejecutarComando();
                    String resultadoCheckOut = recepcion.getResultado();
                    salida.mostrarSalida(resultadoCheckOut);
                    break;
                case 3:
                    salida.mostrarSalida("Nombre del cliente: ");
                    nombreCliente = entrada.obtenerEntrada();
                    salida.mostrarSalida("Tipo de servicio: ");
                    String servicio = entrada.obtenerEntrada();
                    Comando comandoSolicitudServicio = new ComandoSolicitudServicio(nombreCliente,
                            servicio, hotel);
                    recepcion.setComando(comandoSolicitudServicio);
                    recepcion.ejecutarComando();
                    String resultadoSolicitudServicio = recepcion.getResultado();
                    salida.mostrarSalida(resultadoSolicitudServicio);
                    break;
                case 4:
                    Comando comandoVerClientes = new ComandoVerClientes(hotel);
                    recepcion.setComando(comandoVerClientes);
                    recepcion.ejecutarComando();
                    String resultadoVerClientes = recepcion.getResultado();
                    salida.mostrarSalida(resultadoVerClientes);
                    break;   
                case 5:
                    salida.mostrarSalida("Saliendo del programa.");
                    System.exit(0);
                default:
                    salida.mostrarSalida("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
