/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Control.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Usuario
 */
public class Menu extends JFrame {
     Conexion cc=new Conexion();
    Connection con = cc.conexion();
    private JButton boton1;
    private JButton boton2;
     public JPanel panel;
     private JLabel txt1;
      
     
    public Menu(){
        this.setSize(400,450);
        setTitle("MENU KIA");
        //Para que cierre el sistema
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        //Centrar la ventana
        //setBounds(500,200,500,500);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }
     private void iniciarComponentes(){
        colocarPanel();
        crearBotones();
        creacionTexto();
     
       
         
    }
    
     private void colocarPanel(){
        panel = new JPanel();
        //Damos color al panel
        panel.setBackground(Color.white);
        //poner el panel sobre la ventana registro
        this.getContentPane().add(panel);       
    }
    
    private void creacionTexto(){
        ImageIcon imagen1 = new ImageIcon("C:\\Users\\xaldo\\Desktop\\Segundo Semestre\\POO\\ProyectoFinal\\src\\Imagenes\\Kia.jpg"); // Cambiar ruta de la imagen
        JLabel txt1 = new JLabel();
        txt1.setText("");
        panel.add(txt1);
        txt1.setBounds(30, 50, 349, 133);
        txt1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(txt1.getWidth(), txt1.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    private void crearBotones(){
        panel.setLayout(null);
         boton1 = new JButton("Login");
        boton1.setBounds(50, 230, 120, 50);
        panel.add(boton1);
        boton1.setEnabled(true);
        boton1.setMnemonic('a');
        boton1.setForeground(Color.black);
        boton1.setBackground(Color.white);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Login iniciar = new  Login ();
              iniciar.setVisible(true);            
            JOptionPane.showMessageDialog(null,"Bienvenido al Login");   
           
               
            }
        });
        
        boton2 = new JButton("Registro");
        boton2.setBounds(230, 230, 120, 50);
        panel.add(boton2);
        boton2.setEnabled(true);
        boton2.setMnemonic('a');
        boton2.setForeground(Color.black);
        boton2.setBackground(Color.white);
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Registro inicia = new  Registro ();
              inicia.setVisible(true);  
              JOptionPane.showMessageDialog(null,"Bienvenido al Registro ");
              
               
            }
        });
    }
    
    public void cerrar(){
              this.dispose();
          } 
}
