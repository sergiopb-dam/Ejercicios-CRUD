package crud2;

import java.util.ArrayList;

public class Gestor {
    
    ArrayList<Articulo> almacen = new ArrayList<>();

    public void listar() {
        if (almacen.isEmpty()) {
            System.out.println("El almacen esta vacio.");
            return;
        }
        for (Articulo a : almacen) {
            System.out.println("Nombre: " + a.getNombre() + " | Stock: " + a.getStock() + " | Precio: " + a.getPrecio() + " | IVA: " + a.getIva() + "%");
        }
    }

    public boolean alta(String nombre, int stock, double precio, int iva) {
        for (Articulo a : almacen) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                return false;
            }
        }
        almacen.add(new Articulo(nombre, stock, precio, iva));
        return true;
    }

    public boolean baja(String nombre) {
        for (int i = 0; i < almacen.size(); i++) {
            if (almacen.get(i).getNombre().equalsIgnoreCase(nombre)) {
                almacen.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean modificar(String nombre, String nuevoNombre, double nuevoPrecio, int nuevoIva) {
        for (Articulo a : almacen) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                a.setNombre(nuevoNombre);
                a.setPrecio(nuevoPrecio);
                a.setIva(nuevoIva);
                return true;
            }
        }
        return false;
    }

    public boolean entrada(String nombre, int cantidad) {
        if (cantidad <= 0) return false;
        for (Articulo a : almacen) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                a.setStock(a.getStock() + cantidad);
                return true;
            }
        }
        return false;
    }

    public boolean salida(String nombre, int cantidad) {
        if (cantidad <= 0) return false;
        for (Articulo a : almacen) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                if (a.getStock() >= cantidad) {
                    a.setStock(a.getStock() - cantidad);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}