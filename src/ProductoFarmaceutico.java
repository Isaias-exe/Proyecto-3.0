import java.time.LocalDate;

public class ProductoFarmaceutico extends Producto {

    private String prescripcion;

    public ProductoFarmaceutico(String nombre, int cantidad,LocalDate fechaVencimiento , String prescripcion) {
        super(nombre, cantidad, fechaVencimiento);
        this.prescripcion = prescripcion;
    }

    public String getPrescripcion() {
        return prescripcion;
    }

    public void setPrescripcion(String prescripcion) {
        this.prescripcion = prescripcion;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Producto Farmacéutico{" +
                "nombre='" + getNombre() + '\'' +
                ", cantidad=" + getCantidad() +
                ", fechaVencimiento=" + getFechaVencimiento() +
                ", prescripcion='" + prescripcion + '\'' +
                '}');
    }
}
