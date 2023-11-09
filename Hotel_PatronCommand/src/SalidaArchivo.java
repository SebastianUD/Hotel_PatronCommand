import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SalidaArchivo extends Salida {
    private String nombreArchivo;

    public SalidaArchivo() {
        seleccionarArchivoSalida();
    }

    private void seleccionarArchivoSalida() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar archivo de salida");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto (.txt)", "txt"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            this.nombreArchivo = fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            this.nombreArchivo = null;
        }
    }

    @Override
    public void mostrarSalida(String mensaje) {
        if (nombreArchivo != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
                writer.write(mensaje);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se seleccionó un archivo de salida. El resultado no se ha guardado.");
        }
    }
}
