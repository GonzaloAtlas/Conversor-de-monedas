import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApiMonedas {

    public Monedas buscarMonedas(String claveMoneda){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/6107bf05e2eb48753db9d200/latest/"+claveMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Monedas.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré ese valor de conversión");
        }

    }

}