package pe.edu.upc.aweb_g08.dtos;

import java.time.LocalDate;

public class RecetaRecomendacionDTO {
    private Integer idRecomendacion;
    private String motivo;
    private LocalDate fechaGeneracion;
    private String estado;
    private Integer idPerfil;
    private Integer idReceta;

    public Integer getIdRecomendacion() { return idRecomendacion; }
    public void setIdRecomendacion(Integer idRecomendacion) { this.idRecomendacion = idRecomendacion; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public LocalDate getFechaGeneracion() { return fechaGeneracion; }
    public void setFechaGeneracion(LocalDate fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Integer getIdPerfil() { return idPerfil; }
    public void setIdPerfil(Integer idPerfil) { this.idPerfil = idPerfil; }

    public Integer getIdReceta() { return idReceta; }
    public void setIdReceta(Integer idReceta) { this.idReceta = idReceta; }
}
