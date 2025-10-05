package pe.edu.upc.aweb_g08.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Reportes")
public class    Reportes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte")
    private int idReporte;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;


    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;


    public Reportes() {}


    public Reportes(int idReporte, String titulo, String descripcion, LocalDate fecha, Usuario usuario) {
        this.idReporte = idReporte;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuario = usuario;
    }


    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
