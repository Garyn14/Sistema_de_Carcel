
package main;

import controladores.ControladorInicio;
import vistas.inicio;
import datos.BaseDatos;
import modelos.*;

public class main {
    public static void main(String[] args) {
        
        // agregar administradores
        BaseDatos.administradores.add(new Admin("user", "123"));
        BaseDatos.administradores.add(new Admin("admin", "12345"));
        
        // pabellón A
        BaseDatos.pabellonA.add(new Prisionero("persona1", 11111111, 18, 1, "A"));
        BaseDatos.pabellonA.add(new Prisionero("persona2", 11111112, 18, 2, "A"));
        BaseDatos.pabellonA.add(new Prisionero("persona3", 11111113, 18, 3, "A"));
        BaseDatos.pabellonA.add(new Prisionero("persona4", 11111114, 18, 4, "A"));
        BaseDatos.pabellonA.add(new Prisionero("persona5", 11111115, 18, 5, "A"));
        BaseDatos.pabellonA.add(new Prisionero("persona6", 11111116, 18, 6, "A"));
        BaseDatos.pabellonA.add(new Prisionero("persona7", 11111117, 18, 7, "A"));
        BaseDatos.pabellonA.add(new Prisionero("persona8", 11111118, 18, 8, "A"));
        BaseDatos.pabellonA.add(new Prisionero("persona9", 11111119, 18, 9, "A"));
        BaseDatos.pabellonA.add(new Prisionero("persona10", 11111120, 18, 10, "A"));
        
        
        // pabellón B
        BaseDatos.pabellonB.add(new Prisionero("persona11", 22222220, 18, 11, "B"));
        BaseDatos.pabellonB.add(new Prisionero("persona12", 22222221, 18, 12, "B"));
        BaseDatos.pabellonB.add(new Prisionero("persona13", 22222222, 18, 13, "B"));
        BaseDatos.pabellonB.add(new Prisionero("persona14", 22222223, 18, 14, "B"));
        BaseDatos.pabellonB.add(new Prisionero("persona15", 22222224, 18, 15, "B"));
        BaseDatos.pabellonB.add(new Prisionero("persona16", 22222225, 18, 16, "B"));
        BaseDatos.pabellonB.add(new Prisionero("persona17", 22222226, 18, 17, "B"));
        BaseDatos.pabellonB.add(new Prisionero("persona18", 22222227, 18, 18, "B"));
        BaseDatos.pabellonB.add(new Prisionero("persona19", 22222228, 18, 19, "B"));
        BaseDatos.pabellonB.add(new Prisionero("persona20", 22222229, 18, 20, "B"));
        
        
        // pabellón C
        BaseDatos.pabellonC.add(new Prisionero("persona21", 33333330, 18, 21, "C"));
        BaseDatos.pabellonC.add(new Prisionero("persona22", 33333331, 18, 22, "C"));
        BaseDatos.pabellonC.add(new Prisionero("persona23", 33333332, 18, 23, "C"));
        BaseDatos.pabellonC.add(new Prisionero("persona24", 33333333, 18, 24, "C"));
        BaseDatos.pabellonC.add(new Prisionero("persona25", 33333334, 18, 25, "C"));
        BaseDatos.pabellonC.add(new Prisionero("persona26", 33333335, 18, 26, "C"));
        BaseDatos.pabellonC.add(new Prisionero("persona27", 33333336, 18, 27, "C"));
        BaseDatos.pabellonC.add(new Prisionero("persona28", 33333337, 18, 28, "C"));
        BaseDatos.pabellonC.add(new Prisionero("persona29", 33333338, 18, 29, "C"));
        BaseDatos.pabellonC.add(new Prisionero("persona30", 33333339, 18, 30, "C"));
        
        
        // pabellón D
        BaseDatos.pabellonD.add(new Prisionero("persona31", 44444440, 18, 31, "D"));
        BaseDatos.pabellonD.add(new Prisionero("persona32", 44444441, 18, 32, "D"));
        BaseDatos.pabellonD.add(new Prisionero("persona33", 44444442, 18, 33, "D"));
        BaseDatos.pabellonD.add(new Prisionero("persona34", 44444443, 18, 34, "D"));
        BaseDatos.pabellonD.add(new Prisionero("persona35", 44444444, 18, 35, "D"));
        BaseDatos.pabellonD.add(new Prisionero("persona36", 44444445, 18, 36, "D"));
        BaseDatos.pabellonD.add(new Prisionero("persona37", 44444446, 18, 37, "D"));
        BaseDatos.pabellonD.add(new Prisionero("persona38", 44444447, 18, 38, "D"));
        BaseDatos.pabellonD.add(new Prisionero("persona39", 44444448, 18, 39, "D"));
        BaseDatos.pabellonD.add(new Prisionero("persona40", 44444449, 18, 40, "D"));
        
        ControladorInicio init = new ControladorInicio(new inicio());
        init.iniciar();
    }
}
