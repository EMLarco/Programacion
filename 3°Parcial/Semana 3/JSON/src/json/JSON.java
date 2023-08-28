
package json;

import org.json.JSONObject;

public class JSON {

    public static void main(String[] args) {
        JSONObject jsonDatos = new JSONObject();
        
        jsonDatos.put("nombre","Juan");
        jsonDatos.put("edad",30);
        jsonDatos.put("ciudad", "Nueva York");
        
        System.out.println("Datos en formato JSON");
        System.out.println(jsonDatos.toString());
    }
}
