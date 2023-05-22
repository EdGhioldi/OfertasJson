package ClaseJson;

public class Producto {
    private String nombre;
    private String[] peso;
    private double precio;

    public Producto(){};
    public Producto(String nombre, String[]peso, double precio){
        this.nombre = nombre;
        this.peso = peso;
        this.precio = precio;
    }

}
