package pe.edu.upc.aweb_g08.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class DispositivosDTO {
    private int idDispositivo;
    private String tipo;
    private String marca;
    private String modelo;
    @JsonProperty("fecha_sincronizacion")
    private LocalDate fechaSincronizacion;

    @JsonProperty("id_Usuario")  // AGREGAR ESTO
    private int idUsuario;

    public DispositivosDTO() {
    }

    public DispositivosDTO(LocalDate fechaSincronizacion, int idDispositivo, String marca, String modelo, String tipo, int idUsuario) {
        this.fechaSincronizacion = fechaSincronizacion;
        this.idDispositivo = idDispositivo;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getFechaSincronizacion() {
        return fechaSincronizacion;
    }

    public void setFechaSincronizacion(LocalDate fechaSincronizacion) {
        this.fechaSincronizacion = fechaSincronizacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}