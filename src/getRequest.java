import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class getRequest {
	
	public static final String URL_GET = "http://httpbin.org/get"; 

	public static void main(String[] args) throws IOException, InterruptedException{
		
		//Cria o cliente
		HttpClient cliente = HttpClient.newHttpClient();

		//Cria o Request
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.timeout(Duration.ofSeconds(10))
				.uri(URI.create(URL_GET))
				.build();
		
		//Envia a solicita��o
		HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
				
		//Imprimir o conte�do
		System.out.println(response.statusCode());
		System.out.println(response.body());
		
	}

}
