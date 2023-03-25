
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.*;
import controladores.*;

public class ControladorInicio {
    // atributos
    private final inicio vista;
    
    public ControladorInicio(inicio vista){
        this.vista = vista;
        eventos();
    }
    
    private void eventos(){
        // botón de menu administrador
        this.vista.btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorLogin login = new ControladorLogin(new login_admin());
                login.init();
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
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
