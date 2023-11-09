import javax.swing.JOptionPane;

// Subclase de Entrada para entrada por GUI (JOptionPane)
class EntradaGUI extends Entrada {
    @Override
    public String obtenerEntrada() {
        return JOptionPane.showInputDialog("Introduce un valor:");
    }
}
