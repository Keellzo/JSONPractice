import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        Object o = new JSONParser().parse(new FileReader("C:\\Users\\kelly\\Desktop\\JSONExample\\src\\data.json"));
        JSONObject jsonData = (JSONObject) o;

        JSONObject person = (JSONObject) jsonData.get("p1");
        String name = (String) person.get("name");
        int age = ((Long) person.get("age")).intValue();

        System.out.println("P1 Name: " + name);
        System.out.println("P1 Age " + age);

    }
}