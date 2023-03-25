
package controladores;

import datos.BaseDatos;
import exceptions.DniInvalidoException;
import exceptions.codigoInvalidoException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Prisionero;
import modelos.Tabla;
import vistas.*;

public class ControladorBuscar {
    // atributos
    private final buscar_recluso vista;
    private DefaultTableModel model;
    private int numFilas;

    public ControladorBuscar(buscar_recluso vista) {
        this.vista = vista;
        modeloTabla();
        eventos();
        numFilas = 0;
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
                switch(vista.buscarPor.getSelectedIndex()){
                    case -1:{
                        JOptionPane.showMessageDialog(vista, "Ingrese una opción");
                        break;
                    }
                    case 0:{
                        
                        try {
                            int cod = Integer.parseInt(vista.input.getText());
                            ControladorRegistrar.codigoValido(cod);
                            
                            Prisionero pri = BaseDatos.buscarCodigo(cod);
                            if(pri == null){
                                Tabla.borrarTabla(numFilas, model);
                                numFilas = model.getRowCount();                                
                                JOptionPane.showMessageDialog(vista, "Recluso no encontrado");

                            } else{
                                Tabla.borrarTabla(numFilas, model);
                                Tabla.mostrarUno(pri, model);
                                numFilas = model.getRowCount();
                            }
                            
                        } catch (NumberFormatException ex1) {
                            Tabla.borrarTabla(numFilas, model);
                            numFilas = model.getRowCount();
                            JOptionPane.showMessageDialog(vista, "Ingrese un valor numérico");
                        } catch (codigoInvalidoException ex2){
                            Tabla.borrarTabla(numFilas, model);
                            numFilas = model.getRowCount();
                            JOptionPane.showMessageDialog(vista, "El Código debe contar con 5 dígitos");
                        }
                        
                        break;
                    }
                    case 1:{
                        
                        try {
                            int dni = Integer.parseInt(vista.input.getText());
                            ControladorRegistrar.dniValido(dni);
                            
                            Prisionero pri = BaseDatos.buscarDni(dni);
                            if(pri == null){
                                Tabla.borrarTabla(numFilas, model);
                                numFilas = model.getRowCount();                                
                                JOptionPane.showMessageDialog(vista, "Recluso no encontrado");

                            } else{
                                Tabla.borrarTabla(numFilas, model);
                                Tabla.mostrarUno(pri, model);
                                numFilas = model.getRowCount();
                            }
                            
                        } catch (NumberFormatException ex1) {
                            Tabla.borrarTabla(numFilas, model);
                            numFilas = model.getRowCount();
                            JOptionPane.showMessageDialog(vista, "Ingrese un valor numérico");
                        } catch (DniInvalidoException ex2){
                            Tabla.borrarTabla(numFilas, model);
                            numFilas = model.getRowCount();
                            JOptionPane.showMessageDialog(vista, "El DNI debe contar con 8 dígitos");
                        }
                        
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
        
        this.vista.tablaRecluso.setModel(model);
    }
    
    public void init(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
