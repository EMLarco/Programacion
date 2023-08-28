
package Vista;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Horario extends JFrame {
    private JPanel panel;
    public DefaultTableModel tabla;
    private JTextField cajaTextoLab;
    private JTextField cajaTextoInicio;
    private JTextField cajaTextoFin;
    private JTextField cajaTextoDia;
    private JTable tabla1;

    public Horario() {
        this.setSize(1300, 600);
        setTitle("REGISTRO DE HORARIOS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        colocarPanel();
        colocarEtiquetas();
        colocarTextFields();
        crearBotones();
        tablaDeDatos();
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setBackground(Color.black);
        this.getContentPane().add(panel);
    }

    public void colocarEtiquetas() {
        JLabel label = new JLabel("Registro de Horarios", SwingConstants.CENTER);
        panel.add(label);
        panel.setLayout(null);
        label.setBounds(69, 10, 350, 30);
        label.setForeground(Color.black);
        label.setBackground(Color.white);
        label.setOpaque(true);

        JLabel label1 = new JLabel();
        label1.setText("Laboratorio:");
        panel.add(label1);
        label1.setHorizontalAlignment(HEIGHT);
        label1.setFont(new Font("Arial", Font.PLAIN, 12));
        label1.setBounds(30, 70, 350, 50);
        label1.setForeground(Color.white);

        JLabel label2 = new JLabel();
        label2.setText("Hora de Inicio:");
        panel.add(label2);
        label2.setHorizontalAlignment(HEIGHT);
        label2.setFont(new Font("Arial", Font.PLAIN, 12));
        label2.setBounds(30, 100, 350, 50);
        label2.setForeground(Color.white);

        JLabel label3 = new JLabel();
        label3.setText("Hora de Fin:");
        panel.add(label3);
        label3.setHorizontalAlignment(HEIGHT);
        label3.setFont(new Font("Arial", Font.PLAIN, 12));
        label3.setBounds(30, 130, 350, 50);
        label3.setForeground(Color.white);

        JLabel label4 = new JLabel();
        label4.setText("Día:");
        panel.add(label4);
        label4.setHorizontalAlignment(HEIGHT);
        label4.setFont(new Font("Arial", Font.PLAIN, 12));
        label4.setBounds(30, 160, 350, 50);
        label4.setForeground(Color.white);
    }

    public void colocarTextFields() {
        cajaTextoLab = new JTextField();
        cajaTextoLab.setBounds(130, 80, 250, 20);
        panel.add(cajaTextoLab);
        cajaTextoLab.setText("Escribir Laboratorio");

        cajaTextoInicio = new JTextField();
        cajaTextoInicio.setBounds(130, 110, 250, 20);
        panel.add(cajaTextoInicio);
        cajaTextoInicio.setText("Hora de Inicio");

        cajaTextoFin = new JTextField();
        cajaTextoFin.setBounds(130, 140, 250, 20);
        panel.add(cajaTextoFin);
        cajaTextoFin.setText("Hora de Fin");

        cajaTextoDia = new JTextField();
        cajaTextoDia.setBounds(130, 170, 250, 20);
        panel.add(cajaTextoDia);
        cajaTextoDia.setText("Día");
    }

    public void crearBotones() {
        JButton boton = new JButton("Nuevo");
        boton.setBounds(30, 250, 100, 50);
        panel.add(boton);
        boton.setEnabled(true);
        boton.setMnemonic('a');

        JButton boton2 = new JButton("Guardar");
        boton2.setBounds(140, 250, 100, 50);
        panel.add(boton2);
        boton2.setEnabled(true);
        boton2.setMnemonic('a');
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        JButton boton3 = new JButton("Editar");
        boton3.setBounds(250, 250, 100, 50);
        panel.add(boton3);
        boton3.setEnabled(true);
        boton3.setMnemonic('a');
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        JButton boton4 = new JButton("Eliminar");
        boton4.setBounds(360, 250, 100, 50);
        panel.add(boton4);
        boton4.setEnabled(true);
        boton4.setMnemonic('a');
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        JButton boton5 = new JButton("Salir");
        boton5.setBounds(470, 250, 100, 50);
        panel.add(boton5);
        boton5.setEnabled(true);
        boton5.setMnemonic('a');
    }

    public void tablaDeDatos() {
        tabla = new DefaultTableModel();
        tabla.addColumn("Laboratorio");
        tabla.addColumn("Hora de Inicio");
        tabla.addColumn("Hora de Fin");
        tabla.addColumn("Día");

        tabla1 = new JTable(tabla);
        JScrollPane barra = new JScrollPane(tabla1);
        barra.setBounds(600, 70, 650, 300);
        panel.add(barra);
    }

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("mounts"); // Reemplaza con el nombre de tu base de datos
        MongoCollection<Document> collection = database.getCollection("horario");

        Document horario = new Document()
                .append("hora_lab", cajaTextoLab.getText())
                .append("hora_inicio", cajaTextoInicio.getText())
                .append("hora_fin", cajaTextoFin.getText())
                .append("hora_dia", cajaTextoDia.getText());

        collection.insertOne(horario);

        mostrarDatos();
        limpiarDatos();

        mongoClient.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}

private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
    int filaSeleccionada = tabla1.getSelectedRow();
    if (filaSeleccionada >= 0) {
        try {
            MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("mounts"); // Reemplaza con el nombre de tu base de datos
            MongoCollection<Document> collection = database.getCollection("horario");

            String user_codigo = tabla1.getValueAt(filaSeleccionada, 0).toString();

            Document horario = new Document()
                    .append("hora_lab", cajaTextoLab.getText())
                    .append("hora_inicio", cajaTextoInicio.getText())
                    .append("hora_fin", cajaTextoFin.getText())
                    .append("hora_dia", cajaTextoDia.getText());

            Document filter = new Document("hora_codigo", user_codigo);
            Document updateDocument = new Document("$set", horario);
            collection.updateOne(filter, updateDocument);

            mostrarDatos();
            limpiarDatos();

            mongoClient.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione una fila para editar.");
    }
}
    
public void mostrarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) tabla1.getModel();
        modelo.setRowCount(0);

        try {
            MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("mounts"); // Reemplaza con el nombre de tu base de datos
            MongoCollection<Document> collection = database.getCollection("horario");

            for (Document document : collection.find()) {
                String hora_lab = document.getString("hora_lab");
                String hora_inicio = document.getString("hora_inicio");
                String hora_fin = document.getString("hora_fin");
                String hora_dia = document.getString("hora_dia");

                modelo.addRow(new Object[]{hora_lab, hora_inicio, hora_fin, hora_dia});
            }

            mongoClient.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void limpiarDatos() {
        cajaTextoLab.setText("");
        cajaTextoInicio.setText("");
        cajaTextoFin.setText("");
        cajaTextoDia.setText("");
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = tabla1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String hora_lab = tabla1.getValueAt(filaSeleccionada, 0).toString();

            try {
                MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
                MongoClient mongoClient = new MongoClient(uri);
                MongoDatabase database = mongoClient.getDatabase("mounts"); // Reemplaza con el nombre de tu base de datos
                MongoCollection<Document> collection = database.getCollection("horario");

                Document filter = new Document("hora_lab", hora_lab);
                collection.deleteOne(filter);

                mostrarDatos();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
        }
    }

}
