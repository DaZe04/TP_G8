package pe.edu.upc.aweb_g08.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Dispositivos")
public class Dispositivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dispositivo")
    private int idDispositivo;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    @Column(name = "marca", length = 50, nullable = false)
    private String marca;

    @Column(name = "modelo", length = 50, nullable = false)
    private String modelo;

    @Column(name = "fecha_sincronizacion", nullable = false)
    private LocalDate fechaSincronizacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Dispositivos() {}

    public Dispositivos(int idDispositivo, String tipo, String marca, String modelo, LocalDate fechaSincronizacion, Usuario usuario) {
        this.idDispositivo = idDispositivo;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaSincronizacion = fechaSincronizacion;
        this.usuario = usuario;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getFechaSincronizacion() {
        return fechaSincronizacion;
    }

    public void setFechaSincronizacion(LocalDate fechaSincronizacion) {
        this.fechaSincronizacion = fechaSincronizacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
