import java.time.LocalDate;

public abstract class Producto {
    private String nombre;
    private int cantidad;
    private LocalDate fechaVencimiento;

    public Producto(String nombre, int cantidad, LocalDate fechaVencimiento) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", fechaVencimiento=" + fechaVencimiento +
                '}';
    }

    public abstract void mostrarInformacion();
}