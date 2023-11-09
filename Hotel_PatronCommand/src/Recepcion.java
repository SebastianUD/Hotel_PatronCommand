// Clase Invocadora
class Recepcion {
    private Comando comando;
    private String resultado;

    public void setComando(Comando comando) {
        this.comando = comando;
        this.resultado = null; // Restablecer el resultado
    }

    public void ejecutarComando() {
        this.resultado = comando.ejecutar();
    }

    public String getResultado() {
        return resultado;
    }
}

