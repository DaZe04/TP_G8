package pe.edu.upc.aweb_g08.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Lista_Compras")
public class Lista_Compras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_compra")
    private int idListaCompra;

    @Column(name = "fecha_creacion_lista", nullable = false)
    private LocalDate fechaCreacionLista;

    @Column(name = "cantidad")
    private int cantidad;


    @ManyToOne
    @JoinColumn(name = "id_ingrediente", nullable = false)
    private Ingredientes ingrediente;

    public Lista_Compras() {}

    public Lista_Compras(int idListaCompra, LocalDate fechaCreacionLista, int cantidad, Ingredientes ingrediente) {
        this.idListaCompra = idListaCompra;
        this.fechaCreacionLista = fechaCreacionLista;
        this.cantidad = cantidad;
        this.ingrediente = ingrediente;
    }


    public int getIdListaCompra() { return idListaCompra; }
    public void setIdListaCompra(int idListaCompra) { this.idListaCompra = idListaCompra; }

    public LocalDate getFechaCreacionLista() { return fechaCreacionLista; }
    public void setFechaCreacionLista(LocalDate fechaCreacionLista) { this.fechaCreacionLista = fechaCreacionLista; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public Ingredientes getIngrediente() { return ingrediente; }
    public void setIngrediente(Ingredientes ingrediente) { this.ingrediente = ingrediente; }

    }
