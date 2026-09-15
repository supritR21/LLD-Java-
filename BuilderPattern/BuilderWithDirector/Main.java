package BuilderWithDirector;

public class Main {
    public static void main(String[] args) {
        // Normal Request from Builder Directly
        HttpRequest normalRequest = new HttpRequest.HttpRequestBuilder()
                 .withUrl("https://api.example.com")
                 .withMethod("POST")
                 .withHeader("Content-Type", "application/json")
                 .withHeader("Accept", "application/json")
                 .withQueryParams("key", "12345")
                 .withBody("{\"name\":\"Suprit\"}")
                 .withTimeout(60)
                 .build();

        normalRequest.execute(); // Guaranteed to be in a consistent state

        System.out.println();

        HttpRequest getRequest = HttpRequestDirector.createGetRequest("https://api.example.com/users");
        getRequest.execute();

        System.out.println();

        HttpRequest postRequest = HttpRequestDirector.createJsonPostRequest(
            "https://api.example.com/users",
            "{\"name\":\"Suprit\",\"email\":\"suprit790@example.com\"}"
        );
        postRequest.execute();
    }
}
