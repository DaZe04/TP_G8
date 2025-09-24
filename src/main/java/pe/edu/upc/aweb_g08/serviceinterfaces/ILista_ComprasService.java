package pe.edu.upc.aweb_g08.serviceinterfaces;

import pe.edu.upc.aweb_g08.entities.Lista_Compras;

import java.util.List;

public interface ILista_ComprasService  {
    public List<Lista_Compras> list();
    public void insert(Lista_Compras  listaCompras);
    public Lista_Compras  buscar(int id);
    public void delete(int id);
    public void update(Lista_Compras  listaCompras);
}
