package pe.edu.upc.aweb_g08.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "contrasenia", nullable = false, length = 255)
    private String contrasenia;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "fecha_suscripcion")
    private LocalDate fechaSuscripcion;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuario_roles", // tabla intermedia
            joinColumns = @JoinColumn(name = "id_usuario"), // FK hacia usuario
            inverseJoinColumns = @JoinColumn(name = "id_rol") // FK hacia rol
    )
    private List<Rol> roles;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reportes> reportes;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentarios> comentarios;


    public Usuario(List<Alertas> alertas, String apellido, List<Comentarios> comentarios,
                   String contrasenia, LocalDate fechaCreacion, LocalDate fechaNacimiento, String email,
                   int idUsuario, LocalDate fechaSuscripcion, String nombre, List<Reportes> reportes, List<Rol> roles) {
        this.alertas = alertas;
        this.apellido = apellido;
        this.comentarios = comentarios;
        this.contrasenia = contrasenia;
        this.fechaCreacion = fechaCreacion;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.idUsuario = idUsuario;
        this.fechaSuscripcion = fechaSuscripcion;
        this.nombre = nombre;
        this.reportes = reportes;
        this.roles = roles;
    }

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alertas> alertas;

    public Usuario() {
    }



    // Getters y Setters
    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(LocalDate fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }



    public List<Reportes> getReportes() {
        return reportes;
    }

    public void setReportes(List<Reportes> reportes) {
        this.reportes = reportes;
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Alertas> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<Alertas> alertas) {
        this.alertas = alertas;
    }
}