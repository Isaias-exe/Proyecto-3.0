import java.util.List;

public class Notificador {

    public void notificarProximosAVencer(List<Producto> productos) {
        System.out.println("Productos próximos a vencer:");
        for (Producto producto : productos) {
            producto.mostrarInformacion();
        }
    }

    public void notificarVencidos(List<Producto> productos) {
        System.out.println("Productos vencidos:");
        for (Producto producto : productos) {
            producto.mostrarInformacion();
        }
    }
}