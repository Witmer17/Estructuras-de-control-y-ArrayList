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

public class comidas {
    private static final ArrayList<ArrayList<String>> alimentos = new ArrayList<>();
    private static final ArrayList<ArrayList<Double>> precios = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    static {
        ArrayList<String> pastries = new ArrayList<>();
        pastries.add("Muffin Red Velvet");
        pastries.add("Galleta Red Velvet");
        pastries.add("Banana Bread");
        pastries.add("Muffin de Naranja");
        pastries.add("Keke de Zanahoria");
        pastries.add("Galleta Cranberry");
        pastries.add("Keke de Limón");
        pastries.add("Galleta de Chocochips");
        pastries.add("Muffin de Berries");
        pastries.add("Egg Bites de Jamón y Queso");

        ArrayList<String> postres = new ArrayList<>();
        postres.add("Crocante de Manzana Vegetal");
        postres.add("Cake Pop Vainilla");
        postres.add("Cheesecake de Chocolate");
        postres.add("Brownie de Cookies & Cream");
        postres.add("Torta de Chocolate");

        ArrayList<String> sandwiches = new ArrayList<>();
        sandwiches.add("Sandwich de pavo");
        sandwiches.add("Croissant de Mantequilla");
        sandwiches.add("Croissant de Jamón Serrano y Queso");
        sandwiches.add("Croissant Jamón del País y Queso");
        sandwiches.add("Croissant Jamón Inglés y Queso");
        sandwiches.add("Sandwich Pavita & queso");
        sandwiches.add("Sandwich Pavita, queso & espinaca");
        sandwiches.add("Sandwich Brioche campesino");
        sandwiches.add("Empanada de lomo");
        sandwiches.add("Empanada de ají de pollo");
        sandwiches.add("Sandwich Panino vesubio");
        sandwiches.add("Sandwich Chicken panino");
        sandwiches.add("Sandwich Chicken ciabatta");
        sandwiches.add("Sandwich triple");

        alimentos.add(pastries);
        alimentos.add(postres);
        alimentos.add(sandwiches);

        ArrayList<Double> preciosPastries = new ArrayList<>();
        preciosPastries.add(9.50);
        preciosPastries.add(6.00);
        preciosPastries.add(8.00);
        preciosPastries.add(9.00);
        preciosPastries.add(9.00);
        preciosPastries.add(5.50);
        preciosPastries.add(9.00);
        preciosPastries.add(5.50);
        preciosPastries.add(9.00);
        preciosPastries.add(9.00);

        ArrayList<Double> preciosPostres = new ArrayList<>();
        preciosPostres.add(15.00);
        preciosPostres.add(6.50);
        preciosPostres.add(15.00);
        preciosPostres.add(8.50);
        preciosPostres.add(12.50);

        ArrayList<Double> preciosSandwiches = new ArrayList<>();
        preciosSandwiches.add(15.00);
        preciosSandwiches.add(5.50);
        preciosSandwiches.add(15.50);
        preciosSandwiches.add(15.50);
        preciosSandwiches.add(15.50);
        preciosSandwiches.add(13.00);
        preciosSandwiches.add(14.00);
        preciosSandwiches.add(15.00);
        preciosSandwiches.add(9.50);
        preciosSandwiches.add(15.00);
        preciosSandwiches.add(9.50);
        preciosSandwiches.add(12.00);
        preciosSandwiches.add(13.50);
        preciosSandwiches.add(13.50);
        preciosSandwiches.add(15.00);

        precios.add(preciosPastries);
        precios.add(preciosPostres);
        precios.add(preciosSandwiches);
    }

    public static double mostrarAlimentos(ArrayList<String> alimentosComprados) {
        double totalAlimentos = 0;
        int opcion;
        System.out.println("⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬⏬");
        System.out.println("⏩⏩--BIENVENIDO A LA CATEGORIA DE ALIMENTOS --⏪⏪");
        System.out.println("⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫⏫");

        do {
            System.out.println("Contamos con las siguentes opciones:");
            System.out.println("Seleccione una subcategoría de Alimentos:");
            System.out.println("1. Pastries");
            System.out.println("2. Postres");
            System.out.println("3. Sandwiches");
            System.out.println("4. Volver al menú principal");
            System.out.print("Ingrese una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entre 1 y 4.");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: totalAlimentos += seleccionarProducto(alimentos.get(0), precios.get(0), alimentosComprados);break;
                case 2: totalAlimentos += seleccionarProducto(alimentos.get(1), precios.get(1), alimentosComprados);break;
                case 3: totalAlimentos += seleccionarProducto(alimentos.get(2), precios.get(2), alimentosComprados);break;
                case 4:
                    System.out.println("Volviendo al menú principal...");break;
                default: System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);

        return totalAlimentos;
    }

    private static double seleccionarProducto(ArrayList<String> productos, ArrayList<Double> precios, ArrayList<String> alimentosComprados) {
        double total = 0;

        System.out.println("Seleccione un producto:");
        System.out.printf("%-3s %-40s %-10s%n", "N°", "Producto", "Precio");
        for (int i = 0; i < productos.size(); i++) {
            System.out.printf("%-2d. %-40s S/ %.2f%n", i + 1, productos.get(i), precios.get(i));
        }

        System.out.print("Ingrese el número del producto que desea comprar: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor ingrese un número entre 1 y " + productos.size());
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
                alimentosComprados.add(detalleCompra);
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

