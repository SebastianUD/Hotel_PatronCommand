import javax.swing.JOptionPane;

// Subclase de Salida para salida por GUI (JOptionPane)
class SalidaGUI extends Salida {
    @Override
    public void mostrarSalida(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
