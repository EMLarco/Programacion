/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Control.Conexion;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Venta extends JFrame {
     Conexion cc = new Conexion();
    java.sql.Connection con = cc.conexion();
    private JComboBox<String> modeloComboBox;
    private JTextField anoField;
    private JComboBox<String> motorComboBox;
    private JComboBox<String> transmisionComboBox;
    private JButton calcularButton;
    private JLabel imagenModeloLabel;
    private JLabel imagenMotorLabel;
    private JLabel imagenTransmisionLabel;
    
    private static final String RUTA_IMAGEN_KIA_PICANTO = "C:\\Users\\xaldo\\Desktop\\Segundo Semestre\\POO\\ProyectoFinal\\src\\Imagenes\\KiaPicanto.png";
    private static final String RUTA_IMAGEN_KIA_RIO = "C:\\Users\\xaldo\\Desktop\\Segundo Semestre\\POO\\ProyectoFinal\\src\\Imagenes\\KiaRio.png";
    private static final String RUTA_IMAGEN_KIA_SPORTAGE = "C:\\Users\\xaldo\\Desktop\\Segundo Semestre\\POO\\ProyectoFinal\\src\\Imagenes\\KiaSportage.png";
    private static final String RUTA_IMAGEN_MOTOR_1_0L = "C:\\Users\\xaldo\\Desktop\\Segundo Semestre\\POO\\ProyectoFinal\\src\\Imagenes\\Motor1.png";
    private static final String RUTA_IMAGEN_MOTOR_1_2L = "C:\\Users\\xaldo\\Desktop\\Segundo Semestre\\POO\\ProyectoFinal\\src\\Imagenes\\Motor2.png";
    private static final String RUTA_IMAGEN_TRANSMISION_MANUAL = "C:\\Users\\xaldo\\Desktop\\Segundo Semestre\\POO\\ProyectoFinal\\src\\Imagenes\\TransmisionAutomatica.png";
    private static final String RUTA_IMAGEN_TRANSMISION_AUTOMATICA = "C:\\Users\\xaldo\\Desktop\\Segundo Semestre\\POO\\ProyectoFinal\\src\\Imagenes\\TransmisionManual.png";
    

    public Venta() {
        setTitle("Personalizador Kia");
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }

    private void init() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        getContentPane().add(panel);

        // ComboBox de Modelo
        modeloComboBox = new JComboBox<>(new String[]{"Kia Picanto", "Kia Rio", "Kia Sportage"});
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 10);
        panel.add(new JLabel("Modelo:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        panel.add(modeloComboBox, gbc);

        // ComboBox de Año
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 10);
        panel.add(new JLabel("Año (2023 o 2024):"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        anoField = new JTextField(10);
        panel.add(anoField, gbc);

        // ComboBox de Motor
        motorComboBox = new JComboBox<>(new String[]{"Motor 1.0L", "Motor 1.2L"});
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 10);
        panel.add(new JLabel("Motor:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        panel.add(motorComboBox, gbc);

        // ComboBox de Transmisión
        transmisionComboBox = new JComboBox<>(new String[]{"Manual", "Automática"});
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 10);
        panel.add(new JLabel("Transmisión:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        panel.add(transmisionComboBox, gbc);

        calcularButton = new JButton("Calcular Precio");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(calcularButton, gbc);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPrecio();
            }
        });
        
        JButton comprarButton = new JButton("Comprar");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(comprarButton, gbc);

       comprarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
         String modeloSeleccionado = (String) modeloComboBox.getSelectedItem();
        int ano = Integer.parseInt(anoField.getText());
        String motorSeleccionado = (String) motorComboBox.getSelectedItem();
        String transmisionSeleccionada = (String) transmisionComboBox.getSelectedItem();

        obtenerRutaImagenModelo(modeloSeleccionado);
        obtenerRutaImagenMotor(motorSeleccionado);
        obtenerRutaImagenTransmision(transmisionSeleccionada);
        
        try {
            generarPDF(modeloSeleccionado, ano, motorSeleccionado, transmisionSeleccionada, RUTA_IMAGEN_KIA_PICANTO, RUTA_IMAGEN_MOTOR_1_0L, RUTA_IMAGEN_TRANSMISION_MANUAL);
        } catch (BadElementException | IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Venta.this, "Error al generar la factura", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del ActionListener en caso de error
        }
        calcularPrecio(); // Llamar a calcularPrecio para obtener el precio total
       
          Factura facturaFrame = new Factura();
        facturaFrame.setVisible(true);


        

   

        // Insertar los datos en la base de datos
        if (con != null) {
            try {
                String insertQuery = "INSERT INTO venta (venta_modelo, venta_año, venta_motor, venta_transmision) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertQuery);

                preparedStatement.setString(1, modeloSeleccionado);
                preparedStatement.setInt(2, ano);
                preparedStatement.setString(3, motorSeleccionado);
                preparedStatement.setString(4, transmisionSeleccionada);

                preparedStatement.executeUpdate();
                con.close();
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
});






        imagenModeloLabel = new JLabel();
    gbc.gridx = 2;
    gbc.gridy = 0; // Asegura que las imágenes estén en la fila correcta
    gbc.gridheight = 3;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.insets = new Insets(0, 20, 0, 0);
    panel.add(imagenModeloLabel, gbc);

    imagenMotorLabel = new JLabel();
    gbc.gridx = 2;
    gbc.gridy = 3; // Asegura que las imágenes estén en la fila correcta
    gbc.gridheight = 1;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.insets = new Insets(0, 20, 0, 0);
    panel.add(imagenMotorLabel, gbc);

    imagenTransmisionLabel = new JLabel();
    gbc.gridx = 2;
    gbc.gridy = 4; // Asegura que las imágenes estén en la fila correcta
    gbc.gridheight = 1;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.insets = new Insets(0, 20, 0, 0);

        modeloComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String modeloSeleccionado = (String) modeloComboBox.getSelectedItem();
                 obtenerRutaImagenModelo(modeloSeleccionado); // Pasar el modelo seleccionado como argumento
            }
        });

        motorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String motorSeleccionado = (String) motorComboBox.getSelectedItem();
                obtenerRutaImagenMotor(motorSeleccionado);
            }
        });

        transmisionComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String transmisionSeleccionada = (String) transmisionComboBox.getSelectedItem();
                obtenerRutaImagenTransmision(transmisionSeleccionada);
            }
        });
    }
    
    private void obtenerRutaImagenModelo(String modeloSeleccionado) {
    String rutaImagen = "";

    if (modeloSeleccionado.equals("Kia Picanto")) {
        rutaImagen = RUTA_IMAGEN_KIA_PICANTO;
    } else if (modeloSeleccionado.equals("Kia Rio")) {
        rutaImagen = RUTA_IMAGEN_KIA_RIO;
    } else if (modeloSeleccionado.equals("Kia Sportage")) {
        rutaImagen = RUTA_IMAGEN_KIA_SPORTAGE;
    }

    if (!rutaImagen.isEmpty()) {
        ImageIcon iconoImagen = new ImageIcon(rutaImagen);
        imagenModeloLabel.setIcon(iconoImagen);
    }
}
    private void obtenerRutaImagenMotor(String motorSeleccionado) {
    String rutaImagen = "";

    if (motorSeleccionado.equals("Motor 1.0L")) {
        rutaImagen = RUTA_IMAGEN_MOTOR_1_0L; // Debes proporcionar la ruta correcta
    } else if (motorSeleccionado.equals("Motor 1.2L")) {
        rutaImagen = RUTA_IMAGEN_MOTOR_1_2L; // Debes proporcionar la ruta correcta
    }

    if (!rutaImagen.isEmpty()) {
        ImageIcon iconoImagen = new ImageIcon(rutaImagen);
        imagenModeloLabel.setIcon(iconoImagen);
    }
}

