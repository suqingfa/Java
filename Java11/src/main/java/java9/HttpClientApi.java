package java9;

import java.net.URI;
import java.net.http.*;

public class HttpClientApi
{
    public static void main(String[] args) throws Exception
    {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://suqingfa.win"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
