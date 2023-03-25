
package controladores;

import datos.BaseDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vistas.*;

public class ControladorAsignar {
    // atributos
    private final asignar_pabellon vista;

    public ControladorAsignar(asignar_pabellon vista) {
        this.vista = vista;
        eventos();
    }
    
    private void eventos(){
        // botón salir
        this.vista.salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // botón ver
        this.vista.btnVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorVerZonaPrevia zop = new ControladorVerZonaPrevia(new zona_previa());
                zop.init();
                vista.dispose();
            }
        });
        
        // botón mover
        this.vista.btnMover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(BaseDatos.zonaPrevia.isEmpty()){
                    JOptionPane.showMessageDialog(vista, "Zona Previa sin prisioneros");
                } else{
                    BaseDatos.moverZonaPreviaToPabellon();
                    BaseDatos.zonaPrevia.clear();
                    JOptionPane.showMessageDialog(vista, "Reclusos movidos de la zona previa exitosamente");
                }
            }
        });
        
        // botón regresar
        this.vista.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorAdmin adm = new ControladorAdmin(new perfil_admin());
                adm.init();
                vista.dispose();
            }
        });
    }
    
    public void init(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
