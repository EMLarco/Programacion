
package Principal;

import Control.Conexion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

public class Registro extends JFrame {
    private JTextField usuario;
    private JPasswordField contrasena;
    private JPanel panel; // Declaración del panel como campo de la clase

    // Agrega la instancia de Conexion aquí
    Conexion cc = new Conexion();
    Connection con = cc.conexion();

    public Registro() {
        // Configuración básica del JFrame
        setTitle("REGISTRO KIA");
        setSize(400, 450); // Establece el tamaño del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        colocarPanel();
        colocarEtiquetas();
        cajaTexto();
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    private void colocarEtiquetas() {
        JLabel label = new JLabel("REGISTRO", SwingConstants.CENTER);
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

        ImageIcon imagen1 = new ImageIcon("C:\\Users\\xaldo\\Desktop\\Segundo Semestre\\POO\\ProyectoFinal\\src\\Imagenes\\RegistroKia.jpg");
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
        usuario = new JTextField();
        usuario.setBounds(140, 230, 200, 30);
        panel.add(usuario);

        contrasena = new JPasswordField();
        contrasena.setBounds(140, 270, 200, 30);
        panel.add(contrasena);

        JButton registerButton = new JButton("Registrar");
        registerButton.setBounds(40, 330, 130, 40);
        panel.add(registerButton);
        registerButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usuario.getText();
                char[] password = contrasena.getPassword();

                // Verifica si los campos están vacíos
                if (username.isEmpty() || password.length == 0) {
                    JOptionPane.showMessageDialog(Registro.this, "Por favor ingrese los campos para registrarse");
                } else {
                    Connection con = cc.conexion();
                    String insertQuery = "INSERT INTO registro (registro_usuario, registro_contrasena) VALUES (?, ?)";

                    try {
                        PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
                        preparedStatement.setString(1, username);
                        preparedStatement.setString(2, new String(password));
                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(Registro.this, "Registro exitoso");
                            dispose(); // Cerrar la ventana de registro
                        } else {
                            JOptionPane.showMessageDialog(Registro.this, "Error al registrar");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(Registro.this, "Error al registrar: " + ex.getMessage());
                    } finally {
                        try {
                            con.close();
                        } catch (SQLException ex) {
                            // Manejo de error al cerrar la conexión
                        }
                    }
                }
            }
        });


        JButton backButton = new JButton("Volver");
        backButton.setBounds(220, 330, 130, 40);
        panel.add(backButton);
        backButton.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrar();
            }
        });
    }

    private void cerrar() {
        this.dispose();
    }

 
}