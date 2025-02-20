
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class huevos 
    {

    private int puestaHuevos; 
    private LocalDateTime fechaRecoleccion;
    private String tamaño;
    

    // Constructor
    public huevos(int puestaHuevos, LocalDateTime fechaRecoleccion, String tamaño) {
        this.puestaHuevos = puestaHuevos;
        this.fechaRecoleccion = fechaRecoleccion;
        this.tamaño=tamaño;
        
    }

    // Métodos SET
    public void setPuestaHuevos(int puestaHuevos) {
        this.puestaHuevos = puestaHuevos;
    }

    public void setFechaRecoleccion(LocalDateTime fechaRecoleccion) {

        this.fechaRecoleccion = fechaRecoleccion;
    }

    public void setTamaño(String tamaño){
        this.tamaño=tamaño;
    }


    // Métodos GET
    public int getPuestaHuevos() {
        return puestaHuevos;
    }

    public String getFechaRecoleccion() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return fechaRecoleccion.format(formatter);
    }

    public String getTamaño() {
        return tamaño;
    }

    


}
