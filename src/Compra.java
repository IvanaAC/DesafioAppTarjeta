public class Compra {
    private double valorDeCompra;
    private String descripcion;

    //Constructor
    public Compra(double valorDeCompra, String descripcion) {
        this.valorDeCompra = valorDeCompra;
        this.descripcion = descripcion;
    }

    //Getters
    public double getValorDeCompra() {
        return valorDeCompra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    //toString
    @Override
    public String toString() {
        return "Compra: valor" +  valorDeCompra +
                ", descripción= " + descripcion;
    }
}

