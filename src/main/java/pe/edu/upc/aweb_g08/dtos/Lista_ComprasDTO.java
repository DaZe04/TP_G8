package pe.edu.upc.aweb_g08.dtos;

import java.time.LocalDate;

public class Lista_ComprasDTO  {
    private int idListaCompra;
    private LocalDate fechaCreacionLista;
    private int cantidad;
    private int idIngrediente;


    public int getIdListaCompra() {
        return idListaCompra;
    }

    public void setIdListaCompra(int idListaCompra) {
        this.idListaCompra = idListaCompra;
    }

    public LocalDate getFechaCreacionLista() {
        return fechaCreacionLista;
    }

    public void setFechaCreacionLista(LocalDate fechaCreacionLista) {
        this.fechaCreacionLista = fechaCreacionLista;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }
}
