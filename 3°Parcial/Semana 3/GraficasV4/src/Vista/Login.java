
package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Login extends JFrame {

    private JPanel panel;
    private JTextField cajaTextoUsuario;
    private JPasswordField cajaTextoContraseña;

    public Login() {
        this.setSize(500, 500);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        colocarPanel();
        colocarEtiquetas();
        cajaTextoUsuario = new JTextField();
        cajaTextoContraseña = new JPasswordField();
        colocarCajadeTexto("Usuario", 115, 250);
        colocarCajadeTexto("Contraseña", 115, 300);
        colocarBoton();
        colocarImagen();
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
    }

    public void colocarEtiquetas() {
        JLabel label = new JLabel("LOGIN", SwingConstants.CENTER);
        panel.add(label);
        panel.setLayout(null);
        label.setBounds(0, 10, 500, 50);
        label.setForeground(Color.white);
        label.setBackground(Color.DARK_GRAY);
        label.setOpaque(true);
    }

    public void colocarBoton() {
        JButton boton = new JButton("Iniciar sesión");
        boton.setBounds(170, 380, 150, 50);
        panel.add(boton);
        boton.setEnabled(true);
        boton.setMnemonic('a');

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarCredenciales();
            }
        });
    }

    public void colocarCajadeTexto(String textoInicial, int x, int y) {
        JPasswordField cajaTexto = new JPasswordField();
        cajaTexto.setBounds(x, y, 250, 20);
        panel.add(cajaTexto);
        cajaTexto.setText(textoInicial);

        cajaTexto.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(cajaTexto.getPassword()).equals(textoInicial)) {
                    cajaTexto.setText("");
                    cajaTexto.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(cajaTexto.getPassword()).isEmpty()) {
                    cajaTexto.setText(textoInicial);
                    cajaTexto.setForeground(Color.gray);
                }
            }
        });

        // Asigna las cajas de texto adecuadas
        if (textoInicial.equals("Usuario")) {
            cajaTextoUsuario = cajaTexto;
        } else if (textoInicial.equals("Contraseña")) {
            cajaTextoContraseña = cajaTexto;
        }
    }

    public void colocarImagen() {
        ImageIcon imagenOriginal = new ImageIcon("usuario.png");
        int nuevaAnchura = 250;
        int nuevaAltura = 160;
        Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(nuevaAnchura, nuevaAltura, Image.SCALE_SMOOTH);
        ImageIcon imagenRedimensionada = new ImageIcon(imagenEscalada);
        JLabel labelImagen = new JLabel(imagenRedimensionada);
        labelImagen.setBounds(115, 80, nuevaAnchura, nuevaAltura);
        panel.add(labelImagen);
    }

    public void validarCredenciales() {
        String user_name = cajaTextoUsuario.getText();
        String pass_word = String.valueOf(cajaTextoContraseña.getPassword());
        
        try {
            // Conectar a MongoDB
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("mounts"); // el nombre de tu base de datos
            MongoCollection<Document> collection = database.getCollection("login"); // Reemplaza "login" por el nombre de tu colección

            Document query = new Document("user", user_name)
                    .append("pass", pass_word);

            Document result = collection.find(query).first();

            if (result != null) {
                JOptionPane.showMessageDialog(null, "CONTRASEÑA CORRECTA");
                cajaTextoUsuario.setText("");
                cajaTextoContraseña.setText("");
                // Mostrar la ventana del menú
                Menu menu = new Menu();
                menu.setVisible(true);
                dispose(); // Cierra la ventana de inicio de sesión
                JOptionPane.showMessageDialog(null, "Bienvenido");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }

            mongoClient.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR LOGIN: " + e.getMessage());
        }
    }
}