package pe.edu.upc.aweb_g08.dtos;

import java.time.LocalDate;

public class ListaCompraResumenDTO {
    private LocalDate fechaCreacion;
    private long totalProductos;

    public ListaCompraResumenDTO(LocalDate fecha, Long total) {
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public long getTotalProductos() {
        return totalProductos;
    }

    public void setTotalProductos(long totalProductos) {
        this.totalProductos = totalProductos;
    }
}
