import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.xml.transform.Source;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // TODO code application logic here

        Scanner Entrada = new Scanner(System.in);
        int ent;

        ArrayList<huevos> listaHuevos = new ArrayList<>();
        ArrayList<ventas> listaVentas = new ArrayList<>();
        ArrayList<gastos> listaGastos = new ArrayList<>();
        ArrayList<pedidos> listaPedidos = new ArrayList<>();
        ArrayList<clientes> listaClientes = new ArrayList<>();
        ArrayList<insumos> listaInsumos = new ArrayList<>();

        /*
         * clientes[] clien=new clientes[2000];
         * pedidos [] pedid=new pedidos[10000];
         * huevos [] huevo= new huevos[10000];
         * ventas[] vent=new ventas[10000];
         * gastos [] gast=new gastos[10000];
         * insumos [] ins=new insumos[10000];
         */

        String codigoIns;
        float precioIns;

        int stockHuevospeq = 0;
        int stockHuevosmed = 0;
        int stockHuevosgran = 0;
        int stockTotalHuevo = 0;

        int stockAlimentos = 0;
        int stockInfraestructura = 0;
        int stockHerramientas = 0;
        int stockMedicina = 0;
        int stockEmbalaje = 0;
        int stockOtros = 0;

        String tamañoVentas = "0";

        int ent3;
        int ent13 = 0;
        int ent14 = 0;

        String estadoPedidos = "Pendiente";
        LocalDate fechaPedido = null;

        String tamaño;
        int ent4;
        int ent10 = 0;

        int cantVentas = 0;

        String nombreProv;
        String direccionProv;

        int i = 0;

        double precioHuevos = 200;

        float gastosAnuales = 0;
        float gastosMensuales = 0;

        huevos huevosNuevos = new huevos(0, null, "0");
        insumos insumosNuevos = new insumos(0, "0", "0", 0, 0, null);
        do {

            System.out.println("--------------------------------------------");
            System.out.println("Ingrese 1 para ingresar Precios de insumos (Gastos)");
            System.out.println("Ingrese 2 para agregar un producto (Huevos)");
            System.out.println("Ingrese 3 para realizar ventas");
            System.out.println("Ingrese 4 para generar informe");
            System.out.println("Ingrese 5 para calcular gastos totales");
            System.out.println("Ingrese 6 para dar de baja/actualizar un producto/insumo");
            System.out.println("Ingrese 7 para cargar un pedido");
            System.out.println("Ingrese 8 para ver las condiciones y requisitos");
            System.out.println("Ingrese 0 para salir del programa");

            ent = Entrada.nextInt();
            Entrada.nextLine();

            while (ent < 0 || 8 < ent) {
                System.out.print("\033[H\033[2J");

                System.out.println("ERROR.");

                System.out.println("Ingrese 1 para Ingresar Precios de insumos");
                System.out.println("Ingrese 2 para calcular gastos totales");
                System.out.println("Ingrese 3 para realizar ventas");
                System.out.println("Ingrese 4 para generar informe");
                System.out.println("Ingrese 5 para cargar un producto");
                System.out.println("Ingrese 6 para dar de baja un producto");
                System.out.println("Ingrese 7 para ver las condiciones y requisitos");
                System.out.println("Ingrese 0 para salir del programa");

                ent = Entrada.nextInt();

            }

            switch (ent) {

                case 1:

                    System.out.print("\033[H\033[2J");

                    System.out.println("--------------INSUMOS-----------");
                    System.out.println("Ingrese 1 si desea cargar precios de insumos");
                    System.out.println("Ingrese 2 si quiere mostrar todos los precios de los insumos");
                    System.out.println("Ingrese 0 para volver al menu principal");
                    int ent2 = Entrada.nextInt();
                    Entrada.nextLine();

                    while (ent2 < 0 || 2 < ent2) {
                        System.out.print("\033[H\033[2J");
                        System.out.println("ERROR.");
                        System.out.println("--------------INSUMOS-----------");
                        System.out.println("Ingrese 1 si desea cargar precios de insumos");
                        System.out.println("Ingrese 2 si quiere mostrar todos los precios de los insumos");
                        ent2 = Entrada.nextInt();
                        Entrada.nextLine();
                    }

                    if (ent2 == 1) {

                        System.out.println("Ingrese el codigo del producto");

                        while (true) {
                            codigoIns = Entrada.nextLine();
                            // lo que hace esta linea es que no permite menos o mas de 5 caracteres para el
                            // codigo
                            if (codigoIns.length() == 5 && codigoIns.matches("\\d{5}")) {
                                break;
                            } else {
                                System.out.println("ERROR. Debe ingresar un código de 5 números:");
                            }
                        }

                        System.out.print("\033[H\033[2J");
                        System.out.println("Ingrese el precio unitario del insumo");
                        precioIns = Entrada.nextFloat();
                        Entrada.nextLine();

                        while (precioIns < 500) {
                            System.out.print("\033[H\033[2J");
                            System.out.println("ERROR.");
                            System.out.println("Debe ingresar un valor minimo de $500,00");
                            System.out.println("(Positivos)");
                            System.out.println("Ingrese el precio del insumo");
                            precioIns = Entrada.nextFloat();
                            Entrada.nextLine();
                        }

                        System.out.print("\033[H\033[2J");
                        System.out.println("Ingrese la cantidad de los insumos adquiridos");
                        int cantidadInsumos = Entrada.nextInt();
                        Entrada.nextLine();

                        while (cantidadInsumos < 1 || 1000 < cantidadInsumos) {
                            System.out.print("\033[H\033[2J");
                            System.out.println("Error.");
                            System.out.println("(debe ingresar entre 1 y 1000)");
                            System.out.println("Ingrese la cantidad de los insumos adquiridos");
                            cantidadInsumos = Entrada.nextInt();
                            Entrada.nextLine();
                        }

                        System.out.print("\033[H\033[2J");
                        System.out.println("Ingrese el nombre del  insumo");
                        String nombreInsumo = Entrada.nextLine();

                        System.out.print("\033[H\033[2J");
                        System.out.println("Ingrese el tipo de Insumo");
                        System.out.println("1- Alimentos");
                        System.out.println("2- Infraestructura");
                        System.out.println("3- Herramientas");
                        System.out.println("4- Medicina/Productos sanitarios");
                        System.out.println("5- Embalaje");
                        System.out.println("6- otros");
                        int tipo = Entrada.nextInt();
                        Entrada.nextLine();

                        while (tipo < 1 || 6 < tipo) {
                            System.out.print("\033[H\033[2J");
                            System.out.println("Error.");
                            System.out.println("Debe ingresar los numeros mencionados:");
                            System.out.println("Ingrese el tipo de Insumo");
                            System.out.println("1- Alimentos");
                            System.out.println("2- Infraestructura");
                            System.out.println("3- Herramientas");
                            System.out.println("4- Medicina/Productos sanitarios");
                            System.out.println("5- Embalaje");
                            System.out.println("6- otros");
                            tipo = Entrada.nextInt();
                            Entrada.nextLine();
                        }

                        String tipoIns = "0";

                        switch (tipo) {
                            case 1:
                                tipoIns = "Alimentos";
                                stockAlimentos = stockAlimentos + cantidadInsumos;
                                break;
                            case 2:
                                tipoIns = "Infraestructura";
                                stockInfraestructura = stockInfraestructura + cantidadInsumos;
                                break;
                            case 3:
                                tipoIns = "Herramientas";
                                stockHerramientas = stockHerramientas + cantidadInsumos;
                                break;
                            case 4:
                                tipoIns = "Medicina/Productos Sanitarios";
                                stockMedicina = stockMedicina + cantidadInsumos;
                                break;
                            case 5:
                                tipoIns = "Embalaje";
                                stockEmbalaje = stockEmbalaje + cantidadInsumos;
                                break;

                            default:
                                tipoIns = "Otros";
                                stockOtros = stockOtros + cantidadInsumos;
                                break;
                        }

                        // Obtener la fecha actual

                        LocalDate fechaInsumo = LocalDate.now();

                        insumos nuevoInsumo = new insumos(Integer.parseInt(codigoIns), nombreInsumo, tipoIns,
                                cantidadInsumos, precioIns, fechaInsumo);

                        insumosNuevos = nuevoInsumo;

                        listaInsumos.add(insumosNuevos);

                        // gastosAnuales=gastosAnuales+(cantidadInsumos*precioIns);

                        System.out.print("\033[H\033[2J");

                        System.out.println("------------------------------");
                        System.out.println("Se ingresaron los precios correctamente");
                        System.out.println("------------------------------");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");

                        i++;

                    } else {
                        System.out.print("\033[H\033[2J");
                        for (int t = 0; t < listaInsumos.size(); t++) {

                            insumos insumoActual = listaInsumos.get(t);

                            System.out.println("--------------------------------");
                            System.out.println("INSUMO N° " + t);
                            System.out.println("--------------------------------");
                            System.out.println("Código: " + insumoActual.getCodigoIns());
                            System.out.println("Nombre: " + insumoActual.getNombreInsumo());
                            System.out.println("Tipo: " + insumoActual.getTipoInsumo());
                            System.out.println("Cantidad disponible: " + insumoActual.getCantidad());
                            System.out.println("Precio: " + insumoActual.getPrecioIns());
                            System.out.println("Fecha: " + insumoActual.getFechaInsumo());
                            System.out.println("");

                        }
                    }

                    break;

                case 2:

                    System.out.print("\033[H\033[2J");

                    System.out.println("Ingrese 1 si desea Cargar un producto (Huevos)");
                    System.out.println("Ingrese 2 si desea ver los productos ya cargados ");
                    System.out.println("Ingrese 0 para volver al menu principal");
                    int ent5 = Entrada.nextInt();

                    while (ent5 < 0 || 2 < ent5) {
                        System.out.print("\033[H\033[2J");
                        System.out.println("Ingrese 1 si desea Cargar un producto (Huevos)");
                        System.out.println("Ingrese 2 si desea ver los productos ya cargados ");
                        System.out.println("Ingrese 0 para volver al menu principal");
                        ent5 = Entrada.nextInt();
                    }

                    System.out.print("\033[H\033[2J");

                    if (ent5 == 1) {
                        do {

                            System.out.println("Hola!");
                            System.out.println("--------------------------------------");
                            System.out.println("ACLARACION!");
                            System.out.println("Se debe ingresar una puesta de huevos del mismo tamaño");
                            System.out.println("ej: 20 productos de tamaño grande");
                            System.out.println("--------------------------------------");
                            System.out.println("Ingrese la cantidad de productos (huevos) a cargar");
                            System.out.println("Ingrese 0 si quiere volver al menu principal");
                            int puestaHuevos = Entrada.nextInt();

                            if (puestaHuevos == 0) {
                                break;
                            }

                            while (puestaHuevos < 0 || 1000 < puestaHuevos) {
                                System.out.print("\033[H\033[2J");
                                System.out.println("ERROR.");
                                System.out.println("Puede ingresar de 1 hasta 1000 productos (huevos)");
                                System.out.println("Hola!");
                                System.out.println("Ingrese la cantidad de productos (huevos) a cargar");
                                System.out.println("Ingrese 0 si quiere volver al menu principal");
                                puestaHuevos = Entrada.nextInt();
                            }

                            System.out.print("\033[H\033[2J");
                            System.out.println("Ingrese el tamaño de los productos");
                            System.out.println("Ingrese 1 si son pequeños");
                            System.out.println("Ingrese 2 si son medianos");
                            System.out.println("Ingrese 3 si son grandes");
                            ent4 = Entrada.nextInt();

                            while (ent4 < 1 || 3 < ent4) {
                                System.out.print("\033[H\033[2J");
                                System.out.println("Error.");
                                System.out.println("Ingrese el tamaño de los productos");
                                System.out.println("Ingrese 1 si son pequeños");
                                System.out.println("Ingrese 2 si son medianos");
                                System.out.println("Ingrese 3 si son grandes");
                                ent4 = Entrada.nextInt();

                            }

                            if (ent4 == 1) {
                                tamaño = "Pequeños";
                            } else {
                                if (ent4 == 2) {
                                    tamaño = "Medianos";
                                } else {
                                    tamaño = "Grandes";
                                }
                            }

                            if (ent4 == 1) {
                                stockHuevospeq = stockHuevospeq + puestaHuevos;
                            } else {
                                if (ent4 == 2) {
                                    stockHuevosmed = stockHuevosmed + puestaHuevos;
                                } else {

                                    stockHuevosgran = stockHuevosgran + puestaHuevos;
                                }
                            }

                            stockTotalHuevo = stockHuevosgran + stockHuevosmed + stockHuevospeq;

                            LocalDateTime fechaRecoleccion = LocalDateTime.now();

                            huevos huevo = new huevos(puestaHuevos, fechaRecoleccion, tamaño);
                            huevosNuevos = huevo;
                            listaHuevos.add(huevosNuevos);

                            System.out.print("\033[H\033[2J");

                            System.out.println(
                                    "Se cargaron " + puestaHuevos + " productos(huevos) " + tamaño + " correctamente");

                            System.out.println("Fecha Recoleccion y Hora: " + huevosNuevos.getFechaRecoleccion());
                            System.out.println("");
                            System.out.println("---------------------------------------------");
                            System.out.println("desea seguir cargando productos?");
                            System.out.println("Ingrese 1 para SI");
                            System.out.println("Ingrese 0 para NO");
                            ent3 = Entrada.nextInt();
                            System.out.print("\033[H\033[2J");

                        } while (ent3 != 0);

                    } else {

                        if (ent5 == 2) {
                            if (stockHuevosgran != 0 && stockHuevosmed != 0 && stockHuevospeq != 0) {

                                for (int u = 0; u < listaHuevos.size(); u++) {

                                    huevos huevoActual = listaHuevos.get(u); // Obtener cada objeto individualmente

                                    System.out.println("-----------------------");
                                    System.out.println("RECOLECCION N " + u);
                                    System.out.println("-----------------------");
                                    System.out.println("Puesta de huevos: " + huevoActual.getPuestaHuevos());
                                    System.out.println("Tamaño: " + huevoActual.getTamaño());
                                    System.out.println("Fecha y Hora: " + huevoActual.getFechaRecoleccion());

                                }

                                System.out.println("-------------------------");
                                System.out.println("Totales ");
                                System.out.println("-------------------------");
                                System.out.println("Total productos pequeños: " + stockHuevospeq);
                                System.out.println("Total productos medianos: " + stockHuevosmed);
                                System.out.println("Total productos grandes: " + stockHuevosgran);
                                System.out.println("-------------------------");
                                System.out.println("");

                            } else {
                                System.out.print("\033[H\033[2J");
                                System.out.println("-------------------------------------");
                                System.out.println("No hay productos cargados hasta el momento");
                                System.out.println("--------------------------------------");
                            }

                        } else {
                            break;
                        }
                    }

                    break;

                case 3:
                    do {
                        if (stockTotalHuevo != 0) {
                            System.out.println("1- Si desea generar una venta");
                            System.out.println("2- Cancelar una venta");
                            System.out.println("3- Si quiere entregar un pedido");
                            System.out.println("0- volver al menu principal");
                            ent13 = Entrada.nextInt();
                            Entrada.nextLine();

                            while (ent13 < 0 || 2 < ent13) {
                                System.out.println("ERROR.");
                                System.out.println("1- Si desea generar una venta");
                                System.out.println("2- Cancelar una venta");
                                System.out.println("0- volver al menu principal");
                                ent13 = Entrada.nextInt();
                                Entrada.nextLine();

                            }

                            if (ent13 == 1) {
                                System.out.print("\033[H\033[2J");

                                System.out.print("\033[H\033[2J");
                                System.out.println("Ingrese el tamaño de los productos a vender");
                                System.out.println("(DEBE ESCRIBIRSE TODO EN MAYUSCULA)");
                                System.out.println("Marca una de estas 3 opciones:");
                                System.out.println("1- GRANDES");
                                System.out.println("2- MEDIANOS");
                                System.out.println("3- PEQUEÑOS");
                                int tam = Entrada.nextInt();

                                while (tam < 1 || 3 < tam) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.println("ERROR.");
                                    System.out.println("Ingrese el tamaño de los productos a vender");
                                    System.out.println("(DEBE ESCRIBIRSE TODO EN MAYUSCULA)");
                                    System.out.println("Marca una de estas 3 opciones:");
                                    System.out.println("1- GRANDES");
                                    System.out.println("2- MEDIANOS");
                                    System.out.println("3- PEQUEÑOS");
                                    tam = Entrada.nextInt();
                                }

                                System.out.println("Ingrese la cantidad de huevos a vender");
                                int cantHuevos = Entrada.nextInt();
                                Entrada.nextLine();

                                while (cantHuevos < 1) {

                                    System.out.println("ERROR.");
                                    System.out.println("Debe ingresar numeros mayor a 0");
                                    System.out.println("Ingrese la cantidad de huevos a vender");
                                    cantHuevos = Entrada.nextInt();
                                    Entrada.nextLine();

                                }

                                if (tam == 1) {

                                    while (stockHuevosgran < tam) {
                                        System.out.println("ERROR");
                                        System.out.println("No hay suficiente stock para dicha venta");
                                        System.out.println(
                                                "stock disponible; " + stockHuevosgran + " Productos (Huevos)");
                                        System.out.println("Ingrese nuevamente la cantidad de huevos a vender");
                                        System.out.println("Ingrese 0 para volver al menu principal");
                                        cantHuevos = Entrada.nextInt();
                                        Entrada.nextLine();
                                    }

                                    if(cantHuevos==0){
                                        break;
                                    }

                                } else {
                                    if (tam == 2) {

                                        while (stockHuevosmed < tam) {
                                            System.out.println("ERROR");
                                            System.out.println("No hay suficiente stock para dicha venta");

                                            System.out.println("Stock Productos (Huevos) Medianos: " + stockHuevosmed);

                                            System.out.println("Ingrese nuevamente la cantidad de huevos a vender");
                                            cantHuevos = Entrada.nextInt();
                                            Entrada.nextLine();
                                        }

                                    } else {
                                        while (stockHuevospeq < tam) {
                                            System.out.println("ERROR");
                                            System.out.println("No hay suficiente stock para dicha venta");

                                            System.out.println("Stock Productos (Huevos) Pequeños: " + stockHuevospeq);

                                            System.out.println("Ingrese nuevamente la cantidad de huevos a vender");
                                            cantHuevos = Entrada.nextInt();
                                            Entrada.nextLine();
                                        }

                                    }
                                }

                                System.out.print("\033[H\033[2J");
                                System.out.println("Ingrese el metodo de pago");
                                System.out.println("Ingrese 1 si es con tarjeta debito/credito");
                                System.out.println("Ingrese 2 si es con efectivo");
                                System.out.println("Ingrese 3 si es con billeteras virtuales");
                                System.out.println("ingrese 0 para volver");
                                int ent6 = Entrada.nextInt();
                                Entrada.nextLine();

                                while (ent6 < 0 || 3 < ent6) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.println("ERROR.");
                                    System.out.println("Ingrese el metodo de pago");
                                    System.out.println("Ingrese 1 si es con tarjeta debito/credito");
                                    System.out.println("Ingrese 2 si es con efectivo");
                                    System.out.println("Ingrese 3 si es con billeteras virtuales");
                                    System.out.println("ingrese 0 para volver");
                                    ent6 = Entrada.nextInt();
                                    Entrada.nextLine();

                                }

                                String metodo;

                                if (ent6 == 1) {
                                    metodo = "Debito/Credito";
                                } else {
                                    if (ent6 == 2) {
                                        metodo = "Efectivo";
                                    } else {
                                        metodo = "Billetera Virtual";
                                    }
                                }

                                LocalDateTime fechaVenta = LocalDateTime.now();

                                Random randd = new Random();
                                int idVentas = randd.nextInt(1000);

                                double montoTotal = cantHuevos * precioHuevos;

                                if (tam == 1) {
                                    stockHuevosgran = stockHuevosgran - cantHuevos;
                                    tamañoVentas = "GRANDES";
                                } else {
                                    if (tam == 2) {
                                        stockHuevosmed = stockHuevosmed - cantHuevos;
                                        tamañoVentas = "MEDIANOS";
                                    } else {
                                        stockHuevospeq = stockHuevospeq - cantHuevos;
                                        tamañoVentas = "PEQUEÑOS";
                                    }
                                }

                                ventas venta = new ventas(idVentas, fechaVenta, montoTotal, metodo, cantHuevos,
                                        tamañoVentas);

                                listaVentas.add(venta);

                                System.out.print("\033[H\033[2J");
                                System.out.println("---------------------------------");
                                System.out.println("Se realizo la venta correctamente");
                                cantVentas = cantVentas + 1;
                            } else {
                                if (ent13 == 2) {
                                    System.out.println("Ingrese el ID de la venta a cancelar");
                                    int idCanc = Entrada.nextInt();
                                    Entrada.nextLine();

                                    boolean hayCancelacion = false;

                                    for (int g = 0; g < listaVentas.size(); g++) {

                                        if (listaVentas.get(g).getIdVentas() == idCanc) { // Suponiendo que tienes un ID
                                            listaVentas.remove(g); // Eliminar la venta de la lista
                                            System.out.println("La venta ha sido cancelada exitosamente.");
                                            hayCancelacion = true;
                                            break;

                                        }

                                    }

                                    if (hayCancelacion == false) {
                                        System.out.println("No se encuentra ninguna venta con dicho ID");

                                    }

                                } else {
                                    do {
                                        System.out.println("Ingrese el id del pedido a entregar");
                                        System.out.println("Ingrese 0 si quiere volver al menu principal");

                                        ent14 = Entrada.nextInt();

                                        if (ent14 != 0) {
                                            for (int x = 0; x < listaPedidos.size(); x++) {

                                                if (listaPedidos.get(x).getIdPedido() == ent14) {

                                                    pedidos pedidoActual = new pedidos(0, null, "0", 0, 0);

                                                    estadoPedidos = "Completado";
                                                    System.out.println("El pedido se entrego correctamente");
                                                    pedidoActual.setEstado(estadoPedidos);
                                                    break;

                                                } else {
                                                    System.out.println("ERROR.");
                                                    System.out.println("No existe ningun pedido con dicho ID");

                                                }

                                            }
                                        }

                                    } while (ent14 != 0);
                                }
                            }

                        } else {
                            System.out.println("ERROR.");
                            System.out.println("No hay stock de productos (Huevos)");
                        }

                    } while (ent13 != 0);

                    break;

                case 4:

                    System.out.print("\033[H\033[2J");
                    System.out.println("-----------Ingreso GENERAR INFORME--------------");
                    System.out.println("Ingrese 1 si desea ver el informe anual");
                    System.out.println("Ingrese 2 si desea ver el informe mensual");

                    System.out.println("Ingrese 0 para volver al menu principal");
                    int ent7 = Entrada.nextInt();
                    Entrada.nextLine();

                    while (ent7 < 0 || 2 < ent7) {
                        System.out.print("\033[H\033[2J");
                        System.out.println("ERROR.");
                        System.out.println("-----------Ingreso GENERAR INFORME--------------");
                        System.out.println("Ingrese 1 si desea ver el informe anual");
                        System.out.println("Ingrese 2 si desea ver el informe mensual");

                        System.out.println("Ingrese 0 para volver al menu principal");
                        ent7 = Entrada.nextInt();
                    }

                    if (ent7 == 1) {

                        System.out.print("\033[H\033[2J");
                        System.out.println("Ingrese el año para generar el informe");

                        String añoInforme;

                        while (true) {

                            añoInforme = Entrada.nextLine();
                            // lo que hace esta linea es que no permite menos o mas de 4 caracteres para el
                            // año
                            if (añoInforme.length() == 4 && añoInforme.matches("\\d{4}")) {
                                break;
                            } else {
                                System.out.print("\033[H\033[2J");
                                System.out.println("ERROR. Debe ingresar un año de 4 números:");
                            }
                        }

                        boolean hayVentas = false; // Bandera para verificar si hay ventas en ese año
                        System.out.print("\033[H\033[2J");
                        for (int y = 0; y < listaVentas.size(); y++) {

                            ventas ventaActual = listaVentas.get(y);

                            if (Integer.parseInt(añoInforme) == ventaActual.getYearr()) {

                                hayVentas = true; // Se encontró al menos una venta en ese año

                                if (y == 0) {
                                    System.out.println("--------------------");
                                }

                                System.out.println("Venta N° " + y);
                                System.out.println("--------------------");

                                System.out.println("ID: " + ventaActual.getIdVentas());
                                System.out.println("Fecha: " + ventaActual.getFechaVenta());
                                System.out.println("Monto Total: " + ventaActual.getMontoTotal());
                                System.out.println("Metodo: " + ventaActual.getMetodo());
                                System.out.println("Cantidad Productos: " + ventaActual.getCantidadProd());
                                System.out.println("Tamaño: " + ventaActual.getTamaño());
                                System.out.println("--------------------");

                            }

                            if (!hayVentas) {
                                System.out.println("ERROR.");
                                System.out.println("No hay ninguna venta realizada en dicho año.");
                            }

                        }

                    } else {
                        if (ent7 == 2) {
                            int ent8;
                            do {
                                System.out.print("\033[H\033[2J");
                                System.out.println("Ingrese el mes para generar el informe");
                                System.out.println("1- ENERO");
                                System.out.println("2- FEBRERO");
                                System.out.println("3- MARZO");
                                System.out.println("4- ABRIL");
                                System.out.println("5- MAYO");
                                System.out.println("6- JUNIO");
                                System.out.println("7- JULIO");
                                System.out.println("8- AGOSTO");
                                System.out.println("9- SEPTIEMBRE");
                                System.out.println("10- OCTUBRE");
                                System.out.println("11- NOVIEMBRE");
                                System.out.println("12- DICIEMBRE");

                                int mesInforme = Entrada.nextInt();
                                Entrada.nextLine();

                                while (mesInforme < 1 || 12 < mesInforme) {

                                    System.out.print("\033[H\033[2J");
                                    System.out.println("ERROR.");
                                    System.out.println("Ingrese el mes para generar el informe");
                                    System.out.println("1- ENERO");
                                    System.out.println("2- FEBRERO");
                                    System.out.println("3- MARZO");
                                    System.out.println("4- ABRIL");
                                    System.out.println("5- MAYO");
                                    System.out.println("6- JUNIO");
                                    System.out.println("7- JULIO");
                                    System.out.println("8- AGOSTO");
                                    System.out.println("9- SEPTIEMBRE");
                                    System.out.println("10- OCTUBRE");
                                    System.out.println("11- NOVIEMBRE");
                                    System.out.println("12- DICIEMBRE");

                                    mesInforme = Entrada.nextInt();
                                    Entrada.nextLine();
                                }

                                boolean hayyVentas = false; // Bandera para verificar si hay ventas en ese año
                                System.out.print("\033[H\033[2J");

                                for (int w = 0; w < listaVentas.size(); w++) {

                                    ventas ventaActual = listaVentas.get(w);

                                    if (mesInforme == ventaActual.getMonthValue()) {

                                        hayyVentas = true; // Se encontró al menos una venta en ese año

                                        if (w == 0) {
                                            System.out.println("--------------------");
                                        }

                                        System.out.println("Venta N° " + w);
                                        System.out.println("--------------------");
                                        System.out.println(ventaActual.getMonthValue());
                                        System.out.println("ID: " + ventaActual.getIdVentas());
                                        System.out.println("Fecha: " + ventaActual.getFechaVenta());
                                        System.out.println("Monto Total: " + ventaActual.getMontoTotal());
                                        System.out.println("Metodo: " + ventaActual.getMetodo());
                                        System.out.println("Cantidad Productos: " + ventaActual.getCantidadProd());
                                        System.out.println("Tamaño: " + ventaActual.getTamaño());

                                    }

                                    if (!hayyVentas) {

                                        System.out.print("\033[H\033[2J");
                                        System.out.println("ERROR.");
                                        System.out.println("No hay ninguna venta realizada en dicho año.");

                                    }

                                }

                                System.out.println("Desea seguir consultando para generar un informe?");
                                System.out.println("1- SI");
                                System.out.println("0- NO");
                                ent8 = Entrada.nextInt();
                                Entrada.nextLine();

                                System.out.print("\033[H\033[2J");

                                while (ent8 < 0 || 1 < ent8) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.println("ERROR.");

                                    System.out.println("Desea seguir consultando para generar un informe?");
                                    System.out.println("1- SI");
                                    System.out.println("0- NO");
                                    ent8 = Entrada.nextInt();
                                    Entrada.nextLine();

                                    System.out.print("\033[H\033[2J");
                                }

                            } while (ent8 != 0);

                        }
                    }
                    break;

                case 5:

                    System.out.print("\033[H\033[2J");
                    System.out.println("Hola! ha ingresado en calcular gastos totales");
                    System.out.println("Ingrese 1 si desea ver el monto total de los gastos anual ");
                    System.out.println("Ingrese 2 si desea ver el monto total de los gastos mensual");
                    System.out.println("Ingrese 3 si desea ver un gasto especifico");
                    System.out.println("Ingrese 0 si quiere volver al menu principal");
                    int ent9 = Entrada.nextInt();
                    Entrada.nextLine();

                    while (ent9 < 0 || 3 < ent9) {

                        System.out.print("\033[H\033[2J");
                        System.out.println("ERROR.");
                        System.out.println("Hola! ha ingresado en calcular gastos totales");
                        System.out.println("Ingrese 1 si desea ver el monto total de los gastos anual ");
                        System.out.println("Ingrese 2 si desea ver el monto total de los gastos mensual");
                        System.out.println("Ingrese 0 si quiere volver al menu principal");
                        ent9 = Entrada.nextInt();
                        Entrada.nextLine();
                    }

                    if (ent9 == 1) {

                        System.out.print("\033[H\033[2J");
                        System.out.println("Ingrese el año que desea ver los gastos");

                        String añoGastos;

                        while (true) {

                            añoGastos = Entrada.nextLine();
                            // lo que hace esta linea es que no permite menos o mas de 4 caracteres para el
                            // año
                            if (añoGastos.length() == 4 && añoGastos.matches("\\d{4}")) {
                                break;
                            } else {
                                System.out.print("\033[H\033[2J");
                                System.out.println("ERROR. Debe ingresar un año de 4 números:");
                            }
                        }

                        boolean hayGastos = false; // Bandera para verificar si hay ventas en ese año

                        System.out.print("\033[H\033[2J");

                        for (int y = 0; y < listaInsumos.size(); y++) {

                            insumos insumoActual = listaInsumos.get(y);

                            if (Integer.parseInt(añoGastos) == insumoActual.getYearr()) {

                                hayGastos = true; // Se encontró al menos una venta en ese año

                                gastosAnuales = gastosAnuales
                                        + (insumoActual.getCantidad() * insumoActual.getPrecioIns());

                            }

                            if (!hayGastos) {
                                System.out.print("\033[H\033[2J");
                                System.out.println("ERROR.");
                                System.out.println("No hay ningun gasto realizada en dicho año.");
                            }

                        }

                        System.out.println("Gasto Total Anual: $" + gastosAnuales);

                    } else {

                        do {
                            System.out.print("\033[H\033[2J");
                            System.out.println("Ingrese el mes que desea ver los gastos");
                            System.out.println("Ingrese numeros del 1 al 12");
                            System.out.println("ej: 1 (ENERO)");
                            int mesGastos;

                            mesGastos = Entrada.nextInt();
                            Entrada.nextLine();

                            while (mesGastos < 1 || 12 < mesGastos) {
                                System.out.print("\033[H\033[2J");
                                System.out.println("ERROR.");
                                System.out.println("Ingrese el mes que desea ver los gastos");
                                System.out.println("Ingrese numeros del 1 al 12");
                                System.out.println("ej: 1 (ENERO)");
                                mesGastos = Entrada.nextInt();
                                Entrada.nextLine();

                            }

                            boolean hayGastos = false; // Bandera para verificar si hay ventas en ese año

                            System.out.print("\033[H\033[2J");

                            for (int y = 0; y < listaInsumos.size(); y++) {

                                insumos insumoActual = listaInsumos.get(y);

                                if (mesGastos == insumoActual.getMonthValue()) {

                                    hayGastos = true; // Se encontró al menos una venta en ese año

                                    gastosMensuales = gastosMensuales
                                            + (insumoActual.getCantidad() * insumoActual.getPrecioIns());

                                }

                                if (!hayGastos) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.println("ERROR.");
                                    System.out.println("No hay ningun gasto realizada en dicho año.");

                                    System.out.println("Desea seguir consultando por los gastos?");
                                    System.out.println("1- SI");
                                    System.out.println("0- NO (Menu Principal)");
                                    ent10 = Entrada.nextInt();
                                    Entrada.nextLine();

                                    while (ent10 < 0 || 1 < ent10) {

                                        System.out.print("\033[H\033[2J");
                                        System.out.println("ERROR.");

                                        System.out.println("No hay ningun gasto realizada en dicho año.");

                                        System.out.println("Desea seguir consultando por los gastos?");
                                    }
                                    System.out.println("1- SI");
                                    System.out.println("0- NO (Menu Principal)");
                                    ent10 = Entrada.nextInt();

                                }

                            }

                            System.out.println("Gasto Total Anual: $" + gastosMensuales);

                        } while (ent10 != 0);

                    }

                    break;

                case 6:

                    System.out.println("----------DAR DE BAJA----------");
                    System.out.println("1- si desea dar de baja un producto (huevos)");
                    System.out.println("2- Si desea dar de baja un insumo");
                    System.out.println("0- Volver al menu principal");
                    int ent11 = Entrada.nextInt();
                    Entrada.nextLine();

                    while (ent11 < 0 || 2 < ent11) {

                        System.out.print("\033[H\033[2J");
                        System.out.println("ERROR.");

                        System.out.println("----------DAR DE BAJA----------");
                        System.out.println("1- si desea dar de baja un producto (huevos)");
                        System.out.println("2- Si desea dar de baja un insumo");
                        System.out.println("0- Volver al menu principal");
                        ent11 = Entrada.nextInt();
                        Entrada.nextLine();

                    }

                    if (ent11 == 1) {
                        System.out.println("Ingrese la cantidad de productos (huevos) para dar de baja");

                        int bajaProd = Entrada.nextInt();
                        Entrada.nextLine();

                        System.out.print("\033[H\033[2J");

                        System.out.println("Ingrese el tamaño de los productos");
                        System.out.println("Ingrese 1 para productos (huevos) pequeños");
                        System.out.println("ingrese 2 para productos (huevos) medianos");
                        System.out.println("Ingrese 3 para productos (huevos) grandes");
                        int tamBaja = Entrada.nextInt();
                        Entrada.nextLine();

                        while (tamBaja < 1 || 3 < tamBaja) {
                            System.out.print("\033[H\033[2J");
                            System.out.println("ERROR.");
                            System.out.println("Ingrese el tamaño de los productos");
                            System.out.println("Ingrese 1 para productos (huevos) pequeños");
                            System.out.println("ingrese 2 para productos (huevos) medianos");
                            System.out.println("Ingrese 3 para productos (huevos) grandes");
                            tamBaja = Entrada.nextInt();
                            Entrada.nextLine();

                        }

                        
                        if (tamBaja == 1) {
                            if(stockHuevospeq==0 ){
                                System.out.print("\033[H\033[2J");
                                System.out.println("No hay stock de productos pequeños");
                                System.out.println("No se pudo dar de baja ningun producto");
                                break;
                            }
                            stockHuevospeq = stockHuevospeq - tamBaja;
                        } else {
                            if (tamBaja == 2) {
                                if(stockHuevosmed==0 ){
                                    System.out.print("\033[H\033[2J");
                                    System.out.println("No hay stock de productos Medianos");
                                    System.out.println("No se pudo dar de baja ningun producto");
                                    break;
                                }
                                stockHuevosmed = stockHuevosmed - tamBaja;
                            } else {
                                if(stockHuevosmed==0 ){
                                    System.out.print("\033[H\033[2J");
                                    System.out.println("No hay stock de productos grandes");
                                    System.out.println("No se pudo dar de baja ningun producto");
                                    break;
                                }
                                stockHuevosgran = stockHuevosgran - tamBaja;
                            }
                        }

                        System.out.println("Se dieron de baja los productos correctamente");
                    } else {
                        if (ent11 == 2) {

                            System.out.println("Ingrese el tipo de insumo a dar de baja");

                            System.out.println("1- Alimentos");
                            System.out.println("2- Infraestructura");
                            System.out.println("3- Herramientas");
                            System.out.println("4- Medicina/Productos sanitarios");
                            System.out.println("5- Embalaje");
                            System.out.println("6- otros");
                            System.out.println("0- Menu principal");
                            int insBaja = Entrada.nextInt();

                            while (insBaja < 1 || 3 < insBaja) {
                                System.out.print("\033[H\033[2J");
                                System.out.println("ERROR.");
                                System.out.println("Ingrese el tipo de insumo a dar de baja");

                                System.out.println("1- Alimentos");
                                System.out.println("2- Infraestructura");
                                System.out.println("3- Herramientas");
                                System.out.println("4- Medicina/Productos sanitarios");
                                System.out.println("5- Embalaje");
                                System.out.println("6- otros");
                                System.out.println("0- Menu principal");
                                insBaja = Entrada.nextInt();
                            }

                            String tipoInsBaja = "0";

                            System.out.println("Ingrese la cantidad de insumos a dar de baja");
                            int ent12 = Entrada.nextInt();

                            if (insumosNuevos.getCantidad() < 0) {
                                switch (insBaja) {
                                    case 1:
                                        tipoInsBaja = "Alimentos";
                                        stockAlimentos = stockAlimentos - ent12;
                                        break;
                                    case 2:
                                        tipoInsBaja = "Infraestructura";
                                        stockInfraestructura = stockInfraestructura - ent12;
                                        break;
                                    case 3:
                                        tipoInsBaja = "Herramientas";
                                        stockHerramientas = stockHerramientas - ent12;

                                        break;
                                    case 4:
                                        tipoInsBaja = "Medicina/Productos Sanitarios";
                                        stockMedicina = stockMedicina - ent12;
                                        break;
                                    case 5:
                                        tipoInsBaja = "Embalaje";
                                        stockEmbalaje = stockEmbalaje - ent12;

                                        break;

                                    default:
                                        tipoInsBaja = "Otros";
                                        stockOtros = stockOtros - ent12;

                                        break;
                                }

                                System.out.print("\033[H\033[2J");
                                System.out.println("Se dio de baja correctamente el insumo");

                            } else {
                                System.out.println("Error. no hay Insumos cargados de ese tipo");
                            }

                        } else {

                            break;

                        }

                    }

                    break;
                case 7:

                    System.out.print("\033[H\033[2J");
                    System.out.println("----------PEDIDOS----------");
                    System.out.println("Ingrese la cantidad de productos para el pedido");
                    System.out.println("(maximo 200 productos)");
                    int cantPedido = Entrada.nextInt();
                    Entrada.nextLine();

                    while (cantPedido < 1 || 200 < cantPedido) {
                        System.out.print("\033[H\033[2J");

                        System.out.println("----------PEDIDOS----------");
                        System.out.println("ERROR.");
                        System.out.println("Ingrese la cantidad de productos para el pedido");
                        System.out.println("(maximo 200 productos)");
                        cantPedido = Entrada.nextInt();
                        Entrada.nextLine();
                    }

                    System.out.print("\033[H\033[2J");
                    System.out.println("----------PEDIDOS----------");

                    while (fechaPedido == null) {
                        try {
                            System.out.println("Ingrese la fecha del pedido en formato dd-MM-yyyy:");
                            String fechaIngresada = Entrada.nextLine();
                            // Formateador para parsear la fecha
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            // Convertir la entrada a LocalDate
                            fechaPedido = LocalDate.parse(fechaIngresada, formatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("ERROR: Formato de fecha inválido. Intente nuevamente.");
                        }
                    }

                    Random rand = new Random();
                    int idPedido = rand.nextInt(1000);

                    float montoPedidos = (float) (cantPedido * precioHuevos);

                    pedidos pedido = new pedidos(idPedido, fechaPedido, estadoPedidos, cantPedido, montoPedidos);
                    listaPedidos.add(pedido);

                    System.out.print("\033[H\033[2J");
                    System.out.println("Se cargo el pedido correctamente");

                    break;

                    case 8:

                    System.out.println("CONDICIONES  REQUISITOS");
                    
                    System.out.println("");

                    break;
            }

        } while (ent != 0);

    }

}
