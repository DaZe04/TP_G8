package pe.edu.upc.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Suscripciones")
public class Suscripciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suscripciones")
    private int id_suscripciones;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fecha_inicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fecha_fin;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario id_usuario;

    public Suscripciones() {}

    public Suscripciones(int id_suscripciones, String tipo, LocalDate fecha_inicio, LocalDate fecha_fin, String estado, Usuario id_usuario) {
        this.id_suscripciones = id_suscripciones;
        this.tipo = tipo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.id_usuario = id_usuario;
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

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
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

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }
}
