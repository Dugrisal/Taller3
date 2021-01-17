package com.clientes;
import com.clases.Clientes;
import com.clases.Constantes;
import com.clases.Producto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal  {

    // Clase constructor
    public Principal(){
        // Procedimiento para mostrar Menu
        menu();
    }

    private void menu(){

       boolean salir = false;
        ArrayList<Clientes> arrayCliente  = new ArrayList<Clientes>();
        ArrayList<Producto> arrayProducto = new ArrayList<Producto>();
        Constantes constantes = new Constantes();

        Scanner in = new Scanner(System.in);

        //Uso clico do while() para iniciar menu
        @Deprecated(since = "1.2", forRemoval = true)
        Integer opMenu = new Integer(0);

        /**
         * Segun el concepto de polimorfismo un objeto puede tener multiples formas
         * con la estructura de clase que se entrega por favor implementar el concepto de poliformismo
         */

        do {

            System.out.println(constantes.menu);
            opMenu = in.nextInt();
            switch (opMenu.toString()) {
                case "1":
                    // Agregar cliente
                    arrayCliente = crearCliente(arrayCliente,arrayProducto);
                    break;
                case "2":
                    // Editar cliente
                    arrayCliente = editarCliente(arrayCliente,arrayProducto);
                    break;

                case "3":
                    // Eliminar cliente
                    arrayCliente = eliminarCliente(arrayCliente);
                    break;

                case "4":
                    // Agregar productos
                    arrayProducto = crearProducto(arrayProducto);
                    break;

                case "5":
                    String busDocument = JOptionPane.showInputDialog("Ingrese Documento del cliente");
                    String busTipoDoc  = JOptionPane.showInputDialog("Ingrese Tipo de documento del cliente");
                    consultarClientes(arrayCliente,busDocument,busTipoDoc);
                    break;

                case "6":
                    ListarClientes(arrayCliente);
                case "0":
                    // salir de la aplicacion
                    System.out.println("Muchas gracias por usar nuestra app, hasta luego");
                    break;
                default:
                    System.out.println("El valor ingresado no es una opcion de menu");
                    break;
            }
        } while (!opMenu.toString().equals("0"));
        in.close();
    }

    public static ArrayList crearCliente(ArrayList<Clientes> arraycliente,ArrayList<Producto> arrayProducto){
        Constantes constantes = new Constantes();
        Producto auxProducto = new Producto("","","","");
        ArrayList<Producto> arrayListProductoxCliente = new ArrayList<Producto>();
        boolean indBuscar = false;
        String idprod = "N";


        //1 Agregar cliente
        String cedula = JOptionPane.showInputDialog(constantes.TXT_Cedula);
        String tipdoc = JOptionPane.showInputDialog(constantes.TXT_TipoDoc);
        String nombre = JOptionPane.showInputDialog(constantes.TXT_Nombre);
        String telefo = JOptionPane.showInputDialog(constantes.TXT_Telefono);
        String direcc = JOptionPane.showInputDialog(constantes.TXT_Direccion);
        String movil  = JOptionPane.showInputDialog(constantes.TXT_Celular);

        // Ingresar informacion basica del cliente
        Clientes clientes = new Clientes(nombre,telefo,direcc,tipdoc,cedula,movil);
        indBuscar = false;

        // Ciclo para asignar los productos al cliente
        do {
            idprod = JOptionPane.showInputDialog("Ingresar Id del producto.\n  " +
                                                 "si no desea continuar ingrese 'N'");
            boolean indSalir = false;
            if (idprod.equalsIgnoreCase("N")) {
                indBuscar = true;
            }

            //ciclo para recorrer el vector producto
            for (int i = 0; i < arrayProducto.size(); i++){
                //Asignar info del arreglo recibido por parametro
                auxProducto = arrayProducto.get(i);

                if (idprod.equalsIgnoreCase(auxProducto.getIdProducto())){
                    //Prender indicador que encontro producto
                    indBuscar = true;
                    //Finalizar ciclo For y dejar de recorrer vector producto
                    break;
                }
            }

            //Validar si encontro producto
            if (!indBuscar && !indSalir){
                JOptionPane.showMessageDialog(null,"No se encontro producto","Mensaje",JOptionPane.WARNING_MESSAGE);
            } else {
                //Almacenar producto encontrado en Array local
                arrayListProductoxCliente.add(auxProducto);
            }
        }while (!idprod.equals("N"));

        //Validar si hay registro en el array para asignar al array de la clase cliente
        if (arrayListProductoxCliente.size()>0){
            clientes.setProductos(arrayListProductoxCliente);
        }

        //Asignar la info del objeto cliente al arreglo de la clase
        arraycliente.add(clientes);

        //Retornar cliente
        return arraycliente;
    }

    public static ArrayList editarCliente(ArrayList<Clientes> arraycliente,ArrayList<Producto> arrayProducto){


        boolean encontro = false;
        Producto auxProductoEd = new Producto("","","","");
        ArrayList<Producto> arrayListProductoxClienteEd = new ArrayList<Producto>();

        String nrocedula = JOptionPane.showInputDialog("Ingrese el documento del cliente que desea Editar");
        // Ciclo para recorrer el vector
        for (int i = 0; i < arraycliente.size(); i++){

            //captuar los datos de la cliente en un objeto auxiliar
            Clientes auxcliente = arraycliente.get(i);

            //validar  si el documento ingresado es igual a los almacenados
            if (nrocedula.equalsIgnoreCase(arraycliente.get(i).getCedula())){

                //ingresar datos a modificar
                String NombreCli = (JOptionPane.showInputDialog("Nombre del cliente"));
                String DirecCli  = (JOptionPane.showInputDialog("Dirección del cliente"));
                String TelefCli  = (JOptionPane.showInputDialog("Telefono del cliente"));
                String CeluCli   = (JOptionPane.showInputDialog("Celular del cliente"));

                //Setter atributos basicos
                auxcliente.setNombre(NombreCli);
                auxcliente.setDireccion(DirecCli);
                auxcliente.setTelefono(TelefCli);
                auxcliente.setCelular(CeluCli);

                        // Ciclo para asignar los productos al cliente
                        String idprod = "";
                        do {
                            idprod = JOptionPane.showInputDialog("Desea asociar un producto.\n  " +
                                    "si no desea continuar ingrese 'N'");
                            boolean indprod = false;
                            boolean indBuscar = false;

                            //ciclo para recorrer el vector producto
                            for (int k = 0; k < arrayProducto.size(); k++){
                                //Asignar info del arreglo recibido por parametro
                                auxProductoEd = arrayProducto.get(k);

                                if (idprod.equalsIgnoreCase(auxProductoEd.getIdProducto())){
                                    //Prender indicador que encontro producto
                                    indBuscar = true;
                                    //Finalizar ciclo For y dejar de recorrer vector producto
                                    break;
                                }
                            }

                            //Validar si encontro producto
                            if (!indBuscar && idprod !="N"){
                                JOptionPane.showMessageDialog(null,"No se encontro producto","Mensaje",JOptionPane.WARNING_MESSAGE);
                            } else {
                                //Almacenar producto encontrado en Array local
                                arrayListProductoxClienteEd.add(auxProductoEd);
                            }
                        }while (!idprod.equals("N"));

                        //Validar si hay registro en el array para asignar al array de la clase cliente
                        if (arrayListProductoxClienteEd.size()>0){
                            auxcliente.setProductos(arrayListProductoxClienteEd);
                        }
                //Actualizar cliente
                arraycliente.add(auxcliente);

                encontro = true;

                break;
            }
        }

        // Validar si encontro documento
        if (!encontro) {
            System.out.println("Cliente No encontrado \n");
        }
        return arraycliente;
    }

    public static ArrayList eliminarCliente(ArrayList<Clientes> arraycliente) {
        String nrocedula = JOptionPane.showInputDialog("Ingrese el documento del cliente que desea Eliminar");

        boolean encontro = false;

        // Ciclo para recorrer el vector
        for (int i = 0; i < arraycliente.size(); i++) {

            //captuar los datos de la cliente en un objeto auxiliar
            Clientes auxcliente = arraycliente.get(i);

            //validar  si el documento ingresado es igual a los almacenados
            if (nrocedula.equalsIgnoreCase(arraycliente.get(i).getCedula())) {

                //Para eliminar un elemento de un ArrayList nos vamos a apoyar en el método .remove().
                arraycliente.remove(i);
                encontro= true;
                break;
            }
        }
        // Validar si encontro documento
        if (!encontro) {
            System.out.println("Cliente No encontrado \n");
        }
        return arraycliente;
    }

    public static ArrayList crearProducto(ArrayList<Producto> arrayproducto){
        Constantes constantes = new Constantes();

        // Agregar Productos
        String nombre = JOptionPane.showInputDialog(constantes.TXT_NombreP);
        String caract = JOptionPane.showInputDialog(constantes.TXT_Caracter);
        String idprod = JOptionPane.showInputDialog(constantes.TXT_IdProduct);
        String condi = JOptionPane.showInputDialog(constantes.TXT_Condicion);

        // Ingresar informacion del producto
        Producto producto = new Producto(nombre,caract,idprod,condi);

        //Retornar almacenar producto en lista
        arrayproducto.add(producto);

        // Retonar arreglo producto
        return arrayproducto;

    }

    public void consultarClientes(ArrayList<Clientes> arrayCliente,String documento,String tipoDoc){

        Boolean indConsulta = false;
        // Consultar clientes con documento y tipo de documento
        for (int i = 0; i < arrayCliente.size(); i++){
            Clientes auxCliente = arrayCliente.get(i);

            // Validar con el documento y tipo si el cliente existe
            if (documento.equals(auxCliente.getCedula()) &&
                tipoDoc.equals(auxCliente.gettipoDocumento())){

                System.out.println("Nombre: "    + auxCliente.getNombre());
                System.out.println("Cedula: "    + auxCliente.getCedula());
                System.out.println("Documento: " + auxCliente.gettipoDocumento());
                System.out.println("Direccion: " + auxCliente.getDireccion());
                System.out.println("Telefono: "  + auxCliente.getTelefono());
                System.out.println("Celular: "   + auxCliente.getCelular() + "\n");
                System.out.println("Productos del cliente: " + "\n");

                //Consultar los productos del cliente
                try {
                    for(int j = 0; j < auxCliente.getProductos().size(); j++) {

                        Producto auxProductoCliente = auxCliente.getProductos().get(j);

                        System.out.println("Producto " + j + ":");
                        System.out.println("Id del producto: " + auxProductoCliente.getIdProducto());
                        System.out.println("Nombre del Producto: " + auxProductoCliente.getNombre());
                        System.out.println("Condiciones del producto: " + auxProductoCliente.getCondiciones());
                        System.out.println("Caracteristicas del producto: " + auxProductoCliente.getCarateristicas());
                    }
                }
                catch (NullPointerException e) {
                    System.out.println("Este cliente no tiene productos asociados");
                }
                indConsulta = true;
                break;
            }
        }

        if (!indConsulta) {
            System.out.println("Cliente no existe");
        }

        Scanner in = new Scanner(System.in);
        String seguir = "NO";
        while (seguir.equalsIgnoreCase("NO") ){
            // Solicitar al usuario si desea continuar
            System.out.println("Desea volver al Menu Principal: ");
            seguir = in.nextLine();
        }
    }

    private void ListarClientes(ArrayList<Clientes> arrayCliente) {

        for (int i = 0; i < arrayCliente.size(); i++) {

            System.out.println("Nombre: " + arrayCliente.get(i).getNombre());
            System.out.println("Cedula: " + arrayCliente.get(i).getCedula());
            System.out.println("Documento: " + arrayCliente.get(i).gettipoDocumento());
            System.out.println("Direccion: " + arrayCliente.get(i).getDireccion());
            System.out.println("Telefono: " + arrayCliente.get(i).getTelefono());
            System.out.println("Celular: " + arrayCliente.get(i).getCelular() + "\n");
        }

    }
}
