import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String nombre) {
        productos.removeIf(producto -> producto.getNombre().equals(nombre));
    }

    public void actualizarProducto(String nombre, Producto productoActualizado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(nombre)) {
                productos.set(i, productoActualizado);
                break;
            }
        }
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    public List<Producto> productosProximosAVencer(int dias) {
        List<Producto> proximosAVencer = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        for (Producto producto : productos) {
            if (producto.getFechaVencimiento().isAfter(hoy) && producto.getFechaVencimiento().isBefore(hoy.plusDays(dias))) {
                proximosAVencer.add(producto);
            }
        }
        return proximosAVencer;
    }

    public List<Producto> productosVencidos() {
        List<Producto> vencidos = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        for (Producto producto : productos) {
            if (producto.getFechaVencimiento().isBefore(hoy)) {
                vencidos.add(producto);
            }
        }
        return vencidos;
    }
}