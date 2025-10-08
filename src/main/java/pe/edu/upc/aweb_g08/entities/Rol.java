package pe.edu.upc.aweb_g08.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int idRol;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;


    public Rol() {}


    public Rol(int idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }


    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}