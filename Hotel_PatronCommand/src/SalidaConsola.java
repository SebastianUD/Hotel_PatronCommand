// Subclase de Salida para salida por consola
class SalidaConsola extends Salida {
    @Override
    public void mostrarSalida(String mensaje) {
        System.out.println(mensaje);
    }
}
