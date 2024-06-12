import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.print("Bienvenido/a.\nIngrese el límite de la tarjeta: ");
        double limite = lectura.nextDouble();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);

        boolean salir = false;

        while (!salir) { //Menú
            System.out.println("\nMENÚ DE OPCIONES");
            System.out.print("Seleccione una opción: ");
            System.out.println("\n1. Realizar una compra/Agregar una compra");
            System.out.println("2. Ver resumen de la compra");
            System.out.println("3. Salir");

            int opcion = lectura.nextInt(); //Es para que se espere un número entero

            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese la descripción del producto: ");
                    lectura.nextLine();
                    String descripcion = lectura.nextLine();
                    System.out.print("Ingrese el valor del producto: ");
                    double valorDeCompra = lectura.nextDouble();

                    Compra compra = new Compra(valorDeCompra, descripcion);
                    if (tarjeta.agregarCompra(compra)) {
                        System.out.println("Compra agregada exitosamente.");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }

                    if (tarjeta.getSaldo() <= 0) {
                        System.out.println("\nSe ha alcanzado el límite de la tarjeta.");
                    }
                    break;

                case 2:
                    if (tarjeta.getListaDeCompras().isEmpty()) {
                        System.out.println("\nNo se han realizado compras.");
                    } else {
                        tarjeta.mostrarResumen();
                    }
                    break;

                case 3:
                    salir = true;
                    System.out.println("\nMuchas gracias por usar nuestros servicios.");
                    break;

                default:
                    System.out.println("\nLa opción no es válida, por favor intente de nuevo.");
                    break;
            }
        }
    }
}