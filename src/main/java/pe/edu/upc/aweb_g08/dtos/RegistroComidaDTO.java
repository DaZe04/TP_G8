package pe.edu.upc.aweb_g08.dtos;

import java.time.LocalDate;

public class RegistroComidaDTO {

    private Integer idRegistro;
    private LocalDate fechaConsumo;
    private String notas;
    private Integer idUsuario;
    private Integer idRecetas;

    public Integer getIdRegistro() { return idRegistro; }
    public void setIdRegistro(Integer idRegistro) { this.idRegistro = idRegistro; }

    public LocalDate getFechaConsumo() { return fechaConsumo; }
    public void setFechaConsumo(LocalDate fechaConsumo) { this.fechaConsumo = fechaConsumo; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }

    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }

    public Integer getIdRecetas() { return idRecetas; }
    public void setIdRecetas(Integer idRecetas) { this.idRecetas = idRecetas; }
}
