public class clientes {

    private int idClientes;
    private String nombre;
    private String tipo;
    private int telefono;

    // Constructor
    public clientes(int idClientes, String nombre, String tipo, int telefono) {
        this.idClientes = idClientes;
        this.nombre = nombre;
        this.tipo = tipo;
        this.telefono = telefono;
    }

    // Métodos SET
    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    // Métodos GET
    public int getIdClientes() {
        return idClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getTelefono() {
        return telefono;
    }
}
