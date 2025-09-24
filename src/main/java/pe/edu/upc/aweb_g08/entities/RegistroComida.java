package pe.edu.upc.aweb_g08.entities;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "registro_comidas")

public class RegistroComida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Integer idRegistro;

    @Column(name = "fecha_consumo", nullable = false)
    private LocalDate fechaConsumo;

    @Column(name = "notas", columnDefinition = "TEXT")
    private String notas;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_recetas", nullable = false)
    private Recetas recetas;


    public RegistroComida() {
    }

    public RegistroComida(LocalDate fechaConsumo, String notas, Integer idUsuario, Recetas recetas) {
        this.fechaConsumo = fechaConsumo;
        this.notas = notas;
        this.idUsuario = idUsuario;
        this.recetas = recetas;
    }


    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public LocalDate getFechaConsumo() {
        return fechaConsumo;
    }

    public void setFechaConsumo(LocalDate fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Recetas getRecetas() {
        return recetas;
    }

    public void setRecetas(Recetas recetas) {
        this.recetas = recetas;
    }
}
