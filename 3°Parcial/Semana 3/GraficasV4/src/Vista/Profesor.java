
package Vista;

import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Profesor extends JFrame {
    public JPanel panel;
    private JRadioButton radioButtonActivo;
    public DefaultTableModel tabla;
    private JTextField cajaTexto; // Declarar como campo de clase
    private JTextField cajaTexto1; // Declarar como campo de clase
    private JTextField cajaTexto2; // Declarar como campo de clase
    private JTextField cajaTexto3; // Declarar como campo de clase
    private JTextField cajaTexto4; // Declarar como campo de clase
    private JTextField cajaTexto5; // Declarar como campo de clase
    private JTextField cajaTexto6; // Declarar como campo de clase
    JTable tabla1;

    public Profesor() {
        this.setSize(1300, 600);
        setTitle("REGISTRO");
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
        mostrarDatos();
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        this.getContentPane().add(panel);
    }
    
    public void colocarEtiquetas(){
        JLabel label=new JLabel("Bienvenido al Registro de Profesores",SwingConstants.CENTER);
        panel.add(label);
        panel.setLayout(null);
        label.setBounds(69,10,350,30);//Dimensiones del cuadro
        label.setForeground(Color.black);//Color de la letra
        label.setBackground(Color.white);//Color del cuadro
        label.setOpaque(true);//Para que se vea el cuadro
        
        JLabel label1=new JLabel();
        label1.setText("Nombre:");//Texto con Nombre
        panel.add(label1);//Agregamos la etiqueta para que se muestre en el panel
        label1.setHorizontalAlignment(HEIGHT);//Ubicamos la etiqueta
        label1.setFont(new Font("arial", Font.PLAIN, 12));//Cambiamos y añadimos el tipo de letra
        label1.setBounds(30,70,350,50);//Dimensiones del cuadro
        label1.setForeground(Color.white);//Color de letra
        
        JLabel label2=new JLabel();
        label2.setText("Apellido:");//Texto con Apellido
        panel.add(label2);//Agregamos la etiqueta para que se muestre en el panel
        label2.setHorizontalAlignment(HEIGHT);//Ubicamos la etiqueta
        label2.setFont(new Font("arial",Font.PLAIN, 12));//Cambiamos y añadimos el tipo de letra
        label2.setBounds(30,100,350,50);//Dimensiones del cuadro
        label2.setForeground(Color.white);//Color de letra
        
        JLabel label3=new JLabel();
        label3.setText("Telefono:");
        panel.add(label3);
        label3.setHorizontalAlignment(HEIGHT);
        label3.setFont(new Font("arial", Font.PLAIN,12));
        label3.setBounds(30,130,350,50);
        label3.setForeground(Color.white);
        
        JLabel label4=new JLabel();
        label4.setText("Titulo:");//Texto con Codigo
        panel.add(label4);//Agregamos la etiqueta para que se muestre en el panel
        label4.setHorizontalAlignment(HEIGHT);//Ubicamos la etiqueta
        label4.setFont(new Font("arial",Font.PLAIN, 12));//Cambiamos y añadimos el tipo de letra
        label4.setBounds(30,160,350,50);//Dimensiones del cuadro
        label4.setForeground(Color.white);//Color de letra
        
        JLabel label5=new JLabel();
        label5.setText("Estado:");//Texto con Mail
        panel.add(label5);//Agregamos la etiqueta para que se muestre en el panel
        label5.setHorizontalAlignment(HEIGHT);//Ubicamos la etiqueta
        label5.setFont(new Font("arial",Font.PLAIN, 12));//Cambiamos y añadimos el tipo de letra
        label5.setBounds(30,190,350,50);//Dimensiones del cuadro
        label5.setForeground(Color.white);//Color de letra
        
        JLabel label6=new JLabel();
        label6.setText("Materia:");//Texto con Telefono
        panel.add(label6);//Agregamos la etiqueta para que se muestre en el panel
        label6.setHorizontalAlignment(HEIGHT);//Ubicamos la etiqueta
        label6.setFont(new Font("arial",Font.PLAIN, 12));//Cambiamos y añadimos el tipo de letra
        label6.setBounds(30,220,350,50);//Dimensiones del cuadro
        label6.setForeground(Color.white);//Color de letra
        
    }
    
    public void colocarTextFields(){
        JTextField cajaTexto=new JTextField();//Creamos una zona de texto
        cajaTexto.setBounds(130,80,250,20);//Creamos sus dimensiones
        panel.add(cajaTexto);//Añadimos el objeto
        cajaTexto.setText("Escribir Nombre");//Esto va a ir dentro de la caja de texto
       
        JTextField cajaTexto1=new JTextField();//Creamos una zona de texto
        cajaTexto1.setBounds(130,110,250,20);//Creamos sus dimensiones
        panel.add(cajaTexto1);//Añadimos el objeto
        cajaTexto1.setText("Escribir Apellido");
   
        JTextField cajaTexto2=new JTextField();//Creamos una zona de texto
        cajaTexto2.setBounds(130,140,250,20);//Creamos sus dimensiones
        panel.add(cajaTexto2);//Añadimos el objeto
        cajaTexto2.setText("Escribir Telefono");//Esto va a ir dentro de la caja de texto
        
        JTextField cajaTexto3=new JTextField();//Creamos una zona de texto
        cajaTexto3.setBounds(130,170,250,20);//Creamos sus dimensiones
        panel.add(cajaTexto3);//Añadimos el objeto
        cajaTexto3.setText("Escribir Titulacion");//Esto va a ir dentro de la caja de texto
        
        JTextField cajaTexto4=new JTextField();
        cajaTexto4.setBounds(130,230,250,20);
        panel.add(cajaTexto4);
        cajaTexto4.setText("Escribir la Materia a dar");

        radioButtonActivo = new JRadioButton("Activo"); // Inicializar radioButtonActivo//Creamos las opciones
        ButtonGroup grupoEstado = new ButtonGroup();//Creamos el grupo para que se seleccionen las opciones
        grupoEstado.add(radioButtonActivo);//Añadimos los botones
        radioButtonActivo.setBounds(130, 200, 80, 20);//Creamos sus dimensiones
        panel.add(radioButtonActivo);//Añadimos el objeto
        radioButtonActivo.setBackground(Color.BLACK);
        radioButtonActivo.setForeground(Color.white);
        
        JRadioButton botonInactivo = new JRadioButton("Inactivo");//Creamos las opciones
        grupoEstado.add(botonInactivo);//Añadimos los botones
        botonInactivo.setBounds(210, 200, 80, 20);//Creamos sus dimensiones
        panel.add(botonInactivo);//Añadimos el objeto
        botonInactivo.setBackground(Color.BLACK);//Cambiamos de color el fondo
        botonInactivo.setForeground(Color.white);//Cambiamos de color la letra
    }
    
    public void colocarImagen() {
        ImageIcon imagenOriginal = new ImageIcon("profesor.png");
        int nuevaAnchura = 250;
        int nuevaAltura = 160;
        Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(nuevaAnchura, nuevaAltura, Image.SCALE_SMOOTH);
        ImageIcon imagenRedimensionada = new ImageIcon(imagenEscalada);
        JLabel labelImagen = new JLabel(imagenRedimensionada);
        labelImagen.setBounds(115, 260, nuevaAnchura, nuevaAltura);
        panel.add(labelImagen);
    }
    
     public void crearBotones(){
        JButton boton=new JButton("Nuevo");//Creamos un boton
        boton.setBounds(30,440,100,50);//Creamos sus dimensiones
        panel.add(boton);//Añadimos el objeto
        boton.setEnabled(true);//Definimos si funciona o no
        boton.setMnemonic('a');//Definimos con que se va a poder dar click

        
        JButton boton2=new JButton("Guardar");//Creamos un boton
        boton2.setBounds(140,440,100,50);//Creamos sus dimensiones
        panel.add(boton2);//Añadimos el objeto
        boton2.setEnabled(true);//Definimos si funciona o no
        boton2.setMnemonic('a');//Definimos con que se va a poder dar click
        // Agregar un ActionListener al botón "Guardar" para que ejecute btnGuardarActionPerformed
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        
        JButton boton3=new JButton("Editar");//Creamos un boton
        boton3.setBounds(250,440,100,50);//Creamos sus dimensiones
        panel.add(boton3);//Añadimos el objeto
        boton3.setEnabled(true);//Definimos si funciona o no
        boton3.setMnemonic('a');//Definimos con que se va a poder dar click
        boton3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                btnEditarActionPerformed(evt);
            }
        });
        
        JButton boton4=new JButton("Eliminar");//Creamos un boton
        boton4.setBounds(360,440,100,50);//Creamos sus dimensiones
        panel.add(boton4);//Añadimos el objeto
        boton4.setEnabled(true);//Definimos si funciona o no
        boton4.setMnemonic('a');//Definimos con que se va a poder dar click
        boton4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            btnEliminarActionPerformed(evt);
        }
    });
        
        JButton boton5=new JButton("Salir");//Creamos un boton
        boton5.setBounds(470,440,100,50);//Creamos sus dimensiones
        panel.add(boton5);//Añadimos el objeto
        boton5.setEnabled(true);//Definimos si funciona o no
        boton5.setMnemonic('a');//Definimos con que se va a poder dar click
     
    }
     
     public void tablaDeDatos() {
        tabla = new DefaultTableModel();
        tabla.addColumn("Codigo");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");
        tabla.addColumn("Telefono");
        tabla.addColumn("Titulo");
        tabla.addColumn("Materia");
        tabla.addColumn("Estado");

        tabla1 = new JTable(tabla); // Corrección: asignar a tabla1
        JScrollPane barra = new JScrollPane(tabla1);
        barra.setBounds(600, 70, 650, 300);
        panel.add(barra);
    }
     

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        String user_nombre = cajaTexto.getText();
        String user_apellido = cajaTexto1.getText();
        String user_telefono = cajaTexto4.getText();
        String user_titulo = cajaTexto6.getText();
        String user_materia = cajaTexto2.getText();
        int user_estado = radioButtonActivo.isSelected() ? 0 : 1;

        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("mounts");
            MongoCollection<Document> collection = database.getCollection("profesor");

            Document document = new Document("pro_nombre", user_nombre)
                    .append("pro_apellido", user_apellido)
                    .append("pro_telefono", user_telefono)
                    .append("pro_titulo", user_titulo)
                    .append("pro_materia", user_materia)
                    .append("pro_estado", user_estado);

            collection.insertOne(document);

            mostrarDatos();
            limpiarDatos();

            mongoClient.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada;
        filaSeleccionada = tabla1.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
        } else {
            String codigo = tabla.getValueAt(filaSeleccionada, 0).toString();
            try {
                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                MongoDatabase database = mongoClient.getDatabase("mounts");
                MongoCollection<Document> collection = database.getCollection("profesor");

                Document query = new Document("pro_codigo", codigo);
                collection.deleteOne(query);

                mostrarDatos();
                mongoClient.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void mostrarDatos() {
        String titulos[] = {"Código", "Apellidos", "Nombres", "Telefono", "Titulo", "Materia", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("mounts");
            MongoCollection<Document> collection = database.getCollection("profesor");

            FindIterable<Document> datos = collection.find();
            for (Document doc : datos) {
                modelo.addRow(new Object[]{
                        doc.get("pro_codigo"),
                        doc.get("pro_apellido"),
                        doc.get("pro_nombre"),
                        doc.get("pro_telefono"),
                        doc.get("pro_titulo"),
                        doc.get("pro_materia"),
                        doc.get("pro_estado")
                });
            }

            tabla1.setModel(modelo);
            mongoClient.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos: " + e);
        }
    }

    public void limpiarDatos() {
        cajaTexto.setText("");
        cajaTexto1.setText("");
        cajaTexto2.setText("");
        cajaTexto4.setText("");
        cajaTexto6.setText("");
        cajaTexto5.setText("");
        radioButtonActivo.setSelected(true);
    }

private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
    int filaSeleccionada = tabla1.getSelectedRow();
    if (filaSeleccionada >= 0) {
        String user_codigo = tabla1.getValueAt(filaSeleccionada, 0).toString();
        String user_nombre = cajaTexto.getText();
        String user_apellido = cajaTexto1.getText();
        String user_telefono = cajaTexto4.getText();
        String user_titulo = cajaTexto6.getText();
        String user_materia = cajaTexto2.getText();
        int user_estado = radioButtonActivo.isSelected() ? 0 : 1;

        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("mounts");
            MongoCollection<Document> collection = database.getCollection("profesor");

            Document query = new Document("pro_codigo", user_codigo);
            Document setData = new Document("$set", new Document("pro_nombre", user_nombre)
                    .append("pro_apellido", user_apellido)
                    .append("pro_telefono", user_telefono)
                    .append("pro_titulo", user_titulo)
                    .append("pro_materia", user_materia)
                    .append("pro_estado", user_estado));

            collection.updateOne(query, setData);

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
}
