//Comando de Ver Clientes
class ComandoVerClientes extends Comando {

    private Hotel hotel;

    public ComandoVerClientes(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String ejecutar() {
        return hotel.verClientes();
    }
}

