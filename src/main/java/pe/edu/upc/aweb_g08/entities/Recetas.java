package pe.edu.upc.aweb_g08.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Recetas")
public class Recetas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recetas")
    private int idRecetas;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "dificultad", length = 50)
    private String dificultad;

    @Column(name = "tiempo_preparacion")
    private int tiempoPreparacion;


    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;


    @ManyToOne
    @JoinColumn(name = "id_lista_compra", nullable = false)
    private Lista_Compras listaCompra;

    public Recetas() {}

    public Recetas(int idRecetas, String titulo, String descripcion, String dificultad, int tiempoPreparacion, Usuario usuario, Lista_Compras listaCompra) {
        this.idRecetas = idRecetas;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.tiempoPreparacion = tiempoPreparacion;
        this.usuario = usuario;
        this.listaCompra = listaCompra;
    }


    public int getIdRecetas() { return idRecetas; }
    public void setIdRecetas(int idRecetas) { this.idRecetas = idRecetas; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getDificultad() { return dificultad; }
    public void setDificultad(String dificultad) { this.dificultad = dificultad; }

    public int getTiempoPreparacion() { return tiempoPreparacion; }
    public void setTiempoPreparacion(int tiempoPreparacion) { this.tiempoPreparacion = tiempoPreparacion; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Lista_Compras getListaCompra() { return listaCompra; }
    public void setListaCompra(Lista_Compras listaCompra) { this.listaCompra = listaCompra; }
}