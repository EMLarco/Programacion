
package Vista;


import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;

public class Menu extends JFrame {

    public Menu() {
        this.setSize(500, 500);
        setTitle("Menú Principal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton menu1Button = new JButton("Profesor");
        JButton menu2Button = new JButton("Estudiante");
        JButton menu3Button = new JButton("Horario");
        
        

        panel.add(menu1Button);
        panel.add(menu2Button);
        panel.add(menu3Button);

        menu1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profesor profe = new Profesor();
                profe.setVisible(true);
                JOptionPane.showMessageDialog(null, "Has seleccionado ingresar los profesores");
            }
        });

        menu2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registro estu = new Registro();
                estu.setVisible(true);
                JOptionPane.showMessageDialog(null, "Has seleccionado ingresar los estudiantes");
            }
        });

        menu3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Horario hora= new Horario();
                hora.setVisible(true);
                JOptionPane.showMessageDialog(null, "Has seleccionado ingresar el horario");
            }
        });

        getContentPane().add(panel);
    }
}
