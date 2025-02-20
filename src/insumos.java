import java.time.LocalDate;

public class insumos {
    
    private int codigoIns;
    private String nombreInsumo;
    private String tipoInsumo;
    private int cantidad;
    private float precioIns;
    private LocalDate fechaInsumo;



    // Constructor
    public insumos (int codigoIns, String nombreInsumo, String tipoInsumo, int cantidad, float precioIns, LocalDate fechaInsumo) {
        this.codigoIns = codigoIns;
        this.nombreInsumo = nombreInsumo;
        this.tipoInsumo = tipoInsumo;
        this.cantidad = cantidad;
        this.precioIns = precioIns;
        this.fechaInsumo = fechaInsumo;
    }

    // Métodos SET
    public void setCodigoIns(int codigoIns) {
        this.codigoIns = codigoIns;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public void setTipoInsumo(String tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioIns(float precioIns) {
        this.precioIns = precioIns;
    }

    public void setFechaInsumo(LocalDate fechaInsumo) {
        this.fechaInsumo = fechaInsumo;
    }

    // Métodos GET
    public int getCodigoIns() {
        return codigoIns;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public String getTipoInsumo() {
        return tipoInsumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecioIns() {
        return precioIns;
    }

    public LocalDate getFechaInsumo() {
        return fechaInsumo;
    }

    public int getYearr(){
        return fechaInsumo.getYear();
    }


    public int getMonthValue(){
        return fechaInsumo.getMonthValue();
    }

}
