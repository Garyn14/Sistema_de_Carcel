
package controladores;

import vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAdmin {
    // atributos
    private final perfil_admin vista;
    
    public ControladorAdmin(perfil_admin vista){
        this.vista = vista;
        eventos();
    }
    
    private void eventos(){
        // botón registrar recluso
        this.vista.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorRegistrar re = new ControladorRegistrar(new registrar_recluso());
                re.init();
                vista.dispose();
            }
        });
        
        // botón asignar pabellón
        this.vista.btnAsignar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorAsignar asig = new ControladorAsignar(new asignar_pabellon());
                asig.init();
                vista.dispose();
            }
        });
        
        // botón buscar recluso
        this.vista.btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorBuscar bus = new ControladorBuscar(new buscar_recluso());
                bus.init();
                vista.dispose();
            }
        });
        
        // botón cambiar pabellón
        this.vista.btnCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorCambiar cam = new ControladorCambiar(new cambiar_pabellon());
                cam.init();
                vista.dispose();
            }
        });
        
        // botón ver reclusos
        this.vista.btnVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorVer ver = new ControladorVer(new ver_reclusos());
                ver.init();
                vista.dispose();
            }
        });
        
        // botón estado de la cárcel
        this.vista.btnEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorEstado est = new ControladorEstado(new estado_carcel());
                est.init();
                vista.dispose();
            }
        });
        
        // botón eliminar recluso
        this.vista.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorEliminar eli = new ControladorEliminar(new eliminar_recluso());
                eli.init();
                vista.dispose();
            }
        });
        
        // botón regresar
        this.vista.btnRegresar.addActionListener(new ActionListener() {
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
    
    public void init(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
