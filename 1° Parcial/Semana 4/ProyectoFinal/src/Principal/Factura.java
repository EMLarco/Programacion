package Principal;

import Control.Conexion;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class Factura extends JFrame {
    Conexion cc = new Conexion();
    Connection con = cc.conexion();
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField cedulaField;
    private JTextField direccionField;
    private JTextField tarjetaField;
    private JTextField correoField;
    private JTextField celularField;
    private JButton guardarButton;

    public Factura() {
        setTitle("Factura");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        getContentPane().add(panel);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 10);
        panel.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        nombreField = new JTextField(20);
        panel.add(nombreField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 10);
        panel.add(new JLabel("Apellido:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        apellidoField = new JTextField(20);
        panel.add(apellidoField, gbc);
        
         gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 10);
        panel.add(new JLabel("Cédula:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        cedulaField = new JTextField(20);
        panel.add(cedulaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 10);
        panel.add(new JLabel("Dirección:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        direccionField = new JTextField(20);
        panel.add(direccionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 10);
        panel.add(new JLabel("Tarjeta de crédito:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        tarjetaField = new JTextField(20);
        panel.add(tarjetaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 10);
        panel.add(new JLabel("Correo:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        correoField = new JTextField(20);
        panel.add(correoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 10);
        panel.add(new JLabel("Celular:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        celularField = new JTextField(20);
        panel.add(celularField, gbc);

        

        guardarButton = new JButton("Guardar");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(guardarButton, gbc);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                int cedula = Integer.parseInt(cedulaField.getText());
                String direccion = direccionField.getText();
                int tarjeta = Integer.parseInt(tarjetaField.getText());
                String correo = correoField.getText();
                int celular = Integer.parseInt(celularField.getText());
                generarPDF(nombre, apellido, cedula, direccion, tarjeta, correo, celular);
                guardarFactura(nombre, apellido, cedula, direccion, tarjeta, correo, celular);
                
                String correoDestino = JOptionPane.showInputDialog("Ingrese el correo electrónico de destino:");
                if (correoDestino != null && !correoDestino.isEmpty()) {
                    String asunto = "Factura PDF Adjunto";
                    String mensaje = "Adjunto encontrarás la factura en formato PDF.";

                    String[] rutasArchivosAdjuntos = {
                        "C:\\Users\\xaldo\\Desktop\\Segundo Semestre\\POO\\ProyectoFinal\\FacturaDatos.pdf",
                        "C:\\Users\\xaldo\\Desktop\\Segundo Semestre\\POO\\ProyectoFinal\\FacturaPersonalizacion.pdf"
                    };

                    enviarCorreo(correoDestino, asunto, mensaje, rutasArchivosAdjuntos);
        }
            }
        });
    }

    private void generarPDF(String nombre, String apellido, int cedula, String direccion, int tarjeta, String correo, int celular) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("FacturaDatos.pdf"));
            document.open();

            String contenido = "Factura\n\n" +
                    "Nombre: " + nombre + "\n" +
                    "Apellido: " + apellido + "\n" +
                    "Cédula: " + cedula + "\n" +
                    "Dirección: " + direccion + "\n" +
                    "Tarjeta de crédito: " + tarjeta + "\n" +
                    "Correo: " + correo + "\n" +
                    "Celular: " + celular;

            Paragraph paragraph = new Paragraph(contenido);
            document.add(paragraph);

            document.close();

            JOptionPane.showMessageDialog(this, "PDF de factura generado exitosamente");

        } catch (DocumentException | IOException ex) {
            ex.printStackTrace();
        }
    }

    private void guardarFactura(String nombre, String apellido, int cedula, String direccion, int tarjeta, String correo, int celular) {
        if (con != null) {
            try {
                String insertQuery = "INSERT INTO factura (factura_nombre, factura_apellido, factura_cedula, factura_direccion, factura_tarjeta, factura_correo, factura_celular) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = con.prepareStatement(insertQuery);

                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, apellido);
                preparedStatement.setInt(3, cedula);
                preparedStatement.setString(4, direccion);
                preparedStatement.setInt(5, tarjeta);
                preparedStatement.setString(6, correo);
                preparedStatement.setInt(7, celular);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Factura guardada en la base de datos correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar la factura en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                }

                con.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al guardar la factura en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void enviarCorreo(String destinatario, String asunto, String mensaje, String[] rutasArchivosAdjuntos) {
        String remitente = "aldodszpoo@gmail.com"; // Cambia esto al remitente real
        String contraseña = "dgraavmevyhepiir"; // Cambia esto a la contraseña real

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Cambia esto si estás usando otro proveedor de correo
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, contraseña);
            }
        });

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(remitente));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            emailMessage.setSubject(asunto);

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(mensaje);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            for (String rutaArchivo : rutasArchivosAdjuntos) {
                MimeBodyPart attachmentPart = new MimeBodyPart();
                attachmentPart.attachFile(rutaArchivo);
                multipart.addBodyPart(attachmentPart);
            }

            emailMessage.setContent(multipart);

            Transport.send(emailMessage);

            JOptionPane.showMessageDialog(this, "Correo electrónico enviado exitosamente");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al enviar el correo electrónico", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    
    }

