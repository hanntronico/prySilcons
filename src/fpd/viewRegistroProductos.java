package fpd;

import java.io.Console;
import java.util.Scanner;

public class viewRegistroProductos {

    static String[] codigosProducto = new String[20];
    static String[] nombresProducto = new String[20];
    static String[] descripcionProducto = new String[20];
    static String[] colorProducto = new String[20];
    static String[] tallaProducto = new String[20];
    static Double[] precioProducto = new Double[20];

    static String[] codigosCliente = new String[20];
    static String[] nombresCliente = new String[20];
    static String[] documentosCliente = new String[20];
    static String[] rucCliente = new String[20];
    static String[] direccionesCliente = new String[20];
    static String[] telefonosCliente = new String[20];
    static String[] emailsCliente = new String[20];

    static String[] codigosPedido = new String[20];
    static String[] codigosCli = new String[20];
    static String[] codigosTrabajador = new String[20];
    static String[] tiposPedido = new String[20];
    static String[] fechasPedido = new String[20];
    static String[] fechasIngresaPedido = new String[20];
    static String[] fechasSalidaPedido = new String[20];
    static String[] estadosPedido = new String[20];


    public static boolean verificaLogueo(String usuario, String password) {
        if (usuario.equals("Hanntronico") && password.equals("123456")) {
            return true;
        } else {
            return false;
        }
    }

