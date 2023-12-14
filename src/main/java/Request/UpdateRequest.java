package Request;

public class UpdateRequest {

    private static String name;

    public UpdateRequest(String name) {
        UpdateRequest.name = name;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        UpdateRequest.name = name;
    }
}
