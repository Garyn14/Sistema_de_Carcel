
package controladores;

import datos.BaseDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.*;
import vistas.*;

public class ControladorVer {
    // atributos
    private final ver_reclusos vista;
    private DefaultTableModel model;
    private int numFilas;

    public ControladorVer(ver_reclusos vista) {
        this.vista = vista;
        numFilas = 0;
        modeloTabla();
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
        
        // botón aplicar
        this.vista.btnAplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(vista.input.getSelectedIndex()){
                    case -1:{
                        JOptionPane.showMessageDialog(vista, "Ingrese una opción");
                        break;
                    }
                    case 0:{
                        Tabla.borrarTabla(numFilas, model);
                        Tabla.mostrarTabla(BaseDatos.zonaPrevia, model);
                        numFilas = BaseDatos.zonaPrevia.size();
                        break;
                    }
                    case 1:{
                        Tabla.borrarTabla(numFilas, model);
                        Tabla.mostrarTabla(BaseDatos.pabellonA, model);
                        numFilas = BaseDatos.pabellonA.size();                        
                        break;
                    }
                    case 2:{
                        Tabla.borrarTabla(numFilas, model);
                        Tabla.mostrarTabla(BaseDatos.pabellonB, model);
                        numFilas = BaseDatos.pabellonB.size();                            
                        break;
                    }
                    case 3:{
                        Tabla.borrarTabla(numFilas, model);
                        Tabla.mostrarTabla(BaseDatos.pabellonC, model);
                        numFilas = BaseDatos.pabellonC.size();                          
                        break;
                    }
                    case 4:{
                        Tabla.borrarTabla(numFilas, model);
                        Tabla.mostrarTabla(BaseDatos.pabellonD, model);
                        numFilas = BaseDatos.pabellonD.size();    
                        break;
                    }
                    case 5:{
                        Tabla.borrarTabla(numFilas, model);
                        Tabla.mostrarTabla(BaseDatos.pabellonA, model);
                        Tabla.mostrarTabla(BaseDatos.pabellonB, model);
                        Tabla.mostrarTabla(BaseDatos.pabellonC, model);
                        Tabla.mostrarTabla(BaseDatos.pabellonD, model);
                        numFilas = BaseDatos.pabellonA.size() + BaseDatos.pabellonB.size() + 
                                BaseDatos.pabellonC.size() + BaseDatos.pabellonD.size();
                        break;
                    }
                }
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
