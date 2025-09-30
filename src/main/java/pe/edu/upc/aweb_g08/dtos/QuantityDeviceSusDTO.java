package pe.edu.upc.aweb_g08.dtos;

public class QuantityDeviceSusDTO {
    private String tipo_suscripcion;
    private int cantidad_dispositivos;

    public int getCantidad_dispositivos() {
        return cantidad_dispositivos;
    }

    public void setCantidad_dispositivos(int cantidad_dispositivos) {
        this.cantidad_dispositivos = cantidad_dispositivos;
    }

    public String getTipo_suscripcion() {
        return tipo_suscripcion;
    }

    public void setTipo_suscripcion(String tipo_suscripcion) {
        this.tipo_suscripcion = tipo_suscripcion;
    }
}
