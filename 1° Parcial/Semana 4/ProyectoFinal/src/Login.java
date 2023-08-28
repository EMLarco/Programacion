import Control.Conexion;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Login extends JFrame {
    private JTextField usuario;
    private JPasswordField contrasena;
    
    // Agrega la instancia de Conexion aquí
    Conexion cc = new Conexion();
    Connection con = cc.conexion();

    public Login() {
        // Configuración básica del JFrame
        setTitle("Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Panel para organizar los componentes
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        
        JLabel usernameLabel = new JLabel("Usuario:");
        JLabel passwordLabel = new JLabel("Contraseña:");
        usuario = new JTextField(20);
        contrasena = new JPasswordField(20);

        JButton loginButton = new JButton("Iniciar Sesión");

        // Agrega ActionListener para el botón Iniciar Sesión
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usuario.getText();
                char[] password = contrasena.getPassword();

                Connection con = cc.conexion();
                String selectQuery = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
                
                try {
                    PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, new String(password));
                    ResultSet resultSet = preparedStatement.executeQuery();
                    
                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(Login.this, "Inicio de sesión exitoso");
                    } else {
                        JOptionPane.showMessageDialog(Login.this, "Credenciales incorrectas");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(Login.this, "Error al iniciar sesión: " + ex.getMessage());
                } finally {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        // Manejo de error al cerrar la conexión
                    }
                }
            }
        });

        // Agrega los componentes al panel
        panel.add(usernameLabel);
        panel.add(usuario);
        panel.add(passwordLabel);
        panel.add(contrasena);
        panel.add(loginButton);

        // Agrega el panel al JFrame
        add(panel);

        // Centra el JFrame en la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);

        // Pack el JFrame para ajustar los componentes
        pack();
    }

  
}
