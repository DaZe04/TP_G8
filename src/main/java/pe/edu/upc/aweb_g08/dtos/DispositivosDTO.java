package pe.edu.upc.aweb_g08.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.aweb_g08.entities.Usuario;

import java.time.LocalDate;

public class DispositivosDTO {
    private int idDispositivo;
    private String tipo;
    private String marca;
    private String modelo;
    private LocalDate fechaSincronizacion;
    private Usuario usuario;

    public DispositivosDTO() {
    }

    public DispositivosDTO(LocalDate fechaSincronizacion, int idDispositivo, String marca, String modelo, String tipo, Usuario usuario) {
        this.fechaSincronizacion = fechaSincronizacion;
        this.idDispositivo = idDispositivo;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public LocalDate getFechaSincronizacion() {
        return fechaSincronizacion;
    }

    public void setFechaSincronizacion(LocalDate fechaSincronizacion) {
        this.fechaSincronizacion = fechaSincronizacion;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
