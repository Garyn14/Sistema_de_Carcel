
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

public class ControladorEliminar {
    // atributos
    private final eliminar_recluso vista;
    private DefaultTableModel model;
    private Prisionero pri;
    private int numFilas;

    public ControladorEliminar(eliminar_recluso vista) {
        this.vista = vista;
        modeloTabla();
        eventos();
        numFilas = 0;
        this.pri = null;
        this.vista.btnEliminar.setEnabled(false);
    }
    
    private void eventos(){
        // botón retroceder
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

                switch (vista.buscarPor.getSelectedIndex()) {
                    case -1: {
                        JOptionPane.showMessageDialog(vista, "Ingrese una opción");
                        break;
                    }
                    case 0: {

                        try {
                            int cod = Integer.parseInt(vista.input.getText());
                            ControladorRegistrar.codigoValido(cod);

                            pri = BaseDatos.buscarCodigo(cod);
                            if (pri == null) {
                                Tabla.borrarTabla(numFilas, model);
                                numFilas = model.getRowCount();
                                JOptionPane.showMessageDialog(vista, "Recluso no encontrado");
                            } else {
                                Tabla.borrarTabla(numFilas, model);
                                Tabla.mostrarUno(pri, model);
                                numFilas = model.getRowCount();
                            }

                        } catch (NumberFormatException ex1) {
                            Tabla.borrarTabla(numFilas, model);
                            numFilas = model.getRowCount();
                            pri = null;
                            JOptionPane.showMessageDialog(vista, "Ingrese un valor numérico");
                        } catch (codigoInvalidoException ex2) {
                            Tabla.borrarTabla(numFilas, model);
                            numFilas = model.getRowCount();
                            pri = null;
                            JOptionPane.showMessageDialog(vista, "El Código debe contar con 5 dígitos");
                        }

                        break;
                    }
                    case 1: {

                        try {
                            int dni = Integer.parseInt(vista.input.getText());
                            ControladorRegistrar.dniValido(dni);

                            pri = BaseDatos.buscarDni(dni);
                            if (pri == null) {
                                Tabla.borrarTabla(numFilas, model);
                                numFilas = model.getRowCount();
                                JOptionPane.showMessageDialog(vista, "Recluso no encontrado");

                            } else {
                                Tabla.borrarTabla(numFilas, model);
                                Tabla.mostrarUno(pri, model);
                                numFilas = model.getRowCount();
                            }

                        } catch (NumberFormatException ex1) {
                            Tabla.borrarTabla(numFilas, model);
                            numFilas = model.getRowCount();
                            pri = null;
                            JOptionPane.showMessageDialog(vista, "Ingrese un valor numérico");
                        } catch (DniInvalidoException ex2) {
                            Tabla.borrarTabla(numFilas, model);
                            numFilas = model.getRowCount();
                            pri = null;
                            JOptionPane.showMessageDialog(vista, "El DNI debe contar con 8 dígitos");
                        }

                        break;
                    }
                }

                // si existe un prisioner en la tabla se activa el botón eliminar
                if (pri == null) {
                    vista.btnEliminar.setEnabled(false);
                } else {
                    vista.btnEliminar.setEnabled(true);
                }
            }
        });
        
        // botón eliminar
        this.vista.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(pri.getPabellon()){
                    case "A":{
                        BaseDatos.pabellonA.remove(pri);
                        break;
                    }
                    case "B":{
                        BaseDatos.pabellonB.remove(pri);
                        break;
                    }
                    case "C":{
                        BaseDatos.pabellonC.remove(pri);
                        break;
                    }
                    case "D":{
                        BaseDatos.pabellonD.remove(pri);
                        break;
                    }
                }
                
                // mensaje de confirmación
                JOptionPane.showMessageDialog(vista, "Prisionero eliminado exitosamente");
                estadoInicial();
                BaseDatos.aumentarLiberados();
            }
        });
    }

    private void modeloTabla() {
        this.model = new DefaultTableModel();

        model.addColumn("APELLIDO");
        model.addColumn("DNI");
        model.addColumn("CÓDIGO");
        model.addColumn("EDAD");
        model.addColumn("CONDENA");
        model.addColumn("PABELLON");

        this.vista.tablaRecluso.setModel(model);
    }
   
    private void estadoInicial(){
        this.pri = null;
        this.vista.input.setText("");
        this.vista.btnEliminar.setEnabled(false);
        this.vista.buscarPor.setSelectedIndex(-1);
        Tabla.borrarTabla(numFilas, model);
        numFilas = this.model.getRowCount();
    }
    
    public void init(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
