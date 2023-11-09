// Comando de Solicitud de Servicio
class ComandoSolicitudServicio extends Comando {
    private String cliente;
    private String servicio;
    private Hotel hotel;

    public ComandoSolicitudServicio(String cliente, String servicio,
            Hotel hotel) {
        this.cliente = cliente;
        this.servicio = servicio;
        this.hotel = hotel;
    }

    @Override
    public String ejecutar() {
        return hotel.realizarSolicitudServicio(cliente, servicio);
    }
}

