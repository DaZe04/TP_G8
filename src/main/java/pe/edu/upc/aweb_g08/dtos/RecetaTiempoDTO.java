package pe.edu.upc.aweb_g08.dtos;

import jakarta.persistence.Column;

public class RecetaTiempoDTO {

    private String titulo;
    private int tiempoPreparacion;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }
}
