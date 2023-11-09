// Comando de Check-out
class ComandoCheckOut extends Comando {
    private String cliente;
    private Hotel hotel;

    public ComandoCheckOut(String cliente, Hotel hotel) {
        this.cliente = cliente;
        this.hotel = hotel;
    }

    @Override
    public String ejecutar() {
        return hotel.realizarCheckOut(cliente);
    }
}

