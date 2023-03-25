
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import vistas.*;
import modelos.Tabla;
import datos.BaseDatos;

public class ControladorVerZonaPrevia {
    // atributos
    private final zona_previa vista;
    private DefaultTableModel model;

    public ControladorVerZonaPrevia(zona_previa vista) {
        this.vista = vista;
        modeloTabla();
        Tabla.mostrarTabla(BaseDatos.zonaPrevia, model);
        eventos();
    }
    
    private void eventos(){
        // botón regresar
        this.vista.regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorAsignar asig = new ControladorAsignar(new asignar_pabellon());
                asig.init();
                vista.dispose();
            }
        });
        
        // botón salir
        this.vista.salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
    private void modeloTabla(){
        this.model = new DefaultTableModel();
        
        model.addColumn("APELLIDO");
        model.addColumn("DNI");
        model.addColumn("CÓDIGO");
        model.addColumn("EDAD");
        model.addColumn("CONDENA");
        model.addColumn("PABELLON");
        
        this.vista.tablaReclusos.setModel(model);
    }
    
    public void init(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
