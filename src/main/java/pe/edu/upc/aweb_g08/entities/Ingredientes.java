package pe.edu.upc.aweb_g08.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Ingredientes")

public class Ingredientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredientes")
    private int idIngredientes;

    @Column(name = "nombre",length = 35, nullable = false)
    private String nombre;

    @Column(name = "grasas",nullable = false)
    private float grasas;

    @Column(name = "calorias",nullable = false)
    private float calorias;

    @Column(name = "azucares",nullable = false)
    private float azucares;

    @Column(name = "carbohidratos",nullable = false)
    private float carbohidratos;

    @Column(name = "proteinas",nullable = false)
    private float proteinas;

    public Ingredientes() {}

    public Ingredientes(int idIngredientes,String nombre, float grasas, float calorias, float azucares, float carbohidratos, float proteinas  ) {
        this.idIngredientes = idIngredientes;
        this.nombre = nombre;
        this.grasas = grasas;
        this.calorias = calorias;
        this.azucares = azucares;
        this.carbohidratos = carbohidratos;
        this.proteinas = proteinas;
    }
    public int getIdIngredientes() {
        return idIngredientes;
    }
    public void setIdIngredientes(int idIngredientes) {
        this.idIngredientes = idIngredientes;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getGrasas() {
        return grasas;
    }
    public void setGrasas(float grasas) {
        this.grasas = grasas;
    }
    public float getCalorias() {
        return calorias;
    }
    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }
    public float getAzucares() {
        return azucares;
    }
    public void setAzucares(float azucares) {
        this.azucares = azucares;
    }
    public float getCarbohidratos() {
        return carbohidratos;
    }
    public void setCarbohidratos(float carbohidratos) {
        this.carbohidratos = carbohidratos;
    }
    public float getProteinas() {
        return proteinas;
    }
    public void setProteinas(float proteinas) {
        this.proteinas = proteinas;
    }

}
