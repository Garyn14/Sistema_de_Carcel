
package datos;

import java.util.ArrayList;
import modelos.*;

public class BaseDatos {
    // pabellones y zona previa
    public static ArrayList<Prisionero> zonaPrevia = new ArrayList<>();
    public static ArrayList<Prisionero> pabellonA = new ArrayList<>();
    public static ArrayList<Prisionero> pabellonB = new ArrayList<>();
    public static ArrayList<Prisionero> pabellonC = new ArrayList<>();
    public static ArrayList<Prisionero> pabellonD = new ArrayList<>();
    
    // administradores
    public static ArrayList<Admin> administradores = new ArrayList<>();
    
    // presos liberados
    private static int liberados = 0;
    
    public static boolean perteneceAdmin(String user, String password){
        boolean condition = false;
        for(Admin a : administradores){
            if(a.getUser().compareTo(user) == 0 && a.getPassword().compareTo(password) == 0){
                condition = true;
                break;
            }
        }
        return condition;
    }
    
    public static void moverZonaPreviaToPabellon(){
        for(Prisionero pri : zonaPrevia){
            switch(pri.getPabellon()){
                case "A":{
                    pabellonA.add(pri);
                    break;
                }
                case "B":{
                    pabellonB.add(pri);
                    break;
                }
                case "C":{
                    pabellonC.add(pri);
                    break;
                }
                case "D":{
                    pabellonD.add(pri);
                    break;
                }
            }
        }
    }
    
    public static Prisionero buscarDni(int dni){
        boolean encontrado = false;
        Prisionero pri = null;
        Prisionero buscado = null;
        
        // Pabellón A
        for(int i = 0; i < pabellonA.size() && encontrado == false; i++){
            pri = pabellonA.get(i);
            if(pri.getDni() == dni){
                encontrado = true;
                buscado = pri;
            }
        }
        
        // Pabellón B
        for(int i = 0; i < pabellonB.size() && encontrado == false; i++){
            pri = pabellonB.get(i);
            if(pri.getDni() == dni){
                encontrado = true;
                buscado = pri;
            }
        }
        
        // Pabellón C
        for(int i = 0; i < pabellonC.size() && encontrado == false; i++){
            pri = pabellonC.get(i);
            if(pri.getDni() == dni){
                encontrado = true;
                buscado = pri;
            }
        }
        
        // Pabellón D
        for(int i = 0; i < pabellonD.size() && encontrado == false; i++){
            pri = pabellonD.get(i);
            if(pri.getDni() == dni){
                encontrado = true;
                buscado = pri;
            }
        }

        return buscado;
    }
    
    public static Prisionero buscarCodigo(int codigo){
        boolean encontrado = false;
        Prisionero pri = null;
        Prisionero buscado = null;
        
        // Pabellón A
        for(int i = 0; i < pabellonA.size() && encontrado == false; i++){
            pri = pabellonA.get(i);
            if(pri.getCodigo() == codigo){
                encontrado = true;
                buscado = pri;
            }
        }
        
        // Pabellón B
        for(int i = 0; i < pabellonB.size() && encontrado == false; i++){
            pri = pabellonB.get(i);
            if(pri.getCodigo() == codigo){
                encontrado = true;
                buscado = pri;
            }
        }
        
        // Pabellón C
        for(int i = 0; i < pabellonC.size() && encontrado == false; i++){
            pri = pabellonC.get(i);
            if(pri.getCodigo() == codigo){
                encontrado = true;
                buscado = pri;
            }
        }
        
        // Pabellón D
        for(int i = 0; i < pabellonD.size() && encontrado == false; i++){
            pri = pabellonD.get(i);
            if(pri.getCodigo() == codigo){
                encontrado = true;
                buscado = pri;
            }
        }

        return buscado;
    }  
    
    public static void cambiarPabellon(Prisionero pri, String nuevoPabellon){
        String pabellonActual = pri.getPabellon();
        
        // cambiar de pabellon
        pri.setPabellon(nuevoPabellon);
        
        // agregar recluso a su nuevo pabellón
        switch(nuevoPabellon){
            case "A":{
                pabellonA.add(pri);
                break;
            }
            case "B":{
                pabellonB.add(pri);
                break;
            }
            case "C":{
                pabellonC.add(pri);
                break;
            }
            case "D":{
                pabellonD.add(pri);
                break;
            }
        }
        
        // eliminar recluso de su pabellón actual
        switch(pabellonActual){
            case "A":{
                pabellonA.remove(pri);
                break;
            }
            case "B":{
                pabellonB.remove(pri);
                break;
            }
            case "C":{
                pabellonC.remove(pri);
                break;
            }
            case "D":{
                pabellonD.remove(pri);
                break;
            }
        }
    }
    
    public static int getLiberados(){
        return liberados;
    }
    
    public static void aumentarLiberados(){
        liberados++;
    }

}
