package pe.edu.upc.aweb_g08.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PerfilSalud")
public class PerfilSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil_salud")
    private int idPerfilSalud;

    @Column(name = "peso", nullable = false)
    private double peso;

    @Column(name = "altura", nullable = false)
    private double altura;

    @Column(name = "nivel_trigliceridos")
    private double nivelTrigliceridos;

    @Column(name = "nivel_colesterol")
    private double nivelColesterol;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDate fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    // Getters y Setters
    public int getIdPerfilSalud() {
        return idPerfilSalud;
    }
    public void setIdPerfilSalud(int idPerfilSalud) {
        this.idPerfilSalud = idPerfilSalud;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getNivelTrigliceridos() {
        return nivelTrigliceridos;
    }
    public void setNivelTrigliceridos(double nivelTrigliceridos) {
        this.nivelTrigliceridos = nivelTrigliceridos;
    }

    public double getNivelColesterol() {
        return nivelColesterol;
    }
    public void setNivelColesterol(double nivelColesterol) {
        this.nivelColesterol = nivelColesterol;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }
    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
