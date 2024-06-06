package DAY25Assignments;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleHTTPClient {
   public static void main(String[] args) {
       String urlString = "http://example.com"; // URL to connect to

       try {
           // Create URL object
           URL url = new URL(urlString);

           // Open connection
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();

           // Set request method
           connection.setRequestMethod("GET");

           // Get response code
           int responseCode = connection.getResponseCode();
           System.out.println("Response Code: " + responseCode);

           // Get and print response headers
           System.out.println("Response Headers:");
           connection.getHeaderFields().forEach((key, value) -> {
               if (key != null) {
                   System.out.println(key + ": " + value);
               }
           });

           // Read and print response body
           System.out.println("Response Body:");
           BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
           String line;
           while ((line = reader.readLine()) != null) {
               System.out.println(line);
           }
           reader.close();

           // Disconnect the connection
           connection.disconnect();

       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}