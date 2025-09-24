package pe.edu.upc.aweb_g08.dtos;


import pe.edu.upc.aweb_g08.entities.Usuario;
import pe.edu.upc.aweb_g08.entities.Lista_Compras;


import java.time.LocalDate;
public class RecetasDTO  {
    private int idRecetas;
    private String titulo;
    private String descripcion;
    private String dificultad;
    private int tiempoPreparacion;
    private Usuario usuario;
    private Lista_Compras listaCompra;

    public RecetasDTO() {
    }

    public int getIdRecetas() {
        return idRecetas;
    }

    public void setIdRecetas(int idRecetas) {
        this.idRecetas = idRecetas;
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

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public Lista_Compras getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(Lista_Compras listaCompra) {
        this.listaCompra = listaCompra;
    }

    public RecetasDTO(int idRecetas, String titulo, String descripcion, String dificultad,
                      int tiempoPreparacion, Usuario usuario, Lista_Compras listaCompra) {
        this.idRecetas = idRecetas;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.tiempoPreparacion = tiempoPreparacion;
        this.usuario = usuario;
        this.listaCompra = listaCompra;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
