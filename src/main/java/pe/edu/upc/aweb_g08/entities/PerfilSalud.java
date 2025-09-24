package com.example.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name ="perfil_salud")

public class PerfilSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Integer idPerfil;

    @Column(name = "nivel_trigliceridos")
    private Float nivelTrigliceridos;

    @Column(name = "peso")
    private Float peso;

    @Column(name = "altura")
    private Float altura;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    public PerfilSalud() {}

    public PerfilSalud(Integer idPerfil, Float nivelTrigliceridos, Float peso, Float altura, LocalDate fechaRegistro, Integer idUsuario) {
        this.idPerfil = idPerfil;
        this.nivelTrigliceridos = nivelTrigliceridos;
        this.peso = peso;
        this.altura = altura;
        this.fechaRegistro = fechaRegistro;
        this.idUsuario = idUsuario;
    }

    // Getters y setters
    public Integer getIdPerfil() { return idPerfil; }
    public void setIdPerfil(Integer idPerfil) { this.idPerfil = idPerfil; }

    public Float getNivelTrigliceridos() { return nivelTrigliceridos; }
    public void setNivelTrigliceridos(Float nivelTrigliceridos) { this.nivelTrigliceridos = nivelTrigliceridos; }

    public Float getPeso() { return peso; }
    public void setPeso(Float peso) { this.peso = peso; }

    public Float getAltura() { return altura; }
    public void setAltura(Float altura) { this.altura = altura; }

    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
}
