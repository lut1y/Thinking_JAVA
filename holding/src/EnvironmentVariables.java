import java.util.Map;

/**
 * Created by Dmitriy on 12.11.2019.
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        for(Map.Entry entry : System.getenv().entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }
}
