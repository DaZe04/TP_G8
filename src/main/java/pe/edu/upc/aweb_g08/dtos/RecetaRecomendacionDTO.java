package pe.edu.upc.aweb_g08.dtos;

public class RecetaRecomendacionDTO {
    private Integer idRecomendacion;
    private Float cantidad;
    private Integer unidad;
    private Integer idRecetas;
    private Integer idUsuario;

    public Integer getIdRecomendacion() { return idRecomendacion; }
    public void setIdRecomendacion(Integer idRecomendacion) { this.idRecomendacion = idRecomendacion; }

    public Float getCantidad() { return cantidad; }
    public void setCantidad(Float cantidad) { this.cantidad = cantidad; }

    public Integer getUnidad() { return unidad; }
    public void setUnidad(Integer unidad) { this.unidad = unidad; }

    public Integer getIdRecetas() { return idRecetas; }
    public void setIdRecetas(Integer idRecetas) { this.idRecetas = idRecetas; }

    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
}
