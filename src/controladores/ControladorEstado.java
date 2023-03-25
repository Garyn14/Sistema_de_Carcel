
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelos.Tabla;
import vistas.*;

public class ControladorEstado {
    // atributos
    private final estado_carcel vista;
    private DefaultTableModel model;

    public ControladorEstado(estado_carcel vista) {
        this.vista = vista;
        modeloTabla();
        Tabla.mostrarEstado(model);
        eventos();
    }
    
    private void eventos(){
        // botón regresar
        this.vista.regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorAdmin adm = new ControladorAdmin(new perfil_admin());
                adm.init();
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
        
        model.addColumn("ZONA PREVIA");
        model.addColumn("PABELLÓN A");
        model.addColumn("PABELLÓN B");
        model.addColumn("PABELLÓN C");
        model.addColumn("PABELLÓN D");
        model.addColumn("LIBERADOS");
        
        this.vista.estadoCarcel.setModel(model);
    }
    
    public void init(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
