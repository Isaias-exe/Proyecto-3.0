import java.time.LocalDate;

public class ProductoAlimenticio extends Producto {

    private String tipoAlimento;

    public ProductoAlimenticio(String nombre, int cantidad, LocalDate fechaVencimiento , String tipoAlimento) {
        super(nombre, cantidad, fechaVencimiento);
        this.tipoAlimento = tipoAlimento;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Producto Alimenticio{" +
                "nombre='" + getNombre() + '\'' +
                ", cantidad=" + getCantidad() +
                ", fechaVencimiento=" + getFechaVencimiento() +
                ", tipoAlimento='" + tipoAlimento + '\'' +
                '}');
    }
}
