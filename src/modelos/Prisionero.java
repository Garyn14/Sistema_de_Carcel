
package modelos;

public class Prisionero {
    // atributos
    private final String apellido;
    private final int dni;
    private final int codigo;
    private final int edad;
    private final int condena;
    private String pabellon;
    public static int id = 10_000;
    
    // constructor
    public Prisionero(String apellido, int dni, int edad, int condena, String pabellon) {
        this.apellido = apellido;
        this.dni = dni;
        this.codigo = id;
        this.edad = edad;
        this.condena = condena;
        this.pabellon = pabellon;
        id++;
    }

    // getters
    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getEdad() {
        return edad;
    }

    public int getCondena() {
        return condena;
    }

    public String getPabellon() {
        return pabellon;
    }
    
    
    // setters
    public void setPabellon(String pabellon) {
        this.pabellon = pabellon;
    }
    
}