    public static void limpiaPantalla() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            /*No hacer nada*/
        }
    }

    public static String generarCodigProducto() {
        String ceros = "";
        int longitudArray = 0;

        for (int i = 0; i < codigosProducto.length; i++){
            if (codigosProducto[i] != null){
                longitudArray++;
            }
        }
        if (longitudArray < 9) {
            ceros = "0000";
        } else {
            ceros = "000";
        }
        String codigoProducto = "PRO" + ceros + String.valueOf(longitudArray + 1);
        return codigoProducto;
    }

    public static boolean registrarProducto(String nomProd, String descProd, String colorProd, String tallaProd, String precioProd) {
        int longitudArray = 0;
        String codigoProducto = generarCodigProducto();


        for (int i = 0; i < nombresProducto.length; i++) {
            if (nombresProducto[i] != null) {
                longitudArray++;
            }
        }
        codigosProducto[longitudArray + 1] = codigoProducto;
        nombresProducto[longitudArray + 1] = nomProd;
        descripcionProducto[longitudArray + 1] = descProd;
        colorProducto[longitudArray + 1] = colorProd;
        tallaProducto[longitudArray + 1] = tallaProd;
        precioProducto[longitudArray + 1] = Double.parseDouble(precioProd);
        return true;
    }

    public static String listarProductos(){
        String vista = "";
        String espacio = "";
        vista += "\n";
        vista += "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
        vista += "|  CODIGO      |    PRODUCTO                  |     DESCRIPCION                        |    COLOR    | TALLA |  PRECIO  |\n";
        vista += "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";

        for (int i = 0; i < nombresProducto.length; i++) {
            if (nombresProducto[i] != null) {
            vista += "  "+codigosProducto[i]+"     ";
            vista += "  "+nombresProducto[i];

            espacio = "";
            for (int j = 0; j < (30-nombresProducto[i].length()) ; j++) { espacio = espacio + " "; }
            vista += espacio + "  " + descripcionProducto[i];

            espacio = "";
            for (int j = 0; j < (39-descripcionProducto[i].length()) ; j++) { espacio = espacio + " "; }
            vista += espacio + colorProducto[i];

            espacio = "";
            for (int j = 0; j < (16-colorProducto[i].length()) ; j++) { espacio = espacio + " "; }
            vista += espacio + tallaProducto[i];

            espacio = "";
            for (int j = 0; j < (10-tallaProducto[i].length()) ; j++) { espacio = espacio + " "; }
            vista += espacio + precioProducto[i];


            vista += "\n";
            }
        }

        return vista;
    }

    public static String verProducto(String codProducto){
        int posicion = 0;
        String cadena = "";
        for (int i = 0; i < codigosProducto.length; i++) {
            if (codigosProducto[i] != null){
                if (codigosProducto[i].equals(codProducto) ){
                    posicion = i;
                }
            }
        }
        if(posicion != 0){
            cadena += "\n";
            cadena += "      Codigo producto :  " + codigosProducto[posicion]+"\n";
            cadena += "      Nombre producto :  " + nombresProducto[posicion]+"\n";
            cadena += " Descripcion producto :  " + descripcionProducto[posicion]+"\n";
            cadena += "       Color producto :  " + colorProducto[posicion]+"\n";
            cadena += "       Talla producto :  " + tallaProducto[posicion]+"\n";
            cadena += "      Precio producto :  " + precioProducto[posicion];
        }else if (posicion == 0){
            cadena = "vacio";
        }

        return cadena;
    }

    public static boolean modificarProducto(String codigo, int tipo, String valor){
        int posicion = 0;

        for (int i = 0; i < codigosProducto.length; i++) {
            if (codigosProducto[i] != null){
                if (codigosProducto[i].equals(codigo)){
                    posicion = i;
                }
            }
        }

        if(tipo == 1)nombresProducto[posicion] = valor;
        if(tipo == 2)descripcionProducto[posicion] = valor;
        if(tipo == 3)colorProducto[posicion] = valor;
        if(tipo == 4)tallaProducto[posicion] = valor;
        if(tipo == 5)precioProducto[posicion] = Double.parseDouble(valor);

        return true;
    }

    public static String productoMasPedido(){


        return "";
    }

    public static Double [] porcentajePedidosPorVendedor(){
        double cantidad = 0.0;
        Double[] porcentajes = new Double[3];

        double cantidadVendedor1 = 0, cantidadVendedor2 = 0, cantidadVendedor3 = 0;
        for (int i = 0; i < codigosPedido.length; i++) {
            if (codigosPedido[i] != null){
                cantidad++;
            }
            if (codigosPedido[i] != null){
                if(codigosTrabajador[i].equals("vendedor1")){
                    cantidadVendedor1++;
                }else if (codigosTrabajador[i].equals("vendedor2")){
                    cantidadVendedor2++;
                }else if (codigosTrabajador[i].equals("vendedor3")){
                    cantidadVendedor3++;
                }

            }
        }

        porcentajes[0] = (cantidadVendedor1/cantidad)*100;
        porcentajes[1] = (cantidadVendedor2/cantidad)*100;
        porcentajes[2] = (cantidadVendedor3/cantidad)*100;

        return porcentajes;
    }

    public static Double [] porcentajePedidosPorTipoPedido(){
        double cantidad = 0.0;
        Double[] porcentajePedido = new Double[2];

        double cantidadTipo1 = 0, cantidadTipo2 = 0;
        for (int i = 0; i < codigosPedido.length; i++) {
            if (codigosPedido[i] != null){
                cantidad++;
            }
            if (codigosPedido[i] != null){
                if(tiposPedido[i].equals("externo")){
                    cantidadTipo1++;
                }else if (tiposPedido[i].equals("interno")){
                    cantidadTipo2++;
                }

            }
        }

        porcentajePedido[0] = (cantidadTipo1/cantidad)*100;
        porcentajePedido[1] = (cantidadTipo2/cantidad)*100;

        return porcentajePedido;
    }

    public static Double [] porcentajeCantidadPedidosEstado(){
        double cantidad = 0.0, cantidadEnEspera=0.0, cantidadCancelado=0.0, cantidadAtendido=0.0;
        Double[] porcentajeCantidad = new Double[6];

        for (int i = 0; i < estadosPedido.length; i++) {
            if (estadosPedido[i] != null){
                cantidad++;
            }
            if(estadosPedido[i] != null){
                if (estadosPedido[i].equals("en espera"))cantidadEnEspera++;
                else if (estadosPedido[i].equals("atendido"))cantidadAtendido++;
                else if (estadosPedido[i].equals("cancelado"))cantidadCancelado++;
            }
        }

        porcentajeCantidad[0] = (cantidadEnEspera/cantidad)*100;
        porcentajeCantidad[1] = cantidadEnEspera;
        porcentajeCantidad[2] = (cantidadAtendido/cantidad)*100;
        porcentajeCantidad[3] = cantidadAtendido;
        porcentajeCantidad[4] = (cantidadCancelado/cantidad)*100;
        porcentajeCantidad[5] = cantidadCancelado;

        return porcentajeCantidad;
    }

    public static int cantidadPersonasNatural(){
        int cantidad = 0;
        for (int i = 0; i < rucCliente.length; i++) {
            if (rucCliente[i] != null){
                    if (rucCliente[i].substring(0,2).equals("10") ){
                        cantidad++;
                    }

            }
        }

        return cantidad;
    }

    public static int cantidadPersonasJuridica(){
        int cantidad = 0;
        for (int i = 0; i < rucCliente.length; i++) {
            if (rucCliente[i] != null){
                    if (rucCliente[i].substring(0,2).equals("20") ){
                        cantidad++;
                    }
            }
        }

        return cantidad;
    }


    public static int[] cantidadPedidosPorCliente(){
        int cantidad = 0;

        for (int i = 0; i < codigosCli.length; i++) {
            if (codigosCli[i] != null) cantidad++;
        }

        int[] cantidadPedidos = new int[cantidad];

        for (int i = 0; i < codigosCli.length; i++) {
            if (codigosCli[i] != null) {

                for (int j = 0; j < codigosCliente.length; j++) {
                    if (codigosCli[i].equals(codigosCliente[j])) cantidadPedidos[j]++;
                }

            }
        }

        return cantidadPedidos;
    }

    public static int[] obtener_indice_odenado(String[] cantidad_producto) {

        int[] ordenar_cantidad = new int[cantidad_producto.length];
        int[] indice_cantidad = new int[cantidad_producto.length];

        for (int i = 0; i < ordenar_cantidad.length; i++) {
            ordenar_cantidad[i] = Integer.parseInt(cantidad_producto[i]);
        }
//      ORDENAR arreglo original en otro arreglo "ordenar_cantidad"
        for (int i = 0; i <= ordenar_cantidad.length - 2; i++) {
            for (int j = 1; j <= ordenar_cantidad.length - 1; j++) {
                if (ordenar_cantidad[j] < ordenar_cantidad[j - 1]) {
                    int temp = ordenar_cantidad[j];
                    ordenar_cantidad[j] = ordenar_cantidad[j - 1];
                    ordenar_cantidad[j - 1] = temp;
                }
            }
        }

//      BUSCA y ubica el indice y asigna en un arreglo "indice_cantidad"
        for (int i = 0; i < ordenar_cantidad.length; i++) {
            for (int j = 0; j < cantidad_producto.length; j++) {
                if (ordenar_cantidad[i] == Integer.parseInt(cantidad_producto[j])) {
                    indice_cantidad[i] = j;
//                    System.out.println(j);
                    j = cantidad_producto.length;
                }
            }
        }
        return indice_cantidad;
    }

    public static void main(String[] args) {

        codigosProducto[0] = "PRO00001";   nombresProducto[0] = "Boxer Renata";                descripcionProducto[0] = "Boxer Renata";                        colorProducto[0] = "rosado";     tallaProducto[0] = "S";    precioProducto[0] = 3.00;
        codigosProducto[1] = "PRO00002";   nombresProducto[1] = "Boxer Classy";                descripcionProducto[1] = "Boxer Class";                         colorProducto[1] = "blanco";     tallaProducto[1] = "XL";   precioProducto[1] = 1.00;
        codigosProducto[2] = "PRO00003";   nombresProducto[2] = "Boxer Basico C/E";            descripcionProducto[2] = "boxer basico de algodon pima puro";   colorProducto[2] = "azul";       tallaProducto[2] = "XL";   precioProducto[2] = 12.50;
        codigosProducto[3] = "PRO00004";   nombresProducto[3] = "Boxer Jhon Albert Juvenil";   descripcionProducto[3] = "Boxer de algodon";                    colorProducto[3] = "negro";      tallaProducto[3] = "S";    precioProducto[3] = 8.00;
        codigosProducto[4] = "PRO00005";   nombresProducto[4] = "Boxer Cassy Navy"; 		   descripcionProducto[4] = "Boxer Cassy Navy Algodon"; 	       colorProducto[4] = "azul";       tallaProducto[4] = "S";	   precioProducto[4] = 10.00;
        codigosProducto[5] = "PRO00006";   nombresProducto[5] = "Boxer Classy Navy"; 		   descripcionProducto[5] = "Boxer Classy Navy"; 			       colorProducto[5] = "blanco";     tallaProducto[5] = "S";	   precioProducto[5] = 12.00;
        codigosProducto[6] = "PRO00007";   nombresProducto[6] = "Boxer Classy Scout"; 		   descripcionProducto[6] = "algodon"; 					           colorProducto[6] = "acero";      tallaProducto[6] = "S";	   precioProducto[6] = 12.00;

        codigosCliente[0] = "CLI00001";    nombresCliente[0] = "Juan Carlos Altamirano";			  documentosCliente[0] = "47715777";	rucCliente[0] = "10477157773";	direccionesCliente[0] = "Ca. El Sol 456";									telefonosCliente[0] = "987321654";    emailsCliente[0] = "jcaltam@gmail.com";
        codigosCliente[1] = "CLI00002";    nombresCliente[1] = "Ana Diaz Mundaca";					  documentosCliente[1] = "48596879";	rucCliente[1] = "10485968797";	direccionesCliente[1] = "Chiclayo - Ca. Angamos 34";						telefonosCliente[1] = "987456981";    emailsCliente[1] = "adimun@silicons.com.pe";
        codigosCliente[2] = "CLI00003";    nombresCliente[2] = "CONCASA S.A.C.";					  documentosCliente[2] = "44889966";	rucCliente[2] = "20951463257";	direccionesCliente[2] = "Av. San Luis nro 1365";			 				telefonosCliente[2] = "987633144";    emailsCliente[2] = "jcaceres@gmail.com";
        codigosCliente[3] = "CLI00004";    nombresCliente[3] = "Jorge Luis Padilla";				  documentosCliente[3] = "44112233";	rucCliente[3] = "10441122336";	direccionesCliente[3] = "Av. Libertadores Nro 156 - Trujillo";			    telefonosCliente[3] = "987654321";    emailsCliente[3] = "jlpadilla@hotmail.com";
        codigosCliente[4] = "CLI00005";    nombresCliente[4] = "Joe Postigo Ortigas";				  documentosCliente[4] = "48961236";	rucCliente[4] = "10489612367";	direccionesCliente[4] = "Ca. Campeonato Nro 5632 - Dpto 304 - Surquillo";	telefonosCliente[4] = "998665332";    emailsCliente[4] = "jpostigo_orti@gmail.com";
        codigosCliente[5] = "CLI00006";    nombresCliente[5] = "Mayra Coronado Pérez";				  documentosCliente[5] = "43698741";	rucCliente[5] = "20363614147";	direccionesCliente[5] = "direccion 1177";									telefonosCliente[5] = "963852741";    emailsCliente[5] = "mcoronado@gmail.com";
        codigosCliente[6] = "CLI00007";    nombresCliente[6] = "María del Carmen Alfaro Echeandía";	  documentosCliente[6] = "15636935";	rucCliente[6] = "10156369351";	direccionesCliente[6] = "Madrigal 631 - int B";								telefonosCliente[6] = "974654324";    emailsCliente[6] = "mcafaeche@gmail.com";

        codigosPedido[0]	= "PED00001";	codigosCli[0]	= "CLI00001";	codigosTrabajador[0]	= "vendedor1";  	tiposPedido[0]	= "externo";	fechasPedido[0]	 = "14-02-2016";   fechasIngresaPedido[0]	= "15-02-2016";		fechasSalidaPedido[0]	= "18-02-2016";	  estadosPedido[0]	= "cancelado";
        codigosPedido[1]	= "PED00002";	codigosCli[1]	= "CLI00001";	codigosTrabajador[1]	= "vendedor1";		tiposPedido[1]	= "externo";	fechasPedido[1]	 = "15-02-2016";   fechasIngresaPedido[1]	= "16-02-2016";		fechasSalidaPedido[1]	= "19-02-2016";	  estadosPedido[1]	= "en espera";
        codigosPedido[2]	= "PED00003";	codigosCli[2]	= "CLI00002";	codigosTrabajador[2]	= "vendedor2";		tiposPedido[2]	= "externo";	fechasPedido[2]	 = "05-05-2021";   fechasIngresaPedido[2]	= "06-05-2021";		fechasSalidaPedido[2]	= "09-05-2021";	  estadosPedido[2]	= "atendido";
        codigosPedido[3]	= "PED00004";	codigosCli[3]	= "CLI00003";	codigosTrabajador[3]	= "vendedor1";		tiposPedido[3]	= "interno";	fechasPedido[3]	 = "07-05-2021";   fechasIngresaPedido[3]	= "07-05-2021";		fechasSalidaPedido[3]	= "10-05-2021";	  estadosPedido[3]	= "atendido";
        codigosPedido[4]	= "PED00005";	codigosCli[4]	= "CLI00004";	codigosTrabajador[4]	= "vendedor2";		tiposPedido[4]	= "interno";	fechasPedido[4]	 = "05-05-2021";   fechasIngresaPedido[4]	= "06-05-2021";		fechasSalidaPedido[4]	= "09-05-2021";	  estadosPedido[4]	= "atendido";
        codigosPedido[5]	= "PED00006";	codigosCli[5]	= "CLI00005";	codigosTrabajador[5]	= "vendedor1";		tiposPedido[5]	= "externo";	fechasPedido[5]	 = "05-05-2021";   fechasIngresaPedido[5]	= "06-05-2021";		fechasSalidaPedido[5]	= "09-05-2021";	  estadosPedido[5]	= "cancelado";
        codigosPedido[6]	= "PED00007";	codigosCli[6]	= "CLI00006";	codigosTrabajador[6]	= "vendedor2";		tiposPedido[6]	= "interno";	fechasPedido[6]	 = "21-05-2021";   fechasIngresaPedido[6]	= "22-05-2021";		fechasSalidaPedido[6]	= "25-05-2021";	  estadosPedido[6]	= "en espera";
        codigosPedido[7]	= "PED00008";	codigosCli[7]	= "CLI00005";	codigosTrabajador[7]	= "vendedor3";		tiposPedido[7]	= "externo";	fechasPedido[7]	 = "22-06-2021";   fechasIngresaPedido[7]	= "23-06-2021";		fechasSalidaPedido[7]	= "26-06-2021";	  estadosPedido[7]	= "en espera";
        codigosPedido[8]	= "PED00009";	codigosCli[8]	= "CLI00007";	codigosTrabajador[8]	= "vendedor1";		tiposPedido[8]	= "interno";	fechasPedido[8]	 = "23-06-2021";   fechasIngresaPedido[8]	= "24-06-2021";		fechasSalidaPedido[8]	= "27-06-2021";	  estadosPedido[8]	= "cancelado";
        codigosPedido[9]	= "PED00010";	codigosCli[9]	= "CLI00007";	codigosTrabajador[9]	= "vendedor2";		tiposPedido[9]	= "externo";	fechasPedido[9]	 = "24-07-2021";   fechasIngresaPedido[9]	= "25-07-2021";		fechasSalidaPedido[9]	= "28-07-2021";	  estadosPedido[9]	= "atendido";
        codigosPedido[10]	= "PED00011";	codigosCli[10]	= "CLI00007";	codigosTrabajador[10]	= "vendedor3";		tiposPedido[10]	= "externo";	fechasPedido[10] = "25-07-2021";   fechasIngresaPedido[10]  = "26-07-2021";		fechasSalidaPedido[10]	= "29-07-2021";	  estadosPedido[10]	= "cancelado";


        Scanner sc = new Scanner(System.in);
        int opcion = 0, opcionPro = 0, opcionRepo=0;
        String opcionRepo1 = "";
        String menu = "";
        String enter = "";

        limpiaPantalla();
        System.out.print("");
        menu = "";
        menu += " ******************************************\n";
        menu += " |                                        |\n";
        menu += " |    APLICACION DE GESTION DE PEDIDOS    |\n";
        menu += " |          MANUFACTURAS SILCONS          |\n";
        menu += " |                                        |\n";
        menu += " ******************************************\n";
        menu += "\n";
        menu += "\n";

//        menu+="Ingrese usuario: ";
//        System.out.printf(menu);
//        String usuario = sc.nextLine();
////        System.out.printf("Ingrese password: ");
////        String password = sc.nextLine();
//        Console cnsl = null;
//        String alpha = null;
//        String password = "";
//        try {
//            cnsl = System.console();
//            if (cnsl != null) {
//                char[] pwd = cnsl.readPassword("Password: ");
//                password = String.valueOf(pwd);
//            }
//
//        } catch(Exception ex) {
//            ex.printStackTrace();
//        }

        String usuario = "Hanntronico";
        String password = "123456";

        if (verificaLogueo(usuario, password)) {

            do {
                limpiaPantalla();
                System.out.print("");
                menu = "\n";
                menu += "  ******************************************\n";
                menu += "  |                                        |\n";
                menu += "  |            MENU DE OPCIONES            |\n";
                menu += "  |                                        |\n";
                menu += "  ******************************************\n";
                menu += "\n";
                menu += "  1- Gestionar Productos \n";
                menu += "  2- Gestionar Clientes \n";
                menu += "  3- Gestionar Pedidos \n";
                menu += "  4- Reportes \n";
                menu += "  5- Finalizar \n";
                menu += "     Seleccione una opcion:";
                System.out.println(menu);
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:


                        do {
                            limpiaPantalla();
                            System.out.print("");
                            menu = "\n";
                            menu += "  ******************************************\n";
                            menu += "  |                                        |\n";
                            menu += "  |           GESTION DE PRODUCTOS         |\n";
                            menu += "  |                                        |\n";
                            menu += "  ******************************************\n";
                            menu += "\n";
                            menu += "  1- Buscar Productos \n";
                            menu += "  2- Registrar Productos \n";
                            menu += "  3- Modificar Productos \n";
                            menu += "  4- Eliminar Productos \n";
                            menu += "  5- Volver al menu principal \n";
                            menu += "\n";
                            menu += "     Seleccione una opcion:";
                            System.out.println(menu);

////                            String fffff = sc.nextLine();
//                            System.out.println( listarProductos() );
//                            System.out.println("Seleccione una opcion: ");
                            opcionPro = sc.nextInt();


                            switch (opcionPro) {
                                case 1:
                                    limpiaPantalla();
                                    System.out.println("");
                                    System.out.println("********* B\u00fasqueda de Producto *********\n");
                                    String bus1 = sc.nextLine();
                                    System.out.printf("Ingrese c\u00f3digo del Producto: ");
                                    String codProductoBus1 = sc.nextLine();
                                    System.out.println(verProducto(codProductoBus1));
                                    System.out.println();
                                    System.out.println("Presionar enter para continuar ...");
                                    enter = sc.nextLine();
                                    break;
                                case 2:
                                    limpiaPantalla();
                                    System.out.println(" ");
                                    System.out.println("********* REGISTRAR PRODUCTO *********\n");
                                    String fff = sc.nextLine();
                                    System.out.printf("Ingrese nombre del Producto: ");
                                    String nombreProducto = sc.nextLine();
                                    System.out.printf("Ingrese descripcion del Producto: ");
                                    String descripcioProducto = sc.nextLine();
                                    System.out.printf("Ingrese color de Producto: ");
                                    String colorProducto = sc.nextLine();
                                    System.out.printf("Ingrese talla de Producto: ");
                                    String tallaProducto = sc.nextLine();
                                    System.out.printf("Ingrese precio de Producto: ");
                                    String precioProducto = sc.nextLine();

                                    if (registrarProducto(nombreProducto, descripcioProducto, colorProducto, tallaProducto, precioProducto)) {
                                        System.out.println( listarProductos() );
                                        System.out.println("Presionar enter para continuar ...");
                                        enter = sc.nextLine();
                                    }
                                    break;
                                case 3:
                                    limpiaPantalla();
                                    System.out.println(" ");
                                    System.out.println("*********** MODIFICAR PRODUCTO ***********\n");
                                    String esp = sc.nextLine();
                                    System.out.printf("Ingrese c\u00f3digo del Producto: ");
                                    String codProductoBus2 = sc.nextLine();

                                    if ( verProducto(codProductoBus2).equals("vacio") ) {

                                        System.out.println("Producto no encontrado");
                                        System.out.println("Presionar enter para continuar ...");
                                        enter = sc.nextLine();


                                    }else{

                                        System.out.println(verProducto(codProductoBus2));
                                        System.out.println();
                                        System.out.printf("Desea modificar nombre del Producto? [S/N]");
                                        String respNombre = sc.nextLine();
                                        switch (respNombre) {
                                            case "s":
                                                System.out.println("Ingrese nuevo nombre Producto: ");
                                                String editNombreProducto = sc.nextLine();
                                                modificarProducto(codProductoBus2, 1, editNombreProducto);
                                                break;
                                            case "n":
                                                break;
                                        }

                                        System.out.println();
                                        System.out.printf("Desea modificar descripci\u00f3n del Producto? [S/N]");
                                        String respDescripcion = sc.nextLine();
                                        switch (respDescripcion) {
                                            case "s":
                                                System.out.println("Ingrese nueva descripci\u00f3n del Producto: ");
                                                String editDescripProducto = sc.nextLine();
                                                modificarProducto(codProductoBus2, 2, editDescripProducto);
                                                break;
                                            case "n":
                                                break;
                                        }

                                        System.out.println();
                                        System.out.printf("Desea modificar color del Producto? [S/N]");
                                        String respColor = sc.nextLine();
                                        switch (respColor) {
                                            case "s":
                                                System.out.println("Ingrese nuevo color del Producto: ");
                                                String editColorProducto = sc.nextLine();
                                                modificarProducto(codProductoBus2, 3, editColorProducto);
                                                break;
                                            case "n":
                                                break;
                                        }

                                        System.out.println();
                                        System.out.printf("Desea modificar talla del Producto? [S/N]");
                                        String respTalla = sc.nextLine();
                                        switch (respTalla) {
                                            case "s":
                                                System.out.println("Ingrese nueva talla del Producto: ");
                                                String editColorProducto = sc.nextLine();
                                                modificarProducto(codProductoBus2, 4, editColorProducto);
                                                break;
                                            case "n":
                                                break;
                                        }

                                        System.out.println();
                                        System.out.printf("Desea modificar precio del Producto? [S/N]");
                                        String respPrecio = sc.nextLine();
                                        switch (respPrecio) {
                                            case "s":
                                                System.out.println("Ingrese nuevo precio del Producto: ");
                                                String editPrecioProducto = sc.nextLine();
                                                modificarProducto(codProductoBus2, 5, editPrecioProducto);
                                                break;
                                            case "n":
                                                break;
                                        }

                                        System.out.println( listarProductos() );
                                        System.out.println("Presionar enter para continuar ...");
                                        enter = sc.nextLine();

                                    }


                                    break;
                                case 4:
                                    limpiaPantalla();
                                    System.out.println(" ");
                                    System.out.println("********* ELIMINAR PRODUCTO *********");
                                    String ffff = sc.nextLine();
                                    System.out.println( listarProductos() );
                                    System.out.println("Presionar enter para continuar ...");
                                    String enter2 = sc.nextLine();
                            }
                        } while (opcionPro != 5);


                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        do {
                            limpiaPantalla();
                            System.out.print("");
                            menu = "\n";
                            menu += "  ******************************************\n";
                            menu += "  |                                        |\n";
                            menu += "  |                REPORTES                |\n";
                            menu += "  |                                        |\n";
                            menu += "  ******************************************\n";
                            menu += "\n";
                            menu += "  1- Producto con mayor cantidad de pedidos \n";
                            menu += "  2- Porcentaje de pedidos de cada vendedor \n";
                            menu += "  3- Porcentaje de pedidos de cada Tipo de Pedido \n";
                            menu += "  4- Cantidad y porcentaje de pedidos por Estado \n";
                            menu += "  5- Cantidad y porcentaje de clientes P. Natural o P. Juridica \n";
                            menu += "  6- DNI, RUC e Email del cliente con mayor cantidad de pedidos  \n";
                            menu += "  7- Mes con mayor percentaje de ventas \n";
                            menu += "  8- Mes con menor cantidad de ventas de Persona Natural \n";
                            menu += "  9- Ventas totales por mes \n";
                            menu += "  A- Total de ventas \n";
                            menu += " (R) Retornar al menu principal \n";
                            menu += "\n";
                            menu += "     Seleccione una opcion:  ";
                            System.out.printf(menu);
                            opcionRepo1 = sc.nextLine();
                            switch (opcionRepo1) {
                                case "1":
                                    limpiaPantalla();
                                    System.out.println(" *********  Producto con mayor cantidad de pedidos  *******\n");
                                    System.out.println("Presionar enter para continuar ...");
                                    enter = sc.nextLine();
                                    break;
                                case "2":
                                    limpiaPantalla();
                                    System.out.println();
                                    System.out.println(" *********  Porcentaje de pedidos de cada vendedor  *******\n");
                                    for (int i = 0; i < porcentajePedidosPorVendedor().length; i++) {
                                        System.out.printf(" Vendedor "+(i+1)+": %.2f %% \n", porcentajePedidosPorVendedor()[i]);
                                    }
                                    System.out.println();
                                    System.out.println(" Presionar enter para continuar ...");
                                    enter = sc.nextLine();
                                    break;
                                case "3":
                                    String tipoPedido = "";
                                    limpiaPantalla();
                                    System.out.println();
                                    System.out.println(" *********  Porcentaje de pedidos de cada Tipo de Pedido  *******\n");
                                    for (int i = 0; i < porcentajePedidosPorTipoPedido().length; i++) {
                                        if (i == 0){
                                            tipoPedido = "Externo";
                                        }else if(i == 1){
                                            tipoPedido = "Interno";
                                        }
                                        System.out.printf(tipoPedido + ": %.2f %% \n", porcentajePedidosPorTipoPedido()[i]);
                                    }

                                    System.out.println("Presionar enter para continuar ...");
                                    enter = sc.nextLine();
                                    break;
                                case "4":
                                    String texto = "", tipo = "";
                                    limpiaPantalla();
                                    System.out.println(" *********  Cantidad y porcentaje de pedidos por Estado  *******\n");
                                    for (int i = 0; i < porcentajeCantidadPedidosEstado().length; i++) {
                                        if ((i % 2) == 0) texto = "Porcentaje: %.2f %% \n";
                                        else texto = "Cantidad: %.0f \n\n";

                                        if (i == 0  || i == 1){
                                            tipo = "En Espera ";
                                        }else if(i == 2 || i == 3){
                                            tipo = "Atendido ";
                                        }else if(i == 4 || i == 5){
                                            tipo = "Cancelado ";
                                        }

                                        System.out.printf(tipo + texto, porcentajeCantidadPedidosEstado()[i]);
                                    }
                                    System.out.println("Presionar enter para continuar ...");
                                    enter = sc.nextLine();
                                    break;
                                case "5":
                                    limpiaPantalla();
                                    System.out.println(" *********  Cantidad de clientes P. Natural o P. Juridica  *******\n");

                                    System.out.printf("Cantidad de Clientes Persona Natural  : %s clientes \n", cantidadPersonasNatural());
                                    System.out.printf("Cantidad de Clientes Persona Juridica : %s clientes \n\n", cantidadPersonasJuridica());


                                    System.out.println("Presionar enter para continuar ...");
                                    enter = sc.nextLine();
                                    break;
                                case "6":
                                    limpiaPantalla();
                                    System.out.println(" *********  Cantidad de clientes con con mas pedidos *******\n");

//                                    for (int i = 0; i < cantidadPedidosPorCliente().length; i++)
//                                        System.out.println(cantidadPedidosPorCliente()[i]);

                                    obtener_indice_odenado( cantidadPedidosPorCliente()  );

                                    System.out.println();
                                    System.out.println("Presionar enter para continuar ...");
                                    enter = sc.nextLine();
                                    break;
                                case "7":
                                    break;
                                case "8":
                                    break;
                                case "9":
                                    break;
                                case "A":
                                    limpiaPantalla();
                                    System.out.println("Reporte A");
                                    System.out.println("Presionar enter para continuar ...");
                                    enter = sc.nextLine();
                                    break;

                            }

                        } while ( !opcionRepo1.equalsIgnoreCase("R") );




                        break;
                }
            } while (opcion != 5);


        } else {
            System.out.println("Usuario o Password incorrecto!!");
        }


//        do {
//            System.out.print("");
//            menu="";
//            menu+="******** Menú de opciones *******\n";
//            menu+="1- Ingrese edad años \n";
//            menu+="2- Ingrese edad meses \n";
//            menu+="3- Finalizar \n";
//            menu+="Seleccione una opción:";
//            System.out.println(menu);
//
//            Integer opcionT = sc.nextInt();
//            switch(opcion){
//                case 1:
//                    System.out.println("Ingrese edad en años: ");
//                    String edadAniosT = sc.nextLine();
//                    edadAnios = Integer.parseInt( edadAniosT );
//                    System.out.println("La edad en meses es: "+((edadAnios*12)+edadMeses)+" meses \n");
//                    break;
//                case 2:
//                    System.out.println("Ingrese edad en meses: ");
//                    String edadMesesT = sc.nextLine();
//                    edadMeses = Integer.parseInt(edadMesesT);
//
//                    edadAnios = edadMeses / 12;
//                    meses = edadMeses % 12;
//
//                    System.out.println("La edad en meses es: "+edadAnios+" años "+meses+" mes(es) \n");
//                    break;
//            }
//        }while(opcion != 3);


    }

}
