/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primer.proyecto;

/**
 *
 * @author ASUS VIVOBOOK}
 */
import java.util.ArrayList;
import java.util.Scanner;

public class merchycafe {
    private static final ArrayList<ArrayList<String>> merchyCafe = new ArrayList<>();
    private static final ArrayList<ArrayList<Double>> precios = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    static {
        ArrayList<String> Merch = new ArrayList<>();
        Merch.add("Prensa Francesa");
        Merch.add("Prensa Cold Brew");
        Merch.add("Prensa Pour Over");
        Merch.add("Reusable Aniversario 20 años");
        Merch.add("Vaso Blanco Reusable Sirena Blanca-16oz");

        ArrayList<String> Cafe = new ArrayList<>();
        Cafe.add("Perú");
        Cafe.add("Expresso Roast");
        Cafe.add("Verona");
        Cafe.add("Anniversary Blend 250 gr.");
        Cafe.add("Sumatra");

        merchyCafe.add(Merch);
        merchyCafe.add(Cafe);

        ArrayList<Double> preciosMerch = new ArrayList<>();
        preciosMerch.add(20.00);
        preciosMerch.add(30.00);
        preciosMerch.add(25.00);
        preciosMerch.add(15.00);
        preciosMerch.add(10.00);

        ArrayList<Double> preciosCafe = new ArrayList<>();
        preciosCafe.add(15.00);
        preciosCafe.add(20.00);
        preciosCafe.add(18.00);
        preciosCafe.add(22.00);
        preciosCafe.add(16.00);

        precios.add(preciosMerch);
        precios.add(preciosCafe);
    }

    public static double mostrarMerch(ArrayList<String> merchComprados) {
        double totalMerch = 0;
        int opcion;
        System.out.println("⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏪⏪");
        System.out.println("⏩⏩--BIENVENIDO A LA CATEGORIA DE MERCH Y CAFE EN GRANO--⏪");
        System.out.println("⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏪⏪");

        do {
            System.out.println("Contamos con las siguentes opciones:");
            System.out.println("1. Merch");
            System.out.println("2. Café en Grano");
            System.out.println("3. Regresar al menú principal");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> totalMerch += seleccionarProducto(merchyCafe.get(0), precios.get(0), merchComprados);
                case 2 -> totalMerch += seleccionarProducto(merchyCafe.get(1), precios.get(1), merchComprados);
                case 3 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        return totalMerch;
    }

    private static double seleccionarProducto(ArrayList<String> productos, ArrayList<Double> precios, ArrayList<String> merchComprados) {
        double total = 0;

        System.out.println("Seleccione un producto:");
        System.out.printf("%-3s. %-45s %-10s%n", "N°", "Producto", "Precio");
        for (int i = 0; i < productos.size(); i++) {
            System.out.printf("%d. %-45s S/ %.2f%n", i + 1, productos.get(i), precios.get(i));
        }

        System.out.print("Ingrese el número del producto que desea comprar: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor ingrese un número válido.");
            scanner.next();
        }
        int opcionProducto = scanner.nextInt();

        if (opcionProducto >= 1 && opcionProducto <= productos.size()) {
            String producto = productos.get(opcionProducto - 1);
            double precio = precios.get(opcionProducto - 1);

            System.out.print("¿Cuántos desea comprar? Ingrese la cantidad: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor ingrese una cantidad válida.");
                scanner.next();
            }
            int cantidad = scanner.nextInt();

            if (cantidad > 0) {
                double precioTotal = cantidad * precio;
                String detalleCompra = generarDetalleCompra(producto, cantidad, precioTotal);
                merchComprados.add(detalleCompra);
                total += precioTotal;
                System.out.println("Producto agregado: " + detalleCompra);
                System.out.println(".............................................................");
            } else {
                System.out.println("La cantidad debe ser mayor a cero.");
            }
        } else {
            System.out.println("Producto no válido.");
        }

        return total;
    }

    private static String generarDetalleCompra(String producto, int cantidad, double precioTotal) {
        return String.format("%s | %d unidades | Total: S/ %.2f", producto, cantidad, precioTotal);
    }
}

