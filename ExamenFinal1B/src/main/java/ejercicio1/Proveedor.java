package ejercicio1;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 es una relacion de tipo asociacion
 el Proveedor tiene un Producto
 no hay un contenedor 
 estan relacionados por una pertenencia
 */
public class Proveedor implements Serializable{
    static final long serialVersionUID=43L;
    private String razonSocial;
    private String direccion;
    private int nroTelefono;
    //asignacion de las materias a docentes
    //relacionamos las 2 clases el Proveedor tiene productos
    private List<Producto> ListaProductos;
    
    public Proveedor() {
        ListaProductos=new ArrayList<>();
    }
    //Scanner leer=new Scanner(System.in);
    
    public void mostrar(){
        System.out.println("Razon social: "+this.razonSocial);
        System.out.println("Direccion: "+this.direccion);
        System.out.println("Numero de telefono: "+this.nroTelefono);
        if (ListaProductos.size()>0) {
            System.out.println("\n*** Lista de productos ***\n");
            for(Producto prod:ListaProductos){
                prod.mostrar();
                System.out.println("------------------------------");
            }
        }else{
            System.out.println("*** Lista de productos vacia ***");
        }
    }
    
    
    
    //geter and seter

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(int nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public List<Producto> getListaProductos() {
        return ListaProductos;
    }

    public void setListaProductos(Producto producto) {
        this.ListaProductos.add(producto);
    }
        
}