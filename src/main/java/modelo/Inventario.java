/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Emmanuel
 */
public class Inventario {
    public List<Producto> inventario;
    private final String archivoJSON = "inventario.json";

    public Inventario(List<Producto> inventario) {
        this.inventario = cargarInventario();
    }
    
    
    
    private List<Producto> cargarInventario() {
        List<Producto> inventario = new ArrayList<>();
        try (Reader reader = new FileReader(archivoJSON)) {
            Gson gson = new Gson();
            inventario = gson.fromJson(reader, new TypeToken<List<Producto>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventario;
    }
    
      public void agregarProducto(Producto producto) {
        inventario.add(producto);
        guardarJSON();
    }

    // Método para guardar en un archivo JSON
        public void guardarJSON() {
        try (Writer writer = new FileWriter(archivoJSON)) {
            Gson gson = new Gson();
            gson.toJson(inventario, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     // Método para consultar una persona por su ID
    public Producto consultarPersona(int id) {
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null; // Si no se encuentra la persona
    }

    // Método para actualizar una persona
    public void actualizarInventario(int id, String nombre_producto, String descripcion, int cantidad) {
        for (Producto producto : inventario){
            if (producto.getId() == id) {
                producto.setProducto(nombre_producto);
                producto.setDescripcion(descripcion);
                producto.setCantidad(cantidad);
                guardarJSON();
                return;
            }
        }
   
    }
    
    // Método para eliminar una persona
    public void eliminarPersona(int id) {
        inventario.removeIf(producto -> producto.getId() == id);
        guardarJSON();
    }
    
    
    
}
