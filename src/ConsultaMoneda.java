
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Conversion nuevaConversion(){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5c2d28fd32552be894dcda78/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .GET()
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Conversion conversion = new Gson().fromJson(response.body(), Conversion.class);
            return conversion;
        }catch (Exception e){
            throw new RuntimeException("Error al realizar la consulta de la API", e);
        }
    }

}
