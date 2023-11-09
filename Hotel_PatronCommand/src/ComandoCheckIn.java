// Comando de Check-in
class ComandoCheckIn extends Comando {
    private String cliente;
    private int numeroHabitacion;
    private Hotel hotel;

    public ComandoCheckIn(String cliente, int numeroHabitacion, Hotel hotel) {
        this.cliente = cliente;
        this.numeroHabitacion = numeroHabitacion;
        this.hotel = hotel;
    }

    @Override
    public String ejecutar() {
        return hotel.realizarCheckIn(cliente, numeroHabitacion);
    }
}

