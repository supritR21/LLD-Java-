package SimpleBuilder;

public class Main {
    public static void main(String[] args) {
        HttpRequest request = new HttpRequest.HttpRequestBuilder()
              .withUrl("https://api.example.com")
              .withMethod("POST")
              .withHeader("Content-Type", "application/json")
              .withHeader("Accept", "application/json")
              .withQueryParams("key", "12345")
              .withBody("{\"name\": \"Suprit\"}")
              .withTimeout(60)
              .build();

        request.execute();
    }
}
