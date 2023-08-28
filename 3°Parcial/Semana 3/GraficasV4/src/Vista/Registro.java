//Esteban Larco
package Vista;


import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Registro extends JFrame {
    public JPanel panel;
    public DefaultTableModel tabla;
    private JTextField cajaTexto;
    private JTextField cajaTexto1;
    private JTextField cajaTexto2;
    private JTextField cajaTexto3;
    private JTextField cajaTexto4;
    private JTextField cajaTexto5;
    private JTextField cajaTexto6;
    private JTextField cajaTexto7;
    private JRadioButton radioButtonActivo;
    private JComboBox<String> Materias;
    private String[] materias = {"Física", "Computación Digital", "Ecuaciones Diferenciales", "Calculo Vectorial", "Programación Orientada a Objetos"};
    private JTable tabla1;

    public Registro() {
        this.setSize(1300, 500);
        setTitle("REGISTRO");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        colocarPanel();
        colocarEtiquetas();
        crearBotones();
        colocarCajaTexto();
        tablaDeDatos();
        mostrarDatos();
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        this.getContentPane().add(panel);
    }
    //Crear etiquetas
    public void colocarEtiquetas(){
        JLabel label=new JLabel("Bienvenido al Registro",SwingConstants.CENTER);
        panel.add(label);
        panel.setLayout(null);
        label.setBounds(69,10,350,30);//Dimensiones del cuadro
        label.setForeground(Color.black);//Color de la letra
        label.setBackground(Color.white);//Color del cuadro
        label.setOpaque(true);//Para que se vea el cuadro 
        
        //Creamos los objetos
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
        label3.setText("Cédula:");//Texto con Cedula
        panel.add(label3);//Agregamos la etiqueta para que se muestre en el panel
        label3.setHorizontalAlignment(HEIGHT);//Ubicamos la etiqueta
        label3.setFont(new Font("arial",Font.PLAIN, 12));//Cambiamos y añadimos el tipo de letra
        label3.setBounds(30,130,350,50);//Dimensiones del cuadro
        label3.setForeground(Color.white);//Color de letra
        
        JLabel label4=new JLabel();
        label4.setText("Codigo:");//Texto con Codigo
        panel.add(label4);//Agregamos la etiqueta para que se muestre en el panel
        label4.setHorizontalAlignment(HEIGHT);//Ubicamos la etiqueta
        label4.setFont(new Font("arial",Font.PLAIN, 12));//Cambiamos y añadimos el tipo de letra
        label4.setBounds(30,160,350,50);//Dimensiones del cuadro
        label4.setForeground(Color.white);//Color de letra
        
        JLabel label5=new JLabel();
        label5.setText("Mail:");//Texto con Mail
        panel.add(label5);//Agregamos la etiqueta para que se muestre en el panel
        label5.setHorizontalAlignment(HEIGHT);//Ubicamos la etiqueta
        label5.setFont(new Font("arial",Font.PLAIN, 12));//Cambiamos y añadimos el tipo de letra
        label5.setBounds(30,190,350,50);//Dimensiones del cuadro
        label5.setForeground(Color.white);//Color de letra
        
        JLabel label6=new JLabel();
        label6.setText("Telefono:");//Texto con Telefono
        panel.add(label6);//Agregamos la etiqueta para que se muestre en el panel
        label6.setHorizontalAlignment(HEIGHT);//Ubicamos la etiqueta
        label6.setFont(new Font("arial",Font.PLAIN, 12));//Cambiamos y añadimos el tipo de letra
        label6.setBounds(30,220,350,50);//Dimensiones del cuadro
        label6.setForeground(Color.white);//Color de letra
        
        JLabel label7=new JLabel();
        label7.setText("Dirección:");//Texto con Dirección
        panel.add(label7);//Agregamos la etiqueta para que se muestre en el panel
        label7.setHorizontalAlignment(HEIGHT);//Ubicamos la etiqueta
        label7.setFont(new Font("arial",Font.PLAIN, 12));//Cambiamos y añadimos el tipo de letra
        label7.setBounds(30,250,350,50);//Dimensiones del cuadro
        label7.setForeground(Color.white);//Color de letra
        
         JLabel label8=new JLabel();
        label8.setText("Materia:");//Texto con Materia
        panel.add(label8);//Agregamos la etiqueta para que se muestre en el panel
        label8.setHorizontalAlignment(HEIGHT);//Ubicamos la etiqueta
        label8.setFont(new Font("arial",Font.PLAIN, 12));//Cambiamos y añadimos el tipo de letra
        label8.setBounds(30,280,350,50);//Dimensiones del cuadro
        label8.setForeground(Color.white);//Color de letra
   
        JLabel label9=new JLabel();
        label9.setText("Estado:");//Texto con Estado
        panel.add(label9);//Agregamos la etiqueta para que se muestre en el panel
        label9.setHorizontalAlignment(HEIGHT);//Ubicamos la etiqueta
        label9.setFont(new Font("arial",Font.PLAIN, 12));//Cambiamos y añadimos el tipo de letra
        label9.setBounds(30,310,350,50);//Dimensiones del cuadro
        label9.setForeground(Color.white);//Color de letra
        
    }
    
    //Crear botones
    public void crearBotones(){
        JButton boton=new JButton("Nuevo");//Creamos un boton
        boton.setBounds(30,380,100,50);//Creamos sus dimensiones
        panel.add(boton);//Añadimos el objeto
        boton.setEnabled(true);//Definimos si funciona o no
        boton.setMnemonic('a');//Definimos con que se va a poder dar click

        
        JButton boton2=new JButton("Guardar");//Creamos un boton
        boton2.setBounds(140,380,100,50);//Creamos sus dimensiones
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
        boton3.setBounds(250,380,100,50);//Creamos sus dimensiones
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
        boton4.setBounds(360,380,100,50);//Creamos sus dimensiones
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
        boton5.setBounds(470,380,100,50);//Creamos sus dimensiones
        panel.add(boton5);//Añadimos el objeto
        boton5.setEnabled(true);//Definimos si funciona o no
        boton5.setMnemonic('a');//Definimos con que se va a poder dar click
     
    }
    //Cajas de Texto
    public void colocarCajaTexto(){
        cajaTexto=new JTextField();//Creamos una zona de texto
        cajaTexto.setBounds(130,80,250,20);//Creamos sus dimensiones
        panel.add(cajaTexto);//Añadimos el objeto
        cajaTexto.setText("");//Esto va a ir dentro de la caja de texto
       
        cajaTexto1=new JTextField();//Creamos una zona de texto
        cajaTexto1.setBounds(130,110,250,20);//Creamos sus dimensiones
        panel.add(cajaTexto1);//Añadimos el objeto
        cajaTexto1.setText("");
   
        cajaTexto2=new JTextField();//Creamos una zona de texto
        cajaTexto2.setBounds(130,140,250,20);//Creamos sus dimensiones
        panel.add(cajaTexto2);//Añadimos el objeto
        cajaTexto2.setText("");//Esto va a ir dentro de la caja de texto
        
        cajaTexto3=new JTextField();//Creamos una zona de texto
        cajaTexto3.setBounds(130,170,250,20);//Creamos sus dimensiones
        panel.add(cajaTexto3);//Añadimos el objeto
        cajaTexto3.setText("");//Esto va a ir dentro de la caja de texto

        cajaTexto4=new JTextField();//Creamos una zona de texto
        cajaTexto4.setBounds(130,200,250,20);//Creamos sus dimensiones
        panel.add(cajaTexto4);//Añadimos el objeto
        cajaTexto4.setText("");//Esto va a ir dentro de la caja de texto
 
        cajaTexto5=new JTextField();//Creamos una zona de texto
        cajaTexto5.setBounds(130,230,250,20);//Creamos sus dimensiones
        panel.add(cajaTexto5);//Añadimos el objeto
        cajaTexto5.setText("");//Esto va a ir dentro de la caja de texto
        
        cajaTexto6=new JTextField();//Creamos una zona de texto
        cajaTexto6.setBounds(130,260,250,20);//Creamos sus dimensiones
        panel.add(cajaTexto6);//Añadimos el objeto
        cajaTexto6.setText("");//Esto va a ir dentro de la caja de texto
        
        cajaTexto7=new JTextField();//Creamos una zona de texto
        cajaTexto7.setBounds(130,200,250,20);//Creamos sus dimensiones
        panel.add(cajaTexto7);//Añadimos el objeto
        cajaTexto7.setText("");//Esto va a ir dentro de la caja de texto
        
        radioButtonActivo = new JRadioButton("Activo"); // Inicializar radioButtonActivo//Creamos las opciones
        ButtonGroup grupoEstado = new ButtonGroup();//Creamos el grupo para que se seleccionen las opciones
        grupoEstado.add(radioButtonActivo);//Añadimos los botones
        radioButtonActivo.setBounds(130, 330, 80, 20);//Creamos sus dimensiones
        panel.add(radioButtonActivo);//Añadimos el objeto
        radioButtonActivo.setBackground(Color.BLACK);
        radioButtonActivo.setForeground(Color.white);
        
        JRadioButton botonInactivo = new JRadioButton("Inactivo");//Creamos las opciones
        grupoEstado.add(botonInactivo);//Añadimos los botones
        botonInactivo.setBounds(210, 330, 80, 20);//Creamos sus dimensiones
        panel.add(botonInactivo);//Añadimos el objeto
        botonInactivo.setBackground(Color.BLACK);//Cambiamos de color el fondo
        botonInactivo.setForeground(Color.white);//Cambiamos de color la letra
        
        Materias = new JComboBox<>(materias); // Inicializa la variable de instancia
        Materias.setBounds(130, 295, 250, 20);
        panel.add(Materias);
        Materias.setBackground(Color.white);
    }
    
    public void tablaDeDatos() {
        tabla = new DefaultTableModel();
        tabla.addColumn("Codigo");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");
        tabla.addColumn("Mail");
        tabla.addColumn("Telefono");
        tabla.addColumn("Direccion");
        tabla.addColumn("Materia");
        tabla.addColumn("Estado");

        JTable tabla1 = new JTable(tabla);
        JScrollPane barra = new JScrollPane(tabla1);
        barra.setBounds(600, 70, 650, 300);
        panel.add(barra);
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        String user_materias = Materias.getSelectedItem().toString();
        String user_nombre = cajaTexto.getText();
        String user_apellido = cajaTexto1.getText();
        String user_mail = cajaTexto4.getText();
        String user_direccion = cajaTexto6.getText();
        String user_cedula = cajaTexto2.getText();
        String user_telefono = cajaTexto5.getText();
        int user_estado = radioButtonActivo.isSelected() ? 0 : 1;

        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("mounts");
            MongoCollection<Document> collection = database.getCollection("usuarios");

            Document document = new Document("user_materias", user_materias)
                    .append("user_nombre", user_nombre)
                    .append("user_apellido", user_apellido)
                    .append("user_mail", user_mail)
                    .append("user_direccion", user_direccion)
                    .append("user_cedula", user_cedula)
                    .append("user_telefono", user_telefono)
                    .append("user_estado", user_estado);

            collection.insertOne(document);

            mostrarDatos();
            limpiarDatos();

            mongoClient.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = tabla1.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
        } else {
            String user_codigo = tabla.getValueAt(filaSeleccionada, 0).toString();

            try {
                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                MongoDatabase database = mongoClient.getDatabase("mounts");
                MongoCollection<Document> collection = database.getCollection("usuarios");

                collection.deleteOne(new Document("user_codigo", user_codigo));

                mostrarDatos();
                mongoClient.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void mostrarDatos() {
        String titulos[] = {"Codigo", "Apellidos", "Nombres", "Mail", "Direccion", "Cedula", "Telefono", "Materia", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("mounts");
            MongoCollection<Document> collection = database.getCollection("usuarios");

            List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());

            for (Document document : documents) {
                String user_codigo = document.getString("user_codigo");
                String user_apellido = document.getString("user_apellido");
                String user_nombre = document.getString("user_nombre");
                String user_mail = document.getString("user_mail");
                String user_direccion = document.getString("user_direccion");
                String user_cedula = document.getString("user_cedula");
                String user_telefono = document.getString("user_telefono");
                String user_materias = document.getString("user_materias");
                String user_estado = document.getInteger("user_estado").toString();

                modelo.addRow(new String[]{user_codigo, user_apellido, user_nombre, user_mail, user_direccion, user_cedula, user_telefono, user_materias, user_estado});
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
        cajaTexto5.setText("");
        cajaTexto6.setText("");
        radioButtonActivo.setSelected(true);
        Materias.setSelectedIndex(0);
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = tabla1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String user_codigo = tabla1.getValueAt(filaSeleccionada, 0).toString();
            String user_nombre = cajaTexto.getText();
            String user_apellido = cajaTexto1.getText();
            String user_mail = cajaTexto4.getText();
            String user_direccion = cajaTexto6.getText();
            String user_cedula = cajaTexto2.getText();
            String user_telefono = cajaTexto5.getText();
            String user_materias = Materias.getSelectedItem().toString();
            int user_estado = radioButtonActivo.isSelected() ? 0 : 1;

            try {
                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                MongoDatabase database = mongoClient.getDatabase("mounts");
                MongoCollection<Document> collection = database.getCollection("usuarios");

                Document query = new Document("user_codigo", user_codigo);
                Document update = new Document("$set", new Document("user_materias", user_materias)
                        .append("user_nombre", user_nombre)
                        .append("user_apellido", user_apellido)
                        .append("user_mail", user_mail)
                        .append("user_direccion", user_direccion)
                        .append("user_cedula", user_cedula)
                        .append("user_telefono", user_telefono)
                        .append("user_estado", user_estado));

                collection.updateOne(query, update);

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