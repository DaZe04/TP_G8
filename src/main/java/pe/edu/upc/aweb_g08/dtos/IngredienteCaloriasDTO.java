package pe.edu.upc.aweb_g08.dtos;

public class IngredienteCaloriasDTO {
    private String nombre;
    private float totalCalorias;

    public IngredienteCaloriasDTO() {
    }

    public IngredienteCaloriasDTO(String nombre, float totalCalorias) {
        this.nombre = nombre;
        this.totalCalorias = totalCalorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(float totalCalorias) {
        this.totalCalorias = totalCalorias;
    }
}
