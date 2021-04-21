package ejercicio1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class OperacionesProveedorProducto {
    
    Scanner leer=new Scanner(System.in);
        
    Proveedor proveedor=new Proveedor();
    private Producto producto;
    
    private List<Proveedor> ListaProveedor=new ArrayList<>();
    
    
    public void crearProveedor(){
        proveedor=new Proveedor();
        System.out.println("Digite la razon social: ");
        proveedor.setRazonSocial(leer.nextLine());
        System.out.println("Digite la direccion: ");
        proveedor.setDireccion(leer.nextLine());
        System.out.println("Digite el numero de telefono: ");
        proveedor.setNroTelefono(leer.nextInt());
        System.out.println("Proveedor registrado!....");
        // Agregamos al proveedor a la lista de proveedores
        ListaProveedor.add(proveedor);
        leer.nextLine();
        guardarObjetos();
    }
    
    
    public void mostrarProveedor(){
        if(ListaProveedor.size()>0){
            System.out.println("------------- Lista de proveedores -------------");
            int con=1;
            for(Proveedor prove:ListaProveedor){
                System.out.println("****EMPRESA "+con+" ****");
                prove.mostrar();
                con++;
                System.out.println("--------------------------------------------");
            }
        }else{
            System.out.println("Lista de proveedores vacia");
        }
    }
    
    //Mostramos los productos de un determinado proveedor
    public void mostrarProductosProveedor(){
        if(ListaProveedor.size()>0){
            System.out.println("Digite razon social del proveedor: ");
            String nom=leer.nextLine();
            boolean sw=false;
            for(Proveedor prove:ListaProveedor){
                if(prove.getRazonSocial().equalsIgnoreCase(nom)){
                    sw=true;
                    prove.mostrar();
                }
            }
            if (!sw) {
                System.out.println("Proveedor no encontrado o no registrado!...");
            }
        }else{
            System.out.println("Lista de proveedores vacia o producto no registrado");
        }
    }
    /* *** realizamos la compra de un determinado producto ***
    *  dado que leche natural puede tener 2 o mas proveedos diferentes como 
    *       Pil=>leche natural
    *       delicia=>leche natural
    *  entonces pregunramos el nombre o razon social del proveedor y despues el nombre del prudocto
    */
    public void compraProducto(){
        if(ListaProveedor.size()>0){
            System.out.println("Digite nombre del proveedor: ");
            String nom=leer.nextLine();
            boolean sw=false,sw2=false;
            for(Proveedor prove:ListaProveedor){
                if(prove.getRazonSocial().equalsIgnoreCase(nom)){
                    sw=true;
                    System.out.println("Proveedor encontrado");
                    System.out.println("Digite el nombre del producto: ");
                    String nomProd=leer.nextLine();
                    for(Producto prod:prove.getListaProductos()){
                        if(prod.getNombreProducto().equalsIgnoreCase(nomProd)){
                            sw2=true;
                            System.out.println("Producto encontrado");
                            System.out.println("Digite la cantidad a comprar: ");
                            int cant=leer.nextInt();
                            if(cant>0){
                                prod.setStock(prod.getStock()+cant);
                                System.out.println("Operacion realizada con exito!...");
                                guardarObjetos();
                            }else{
                                System.out.println("Dato ingresado no valido");
                                System.out.println("Operacion no realizada!...");
                            }
                        }
                    }
                }   
            }
            if (!sw) {
                System.out.println("no se encontro al proveedor");
            }else if(!sw2){
                System.out.println("producto no encontrado!..");
            }
        }else{
            System.out.println("Lista de proveedores vacia o producto no registrado");
        }
    }
    
    /*  *** Realizacon de la simulacion de la salida de productos ***
    *
    * dado que leche natural puede tener 2 o mas proveedos diferentes como 
    *       Pil=>leche natural
    *       delicia=>leche natural
    * entonces pregunramos el nombre o razon social del proveedor y despues el nombre del prudocto
    */
    public void salidaProducto(){
        if(ListaProveedor.size()>0){
            System.out.println("Digite nombre del proveedor: ");
            String nom=leer.nextLine();
            boolean sw=false,sw2=false;
            for(Proveedor prove:ListaProveedor){
                if(prove.getRazonSocial().equalsIgnoreCase(nom)){
                    sw=true;
                    System.out.println("Proveedor encontrado");
                    System.out.println("Digite el nombre del producto: ");
                    String nomProd=leer.nextLine();
                    for(Producto prod:prove.getListaProductos()){
                        if(prod.getNombreProducto().equalsIgnoreCase(nomProd)){
                            sw2=true;
                            System.out.println("Producto encontrado");
                            System.out.println("Digite la cantodad de salida de producto: ");
                            int cant=leer.nextInt();
                            if(cant<=prod.getStock()){
                                prod.setStock(prod.getStock()-cant);
                                System.out.println("Operacion realizada con exito!...");
                                guardarObjetos();
                            }else{
                                System.out.println("La cantidad requerida es mayor a la cantidad en el stock");
                                System.out.println("Operacion no realizada!...");
                            }
                        }
                    }
                }   
            }
            if (!sw) {
                System.out.println("no se encontro al proveedor");
            }else if(!sw2){
                System.out.println("producto no encontrado!..");
            }
        }else{
            System.out.println("Lista de proveedores vacia o producto no registrado");
        }
    }
    
    public void crearProducto(){
        producto=new Producto();
        System.out.println("Digite el nombre del producto: ");
        producto.setNombreProducto(leer.nextLine());
        System.out.println("Digite el costo unitario: ");
        producto.setCostoUnitario(leer.nextFloat());
        System.out.println("Digite el stock: ");
        producto.setStock(leer.nextInt());
        System.out.println("Producto registrada!...");
        leer.nextLine();
    }
    
    public void mostrarProducto(){
        if (producto!=null) {
            producto.mostrar();
        }else{
            System.out.println("Aun no se tiene registrado a un producto!...");
        }
    }
    
    public void asignarProductoProveedor(){
        if(ListaProveedor.size()>0 && producto!=null && producto.getStock()>0){
            System.out.println("Digite razon social del proveedor: ");
            String nom=leer.nextLine();
            boolean sw=false;
            for(Proveedor prove:ListaProveedor){
                if(prove.getRazonSocial().equalsIgnoreCase(nom)){
                    sw=true;
                    prove.setListaProductos(producto);
                    System.out.println("Asignacion realizada!...");
                    prove.mostrar();
                    guardarObjetos();
                }
            }
            if (!sw) {
                System.out.println("no se encontro al proveedor");
            }
        }else{
            System.out.println("Hubo un error, por favor revise los datos!...");
            System.out.println("Lista de proveedores vacia o producto no registrado");
        }
        
    }
    
    
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        Path path=Paths.get("D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\ExamenFinal1B-2021\\archivoProveedor.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente");
            }else{
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
        }
    }
    //guardando la listacliente dentro del archivo creado con anterioridad
    public void guardarObjetos(){
        String ruta="D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\ExamenFinal1B-2021\\archivoProveedor.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(ListaProveedor);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesProveedorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionesProveedorProducto.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerClientes(){
        String ruta="D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\ExamenFinal1B-2021\\archivoProveedor.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                ListaProveedor=(List<Proveedor>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesProveedorProducto.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionesProveedorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionesProveedorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

