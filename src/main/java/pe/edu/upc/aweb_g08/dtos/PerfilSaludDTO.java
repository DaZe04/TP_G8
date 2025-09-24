package pe.edu.upc.aweb_g08.dtos;

import java.time.LocalDate;

public class PerfilSaludDTO {
    private int idPerfilSalud;
    private double peso;
    private double altura;
    private double nivelTrigliceridos;
    private double nivelColesterol;
    private LocalDate fechaActualizacion;
    private int idUsuario;
    private String nombreUsuario;

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

    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
