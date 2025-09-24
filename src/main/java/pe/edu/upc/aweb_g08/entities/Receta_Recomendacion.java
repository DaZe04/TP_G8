package pe.edu.upc.aweb_g08.entities;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Receta_Recomendacion")
public class Receta_Recomendacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recomendacion")
    private int idRecomendacion;

    @Column(name = "cantidad")
    private float cantidad;

    @Column(name = "unidad")
    private int unidad;

    // Relación con Recetas (FK)
    @ManyToOne
    @JoinColumn(name = "id_recetas", nullable = false)
    private Recetas recetas;

    // Relación con Usuario (FK)
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Receta_Recomendacion() {}

    public Receta_Recomendacion(int idRecomendacion, float cantidad, int unidad, Recetas receta, Usuario usuario) {
        this.idRecomendacion = idRecomendacion;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.recetas = recetas;
        this.usuario = usuario;
    }

    // Getters y Setters
    public int getIdRecomendacion() { return idRecomendacion; }
    public void setIdRecomendacion(int idRecomendacion) { this.idRecomendacion = idRecomendacion; }

    public float getCantidad() { return cantidad; }
    public void setCantidad(float cantidad) { this.cantidad = cantidad; }

    public int getUnidad() { return unidad; }
    public void setUnidad(int unidad) { this.unidad = unidad; }

    public Recetas getRecetas() { return recetas; }
    public void setRecetas(Recetas recetas) { this.recetas = recetas; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}