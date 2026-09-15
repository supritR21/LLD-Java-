import java.util.*;

class HttpRequest {
    private String url;                                 // required
    private String method;                              // required
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private String body;
    private int timeout;                                // required

    public HttpRequest(String url) {
        this.url = url;
        this.method = "GET";                     // Default method
        this.timeout = 30;                       // Default timeout
        this.headers = new HashMap<>();
        this.queryParams = new HashMap<>();
    }

    public HttpRequest(String url, String method) {
        this.url = url;
        this.method = method;
        this.timeout = 30;
        this.headers = new HashMap<>();
        this.queryParams = new HashMap<>();
    }

    public HttpRequest(String url, String method, int timeout) {
        this.url = url;
        this.method = method;
        this.timeout = timeout;
        this.headers = new HashMap<>();
        this.queryParams = new HashMap<>();
    }

    public HttpRequest(String url, String method, int timeout, Map<String, String> headers) {
        this.url = url;
        this.method = method;
        this.timeout = timeout;
        this.headers = headers;
        this.queryParams = new HashMap<>();
    }

    public HttpRequest(String url, String method, int timeout, Map<String, String> headers, Map<String, String> queryParams) {
        this.url = url;
        this.method = method;
        this.timeout = timeout;
        this.headers = headers;
        this.queryParams = queryParams;
    }

    public HttpRequest(String url, String method, int timeout, Map<String, String> headers, Map<String, String> queryParams, String body) {
        this.url = url;
        this.method = method;
        this.timeout = timeout;
        this.headers = headers;
        this.queryParams = queryParams;
        this.body = body;
    }

    // Setters (leads to mutable object)
    public void setUrl(String url) {
        this.url = url;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    public void addQueryParam(String key, String value) {
        queryParams.put(key, value);
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void execute() {
        System.out.println("Executing " + method + " request to " + url);

        if(!queryParams.isEmpty()) {
            System.out.println("Query Parameters:");
            for(Map.Entry<String, String> param : queryParams.entrySet()) {
                System.out.println(" " + param.getKey() + "=" + param.getValue());
            }
        }

        System.out.println("Headers:");
        for(Map.Entry<String, String> header : headers.entrySet()) {
            System.out.println(" " + header.getKey() + ": " + header.getValue());
        }

        if(body!=null && !body.isEmpty()) {
            System.out.println("Body: " + body);
        }
        System.out.println("Timeout: " + timeout + " seconds");
        System.out.println("Request executed successfully!");
    }
}

public class WithoutBuilder {
    public static void main(String[] args) {
        HttpRequest req1 = new HttpRequest("https://api.example.com");
        HttpRequest req2 = new HttpRequest("https://api.example.com", "POST");
        HttpRequest req3 = new HttpRequest("https://api.example.com", "PUT", 60);

        // Using setters (mutable object problem)
        HttpRequest req4 = new HttpRequest("https://api.example.com");
        req4.setMethod("POST");
        req4.addHeader("Content-Type", "application/json");
        req4.addQueryParam("key", "12345");
        req4.setBody("{\"name\": \"Suprit\"}");
        req4.setTimeout(60);

        // The problem: what if we forgot to set an important field?
        req4.execute();
    }
}
