import java.time.LocalDate;

public class pedidos {

    private int idPedido;
    private LocalDate fechaPedido;
    private String estado;
    private int cantHuevos;
    private float montoPedidos;

    // Constructor
    public pedidos(int idPedido, LocalDate fechaPedido, String estado, int cantHuevos, float montoPedidos) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.cantHuevos = cantHuevos;
        this.montoPedidos = montoPedidos;
    }

    // Métodos SET
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCantHuevos(int cantHuevos) {
        this.cantHuevos = cantHuevos;
    }

    public void setMontoPedidos(float montoPedidos) {
        this.montoPedidos = montoPedidos;
    }

    // Métodos GET
    public int getIdPedido() {
        return idPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public int getCantHuevos() {
        return cantHuevos;
    }

    public float getMontoPedidos() {
        return montoPedidos;
    }
}
