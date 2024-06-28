import java.time.LocalDate;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Notificador notificador = new Notificador();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Ver productos");
            System.out.println("3. Ver productos próximos a vencer");
            System.out.println("4. Ver productos vencidos");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Actualizar producto");
            System.out.println("7. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            try {
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese tipo de producto (1: Alimenticio, 2: Farmacéutico):");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();  // Consumir la nueva línea
                        System.out.println("Ingrese nombre del producto:");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese cantidad:");
                        int cantidad = scanner.nextInt();
                        System.out.println("Ingrese fecha de vencimiento (AAAA-MM-DD):");
                        LocalDate fechaVencimiento = LocalDate.parse(scanner.next());
                        scanner.nextLine();  // Consumir la nueva línea
                        if (tipo == 1) {
                            System.out.println("Ingrese tipo de alimento:");
                            String tipoAlimento = scanner.nextLine();
                            ProductoAlimenticio productoAlimenticio = new ProductoAlimenticio(nombre, cantidad, fechaVencimiento, tipoAlimento);
                            inventario.agregarProducto(productoAlimenticio);
                        } else if (tipo == 2) {
                            System.out.println("Ingrese prescripción:");
                            String prescripcion = scanner.nextLine();
                            ProductoFarmaceutico productoFarmaceutico = new ProductoFarmaceutico(nombre, cantidad, fechaVencimiento, prescripcion);
                            inventario.agregarProducto(productoFarmaceutico);
                        } else {
                            System.out.println("Tipo de producto no válido");
                        }
                        break;
                    case 2:
                        System.out.println("Lista de productos:");
                        for (Producto p : inventario.listarProductos()) {
                            p.mostrarInformacion();
                        }
                        break;
                    case 3:
                        System.out.println("Productos próximos a vencer:");
                        notificador.notificarProximosAVencer(inventario.productosProximosAVencer(30));
                        break;
                    case 4:
                        System.out.println("Productos vencidos:");
                        notificador.notificarVencidos(inventario.productosVencidos());
                        break;
                    case 5:
                        System.out.println("Ingrese nombre del producto a eliminar:");
                        String nombreEliminar = scanner.nextLine();
                        inventario.eliminarProducto(nombreEliminar);
                        break;
                    case 6:
                        System.out.println("Ingrese nombre del producto a actualizar:");
                        String nombreActualizar = scanner.nextLine();
                        System.out.println("Ingrese nuevo nombre:");
                        String nuevoNombre = scanner.nextLine();
                        System.out.println("Ingrese nueva cantidad:");
                        int nuevaCantidad = scanner.nextInt();
                        System.out.println("Ingrese nueva fecha de vencimiento (AAAA-MM-DD):");
                        LocalDate nuevaFechaVencimiento = LocalDate.parse(scanner.next());
                        scanner.nextLine();  // Consumir la nueva línea
                        System.out.println("Ingrese tipo de producto (1: Alimenticio, 2: Farmacéutico):");
                        int tipoNuevo = scanner.nextInt();
                        scanner.nextLine();  // Consumir la nueva línea

                        if (tipoNuevo == 1) {
                            System.out.println("Ingrese tipo de alimento:");
                            String tipoAlimentoNuevo = scanner.nextLine();
                            ProductoAlimenticio productoActualizado = new ProductoAlimenticio(nuevoNombre, nuevaCantidad, nuevaFechaVencimiento, tipoAlimentoNuevo);
                            inventario.actualizarProducto(nombreActualizar, productoActualizado);
                        } else if (tipoNuevo == 2) {
                            System.out.println("Ingrese prescripción:");
                            String prescripcionNueva = scanner.nextLine();
                            ProductoFarmaceutico productoActualizado = new ProductoFarmaceutico(nuevoNombre, nuevaCantidad, nuevaFechaVencimiento, prescripcionNueva);
                            inventario.actualizarProducto(nombreActualizar, productoActualizado);
                        } else {
                            System.out.println("Tipo de producto no válido");
                        }
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
                scanner.nextLine();  // Consumir la nueva línea en caso de error
            }
        }
    }
}