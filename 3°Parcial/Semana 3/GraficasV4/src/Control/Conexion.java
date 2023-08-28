
package Control;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import javax.swing.JOptionPane;

public class Conexion {
    private static MongoClient mongoClient = null;

    public static MongoClient conexion() {
        try {
            // Conectar a MongoDB usando la cadena de conexión
            mongoClient = MongoClients.create("mongodb://localhost:27017");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
        return mongoClient;
    }
}
