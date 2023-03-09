import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        String filepath = "C:\\Users\\kelly\\Desktop\\JSONPractice\\src\\data.json";

        // Hämta data från JSON fil
        Object o = new JSONParser().parse(new FileReader(filepath));
        JSONObject jsonData = (JSONObject) o;

        //Konvertera data till ett JSON object
        JSONObject person = (JSONObject) jsonData.get("p1");
        JSONObject personTwo = (JSONObject) jsonData.get("p2");

        //Hämta och skriva ut data
        String name = (String) person.get("name");
        int age = ((Long) person.get("age")).intValue();

        String nameTwo = (String) personTwo.get("name");
        int ageTwo = ((Long) personTwo.get("age")).intValue();

        System.out.println("P1 Name: " + name);
        System.out.println("P1 Age: " + age);
        System.out.println();
        System.out.println("P2 Name: " + nameTwo);
        System.out.println("P2 Age: " + ageTwo);
        System.out.println("---------------------");

        fetchJsonFromApi();

    }

    static void fetchJsonFromApi() throws IOException, ParseException {
        //Spara URL till api
        URL url = new URL("https://api.wheretheiss.at/v1/satellites/25544");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();


        conn.setRequestMethod("GET");
        conn.connect();
        if (conn.getResponseCode() == 200) {
            System.out.println("Koppling lyckas");

            //Skapa StrBuilder och Scan object
            StringBuilder strData = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());

            //Bygger upp str med data från API
            while (scanner.hasNext()) {
                strData.append(scanner.nextLine());
            }
            scanner.close();

            // Parse the JSON data
            JSONParser parser = new JSONParser();
            JSONObject issData = (JSONObject) parser.parse(strData.toString());

            // Extract the required fields
            String name = (String) issData.get("name");
            double latitude = (double) issData.get("latitude");
            double longitude = (double) issData.get("longitude");
            double velocity = (double) issData.get("velocity");

            // Print the results
            System.out.println("Name: " + name);
            System.out.println("Latitude: " + latitude);
            System.out.println("Longitude: " + longitude);
            System.out.println("Velocity: " + velocity);
        } else {
            System.out.println("fail");
        }
    }
}