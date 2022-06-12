package spotify.api.ingest.external;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class RequestEntityBuilder {

    private static final String CONTENT_TYPE = "application/json";

    private RequestEntityBuilder(){}

    public static HttpEntity<Void> buildRequestEntity(String auth){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", auth);
        headers.set("Content-Type", CONTENT_TYPE);
        return new HttpEntity<>(headers);
    }
}
