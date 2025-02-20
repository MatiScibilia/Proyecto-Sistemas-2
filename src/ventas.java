
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ventas {

    private int idVentas;
    private LocalDateTime fechaVenta;
    private double montoTotal;
    private String metodo;
    private int cantidadProd;
    private String tamaño;
    

    Scanner Entrada = new Scanner(System.in);

    // Constructor
    public ventas(int idVentas, LocalDateTime fechaVenta, double montoTotal, String metodo, int cantidadProd, String tamaño) {
        this.idVentas = idVentas;
        this.fechaVenta = fechaVenta;
        this.montoTotal = montoTotal;
        this.metodo = metodo;
        this.cantidadProd=cantidadProd;
        this.tamaño=tamaño;
    }

   
    // Métodos SET
    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    // Métodos GET
    public int getIdVentas() {
        return idVentas;
    }

    public String getFechaVenta() {
       
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return fechaVenta.format(formatter);
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public String getMetodo() {
        return metodo;
    }

    public String getTamaño() {
        return tamaño;
    }


    public int getYearr(){
        return fechaVenta.getYear();
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public int getMonthValue(){
        return fechaVenta.getMonthValue();
    }
   

    




}
