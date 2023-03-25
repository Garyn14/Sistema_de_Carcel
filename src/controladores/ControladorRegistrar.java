
package controladores;

import exceptions.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelos.Prisionero;
import vistas.*;

public class ControladorRegistrar {
    // atributos
    private final registrar_recluso vista;

    public ControladorRegistrar(registrar_recluso vista) {
        this.vista = vista;
        eventos();
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
        
        // botón registrar
        this.vista.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarDatos();
            }
        });
    }
    
    private void validarDatos(){
        String apellidos = this.vista.apellidoIn.getText();
        int dni = 0;
        int edad = 0;
        int condena = 0;
        
        try {
            espacioVacio(apellidos);
            try{
                espacioVacio(this.vista.dniIn.getText());
                dni = Integer.parseInt(this.vista.dniIn.getText());
                dniValido(dni);

                try {
                    espacioVacio(this.vista.edadIn.getText());
                    edad = Integer.parseInt(this.vista.edadIn.getText());
                    edadValida(edad);

                    try {
                        espacioVacio(this.vista.condenaIn.getText());
                        condena = Integer.parseInt(this.vista.condenaIn.getText());
                        condenaValida(condena);
                        ingresarRecluso(apellidos, dni, edad, condena, (String)this.vista.pabellonIn.getSelectedItem());

                    } catch(espacioBlankException ex003){
                        JOptionPane.showMessageDialog(vista, "ingrese la condena");
                    } catch (NumberFormatException ex5) {
                        JOptionPane.showMessageDialog(vista, "La condena debe ser un valor numérico");
                    } catch(condenaInvalidaExeception ex6){
                        JOptionPane.showMessageDialog(vista, "La condena debe encontrarse en el rango de 1 - 90");
                    }

                } catch(espacioBlankException ex002){
                    JOptionPane.showMessageDialog(vista, "ingrese la edad");
                } catch (NumberFormatException ex3) {
                    JOptionPane.showMessageDialog(vista, "La edad debe ser un valor numérico");
                } catch(edadInvalidaException ex4){
                    JOptionPane.showMessageDialog(vista, "La edad debe encontrarse en el rango de 18 - 100");
                }

            } catch(espacioBlankException ex001){
                JOptionPane.showMessageDialog(vista, "ingrese el DNI");
            } catch(NumberFormatException ex1){
                JOptionPane.showMessageDialog(vista, "El DNI debe ser un valor numérico");
            } catch(DniInvalidoException ex2){
                JOptionPane.showMessageDialog(vista, "El DNI debe contar con 8 dígitos");
            }
            
        } catch (espacioBlankException ex00) {
            JOptionPane.showMessageDialog(vista, "Ingrese un apellido");
        }
        
        

    }
    
    public static void dniValido(int dniNumber) throws DniInvalidoException{
        if(dniNumber < 10_000_000 || dniNumber > 99_999_999){
            throw new DniInvalidoException();
        }
    }
    
    public static void codigoValido(int codigoNumber) throws codigoInvalidoException{
        if(codigoNumber < 10_000 || codigoNumber > 99_999){
            throw new codigoInvalidoException();
        }
    }
    
    private void edadValida(int edadNumber) throws edadInvalidaException{
        if(edadNumber < 18 || edadNumber > 100){
            throw new edadInvalidaException();
        }
    }
    
    private void condenaValida(int condenaNumber) throws condenaInvalidaExeception{
        if(condenaNumber < 1 || condenaNumber > 90){
            throw  new condenaInvalidaExeception();
        }
    }
    
    private void espacioVacio(String espacio) throws espacioBlankException{
        if(espacio.isBlank()){
            throw new espacioBlankException();
        }
    }
    
    private void ingresarRecluso(String apellido, int dni, int edad, int condena, String pabellon){
        Prisionero pri = new Prisionero(apellido, dni, edad, condena, pabellon);
        datos.BaseDatos.zonaPrevia.add(pri);
        JOptionPane.showMessageDialog(vista, "PRISIONERO REGISTRADO EXITOSAMENTE\n"
                + "Apellido: " + apellido + "\nDNI: " + dni + "\nCódigo: " + pri.getCodigo() + 
                "\nEdad: " + edad + "\nCondena: " + condena + "\nPabellón: " + pabellon);
        
        // vaciamos los campos
        this.vista.apellidoIn.setText("");
        this.vista.dniIn.setText("");
        this.vista.edadIn.setText("");
        this.vista.condenaIn.setText("");
        this.vista.pabellonIn.setSelectedIndex(-1);
    }
    
    public void init(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
