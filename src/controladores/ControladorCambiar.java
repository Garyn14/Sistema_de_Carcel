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

public class ControladorCambiar {

    // atributos
    private final cambiar_pabellon vista;
    private DefaultTableModel model;
    private Prisionero pri;
    private int numFilas;

    public ControladorCambiar(cambiar_pabellon vista) {
        this.vista = vista;
        modeloTabla();
        eventos();
        numFilas = 0;
        this.pri = null;
        this.vista.btnCambiar.setEnabled(false);
    }

    private void eventos() {

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

                // si existe un prisioner en la tabla se activa el botón cambiar a recluso
                if (pri == null) {
                    vista.btnCambiar.setEnabled(false);
                } else {
                    vista.btnCambiar.setEnabled(true);
                }
            }
        });

        // botón cambiar
        this.vista.btnCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                switch (vista.nuevoPabe.getSelectedIndex()) {
                    case -1: {
                        JOptionPane.showMessageDialog(vista, "Ingrese una opción");
                        break;
                    }
                    case 0: {
                        if (pri.getPabellon().compareTo("A") == 0) {
                            JOptionPane.showMessageDialog(vista, "El pabellón actual y el nuevo pabellón son iguales\n"
                                    + "por favor ingrese otro pabellón");
                        } else {
                            BaseDatos.cambiarPabellon(pri, "A");
                            JOptionPane.showMessageDialog(vista, "El recluso ha sido cambiado de pabellón\n"
                                    + "exitosamente");
                            estadoInicial();
                        }

                        break;
                    }
                    case 1: {
                        if (pri.getPabellon().compareTo("B") == 0) {
                            JOptionPane.showMessageDialog(vista, "El pabellón actual y el nuevo pabellón son iguales\n"
                                    + "por favor ingrese otro pabellón");
                        } else {
                            BaseDatos.cambiarPabellon(pri, "B");
                            JOptionPane.showMessageDialog(vista, "El recluso ha sido cambiado de pabellón\n"
                                    + "exitosamente");
                            estadoInicial();
                        }

                        break;
                    }
                    case 2: {
                        if (pri.getPabellon().compareTo("C") == 0) {
                            JOptionPane.showMessageDialog(vista, "El pabellón actual y el nuevo pabellón son iguales\n"
                                    + "por favor ingrese otro pabellón");
                        } else {
                            BaseDatos.cambiarPabellon(pri, "C");
                            JOptionPane.showMessageDialog(vista, "El recluso ha sido cambiado de pabellón\n"
                                    + "exitosamente");
                            estadoInicial();
                        }

                        break;
                    }
                    case 3: {
                        if (pri.getPabellon().compareTo("D") == 0) {
                            JOptionPane.showMessageDialog(vista, "El pabellón actual y el nuevo pabellón son iguales\n"
                                    + "por favor ingrese otro pabellón");
                        } else {
                            BaseDatos.cambiarPabellon(pri, "D");
                            JOptionPane.showMessageDialog(vista, "El recluso ha sido cambiado de pabellón\n"
                                    + "exitosamente");
                            estadoInicial();
                        }

                        break;
                    }

                }

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

    private void estadoInicial() {
        pri = null;
        vista.btnCambiar.setEnabled(false);
        vista.input.setText("");
        vista.buscarPor.setSelectedIndex(-1);
        vista.nuevoPabe.setSelectedIndex(-1);
        Tabla.borrarTabla(numFilas, model);
        numFilas = this.model.getRowCount();
    }

    public void init() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
