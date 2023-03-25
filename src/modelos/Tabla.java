package modelos;

import datos.BaseDatos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Tabla {

    public Tabla() {

    }

    public static void mostrarTabla(ArrayList<Prisionero> lista, DefaultTableModel model) {
        String informacion[] = new String[6];
        for (Prisionero pri : lista) {
            informacion[0] = pri.getApellido();
            informacion[1] = Integer.toString(pri.getDni());
            informacion[2] = Integer.toString(pri.getCodigo());
            informacion[3] = Integer.toString(pri.getEdad());
            informacion[4] = Integer.toString(pri.getCondena());
            informacion[5] = pri.getPabellon();

            model.addRow(informacion);
        }
    }

    public static void mostrarUno(Prisionero pri, DefaultTableModel model) {
        String informacion[] = new String[6];
        
        informacion[0] = pri.getApellido();
        informacion[1] = Integer.toString(pri.getDni());
        informacion[2] = Integer.toString(pri.getCodigo());
        informacion[3] = Integer.toString(pri.getEdad());
        informacion[4] = Integer.toString(pri.getCondena());
        informacion[5] = pri.getPabellon();
        
        model.addRow(informacion);
    }

    public static void borrarTabla(int filas, DefaultTableModel model) {
        for (int i = 0; i < filas; i++) {
            model.removeRow(0);
        }
    }
    
    public static void mostrarEstado(DefaultTableModel model){
        String informacion[] = new String[6];
        
        informacion[0] = Integer.toString(BaseDatos.zonaPrevia.size());
        informacion[1] = Integer.toString(BaseDatos.pabellonA.size());
        informacion[2] = Integer.toString(BaseDatos.pabellonB.size());
        informacion[3] = Integer.toString(BaseDatos.pabellonC.size());
        informacion[4] = Integer.toString(BaseDatos.pabellonD.size());
        informacion[5] = Integer.toString(BaseDatos.getLiberados());
        
        model.addRow(informacion);
    }
    
}
