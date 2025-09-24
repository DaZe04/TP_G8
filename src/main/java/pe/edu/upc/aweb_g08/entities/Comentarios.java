package pe.edu.upc.aweb_g08.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Comentarios")
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentarios")
    private int idComentarios;

    @Column(name = "contenido", columnDefinition = "TEXT", nullable = false)
    private String contenido;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;


    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Comentarios() {
    }

    public void Comentario(int idComentarios, String contenido, LocalDate fecha, Usuario usuario) {
        this.idComentarios = idComentarios;
        this.contenido = contenido;
        this.fecha = fecha;
        this.usuario = usuario;
    }


    public int getIdComentarios() {
        return idComentarios;
    }

    public void setIdComentarios(int idComentarios) {
        this.idComentarios = idComentarios;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}



