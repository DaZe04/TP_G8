package pe.edu.upc.aweb_g08.dtos;


import pe.edu.upc.aweb_g08.entities.Usuario;
import pe.edu.upc.aweb_g08.entities.Lista_Compras;


import java.time.LocalDate;
public class RecetasDTO  {
    private int idRecetas;



    private String titulo;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdListaCompra() {
        return idListaCompra;
    }

    public void setIdListaCompra(int idListaCompra) {
        this.idListaCompra = idListaCompra;
    }

    private String descripcion;
    private String dificultad;
    private int tiempoPreparacion;
    private int idUsuario;
    private int idListaCompra;

    public RecetasDTO() {
    }

    public RecetasDTO(int idRecetas, String titulo, String descripcion, String dificultad,
                      int tiempoPreparacion, int id_usuario, int idListaCompra) {
        this.idRecetas = idRecetas;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.tiempoPreparacion = tiempoPreparacion;
        this.idUsuario = id_usuario;
        this.idListaCompra = idListaCompra;
    }



}
