import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TarjetaDeCredito {
    private double limite;
    private double saldo;
    private List<Compra> listaDeCompras;

    //Constructor
    public TarjetaDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.listaDeCompras = new ArrayList<>();
    }

    //Método
    public boolean agregarCompra(Compra compra) {
        if (this.saldo >= compra.getValorDeCompra()) {
            this.saldo -= compra.getValorDeCompra(); //resta valor de compra
            this.listaDeCompras.add(compra);//agrega la compra a la lista
            return true;
        } else {
            return false;
        }
    }

    public void mostrarResumen() {
        System.out.println("\n****************************************");
        System.out.println("RESUMEN DE COMPRA:");
        listaDeCompras.sort(Comparator.comparingDouble(Compra::getValorDeCompra));//para ordenar por el precio
        for (Compra compra : listaDeCompras) {
            System.out.println("Descripción: " + compra.getDescripcion() + ", Valor: " + compra.getValorDeCompra());
        }
        System.out.println("****************************************");
        System.out.println("Saldo restante: " + saldo);
        System.out.println("****************************************");
    }

    //Getters
    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getListaDeCompras() {
        return listaDeCompras;
    }

}
