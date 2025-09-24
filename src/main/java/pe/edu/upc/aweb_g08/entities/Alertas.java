package pe.edu.upc.aweb_g08.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Alertas")
public class Alertas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta")
    private int idAlerta;

    @Column(name = "mensaje", nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;


    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;


    public Alertas() {}


    public Alertas(int idAlerta, String mensaje, LocalDate fecha, Usuario usuario) {
        this.idAlerta = idAlerta;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.usuario = usuario;
    }


    public int getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
