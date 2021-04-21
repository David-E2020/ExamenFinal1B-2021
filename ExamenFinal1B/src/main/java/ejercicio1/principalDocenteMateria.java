package ejercicio1;

import java.util.Scanner;
/**
 *
 * @author david
 */
public class principalDocenteMateria {
    public static void main(String[] args) {
        int opc = 0;
        boolean continuar = true;
        OperacionesProveedorProducto obj = new OperacionesProveedorProducto();
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Crear archivo");
            System.out.println("2. Registrar proveedor");
            System.out.println("3. Registrar producto");
            System.out.println("4. Mostrar producto");
            System.out.println("5. Asignar producto a proveedor");
            System.out.println("6. Mostrar productos de un proveedor");
            System.out.println("7. Realizar la compra de un producto");
            System.out.println("8. Salida de producto");
            System.out.println("9. Mostrar Datos"); 
            System.out.println("10. salir");
            System.out.println("Digite una opcion");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.crearProveedor();
                    obj.mostrarProveedor();
                    break;
                case 3:
                    obj.crearProducto();
                    obj.mostrarProducto();
                    break;
                case 4:
                    obj.mostrarProducto();
                    break;
                case 5:
                    obj.asignarProductoProveedor();
                    break;
                case 6:
                    obj.mostrarProductosProveedor();
                    break;
                case 7:
                    obj.compraProducto();
                    break;
                case 8:
                    obj.salidaProducto();
                    break;
                case 9:
                    obj.leerClientes();
                    obj.mostrarProveedor();
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }
}
