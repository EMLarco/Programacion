
package control;

import com.sun.jdi.connect.spi.Connection;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import javax.swing.JOptionPane;



public class Conexion {
  
    private static final String drive="com.mysql.jdbc.Drive";
    private static final String user="root";
    private static final String pass="";
    private static final String url="jdbc:mysaql://localhost:8080/estudiantes";
    
    Connection conectar=null;
    
    public Connection conexion(){
      
        try{
            Class.forName(drive);
            conectar=(Connection) DriverManager.getConnection(url,user,pass,);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de conexion"+e.getMessage());
        }
        return conectar;
    }
}