private void obtenerRutaImagenTransmision(String transmisionSeleccionada) {
    String rutaImagen = "";

    if (transmisionSeleccionada.equals("Manual")) {
        rutaImagen = RUTA_IMAGEN_TRANSMISION_MANUAL; // Debes proporcionar la ruta correcta
    } else if (transmisionSeleccionada.equals("Automática")) {
        rutaImagen = RUTA_IMAGEN_TRANSMISION_AUTOMATICA; // Debes proporcionar la ruta correcta
    }

    if (!rutaImagen.isEmpty()) {
        ImageIcon iconoImagen = new ImageIcon(rutaImagen);
        imagenModeloLabel.setIcon(iconoImagen);
    }
}

private void generarPDF(String modelo, int ano, String motor, String transmision, String rutaImagenModelo, String rutaImagenMotor, String rutaImagenTransmision) throws BadElementException, IOException {
    Document document = new Document();

    try {
        PdfWriter.getInstance(document, new FileOutputStream("FacturaPersonalizacion.pdf"));
        document.open();

        // Agregar contenido al PDF
        Paragraph paragraph = new Paragraph();
        paragraph.add("Factura de Personalización\n\n");
        paragraph.add("Modelo: " + modelo + "\n");
        paragraph.add("Año: " + ano + "\n");
        paragraph.add("Motor: " + motor + "\n");
        paragraph.add("Transmisión: " + transmision + "\n");
        paragraph.add("Precio Total: $" + calcularPrecioTotal(modelo, motor, transmision) + "\n\n");

        // Agregar imágenes al PDF
        Image imagenModelo = Image.getInstance(rutaImagenModelo);
        imagenModelo.scaleAbsolute(100, 100);
        document.add(imagenModelo);

        Image imagenMotor = Image.getInstance(rutaImagenMotor);
        imagenMotor.scaleAbsolute(100, 100);
        document.add(imagenMotor);

        Image imagenTransmision = Image.getInstance(rutaImagenTransmision);
        imagenTransmision.scaleAbsolute(100, 100);
        document.add(imagenTransmision);

        document.add(paragraph);
        document.close();

        JOptionPane.showMessageDialog(this, "Factura generada correctamente como 'Factura.pdf'", "Factura Generada", JOptionPane.INFORMATION_MESSAGE);
    } catch (FileNotFoundException | DocumentException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al generar la factura", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
   private double calcularPrecioTotal(String modelo, String motor, String transmision) {
    double precioBase = 13000.00;
    if (modelo.equals("Kia Rio")) {
        precioBase += 2000.00;
    } else if (modelo.equals("Kia Sportage")) {
        precioBase += 14000.00;
    }

    double precioTotal = precioBase;

    if (motor.equals("Motor 1.2L")) {
        precioTotal += 2000.00;
    }

    if (transmision.equals("Automática")) {
        precioTotal += 3000.00;
    }

    return precioTotal;
}





    

   
    private void calcularPrecio() {
        String modeloSeleccionado = (String) modeloComboBox.getSelectedItem();
        int ano = Integer.parseInt(anoField.getText());
        String motorSeleccionado = (String) motorComboBox.getSelectedItem();
        String transmisionSeleccionada = (String) transmisionComboBox.getSelectedItem();

        double precioBase = 13000.00;
        if (modeloSeleccionado.equals("Kia Rio")) {
            precioBase += 2000.00;
        } else if (modeloSeleccionado.equals("Kia Sportage")) {
            precioBase += 14000.00;
        }

        double precioTotal = precioBase;

        if (motorSeleccionado.equals("Motor 1.2L")) {
            precioTotal += 2000.00;
        }

        if (transmisionSeleccionada.equals("Automatica")) {
            precioTotal += 3000.00;
        }

        mostrarFactura(modeloSeleccionado, ano, motorSeleccionado, transmisionSeleccionada, precioTotal);
    }

    private void mostrarFactura(String modelo, int ano, String motor, String transmision, double precioTotal) {
        JOptionPane.showMessageDialog(this,
                "Modelo: " + modelo + "\n" +
                "Año: " + ano + "\n" +
                "Motor: " + motor + "\n" +
                "Transmisión: " + transmision + "\n" +
                "Precio Total: $" + precioTotal,
                "Factura de Personalización",
                JOptionPane.INFORMATION_MESSAGE);
    }

    
}