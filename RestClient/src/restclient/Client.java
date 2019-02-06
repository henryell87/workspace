package restclient;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
public class Client {
	public static void main(String[] args) {
		try{
			URL url = new URL("http://localhost:8080/RESTProject/rest/hi//person?name=Henry&id=1234");
			URLConnection urlConn = url.openConnection();
			InputStream inputStream = urlConn.getInputStream();
			BufferedReader in = new BufferedReader(new
					 InputStreamReader(inputStream));
					String line = in.readLine();
					while (line != null) {
					System.out.println(line);
					line = in.readLine();
					}
					in.close();
					} catch (Exception e) {
					System.out.println(e);
					}
		}

}
