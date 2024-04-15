/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.List;
import modelo.Inventario;
/**
 *
 * @author Emmanuel
 */
public class Compra extends Inventario {

    public Compra(List<Producto> inventario) {
        super(inventario);
    }
    
    public void generarCompra(int id, int cantidad){
         for (Producto producto : inventario){
            if (producto.getId() == id) {
                producto.setCantidad(producto.getCantidad()+cantidad);
                guardarJSON();
                return;
            }
        }
    }

   
}
