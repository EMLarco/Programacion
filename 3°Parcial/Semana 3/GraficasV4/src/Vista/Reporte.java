
package Vista;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class Reporte {
    public void generarReporte() {
        // Configurar el documento PDF
        Document documento = new Document();


        try {
            // Especificar la ubicación del archivo PDF resultante
            PdfWriter.getInstance(documento, new FileOutputStream("reporte.pdf"));

            // Abrir el documento
            documento.open();

            // Agregar contenido al documento
            agregarContenido(documento);

            // Cerrar el documento
            documento.close();

            System.out.println("Informe generado correctamente en 'reporte.pdf'.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al generar el informe: " + e.getMessage());
        }
    }

    private void agregarContenido(Document documento) throws DocumentException {
        // Configurar la fuente y el tamaño de fuente
        Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

        // Conectar a la base de datos MongoDB
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("mounts");

        try {
            // Obtener datos del profesor
            MongoCollection<Document> profesoresCollection = database.getCollection("profesor");
            Document profesorQuery = new Document("pro_codigo", 1); // Reemplaza con el código del profesor deseado
            Document profesor = profesoresCollection.find(profesorQuery).first();
            String nombreProfesor = "";

            if (profesor != null) {
                nombreProfesor = profesor.getString("pro_nombre");
            }

            // Obtener datos del laboratorio
            MongoCollection<Document> laboratoriosCollection = database.getCollection("laboratorio");
            Document laboratorioQuery = new Document("lab_codigo", 1); // Reemplaza con el código del laboratorio deseado
            Document laboratorio = laboratoriosCollection.find(laboratorioQuery).first();
            String nombreLaboratorio = "";

            if (laboratorio != null) {
                nombreLaboratorio = laboratorio.getString("lab_nombre");
            }

            // Obtener datos de estudiantes
            MongoCollection<Document> estudiantesCollection = database.getCollection("estudiante");
            Document estudianteQuery = new Document("pro_codigo", 1); // Reemplaza con el código del profesor deseado
            MongoCursor<Document> estudiantes = estudiantesCollection.find(estudianteQuery).iterator();
            List<String> nombresEstudiantes = new ArrayList<>();

            while (estudiantes.hasNext()) {
                Document estudiante = estudiantes.next();
                String nombreEstudiante = estudiante.getString("est_nombre");
                nombresEstudiantes.add(nombreEstudiante);
            }

            // Crear el contenido del informe
            Paragraph contenido = new Paragraph();
            contenido.setFont(fuente);
            contenido.add("Informe de Clase\n\n");
            contenido.add("Profesor: " + nombreProfesor + "\n");
            contenido.add("Laboratorio: " + nombreLaboratorio + "\n");
            contenido.add("Estudiantes:\n");

            for (String nombreEstudiante : nombresEstudiantes) {
                contenido.add("  - " + nombreEstudiante + "\n");
            }

            // Agregar el contenido al documento
            documento.add(contenido);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al generar el informe: " + e.getMessage());
        } finally {
            // Cerrar la conexión a MongoDB
            mongoClient.close();
        }
    }

}
