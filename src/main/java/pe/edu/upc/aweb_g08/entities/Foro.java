package pe.edu.upc.aweb_g08.entities;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "Foro")
public class Foro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_foro")
    private int idForo;

    @Column(name = "titulo",length = 50,nullable = false)
    private String titulo;

    @Column(name = "contenido",length = 100,columnDefinition = "TEXT",nullable = false)
    private String contenido;

    @Column(name = "fecha_publicacion",nullable = false)
    private LocalDate fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuario;

    public Foro() {}
    public Foro(int idForo, String titulo, String contenido, LocalDate fechaPublicacion,Usuario usuario) {
        this.idForo = idForo;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaPublicacion = fechaPublicacion;
        this.usuario = usuario;
    }
    public int getIdForo() {
        return idForo;
    }
    public void setIdForo(int idForo) {
        this.idForo = idForo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
