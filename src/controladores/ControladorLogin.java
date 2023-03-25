
package controladores;

import vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import datos.BaseDatos;
import javax.swing.JOptionPane;

public class ControladorLogin {
    // atributos
    private final login_admin vista;
    
    public ControladorLogin(login_admin vista){
        this.vista = vista;
        eventos();
    }
    
    private void eventos(){
        // botón ingresar
        this.vista.btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(BaseDatos.perteneceAdmin(vista.userInput.getText(), vista.passwordInput.getText())){
                    ControladorAdmin administrador = new ControladorAdmin(new perfil_admin());
                    administrador.init();
                    vista.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(vista, "Credenciales incorrectas");
                }
            }
        });
        
        // botón salir
        this.vista.salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // botón retroceder
        this.vista.regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorInicio in = new ControladorInicio(new inicio());
                in.iniciar();
                vista.dispose();
            }
        });
    }
    
    public void init(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
