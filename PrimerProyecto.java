/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primer.proyecto;

/**
 *
 * @author ASUS VIVOBOOK}
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.time.YearMonth;

public class PrimerProyecto {
    public static double totalCompra = 0;
    public static final ArrayList<String> detallesCompra = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("==== MENÚ PRINCIPAL ====");
            System.out.println("1. Alimentos");
            System.out.println("2. Merch y Cafe");
            System.out.println("3. Mostrar carrito");
            System.out.println("4. Realizar proceso de pago");
            System.out.println("5. Salir");
            System.out.println("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> totalCompra += comidas.mostrarAlimentos(detallesCompra);
                case 2 -> totalCompra += merchycafe.mostrarMerch(detallesCompra);
                case 3 -> Carrito();
                case 4 -> seleccionarMetodoDePago();
                case 5 -> {
                    if (totalCompra > 0) {
                        System.out.printf("Tiene productos en el carrito con un total de S/ %.2f%n", totalCompra);
                        System.out.println("¿Desea pagar ahora o salir sin guardar?");
                        System.out.println("1. Pagar ahora");
                        System.out.println("2. Salir sin guardar");
                        int respuesta = scanner.nextInt();
                        switch (respuesta) {
                            case 1 -> seleccionarMetodoDePago();
                            case 2 -> {
                                detallesCompra.clear();
                                totalCompra = 0;
                                System.out.println("Se han eliminado los artículos seleccionados. ¡Hasta luego!");
                                System.exit(0);
                            }
                            default -> System.out.println("Opción no válida. Regresando al menú principal...");
                        }
                    }
                    else {
                        System.out.println("No ha realizado compras.");
                        System.out.println("¿Desea salir de todas formas?");
                        System.out.println("1. Sí");
                        System.out.println("2. No");
                        int confirmacion = scanner.nextInt();

                        switch (confirmacion) {
                            case 1 -> {
                                System.out.println("¡Hasta luego!");
                                System.exit(0);
                            }
                            case 2 -> {
                                System.out.println("Regresando al menú principal...");
                            }
                            default -> {
                                System.out.println("Opción no válida. Regresando al menú principal...");
                            }
                        }
                    }

                }
                default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 7);
    }

    public static void mostrarBoleta() {
        System.out.println("⌈‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾ BOLETA ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾⌉");
        System.out.printf("|%-5s %-40s %-10s %-10s%n", "N°", "Descripción", "Cantidad", "Precio");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        if (detallesCompra.isEmpty()) {
            System.out.println("No has realizado ninguna compra.");
        } else {
            int contador = 1;
            double totalpagar = 0;
            for (String detalle : detallesCompra) {
                String[] partes = detalle.split(" \\| ");
                if (partes.length == 3) {
                    String descripcion = partes[0];
                    String cantidadStr = partes[1].replaceAll("[^0-9]", "").trim();
                    int cantidad = Integer.parseInt(cantidadStr);
                    double precioTotal = Double.parseDouble(partes[2].replace("Total: S/ ", "").trim());
                    totalpagar += precioTotal;
                    System.out.printf("%-5d  %-40s %-10d S/ %.2f%n", contador++, descripcion, cantidad, precioTotal);
                } else {
                    System.out.println("Error en el formato del detalle: " + detalle);
                }
            }
            double subtotal = totalCompra / 1.18;
            double igv = subtotal * 0.18;
            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
            System.out.printf("%-20s %-10s%n", "SUBTOTAL:", String.format("S/ %.2f", subtotal));
            System.out.printf("%-20s %-10s%n", "IGV:", String.format("S/ %.2f", igv));
            System.out.printf("%-20s %-10s%n", "TOTAL:", String.format("S/ %.2f", totalCompra));
            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        }
    }
    public static void Carrito(){
        System.out.println("usted tiene en su carrito los siguientes productos\n");
        System.out.printf("%-5s %-40s %-10s %-10s%n", "N°", "Descripción", "Cantidad", "Precio");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");

        if (detallesCompra.isEmpty()) {
            System.out.println("No has realizado ninguna compra.");
        } else {
            int contador = 1;
            double totalpagar = 0;
            for (String detalle : detallesCompra) {
                String[] partes = detalle.split(" \\| ");
                if (partes.length == 3) {
                    String descripcion = partes[0];
                    String cantidadStr = partes[1].replaceAll("[^0-9]", "").trim();
                    int cantidad = Integer.parseInt(cantidadStr);
                    double precioTotal = Double.parseDouble(partes[2].replace("Total: S/ ", "").trim());
                    totalpagar += precioTotal;
                    System.out.printf("%-5d  %-40s %-10d S/ %.2f%n", contador++, descripcion, cantidad, precioTotal);
                } else {
                    System.out.println("Error en el formato del detalle: " + detalle);
                }
            }
            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
            System.out.println("con un total de: S/"+totalCompra);
            System.out.println(" ");
        }}



    public static void seleccionarMetodoDePago() {
        System.out.println("==== MÉTODO DE PAGO ====");
        System.out.println("1. Tarjeta de Crédito/Débito");
        System.out.println("2. Efectivo");
        System.out.print("Selecciona tu método de pago: ");
        int metodoPago = scanner.nextInt();

        switch (metodoPago) {
            case 1 -> {
                System.out.println("Has seleccionado pagar con Tarjeta de Crédito/Débito.");
                pagoTarjeta();
            }
            case 2 -> {
                System.out.println("Has seleccionado pagar en Efectivo.");
                System.out.println("El total a pagar es: S/ " + totalCompra);
                double pago = 0;
                boolean entradaInvalida = false;

                while (pago < totalCompra) {
                    System.out.print("Ingrese el monto de pago: ");
                    double pagoActual = scanner.nextDouble();

                    if (pagoActual <= 0) {
                        if (!entradaInvalida) {
                            System.out.println("El monto no puede ser cero o negativo. Intente nuevamente.");
                            entradaInvalida = true;
                        } else {
                            System.out.println("Ya ha ingresado un valor inválido anteriormente. Cancelando el proceso de pago.");
                            break;
                        }
                        continue;
                    }

                    pago += pagoActual;

                    if (pago < totalCompra) {
                        double faltante = totalCompra - pago;
                        System.out.printf("Monto insuficiente. Faltan S/ %.2f\n", faltante);
                    }
                }

                if (pago >= totalCompra) {
                    double vuelto = pago - totalCompra;
                    System.out.println("Pago completo.");
                    if (vuelto > 0) {
                        System.out.printf("Su vuelto es: S/ %.2f\n", vuelto);
                    }
                    mostrarBoleta();
                } else {
                    System.out.println("El proceso de pago ha sido cancelado.");
                }
            }
            default -> System.out.println("Método de pago no válido.");
        }
        System.out.println("¡Gracias por tu compra!");
    }

    public static void pagoTarjeta() {
        String tarjeta;
        boolean tarjetaValida = false;
        while (!tarjetaValida) {
            System.out.print("Ingrese el número de tarjeta (16 dígitos): ");
            tarjeta = scanner.next();
            if (tarjeta.length() == 16 && tarjeta.matches("[0-9]+")) {
                tarjetaValida = true;
                System.out.println("Número de tarjeta válido.");
                boolean fechaValida = false;
                while (!fechaValida) {
                    System.out.print("Ingrese el mes de vencimiento (MM): ");
                    int mesVencimiento = scanner.nextInt();
                    System.out.print("Ingrese el año de vencimiento (YYYY): ");
                    int añoVencimiento = scanner.nextInt();
                    YearMonth fechaVencimiento = YearMonth.of(añoVencimiento, mesVencimiento);
                    YearMonth fechaActual = YearMonth.now();
                    if (fechaVencimiento.isAfter(fechaActual)) {
                        fechaValida = true;
                        System.out.println("Fecha de vencimiento válida.");
                        String cvv;
                        boolean cvvValido = false;
                        while (!cvvValido) {
                            System.out.print("Ingrese el código CVV (3 dígitos): ");
                            cvv = scanner.next();
                            if (cvv.length() == 3 && cvv.matches("[0-9]+")) {
                                cvvValido = true;
                                System.out.println("Código CVV válido.");
                                String clave;
                                boolean claveValida = false;
                                while (!claveValida) {
                                    System.out.print("Ingrese su clave de 4 dígitos: ");
                                    clave = scanner.next();
                                    if (clave.length() == 4 && clave.matches("[0-9]+")) {
                                        claveValida = true;
                                        System.out.println("Clave válida.");
                                        System.out.println("¿Desea pagar en cuotas? \n1. Sí \n2. No");
                                        int cuotaOpcion = scanner.nextInt();
                                        if (cuotaOpcion == 1) {
                                            System.out.println("¿En cuántas cuotas desea dividir el pago?");
                                            int cuotas = scanner.nextInt();
                                            if (cuotas >= 1) {
                                                double cuota = totalCompra / cuotas;
                                                System.out.printf("Cada cuota será de: S/ %.2f\n", cuota);
                                                System.out.println("Pago realizado en cuotas.");
                                            } else {
                                                System.out.println("Número de cuotas inválido. Realizando pago único.");
                                            }
                                        }
                                        System.out.println("Pago con tarjeta realizado exitosamente.");
                                        System.out.println(" ");
                                        mostrarBoleta();
                                        return;
                                    } else {
                                        System.out.println("Clave inválida. Debe tener 4 dígitos numéricos.");
                                    }
                                }
                            } else {
                                System.out.println("Código CVV inválido. Debe tener 3 dígitos numéricos.");
                            }
                        }
                    } else {
                        System.out.println("Fecha de vencimiento inválida.");
                    }
                }
            } else {
                System.out.println("Número de tarjeta inválido. Debe tener 16 dígitos numéricos.");
            }
        }
    }

    public static void main(String[] args) {
        mostrarMenu();
    }
}


