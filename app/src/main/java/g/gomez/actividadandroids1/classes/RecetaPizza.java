package g.gomez.actividadandroids1.classes;

import java.util.ArrayList;

public class RecetaPizza {
    private String nombre;
    private String principal;
    private String base;
    private ArrayList<String> ingredientes = new ArrayList<String>();
    private ArrayList<String> alinios = new ArrayList<String>();
    private float precio;

    public RecetaPizza() { }

    public RecetaPizza(String nombre, String principal, String base, ArrayList<String> ingredientes, ArrayList<String> alinios, float precio) {
        this.nombre = nombre;
        this.principal = principal;
        this.base = base;
        this.ingredientes = ingredientes;
        this.alinios = alinios;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public ArrayList<String> getAlinios() {
        return alinios;
    }

    public void setAlinios(ArrayList<String> alinios) {
        this.alinios = alinios;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
