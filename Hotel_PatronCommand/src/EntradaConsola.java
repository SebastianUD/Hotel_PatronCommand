import java.util.Scanner;

// Subclase de Entrada para entrada por consola
class EntradaConsola extends Entrada {
    @Override
    public String obtenerEntrada() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
