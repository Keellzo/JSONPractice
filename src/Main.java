import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        String filepath = "C:\\Users\\kelly\\Desktop\\JSONPractice\\src\\data.json";

        Object o = new JSONParser().parse(new FileReader(filepath));
        JSONObject jsonData = (JSONObject) o;

        JSONObject person = (JSONObject) jsonData.get("p1");
        String name = (String) person.get("name");
        int age = ((Long) person.get("age")).intValue();

        JSONObject personTwo = (JSONObject) jsonData.get("p2");
        String nameTwo = (String) personTwo.get("name");
        int ageTwo = ((Long) personTwo.get("age")).intValue();

        System.out.println("P1 Name: " + name);
        System.out.println("P1 Age " + age);
        System.out.println();
        System.out.println("P2 Name: " + nameTwo);
        System.out.println("P2 Age " + ageTwo);

    }
}