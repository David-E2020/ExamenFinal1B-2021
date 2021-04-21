package ejercicio1;

import java.io.Serializable;

/**
 *
 * @author david
 */
public class Producto implements Serializable{
    static final long serialVersionUID=42L;
    private String nombreProducto;
    private float costoUnitario;
    private int stock;

    public void mostrar() {
        System.out.println("Nombre producto: " + this.nombreProducto);
        System.out.println("Costo unitario: " + this.costoUnitario);
        System.out.println("Stock: " + this.stock);
    }

    //geter and seter

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(float costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}