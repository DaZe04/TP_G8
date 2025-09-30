package pe.edu.upc.aweb_g08.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.aweb_g08.entities.Usuario;

import java.time.LocalDate;

public class SuscripcionesDTO {


    private int id_suscripciones;
    private String tipo;

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_suscripciones() {
        return id_suscripciones;
    }

    public void setId_suscripciones(int id_suscripciones) {
        this.id_suscripciones = id_suscripciones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String estado;
    private Integer id_usuario;

    public SuscripcionesDTO() {
    }

    public SuscripcionesDTO(String estado, LocalDate fecha_fin, LocalDate fecha_inicio, int id_suscripciones, Integer id_usuario, String tipo) {
        this.estado = estado;
        this.fecha_fin = fecha_fin;
        this.fecha_inicio = fecha_inicio;
        this.id_suscripciones = id_suscripciones;
        this.id_usuario = id_usuario;
        this.tipo = tipo;
    }


}
