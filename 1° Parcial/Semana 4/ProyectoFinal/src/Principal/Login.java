
package Principal;


import Control.Conexion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame {
    Conexion cc = new Conexion();
    Connection con = cc.conexion();
    public JPanel panel;

    public Login() {
        this.setSize(400, 450);
        setTitle("LOGIN KIA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        colocarPanel();
        colocarEtiquetas();
        cajaTexto();
        crearBotones();
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    private void colocarEtiquetas() {
        JLabel label = new JLabel("LOGIN", SwingConstants.CENTER);
        panel.add(label);
        panel.setLayout(null);
        label.setBounds(0, 0, 400, 70);
        label.setForeground(Color.white);
        label.setBackground(Color.black);
        label.setOpaque(true);
        label.setFont(new Font("arial", Font.PLAIN, 20));

        JLabel labell = new JLabel();
        labell.setText("USUARIO");
        panel.add(labell);
        labell.setHorizontalAlignment(SwingConstants.LEFT);
        labell.setFont(new Font("arial", Font.PLAIN, 15));
        labell.setBounds(40, 220, 350, 50);

        ImageIcon imagen1 = new ImageIcon("C:\\Users\\xaldo\\Desktop\\Segundo Semestre\\POO\\ProyectoFinal\\src\\Imagenes\\LoginKia.png");
        JLabel labell2 = new JLabel();
        labell2.setText("");
        panel.add(labell2);
        labell2.setBounds(150, 100, 100, 100);
        labell2.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(labell2.getWidth(), labell2.getHeight(), Image.SCALE_SMOOTH)));

        JLabel labell3 = new JLabel();
        labell3.setText("PASSWORD");
        panel.add(labell3);
        labell3.setHorizontalAlignment(SwingConstants.LEFT);
        labell3.setFont(new Font("arial", Font.PLAIN, 15));
        labell3.setBounds(40, 260, 350, 50);
    }

    private void cajaTexto() {
        JTextField cajatexto1 = new JTextField();
        cajatexto1.setBounds(140, 230, 200, 30);
        panel.add(cajatexto1);

        JTextField cajatexto2 = new JTextField();
        cajatexto2.setBounds(140, 270, 200, 30);
        panel.add(cajatexto2);

        JButton boton1 = new JButton("INICIAR SESION");
        boton1.setBounds(40, 330, 130, 40);
        panel.add(boton1);
        boton1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String log_pass = cajatexto2.getText();
                String log_usuario = cajatexto1.getText();
                String SQL = "SELECT * FROM registro where registro_usuario='" + log_usuario + "'and registro_contrasena='" + log_pass + "'";

                try {
                    Statement st = (Statement) con.createStatement();
                    ResultSet rs = st.executeQuery(SQL);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                        mostrarVenta();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
                    }
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "ERROR LOGIN" + i.getMessage());
                } finally {
                    cerrar();
                }
            }
        });

        JButton boton2 = new JButton("VOLVER");
        boton2.setBounds(220, 330, 130, 40);
        panel.add(boton2);
        boton2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrar();
            }
        });
    }

    private void crearBotones() {
    }

    private void cerrar() {
        this.dispose();
    }

    private void validarUsuario() {
    }

    private void mostrarVenta() {
        new Venta().setVisible(true);
        dispose();
    }

    
}