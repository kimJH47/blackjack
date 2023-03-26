import java.util.LinkedHashMap;
import java.util.Map;
import util.Result;

public class DashBoard {

    private final Map<String, Integer> dashBoard = new LinkedHashMap<>();
    public void put(String name) {
        dashBoard.put(name, 0);
    }

    public void updateResult(String name, Result result) {
        dashBoard.put(name, dashBoard.get(name) + result.getPoint());
    }
}
